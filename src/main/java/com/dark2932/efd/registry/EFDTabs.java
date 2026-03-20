package com.dark2932.efd.registry;

import com.dark2932.efd.EFD;
import com.dark2932.efd.registry.item.EFDDrinkAndFoodItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EFDTabs {

    public static final DeferredRegister<CreativeModeTab> REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EFD.MODID);

    public static final RegistryObject<CreativeModeTab> TAB = REGISTER.register("efd_tab", () ->
        CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.efd.tab"))
            .icon(() -> EFDDrinkAndFoodItems.TAURINE_DRINK.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                for (Item item : ForgeRegistries.ITEMS.getValues()) {
                    ResourceLocation id = ForgeRegistries.ITEMS.getKey(item);
                    if (id != null && id.getNamespace().equals("efd")) {
                        output.accept(item);
                    }
                }
            })
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .build()
    );

    public static void init(IEventBus bus) {
        REGISTER.register(bus);
    }

}