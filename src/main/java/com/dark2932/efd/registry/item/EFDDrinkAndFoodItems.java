package com.dark2932.efd.registry.item;

import com.dark2932.darklib.register.item.FoodRegister;
import com.dark2932.darklib.register.item.ItemRegister;
import com.dark2932.darklib.util.ItemEntry;
import com.dark2932.efd.EFD;
import com.dark2932.efd.item.DrinkItem;
import com.dark2932.efd.item.manager.DrinkItemManager;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;

public class EFDDrinkAndFoodItems {

    public static final ItemRegister ITEM_REGISTER = ItemRegister.of(EFD.MODID);
    public static final FoodRegister FOOD_REGISTER = FoodRegister.of(EFD.MODID);

    public static void init(IEventBus bus) {
        ITEM_REGISTER.init(bus);
        FOOD_REGISTER.init(bus);
    }

    public static final ItemEntry TAURINE_CRYSTAL = newFood("taurine_crystal",
            new Item.Properties(),
            new FoodProperties.Builder().nutrition(1).saturationMod(3.5f)
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20*100, 0, false, false, true), 0.75f)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20*100, 0, false, false, true), 0.75f)
    );

    public static final ItemEntry TAURINE_DRINK = newDrinkableFood("taurine_drink",
            new Item.Properties().stacksTo(16),
            new DrinkItemManager().thirst(4).quenched(4)
                    .container(EFDCommonItems.STEEL_BOTTLE)
                    .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20 * 150, 1, false, false, true), 1.0f)
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20 * 150, 2, false, false, true), 1.0f),
            new FoodProperties.Builder().nutrition(3).saturationMod(5.5f)
                    .alwaysEat()
    );

    /** 构建物品的私有方法 **/
    private static ItemEntry newDrinkableFood(String name, Item.Properties iProp, DrinkItemManager dProp, FoodProperties.Builder fBuilder) {
        FoodProperties fProp = fBuilder.build();
        return newDrink(name, iProp.food(fProp), dProp);
    }

    private static ItemEntry newDrink(String name, Item.Properties iProp, DrinkItemManager dProp) {
        return ITEM_REGISTER.newItem(name, () -> new DrinkItem(iProp, dProp));
    }

    private static ItemEntry newFood(String name, Item.Properties properties, FoodProperties.Builder builder) {
        return FOOD_REGISTER.newFood(name, properties, builder.build());
    }

}
