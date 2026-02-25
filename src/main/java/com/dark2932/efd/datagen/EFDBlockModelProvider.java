package com.dark2932.efd.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class EFDBlockModelProvider extends BlockStateProvider {

    public EFDBlockModelProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //simpleBlockWithItem(EFDBlocks.BlockOne.get(), cubeAll(EFDBlock.BlockOne.get()));
    }
}
