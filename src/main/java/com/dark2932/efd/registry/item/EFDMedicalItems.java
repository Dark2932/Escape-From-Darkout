package com.dark2932.efd.registry.item;

import com.dark2932.darklib.register.item.ItemRegister;
import com.dark2932.darklib.util.ItemEntry;
import com.dark2932.efd.EFD;
import com.dark2932.efd.item.MedicalItem;
import com.dark2932.efd.item.manager.MedicalItemManager;
import net.minecraft.world.item.Item;

public class EFDMedicalItems {

    public static final ItemRegister ITEM_REGISTER = ItemRegister.of(EFD.MODID);

    /**
     * 标准军用医疗包 standard_first_aid_kit
     */
    public static final ItemEntry STANDARD_FIRST_AID_KIT = ITEM_REGISTER.newItem("standard_first_aid_kit", () -> new MedicalItem(
            new Item.Properties().stacksTo(1).durability(10),
            new MedicalItemManager().useDuration((int)(20*2.1)).consumeThirst(2)
    ));

    /**
     * 926快速医疗包 Rapid Medical Kit
     */
    public static final ItemEntry RAPID_MEDICAL_KIT = ITEM_REGISTER.newItem("rapid_medical_kit", () -> new MedicalItem(
            new Item.Properties().stacksTo(1).durability(12),
            new MedicalItemManager().useDuration((int)(20*3.2)).consumeThirst(3)
    ));

    /**
     * E3军用医疗包Military medical kit
     */
    public static final ItemEntry E3_MILITARY_MEDICAL_KIT = ITEM_REGISTER.newItem("e3_military_medical_kit", () -> new MedicalItem(
            new Item.Properties().stacksTo(1).durability(20),
            new MedicalItemManager().useDuration((int)(20*4.1)).consumeThirst(3)
    ));

    /**
     * TMK野战医疗包tmk_field_medical_kit
     */
    public static final ItemEntry TMK_FIELD_MEDICAL_KIT = ITEM_REGISTER.newItem("tmk_field_medical_kit", () -> new MedicalItem(
            new Item.Properties().stacksTo(1).durability(38),
            new MedicalItemManager().useDuration((int)(20*4.1)).consumeThirst(3)
    ));

    /**
     * STO急救套装sto_first_aid_kit
     */
    public static final ItemEntry STO_FIRST_AID_KIT = ITEM_REGISTER.newItem("sto_first_aid_kit", () -> new MedicalItem(
            new Item.Properties().stacksTo(1).durability(70),
            new MedicalItemManager().useDuration((int)(20*3.3)).consumeThirst(2)
    ));

    /**
     * 战地医疗包 (battlefield_medical_kit)
     */
    public static final ItemEntry BATTLEFIELD_MEDICAL_KIT = ITEM_REGISTER.newItem("battlefield_medical_kit", () -> new MedicalItem(
            new Item.Properties().stacksTo(1).durability(30),
            new MedicalItemManager().useDuration((int)(20*4.1)).consumeThirst(0)
    ));

    /**
     * 简易医疗盒 (basic_first_aid_kit)
     */
    public static final ItemEntry BASIC_FIRST_AID_KIT = ITEM_REGISTER.newItem("basic_first_aid_kit", () -> new MedicalItem(
            new Item.Properties().stacksTo(1).durability(8),
            new MedicalItemManager().consumeThirst(2).useDuration(2*20)
    ));

}
