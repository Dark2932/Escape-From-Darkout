package com.dark2932.efd;

import com.dark2932.efd.registry.EFDTabs;
import com.dark2932.efd.registry.item.EFDCommonItems;
import com.dark2932.efd.registry.item.EFDDrinkAndFoodItems;
import com.dark2932.efd.registry.item.EFDMedicalItems;
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

        EFDCommonItems.ITEM_REGISTER.init(bus);
        EFDDrinkAndFoodItems.ITEM_REGISTER.init(bus);
        EFDDrinkAndFoodItems.FOOD_REGISTER.init(bus);
        EFDTabs.TAB_REGISTER.init(bus);
        EFDMedicalItems.ITEM_REGISTER.init(bus);

    }

    private void onFMLCommonSetup(FMLCommonSetupEvent event) {

    }

}
