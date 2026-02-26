package com.dark2932.efd.registry;

import com.dark2932.darklib.register.item.FoodRegister;
import com.dark2932.darklib.register.item.ItemRegister;
import com.dark2932.darklib.util.ItemEntry;
import com.dark2932.efd.EFD;
import com.dark2932.efd.util.accessor.DrinkableItemAccessor;
import com.dark2932.efd.util.manager.DrinkableItemManager;
import dev.ghen.thirst.foundation.common.item.DrinkableItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;

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

    public static final ItemEntry TAURINE_DRINK = newDrinkableFood("taurine_drink",
            new Item.Properties().stacksTo(16),
            new DrinkableItemManager().thirst(4).quenched(4).container(STEEL_BOTTLE),
            (newFoodProps().nutrition(3).saturationMod(5.5f)
                    .alwaysEat()
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20 * 150, 2, false, false, true), 1.0f)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20 * 150, 1, false, false, true), 1.0f)
            )
    );

    /** 构建物品的私有方法 **/
    private static ItemEntry newDrinkableFood(String name, Item.Properties iProp, DrinkableItemManager dProp, FoodProperties.Builder fBuilder) {
        FoodProperties fProp = fBuilder.build();
        return newDrink(name, iProp.food(fProp), dProp.isFast(fProp.isFastFood()));
    }

    private static ItemEntry newDrink(String name, Item.Properties iProp, DrinkableItemManager dProp) {
        return ITEM_REGISTER.newItem(name, () -> {
            DrinkableItem item = new DrinkableItem(iProp).setDrinkDuration(dProp.isFastDrink() ? 16 : 32);
            if (dProp.getContainer() != null) item.setContainer(dProp.getContainer().item());
            ((DrinkableItemAccessor) item).setManager(dProp);
            return item;
        });
    }

    private static ItemEntry newFood(String name, Item.Properties properties, FoodProperties.Builder builder) {
        return FOOD_REGISTER.newFood(name, properties, builder.build());
    }

    private static FoodProperties.Builder newFoodProps() {
        return new FoodProperties.Builder();
    }

}