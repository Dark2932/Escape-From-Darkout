package com.dark2932.efd.datagen;

import com.dark2932.efd.registry.item.EFDCommonItems;
import com.dark2932.efd.registry.item.EFDDrinkAndFoodItems;
import com.dark2932.efd.registry.item.EFDMedicalItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class EFDZhLanguageProvider extends LanguageProvider {

    public EFDZhLanguageProvider(PackOutput output, String modid) {
        super(output, modid, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.efd.tab", "Escape From Darkout");

        add(EFDCommonItems.STEEL_INGOT.item(),"钢锭");
        add(EFDCommonItems.STEEL_BOTTLE.item(),"钢瓶");
        add(EFDCommonItems.HIGH_TOUGHNESS_STEEL.item(),"高韧钢");
        add(EFDCommonItems.THIN_STEEL_SHEET.item(),"薄钢板");
        add(EFDCommonItems.TOOL_HAMMER.item(),"锤子");

        add(EFDDrinkAndFoodItems.TAURINE_CRYSTAL.item(),"牛磺酸结晶");
        add(EFDDrinkAndFoodItems.TAURINE_DRINK.item(),"牛磺酸饮料");
        add(EFDDrinkAndFoodItems.COMPRESSED_BISCUITS.item(),"压缩饼干");

        add(EFDMedicalItems.STANDARD_FIRST_AID_KIT.item(),"标准军用医疗包");
        add(EFDMedicalItems.RAPID_MEDICAL_KIT.item(),"926快速急救包");
        add(EFDMedicalItems.E3_MILITARY_MEDICAL_KIT.item(),"E3军用医疗包");
        add(EFDMedicalItems.STO_FIRST_AID_KIT.item(),"STO急救套装");
        add(EFDMedicalItems.TMK_FIELD_MEDICAL_KIT.item(),"TMK野战医疗包");
        add(EFDMedicalItems.BATTLEFIELD_MEDICAL_KIT.item(),"战地医疗包");
        add(EFDMedicalItems.BASIC_FIRST_AID_KIT.item(),"简易医疗盒");
    }

}