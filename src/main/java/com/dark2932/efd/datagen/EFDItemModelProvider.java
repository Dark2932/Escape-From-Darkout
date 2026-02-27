package com.dark2932.efd.datagen;

import com.dark2932.efd.registry.item.EFDCommonItems;
import com.dark2932.efd.registry.item.EFDDrinkAndFoodItems;
import com.dark2932.efd.registry.item.EFDMedicalItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class EFDItemModelProvider extends ItemModelProvider {
    public EFDItemModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(EFDCommonItems.STEEL_INGOT.item());
        basicItem(EFDDrinkAndFoodItems.TAURINE_DRINK.item());
        basicItem(EFDCommonItems.HIGH_TOUGHNESS_STEEL.item());
        basicItem(EFDCommonItems.STEEL_BOTTLE.item());
        basicItem(EFDCommonItems.THIN_STEEL_SHEET.item());
        basicItem(EFDDrinkAndFoodItems.TAURINE_CRYSTAL.item());
        basicItem(EFDCommonItems.TOOL_HAMMER.item());
        basicItem(EFDMedicalItems.STANDARD_FIRST_AID_KIT.item());
        basicItem(EFDMedicalItems.RAPID_MEDICAL_KIT.item());
        basicItem(EFDMedicalItems.E3_MILITARY_MEDICAL_KIT.item());
        basicItem(EFDMedicalItems.TMK_FIELD_MEDICAL_KIT.item());
        basicItem(EFDMedicalItems.STO_FIRST_AID_KIT.item());
        basicItem(EFDMedicalItems.BATTLEFIELD_MEDICAL_KIT.item());
        basicItem(EFDMedicalItems.BASIC_FIRST_AID_KIT.item());
    }
}
