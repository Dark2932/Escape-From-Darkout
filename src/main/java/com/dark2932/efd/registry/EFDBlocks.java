package com.dark2932.efd.registry;

import com.dark2932.efd.EFD;
import com.dark2932.efd.gui.blocks.MedicalCraftingTableBlock;
import com.dark2932.efd.gui.entity.MedicalCraftingTableEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EFDBlocks {
    public static void initBlocks(){}
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EFD.MODID);

    public static final RegistryObject<Block> MEDICAL_CRAFTING_TABLE =
            BLOCKS.register("medical_crafting_table", MedicalCraftingTableBlock::new);

    // 注册方块物品
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EFD.MODID);

    public static final RegistryObject<Item> MEDICAL_CRAFTING_TABLE_ITEM = BLOCK_ITEMS.register("medical_crafting_table", () -> 
            new BlockItem(MEDICAL_CRAFTING_TABLE.get(), new Item.Properties())
    );

    // 初始化所有注册
    public static void init(IEventBus bus) {
        BLOCKS.register(bus);
        BLOCK_ITEMS.register(bus);
    }

}