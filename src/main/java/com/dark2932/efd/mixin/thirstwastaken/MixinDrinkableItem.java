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

    @Unique private DrinkableItemManager manager;

    @Redirect(method = "finishUsingItem", at = @At(value = "INVOKE", target = "Ldev/ghen/thirst/content/thirst/PlayerThirst;drink(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/player/Player;)V"))
    private void drinkMixin(ItemStack stack, Player player) {
        WaterPurity.addPurity(stack, manager.getPurity());
        player.getCapability(ModCapabilities.PLAYER_THIRST).ifPresent(cap -> {
            if (WaterPurity.givePurityEffects(player, stack)) {
                cap.drink(player, manager.getThirst(), manager.getQuenched());
            }
        });
    }

    @Inject(method = "finishUsingItem", at = @At(value = "RETURN"), cancellable = true)
    private void eatMixin(ItemStack stack, Level level, LivingEntity entity, CallbackInfoReturnable<ItemStack> cir) {
        cir.setReturnValue(stack.isEdible() ? entity.eat(level, stack) : stack);
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