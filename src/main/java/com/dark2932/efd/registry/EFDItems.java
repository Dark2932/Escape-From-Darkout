package com.dark2932.efd.registry;

import com.dark2932.darklib.register.item.FoodRegister;
import com.dark2932.darklib.register.item.ItemRegister;
import com.dark2932.darklib.util.ItemEntry;
import com.dark2932.efd.EFD;
import dev.ghen.thirst.foundation.common.item.DrinkableItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

/**
 * @author Dark2932
 */
public class EFDItems {

    public static final ItemRegister ITEM_REGISTER = ItemRegister.of(EFD.MODID);
    public static final FoodRegister FOOD_REGISTER = FoodRegister.of(EFD.MODID);

    /** 普通物品 **/
    public static final ItemEntry STEEL_INGOT = ITEM_REGISTER.newItem("steel_ingot");
    public static final ItemEntry HIGH_TOUGHNESS_STEEL = ITEM_REGISTER.newItem("high_toughness_steel");
    public static final ItemEntry HAMMER = ITEM_REGISTER.newItem("hammer");
    public static final ItemEntry THIN_STEEL_SHEET = ITEM_REGISTER.newItem("thin_steel_sheet");
    public static final ItemEntry STEEL_BOTTLE = ITEM_REGISTER.newItem("steel_bottle");

    /** 食物与饮品 **/
    public static final ItemEntry TAURINE_DRINK = newFoodDrink("taurine_drink", STEEL_BOTTLE,
            new Item.Properties().stacksTo(16),
            (newFoodProps().nutrition(3).saturationMod(5.5f)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600), 1.0f)
                    .fast()
                    .alwaysEat()
            )
    );

    /** 构建物品的私有方法 **/
    private static ItemEntry newDrink(String name, boolean isFast, Item.Properties properties) {
        return ITEM_REGISTER.newItem(name, () -> new DrinkableItem(properties).setDrinkDuration(isFast ? 16 : 32));
    }

    private static ItemEntry newDrink(String name, boolean isFast, ItemEntry container, Item.Properties properties) {
        return ITEM_REGISTER.newItem(name, () -> new DrinkableItem(properties).setDrinkDuration(isFast ? 16 : 32).setContainer(container.item()));
    }

    private static ItemEntry newFoodDrink(String name, Item.Properties properties, FoodProperties.Builder builder) {
        FoodProperties foodProperties = builder.build();
        return newDrink(name, foodProperties.isFastFood(), properties.food(foodProperties));
    }

    private static ItemEntry newFoodDrink(String name, ItemEntry container, Item.Properties properties, FoodProperties.Builder builder) {
        FoodProperties foodProperties = builder.build();
        return newDrink(name, foodProperties.isFastFood(), container, properties.food(foodProperties));
    }

    private static FoodProperties.Builder newFoodProps() {
        return new FoodProperties.Builder();
    }

}