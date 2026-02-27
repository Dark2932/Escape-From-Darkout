package com.dark2932.efd.registry;

import com.dark2932.efd.EFD;
import com.dark2932.efd.util.manager.EFDMedicalManager;
import net.minecraft.world.item.Item;
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

    /**
     * 标准军用医疗包 standard_first_aid_kit
     */
    public static final RegistryObject<Item> STANDARD_FIRST_AID_KIT =
            MedicalRegister.register("standard_first_aid_kit",() -> new EFDMedicalManager(new Item.Properties()
                    .stacksTo(1),10
            )
                    .setUsingTime((int)(20*2.1))
                    .setThirstConsumption(2)
            );

    /**
     * 926快速医疗包 Rapid Medical Kit
     */
    public static final RegistryObject<Item> RAPID_MEDICAL_KIT =
            MedicalRegister.register("rapid_medical_kit", () -> new EFDMedicalManager(new Item.Properties()
                    .stacksTo(1),12
            )
                    .setUsingTime((int)(20*3.2))
                    .setThirstConsumption(3)
            );

    /**
     * E3军用医疗包Military medical kit
     */
    public static final RegistryObject<Item> E3_MILITARY_MEDICAL_KIT =
            MedicalRegister.register("e3_military_medical_kit", () -> new EFDMedicalManager(new Item.Properties()
                    .stacksTo(1),20
            )
                            .setUsingTime((int)(20*4.1))
                            .setThirstConsumption(3)
            );
    /**
     * TMK野战医疗包tmk_field_medical_kit
     */
    public static final RegistryObject<Item> TMK_FIELD_MEDICAL_KIT =
            MedicalRegister.register("tmk_field_medical_kit",() -> new EFDMedicalManager(new Item.Properties()
                    .stacksTo(1),38
            )
                            .setUsingTime((int)(20*4.1))
                            .setThirstConsumption(3)
            );
    /**
     * STO急救套装sto_first_aid_kit
     */
    public static final RegistryObject<Item> STO_FIRST_AID_KIT =
            MedicalRegister.register("sto_first_aid_kit",()-> new EFDMedicalManager(new Item.Properties()
                    .stacksTo(1),70
            )
                    .setThirstConsumption(2)
                    .setUsingTime((int)(20*3.3))
            );
    /**
     * 战地医疗包 (battlefield_medical_kit)
     */
    public static final RegistryObject<Item> BATTLEFIELD_MEDICAL_KIT =
            MedicalRegister.register("battlefield_medical_kit",()-> new EFDMedicalManager(new Item.Properties()
                    .stacksTo(1),30
            )
                    .setUsingTime((int)(20*4.1))
                    .setThirstConsumption(0)
            );
}
