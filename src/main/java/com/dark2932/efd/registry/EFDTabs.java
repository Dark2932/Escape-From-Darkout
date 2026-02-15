package com.dark2932.efd.registry;

import com.dark2932.darklib.register.CreativeTabRegister;
import com.dark2932.efd.EFD;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.RegistryObject;

/**
 * @author Dark2932
 */
public class EFDTabs {

    public static final CreativeTabRegister TAB_REGISTER = CreativeTabRegister.of(EFD.MODID);

    public static final RegistryObject<CreativeModeTab> EFD_TAB = TAB_REGISTER.newTab("efd_tab", EFDItems.TEST_ITEM);

}