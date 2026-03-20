package com.dark2932.efd.registry.item;

import com.dark2932.efd.EFD;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EFDCommonItems {

    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, EFD.MODID);

    public static final RegistryObject<Item> STEEL_INGOT = newCommonItem("steel_ingot");
    public static final RegistryObject<Item> HIGH_TOUGHNESS_STEEL = newCommonItem("high_toughness_steel");
    public static final RegistryObject<Item> TOOL_HAMMER = newCommonItem("tool_hammer");
    public static final RegistryObject<Item> THIN_STEEL_SHEET = newCommonItem("thin_steel_sheet");
    public static final RegistryObject<Item> STEEL_BOTTLE = newCommonItem("steel_bottle");

    /** 构建物品的私有方法 **/
    private static RegistryObject<Item> newCommonItem(String name) {
        return REGISTER.register(name, () -> new Item(new Item.Properties()));
    }

    public static void init(IEventBus bus) {
        REGISTER.register(bus);
    }

}