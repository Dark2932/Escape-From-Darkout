package com.dark2932.efd.item;

import net.minecraft.world.item.Item;

public abstract class ManageredItem<M> extends Item {

    private final M manager;

    public ManageredItem(Properties properties, M manager) {
        super(properties);
        this.manager = manager;
    }

    public M getManager() {
        return manager;
    }

}
