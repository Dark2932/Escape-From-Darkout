package com.dark2932.efd.registry;

import com.dark2932.efd.EFD;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * @author Dark2932
 */
public class EFDItems {
    public static final DeferredRegister ItemRegister =
            DeferredRegister.create(ForgeRegistries.ITEMS, EFD.MODID);
    public static void initItems(){}

    public static final RegistryObject<Item> TEST_ITEM =
            ItemRegister.register("test_item",() -> new Item(new Item.Properties()));

    public static void ItemRegister(IEventBus bus) {
        ItemRegister.register(bus);
    }
}
