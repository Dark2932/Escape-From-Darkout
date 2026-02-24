package com.dark2932.efd;

import com.dark2932.efd.registry.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(EFD.MODID)
public class EFD {

    public static final String MODID = "efd";

    public EFD(FMLJavaModLoadingContext context) {

        EFDBlocks.initBlocks();
        EFDItems.initItems();
        EFDTabs.initTabs();
    }

//    private void commonSetup(FMLCommonSetupEvent event) {}

}
