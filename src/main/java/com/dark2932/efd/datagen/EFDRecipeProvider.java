package com.dark2932.efd.datagen;

import com.dark2932.efd.EFD;
import com.dark2932.efd.registry.EFDItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class EFDRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public EFDRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        // 1铁锭 -> 1钢锭
        SimpleCookingRecipeBuilder.smelting(
                Ingredient.of(Items.IRON_INGOT),//输入物品
                RecipeCategory.BUILDING_BLOCKS,//配方类型
                EFDItems.STEEL_INGOT.item(),//输出物品
                0.7f,//获取经验值
                20*7//熔炼时间
        )
                .unlockedBy("has_iron_ingot",has(Items.IRON_INGOT))
                .save(consumer, EFD.MODID + "steel_ingot_from_smelting");
    }
}
