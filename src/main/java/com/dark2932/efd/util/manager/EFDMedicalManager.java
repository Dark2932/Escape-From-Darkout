package com.dark2932.efd.util.manager;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;


public class EFDMedicalManager extends Item{

    private int healthValue = 1;
    private int consumption = 1;
    private int usingTime = 32;
    private SoundEvent usedSound = SoundEvents.PLAYER_BREATH;
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
    public EFDMedicalManager setHealthRestore(int healthValue){
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
    public void onUseTick(Level pLevel, LivingEntity player, ItemStack stack, int pRemainingUseTicks) {
        // 剩余时间 <= 1 刻时执行效果（确保完整使用）
        if (pRemainingUseTicks <= 1 && player instanceof Player) {
            Player p = (Player) player;

            if (p.getHealth() < p.getMaxHealth() && !stack.isEmpty()) {
                p.heal(healthValue);
                stack.shrink(consumption);
                p.playSound(usedSound, 1.0f, 1.0f);
                p.stopUsingItem();
            }
        }
    }
    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {

        return this.isEdible() ? pLivingEntity.eat(pLevel, pStack) : pStack;
    }

}
