package com.dark2932.efd.registry.item;

import com.dark2932.efd.EFD;
import com.dark2932.thirst_was_tweaked.content.item.DrinkItem;
import com.dark2932.thirst_was_tweaked.content.item.DrinkItemManager;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EFDDrinkAndFoodItems {

    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, EFD.MODID);

    public static final RegistryObject<Item> BRAISED_BEEF_CAN = newFood("braised_beef_can",
            new Item.Properties(),
            new FoodProperties.Builder()
                    .nutrition(16)
                    .saturationMod(20.0f)
                    .alwaysEat()
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60 * 20, 0, false, false, true), 1.0f)
    );

    public static final RegistryObject<Item> TAURINE_CRYSTAL = newFood("taurine_crystal",
            new Item.Properties(),
            new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(3.5f)
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100 * 20, 0, false, false, true), 0.75f)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100 * 20, 0, false, false, true), 0.75f)
    );

    public static final RegistryObject<Item> COMPRESSED_BISCUITS = newDrinkableFood("compressed_biscuits",
            new Item.Properties().stacksTo(16),
            new FoodProperties.Builder()
                    .nutrition(10)
                    .saturationMod(2.5f),
            new DrinkItemManager()
                    .thirst(-3)
                    .foodAnim()
    );

    public static final RegistryObject<Item> TAURINE_DRINK = newDrinkableFood("taurine_drink",
            new Item.Properties().stacksTo(16),
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(5.5f)
                    .alwaysEat(),
            new DrinkItemManager()
                    .thirst(4)
                    .quenched(4)
                    .container(EFDCommonItems.STEEL_BOTTLE.get())
                    .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 150 * 20, 1, false, false, true), 1.0f)
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 150 * 20, 2, false, false, true), 1.0f)
    );

    /** 构建物品的私有方法 **/
    private static RegistryObject<Item> newDrinkableFood(String name, Item.Properties iProp, FoodProperties.Builder fBuilder, DrinkItemManager dProp) {
        return newDrink(name, iProp.food(fBuilder.build()), dProp);
    }

    private static RegistryObject<Item> newDrink(String name, Item.Properties iProp, DrinkItemManager dProp) {
        return REGISTER.register(name, () -> new DrinkItem(iProp, dProp));
    }

    private static RegistryObject<Item> newFood(String name, Item.Properties properties, FoodProperties.Builder builder) {
        return REGISTER.register(name, () -> new Item(properties.food(builder.build())));
    }

    public static void init(IEventBus bus) {
        REGISTER.register(bus);
    }

}
