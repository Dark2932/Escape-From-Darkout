package com.dark2932.efd.registry;

import com.dark2932.darklib.register.item.ItemRegister;
import com.dark2932.darklib.util.ItemEntry;
import com.dark2932.efd.EFD;

/**
 * @author Dark2932
 */
public class EFDItems {

    public static final ItemRegister ITEM_REGISTER = ItemRegister.of(EFD.MODID);

    public static final ItemEntry TEST_ITEM = ITEM_REGISTER.newItem("test_item");

}
