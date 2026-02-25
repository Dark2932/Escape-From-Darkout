package com.dark2932.efd.registry;

import com.dark2932.darklib.register.item.FoodRegister;
import com.dark2932.darklib.register.item.ItemRegister;
import com.dark2932.darklib.util.ItemEntry;
import com.dark2932.efd.EFD;
import com.dark2932.efd.util.accessor.ItemThirstAccessor;
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
    public static final ItemEntry TAURINE_CRYSTAL = newFood("taurine_crystal",
            new Item.Properties(),
            (newFoodProps().nutrition(1).saturationMod(3.5f)
                    .alwaysEat()
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20*100, 0, false, false, true), 0.75f)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20*100, 0, false, false, true), 0.75f)
            )
    );

    public static final ItemEntry TAURINE_DRINK = newFoodDrink("taurine_drink", 4, 4, STEEL_BOTTLE,
            new Item.Properties().stacksTo(16),
            (newFoodProps().nutrition(3).saturationMod(5.5f)
                    .alwaysEat()
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20 * 150, 2, false, false, true), 1.0f)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20 * 150, 1, false, false, true), 1.0f)
            )
    );

    /** 构建物品的私有方法 **/
//    private static ItemEntry newFoodDrink(String name, int thirst, int quenched, Item.Properties properties, FoodProperties.Builder builder) {
//        return newFoodDrink(name, thirst, quenched, null, properties, builder);
//    }

    private static ItemEntry newFoodDrink(String name, int thirst, int quenched, ItemEntry container, Item.Properties properties, FoodProperties.Builder builder) {
        FoodProperties foodProperties = builder.build();
        return newDrink(name, thirst, quenched, foodProperties.isFastFood(), container, properties.food(foodProperties));
    }

    private static ItemEntry newFood(String name, Item.Properties properties, FoodProperties.Builder builder) {
        return FOOD_REGISTER.newFood(name, properties, builder.build());
    }

//    private static ItemEntry newDrink(String name, int thirst, int quenched, boolean isFast, Item.Properties properties) {
//        return newDrink(name, thirst, quenched, isFast, null, properties);
//    }

    private static ItemEntry newDrink(String name, int thirst, int quenched, boolean isFast, ItemEntry container, Item.Properties properties) {
        return ITEM_REGISTER.newItem(name, () -> {
            DrinkableItem item = new DrinkableItem(properties).setDrinkDuration(isFast ? 16 : 32);
            if (container != null) item.setContainer(container.item());
            ((ItemThirstAccessor) item).getManager().setThirst(thirst).setQuenched(quenched);
            return item;
        });
    }

    private static FoodProperties.Builder newFoodProps() {
        return new FoodProperties.Builder();
    }

}