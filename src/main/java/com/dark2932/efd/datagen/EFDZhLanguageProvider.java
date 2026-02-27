package com.dark2932.efd.datagen;

import com.dark2932.efd.registry.EFDItems;
import com.dark2932.efd.registry.EFDMedical;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class EFDZhLanguageProvider extends LanguageProvider {

    public EFDZhLanguageProvider(PackOutput output, String modid) {
        super(output, modid, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        add(EFDItems.STEEL_INGOT.item(),"钢锭");
        add(EFDMedical.STANDARD_FIRST_AID_KIT.get(),"标准军用医疗包");
        add(EFDMedical.RAPID_MEDICAL_KIT.get(),"926快速急救包");
        add(EFDMedical.E3_MILITARY_MEDICAL_KIT.get(),"E3军用医疗包");
        add(EFDMedical.STO_FIRST_AID_KIT.get(),"STO急救套装");
        add(EFDMedical.TMK_FIELD_MEDICAL_KIT.get(),"TMK野战医疗包");
        add(EFDMedical.BATTLEFIELD_MEDICAL_KIT.get(),"战地医疗包");
        add(EFDMedical.BASIC_FIRST_AID_KIT.get(),"简易医疗盒");
    }
}
