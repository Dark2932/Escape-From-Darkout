package com.dark2932.efd.registry;

import com.dark2932.darklib.register.block.BlockRegister;
import com.dark2932.darklib.util.BlockEntry;
import com.dark2932.efd.EFD;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * @author Dark2932
 */
public class EFDBlocks {

    public static void init(){}
    public static final BlockRegister BLOCK_REGISTER = BlockRegister.of(EFD.MODID);

    public static final BlockEntry TEST_BLOCK = BLOCK_REGISTER.newBlock("test_block");
    // ------------I made this from new start.-------------- //
    public static final DeferredRegister<Block> BlOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS,EFD.MODID);
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS,EFD.MODID);

    public static final RegistryObject<Block> HIGH_TOUGHNESS_STEEL_BLOCK = BlOCKS.register("high_toughness_steel_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .sound(SoundType.AMETHYST)
                    .strength(3.0f,3.0f)
            ));

    public static final RegistryObject<Item> HIGH_TOUGHNESS_STEEL_BLOCK_ITEM = ITEMS.register("high_toughness_steel_block",
            ()->new BlockItem(HIGH_TOUGHNESS_STEEL_BLOCK.get(),new Item.Properties()));
}