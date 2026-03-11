package com.dark2932.efd.client;

import com.dark2932.efd.gui.container.MedicalCraftingContainer;
import com.dark2932.efd.gui.screen.MedicalCraftingScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EFDClient {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(MedicalCraftingContainer.MEDICAL_CRAFTING_TABLE.get(), MedicalCraftingScreen::new);
        });
    }

}
