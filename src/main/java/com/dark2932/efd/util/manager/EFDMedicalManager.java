package com.dark2932.efd.util.manager;

import dev.ghen.thirst.foundation.common.capability.ModCapabilities;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;


public class  EFDMedicalManager extends Item{

    private int usingTime = 32;
    private SoundEvent usedSound = SoundEvents.PLAYER_BREATH;
    private int thirstComsumption = 1;

    /**
     * 用于设置医疗物品的属性
     **/
    public EFDMedicalManager(Properties pProperties,int durability) {
        super(pProperties.durability(durability));
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
     * 用于设置医疗物品每修补1血量消耗的水量
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

            if (player.getHealth() < player.getMaxHealth() && !stack.isEmpty() && stack.getDamageValue() < stack.getMaxDamage()) {
                /**
                 * 健康值回复逻辑：
                 * 修补多少血量，使用多少耐久
                 *
                 * 水分减少逻辑：
                 * 每修补一血量，减少**水分
                 */
                float healthDiff = player.getMaxHealth() - player.getHealth();
                int remainingDurability = stack.getMaxDamage() - stack.getDamageValue();
                float durabilityConsumption;
                if (healthDiff >= remainingDurability) {
                    //血量缺少部分>=物品耐久，物品全部使用
                    player.heal(remainingDurability);
                    durabilityConsumption = remainingDurability;
                    stack.setDamageValue(stack.getMaxDamage());
                    //物品销毁
                    stack.shrink(1);
                } else {
                    //血量缺少部分<物品耐久，血量满，物品耐久降低
                    player.setHealth(player.getMaxHealth());
                    durabilityConsumption = healthDiff;
                    stack.setDamageValue(stack.getDamageValue() + (int) healthDiff);
                }
                ((ServerLevel) player.getCommandSenderWorld()).playSound(
                        null,
                        player.getX(), player.getY(), player.getZ(),
                        usedSound,
                        SoundSource.PLAYERS,
                        1.0f,
                        1.0f
                );
                player.playSound(usedSound, 1.0f, 1.0f);
                player.stopUsingItem();
                player.getCapability(ModCapabilities.PLAYER_THIRST).ifPresent(cap -> {
                    cap.drink(player, -(thirstComsumption * (int) durabilityConsumption), 0);
                });
            }
        }
    }

}
