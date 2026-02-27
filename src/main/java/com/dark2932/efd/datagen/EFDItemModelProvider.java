package com.dark2932.efd.datagen;

import com.dark2932.efd.registry.EFDItems;
import com.dark2932.efd.registry.EFDMedical;
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
        basicItem(EFDItems.HIGH_TOUGHNESS_STEEL.item());
        basicItem(EFDItems.STEEL_BOTTLE.item());
        basicItem(EFDItems.THIN_STEEL_SHEET.item());
        basicItem(EFDItems.TAURINE_CRYSTAL.item());
        basicItem(EFDItems.TAURINE_DRINK.item());
        basicItem(EFDItems.TOOL_HAMMER.item());
        basicItem(EFDMedical.STANDARD_FIRST_AID_KIT.get());
        basicItem(EFDMedical.RAPID_MEDICAL_KIT.get());
        basicItem(EFDMedical.E3_MILITARY_MEDICAL_KIT.get());
        basicItem(EFDMedical.TMK_FIELD_MEDICAL_KIT.get());
        basicItem(EFDMedical.STO_FIRST_AID_KIT.get());
        basicItem(EFDMedical.BATTLEFIELD_MEDICAL_KIT.get());
        basicItem(EFDMedical.BASIC_FIRST_AID_KIT.get());
    }
}
