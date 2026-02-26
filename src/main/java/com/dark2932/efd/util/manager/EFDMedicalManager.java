package com.dark2932.efd.util.manager;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;


public class EFDMedicalManager extends Item{

    private int healthValue = 1;
    private int consumption = 1;
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

    @Override
    public UseAnim getUseAnimation(ItemStack stack){
        return UseAnim.BRUSH;
    }
    @Override
    public int getUseDuration(ItemStack stack){
        return 32;
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        // 检查玩家是否受伤（生命值小于最大生命值）
        if (player.getHealth() < player.getMaxHealth()) {
            // 恢复生命值
            player.heal((float) healthValue);

            // 消耗物品
            player.getItemInHand(hand).shrink(consumption);

            // 播放音效（可选）
            player.playSound(usedSound, 1.0f, 1.0f);

            return InteractionResultHolder.success(player.getItemInHand(hand));
        }

        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }
}
