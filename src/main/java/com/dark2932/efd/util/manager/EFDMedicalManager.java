package com.dark2932.efd.util.manager;

import dev.ghen.thirst.foundation.common.capability.ModCapabilities;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;


public class EFDMedicalManager extends Item{

    private float healthValue = 1f;
    private int consumption = 1;
    private int usingTime = 32;
    private SoundEvent usedSound = SoundEvents.PLAYER_BREATH;
    private int thirstComsumption = 1;
    /**
     * 用于设置医疗物品的属性
     **/
    public EFDMedicalManager(Properties pProperties) {
        super(pProperties);
    }
    /**
     * 用于设置医疗物品的健康恢复值
     * @param healthValue 健康恢复值
     **/
    public EFDMedicalManager setHealthRestore(float healthValue){
        this.healthValue = healthValue;
        return this;
    }
    /**
     * 用于设置医疗物品的使用消耗值
     * @param consumption 使用消耗数量
     **/
    public EFDMedicalManager setConsumption(int consumption){
        this.consumption = consumption;
        return this;
    }
    /**
     * 用于设置医疗物品使用后的声音
     * @param sound 使用后声音
     **/
    public EFDMedicalManager setAfterUseSound(SoundEvent sound){
        this.usedSound = sound;
        return this;
    }
    /**
     * 用于设置医疗物品使用的时间，默认32tick
     * @param tick 使用时间
     **/
    public EFDMedicalManager setUsingTime(int tick){
        this.usingTime = tick;
        return this;
    }
    /**
     * 用于设置医疗物品每次使用消耗的水量
     * @param thirstConsumption 消耗水量，填正整数（1-20）
     */
    public EFDMedicalManager setThirstConsumption(int thirstConsumption){
        this.thirstComsumption = thirstConsumption;
        return this;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack){
        return UseAnim.BRUSH;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return usingTime;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        // 只有玩家受伤时才允许使用
        if (player.getHealth() < player.getMaxHealth()) {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(player.getItemInHand(hand));
        }
        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity entity, ItemStack stack, int pRemainingUseTicks) {
        // 剩余时间 <= 1 刻时执行效果（确保完整使用）
        if (pRemainingUseTicks <= 1 && entity instanceof Player player) {

            if (player.getHealth() < player.getMaxHealth() && !stack.isEmpty()) {
                /**
                 * 健康值回复逻辑：
                 * 如果当前剩余物品满足一次消耗（即，当前物品不为空），那么只进行一次消耗
                 * 如果当前物品不满足一次消耗（当前数量 < 消耗数量），那么按比例进行消耗（本来回复血量*（持有物品数量/应消耗数量））
                 * 如果当前需要恢复的血量不足一次消耗，那么按消耗一次计算
                 */

                if (stack.getCount() >= consumption){
                    player.heal(healthValue);
                }else{
                    player.heal((float)(stack.getCount()/consumption)*healthValue);
                }
                stack.shrink(Math.min(stack.getCount(), consumption));
                player.playSound(usedSound, 1.0f, 1.0f);
                player.stopUsingItem();
                player.getCapability(ModCapabilities.PLAYER_THIRST).ifPresent(cap -> {
                    cap.drink(player, -thirstComsumption, 0);
                });
            }
        }
    }

}
