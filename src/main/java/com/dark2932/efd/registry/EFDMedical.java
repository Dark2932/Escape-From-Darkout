package com.dark2932.efd.registry;

import com.dark2932.efd.EFD;
import com.dark2932.efd.util.manager.EFDMedicalManager;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EFDMedical {
    /**
     * 用于初始化医疗物品注册类
     **/
    public static void init(IEventBus bus){
        MedicalRegister.register(bus);
    }
    public static final DeferredRegister<Item> MedicalRegister =
            DeferredRegister.create(ForgeRegistries.ITEMS, EFD.MODID);

    public static final RegistryObject<Item> STANDARD_FIRST_AID_KIT =
            MedicalRegister.register("standard_first_aid_kit",() -> new EFDMedicalManager(new Item.Properties()
                    .stacksTo(16)
                    .rarity(Rarity.UNCOMMON)
            )
                    .setConsumption(2)
                    .setHealthRestore(4)
                    .setUsingTime(20*3/2)//1.5秒打药
                    .setThirstConsumption(2)
            );
}
