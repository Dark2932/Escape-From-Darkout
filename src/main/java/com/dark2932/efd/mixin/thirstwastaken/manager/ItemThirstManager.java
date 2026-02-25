package com.dark2932.efd.mixin.thirstwastaken.manager;

/**
 * @author Dark2932
 */
public class ItemThirstManager {

    private int thirst;
    private int quenched;

    public int getThirst() {
        return thirst;
    }

    public int getQuenched() {
        return quenched;
    }

    public ItemThirstManager setThirst(int thirst) {
        this.thirst = thirst;
        return this;
    }

    public ItemThirstManager setQuenched(int quenched) {
        this.quenched = quenched;
        return this;
    }

}