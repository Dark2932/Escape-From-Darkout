//package com.dark2932.efd.registry;
//
//import com.dark2932.efd.EFD;
//import net.minecraft.world.item.BlockItem;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.Items;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.block.state.BlockBehaviour;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.RegistryObject;
//
//import java.util.function.Supplier;
//
//public class EFDBlocks {
//    public static void initBlocks(){}
//    public static final DeferredRegister<Block> BlockRegister =
//            DeferredRegister.create(ForgeRegistries.BLOCKS, EFD.MODID);
//    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
//        EFDCommonItems.ItemRegister.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
//    }
//    private static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block){
//        RegistryObject<T> blocks = BlockRegister.register(name,block);
//        registerBlockItem(name, blocks);
//        return blocks;
//    }
//
//    public static final RegistryObject<Block> TEST_BLOCK =
//            registryBlock("test_block",() -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
//}