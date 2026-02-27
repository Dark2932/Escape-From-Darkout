package com.dark2932.efd.util.manager;

import com.dark2932.darklib.util.ItemEntry;

/**
 * @author Dark2932
 */
public class DrinkItemManager {

    private int thirst; //可恢复的口渴值
    private int quenched; //可恢复的水合度（饱水度）
    private int purity = 3; //0-3，分别为[脏，有点脏的，能接受的，纯净]
    private int useDuration = 32; //使用时间，原版默认32tick
    private ItemEntry container; //喝完后返还的物品
    private boolean foodAnim; //true播放吃东西的动画，默认为false，即播放喝东西的动画

    public int getThirst() {
        return thirst;
    }

    public int getQuenched() {
        return quenched;
    }

    public int getPurity() {
        return purity;
    }

    public int getUseDuration() {
        return useDuration;
    }

    public ItemEntry getContainer() {
        return container;
    }

    public boolean isFoodAnim() {
        return foodAnim;
    }

    public DrinkItemManager thirst(int thirst) {
        this.thirst = thirst;
        return this;
    }

    public DrinkItemManager quenched(int quenched) {
        this.quenched = quenched;
        return this;
    }

    public DrinkItemManager purity(int purity) {
        this.purity = purity;
        return this;
    }

    public DrinkItemManager useDuration(int useDuration) {
        this.useDuration = useDuration;
        return this;
    }

    public DrinkItemManager container(ItemEntry item) {
        this.container = item;
        return this;
    }

    public DrinkItemManager food() {
        this.foodAnim = true;
        return this;
    }

}