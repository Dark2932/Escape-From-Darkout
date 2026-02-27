package com.dark2932.efd.registry;

import com.dark2932.darklib.register.CreativeTabRegister;
import com.dark2932.efd.EFD;
import com.dark2932.efd.registry.item.EFDDrinkAndFoodItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.registries.RegistryObject;

/**
 * @author Dark2932
 */
public class EFDTabs {

    public static final CreativeTabRegister TAB_REGISTER = CreativeTabRegister.of(EFD.MODID);

    public static final RegistryObject<CreativeModeTab> TAB = TAB_REGISTER.newTab("efd_tab", () -> {
        return CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.efd.tab"))
            .icon(EFDDrinkAndFoodItems.TAURINE_DRINK::stack)
            .displayItems(TAB_REGISTER.getQuickGenerator())
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .build();
    });

}