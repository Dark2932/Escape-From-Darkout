package com.dark2932.efd.registry.item;

import com.dark2932.darklib.register.item.ItemRegister;
import com.dark2932.darklib.util.ItemEntry;
import com.dark2932.efd.EFD;

/**
 * @author Dark2932
 */
public class EFDCommonItems {

    public static final ItemRegister ITEM_REGISTER = ItemRegister.of(EFD.MODID);

    public static final ItemEntry STEEL_INGOT = ITEM_REGISTER.newItem("steel_ingot");
    public static final ItemEntry HIGH_TOUGHNESS_STEEL = ITEM_REGISTER.newItem("high_toughness_steel");
    public static final ItemEntry TOOL_HAMMER = ITEM_REGISTER.newItem("tool_hammer");
    public static final ItemEntry THIN_STEEL_SHEET = ITEM_REGISTER.newItem("thin_steel_sheet");
    public static final ItemEntry STEEL_BOTTLE = ITEM_REGISTER.newItem("steel_bottle");

}