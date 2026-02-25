package com.dark2932.efd.datagen;

import com.dark2932.efd.EFD;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EFD.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EFDDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        //物品数据
        generator.addProvider(event.includeClient(), new EFDItemModelProvider(packOutput, EFD.MODID, existingFileHelper));
        //配方数据
        generator.addProvider(event.includeClient(), new EFDRecipeProvider(packOutput));
        //中文语言
        generator.addProvider(event.includeClient(), new EFDZhLanguageProvider(packOutput, EFD.MODID));
        //方块数据
        generator.addProvider(event.includeClient(), new EFDBlockModelProvider(packOutput, EFD.MODID, existingFileHelper));

    }
}
