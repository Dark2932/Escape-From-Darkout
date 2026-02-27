package com.dark2932.efd;

import com.dark2932.efd.registry.EFDItems;
import com.dark2932.efd.registry.EFDMedical;
import com.dark2932.efd.registry.EFDTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(EFD.MODID)
public class EFD {

    public static final String MODID = "efd";

    public EFD(FMLJavaModLoadingContext context) {

        IEventBus bus = context.getModEventBus();

        bus.addListener(this::onFMLCommonSetup);

        EFDItems.ITEM_REGISTER.init(bus);
        EFDItems.FOOD_REGISTER.init(bus);
        EFDTabs.TAB_REGISTER.init(bus);
        EFDMedical.init(bus);

    }

    private void onFMLCommonSetup(FMLCommonSetupEvent event) {

    }

}
