package com.dark2932.efd.mixin.thirstwastaken;

import com.dark2932.efd.util.accessor.DrinkableItemAccessor;
import com.dark2932.efd.util.manager.DrinkableItemManager;
import dev.ghen.thirst.content.purity.WaterPurity;
import dev.ghen.thirst.foundation.common.capability.ModCapabilities;
import dev.ghen.thirst.foundation.common.item.DrinkableItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * @author Dark2932
 */
@Mixin(value = DrinkableItem.class, remap = false)
public class MixinDrinkableItem implements DrinkableItemAccessor {

    @Unique
    private DrinkableItemManager manager;

    // 移除 @Redirect 方法，改用 @Inject 完全接管

    @Inject(method = "finishUsingItem", at = @At(value = "HEAD"), cancellable = true)
    private void finishUsingItemMixin(ItemStack stack, Level level, LivingEntity entity,
                                      CallbackInfoReturnable<ItemStack> cir) {
        if (entity instanceof Player player && manager != null) {
            // 处理 thirst 水分恢复（只调用一次）
            WaterPurity.addPurity(stack, manager.getPurity());
            player.getCapability(ModCapabilities.PLAYER_THIRST).ifPresent(cap -> {
                if (WaterPurity.givePurityEffects(player, stack)) {
                    cap.drink(player, manager.getThirst(), manager.getQuenched());
                }
            });

            // 处理食物恢复
            cir.setReturnValue(stack.isEdible() ? entity.eat(level, stack) : stack);
            cir.cancel();  // 取消原始方法，防止重复执行
        }
    }

    @Inject(method = "getUseAnimation", at = @At(value = "HEAD"), cancellable = true)
    private void getUseAnimationMixin(ItemStack stack, CallbackInfoReturnable<UseAnim> cir) {
        if (stack.isEdible()) cir.setReturnValue(UseAnim.EAT);
    }

    @Unique
    @Override
    public DrinkableItemManager getManager() {
        return manager;
    }

    @Unique
    @Override
    public DrinkableItemManager setManager(DrinkableItemManager manager) {
        return this.manager = manager;
    }
}