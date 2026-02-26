package com.dark2932.efd.util.manager;

import com.dark2932.darklib.util.ItemEntry;

/**
 * @author Dark2932
 */
public class DrinkableItemManager {

    private int thirst;
    private int quenched;
    private int purity = 3;
    private boolean isFast;
    private ItemEntry container;

    public int getThirst() {
        return thirst;
    }

    public int getQuenched() {
        return quenched;
    }

    public int getPurity() {
        return purity;
    }

    public ItemEntry getContainer() {
        return container;
    }

    public boolean isFastDrink() {
        return isFast;
    }

    public DrinkableItemManager thirst(int thirst) {
        this.thirst = thirst;
        return this;
    }

    public DrinkableItemManager quenched(int quenched) {
        this.quenched = quenched;
        return this;
    }

    public DrinkableItemManager purity(int purity) {
        this.purity = purity;
        return this;
    }

    public DrinkableItemManager container(ItemEntry item) {
        this.container = item;
        return this;
    }

    public DrinkableItemManager fast() {
        this.isFast = true;
        return this;
    }

    public DrinkableItemManager isFast(boolean isFast) {
        this.isFast = isFast;
        return this;
    }

}