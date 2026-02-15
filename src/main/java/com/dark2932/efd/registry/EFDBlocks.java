package com.dark2932.efd.registry;

import com.dark2932.darklib.register.block.BlockRegister;
import com.dark2932.darklib.util.BlockEntry;
import com.dark2932.efd.EFD;

/**
 * @author Dark2932
 */
public class EFDBlocks {

    public static final BlockRegister BLOCK_REGISTER = BlockRegister.of(EFD.MODID);

    public static final BlockEntry TEST_BLOCK = BLOCK_REGISTER.newBlock("test_item");

}