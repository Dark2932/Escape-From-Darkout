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
        basicItem(EFDCommonItems.STEEL_INGOT.get());
        basicItem(EFDCommonItems.HIGH_TOUGHNESS_STEEL.get());
        basicItem(EFDCommonItems.STEEL_BOTTLE.get());
        basicItem(EFDCommonItems.THIN_STEEL_SHEET.get());
        basicItem(EFDCommonItems.TOOL_HAMMER.get());

        basicItem(EFDDrinkAndFoodItems.TAURINE_CRYSTAL.get());
        basicItem(EFDDrinkAndFoodItems.TAURINE_DRINK.get());
        basicItem(EFDDrinkAndFoodItems.COMPRESSED_BISCUITS.get());

        basicItem(EFDMedicalItems.STANDARD_FIRST_AID_KIT.get());
        basicItem(EFDMedicalItems.RAPID_MEDICAL_KIT.get());
        basicItem(EFDMedicalItems.E3_MILITARY_MEDICAL_KIT.get());
        basicItem(EFDMedicalItems.TMK_FIELD_MEDICAL_KIT.get());
        basicItem(EFDMedicalItems.STO_FIRST_AID_KIT.get());
        basicItem(EFDMedicalItems.BATTLEFIELD_MEDICAL_KIT.get());
        basicItem(EFDMedicalItems.BASIC_FIRST_AID_KIT.get());
        basicItem(EFDMedicalItems.AFAK_FIRST_AID_KIT.get());
        basicItem(EFDMedicalItems.CAR_FIRST_AID_KIT.get());
        basicItem(EFDMedicalItems.GRIZZLY_FIRST_AID_KIT.get());
        basicItem(EFDMedicalItems.IFAK_FIRST_AID_KIT.get());
        basicItem(EFDMedicalItems.SALEWA_FIRST_AID_KIT.get());
    }
}
