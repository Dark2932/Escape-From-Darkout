package com.dark2932.efd.mixin.thirstwastaken;

import com.dark2932.efd.mixin.thirstwastaken.accessor.ItemThirstAccessor;
import com.dark2932.efd.mixin.thirstwastaken.manager.ItemThirstManager;
import dev.ghen.thirst.content.purity.WaterPurity;
import dev.ghen.thirst.foundation.common.capability.ModCapabilities;
import dev.ghen.thirst.foundation.common.item.DrinkableItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * @author Dark2932
 */
@Mixin(DrinkableItem.class)
public abstract class MixinDrinkableItem implements ItemThirstAccessor {

    @Unique private final ItemThirstManager manager = new ItemThirstManager();

    @Redirect(method = "finishUsingItem", at = @At(value = "INVOKE", target = "Ldev/ghen/thirst/content/thirst/PlayerThirst;drink(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/player/Player;)V"))
    private void finishUsingItemMixin(ItemStack stack, Player player) {
        player.getCapability(ModCapabilities.PLAYER_THIRST).ifPresent(cap -> {
            if (WaterPurity.givePurityEffects(player, stack)) {
                cap.drink(player, manager.getThirst(), manager.getQuenched());
            }
        });
    }

    @Unique
    @Override
    public ItemThirstManager getManager() {
        return manager;
    }

}
