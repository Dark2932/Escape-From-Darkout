package com.dark2932.efd.datagen;

import com.dark2932.efd.registry.EFDItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class EFDItemModelProvider extends ItemModelProvider {
    public EFDItemModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(EFDItems.STEEL_INGOT.item());
        basicItem(EFDItems.TAURINE_DRINK.item());
    }
}
