package com.dark2932.efd;

import com.dark2932.efd.gui.container.MedicalCraftingContainer;
import com.dark2932.efd.gui.entity.MedicalCraftingTableEntities;
import com.dark2932.efd.registry.EFDBlocks;
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

        // 先注册方块
        EFDBlocks.init(bus);
        // 然后注册方块实体
        MedicalCraftingTableEntities.BLOCK_ENTITIES.register(bus);
        // 最后注册容器
        MedicalCraftingContainer.CONTAINERS.register(bus);

        EFDCommonItems.init(bus);
        EFDMedicalItems.init(bus);
        EFDDrinkAndFoodItems.init(bus);

        EFDTabs.TAB_REGISTER.init(bus);

    }

    private void onFMLCommonSetup(FMLCommonSetupEvent event) {

    }

}
