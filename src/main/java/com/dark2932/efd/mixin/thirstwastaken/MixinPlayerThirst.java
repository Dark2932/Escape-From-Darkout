package com.dark2932.efd.mixin.thirstwastaken;

import com.dark2932.efd.item.DrinkItem;
import com.dark2932.efd.item.manager.DrinkItemManager;
import dev.ghen.thirst.api.ThirstHelper;
import dev.ghen.thirst.content.purity.WaterPurity;
import dev.ghen.thirst.content.thirst.PlayerThirst;
import dev.ghen.thirst.foundation.common.capability.ModCapabilities;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author Dark2932
 */
@Mixin(value = PlayerThirst.class, remap = false)
public class MixinPlayerThirst {

    @Inject(method = "drink(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/player/Player;)V", at = @At(value = "TAIL"))
    private static void mixin$drink(ItemStack stack, Player player, CallbackInfo ci) {
        if (!ThirstHelper.itemRestoresThirst(stack) && stack.getItem() instanceof DrinkItem item) {
            DrinkItemManager manager = item.manager;
            WaterPurity.addPurity(stack, manager.getPurity());
            player.getCapability(ModCapabilities.PLAYER_THIRST).ifPresent(cap -> {
                if (WaterPurity.givePurityEffects(player, stack)) {
                    cap.drink(player, manager.getThirst(), manager.getQuenched());
                }
            });
        }
    }

}
