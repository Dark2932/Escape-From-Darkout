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
    }
}
