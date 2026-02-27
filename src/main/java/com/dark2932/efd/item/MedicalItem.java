package com.dark2932.efd.item;

import com.dark2932.efd.item.manager.MedicalItemManager;
import dev.ghen.thirst.foundation.common.capability.ModCapabilities;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class MedicalItem extends Item {

    public final MedicalItemManager manager;

    public MedicalItem(Properties properties, MedicalItemManager manager) {
        super(properties);
        this.manager = manager;
    }

    @Override
    public int getUseDuration(@NotNull ItemStack stack) {
        return manager.getUseDuration();
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return UseAnim.BRUSH;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand hand) {
        if (player.getHealth() < player.getMaxHealth()) {
            ItemUtils.startUsingInstantly(level, player, hand);
        }
        return InteractionResultHolder.fail(player.getItemInHand(hand));
    }

    @Override
    public void onUseTick(@NotNull Level level, @NotNull LivingEntity entity, @NotNull ItemStack stack, int remainingUseTicks) {
        // 剩余时间 <= 1 刻时执行效果（确保完整使用）
        if (remainingUseTicks <= 1 && entity instanceof Player player) {

            if (player.getHealth() < player.getMaxHealth() && !stack.isEmpty() && stack.getDamageValue() < stack.getMaxDamage()) {

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
                level.playSound(player, player.getX(), player.getY(), player.getZ(), manager.getUseSound(), SoundSource.PLAYERS, 1.0f, 1.0f);
                player.stopUsingItem();
                player.getCapability(ModCapabilities.PLAYER_THIRST).ifPresent(cap -> {
                    cap.drink(player, -(manager.getConsumeThirst() * (int) durabilityConsumption), 0);
                });
            }
        }
    }

}
