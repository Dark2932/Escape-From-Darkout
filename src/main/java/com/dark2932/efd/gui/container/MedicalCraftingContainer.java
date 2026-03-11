package com.dark2932.efd.gui.container;

import com.dark2932.efd.EFD;
import com.dark2932.efd.gui.entity.MedicalCraftingTableEntity;
import com.dark2932.efd.registry.EFDBlocks;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

public class MedicalCraftingContainer extends AbstractContainerMenu {

    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, EFD.MODID);

    public static final RegistryObject<MenuType<MedicalCraftingContainer>> MEDICAL_CRAFTING_TABLE = CONTAINERS.register("medical_crafting_table",
            () -> IForgeMenuType.create((windowId, inv, data) -> {
                return new MedicalCraftingContainer(windowId, inv, (MedicalCraftingTableEntity) inv.player.level().getBlockEntity(data.readBlockPos()));
            }));

    private final MedicalCraftingTableEntity blockEntity;

    protected MedicalCraftingContainer(@Nullable MenuType<?> pMenuType, int pContainerId) {
        super(pMenuType, pContainerId);
        this.blockEntity = null;
    }

    public MedicalCraftingContainer(int id, Inventory inventory, MedicalCraftingTableEntity entity) {
        super(MEDICAL_CRAFTING_TABLE.get(), id);
        this.blockEntity = entity;

        // 初始化槽位
        this.addSlot(new Slot(entity, 0, 30, 17));   // 输入槽 1
        this.addSlot(new Slot(entity, 1, 48, 17));   // 输入槽 2
        this.addSlot(new Slot(entity, 2, 66, 17));   // 输入槽 3
        this.addSlot(new Slot(entity, 3, 30, 35));  // 输入槽 4
        this.addSlot(new Slot(entity, 4, 48, 35));  // 输入槽 5
        this.addSlot(new Slot(entity, 5, 66, 35));  // 输入槽 6
        this.addSlot(new Slot(entity, 6, 30, 53));  // 输入槽 7
        this.addSlot(new Slot(entity, 7, 48, 53));  // 输入槽 8
        this.addSlot(new Slot(entity, 8, 66, 53));  // 输入槽 9
        this.addSlot(new Slot(entity, 9, 124, 35) { // 输出槽
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }
        });

        // 玩家物品栏
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(inventory, 9 + col + row * 9, 8 + col * 18, 84 + row * 18));
            }
        }

        // 快捷栏
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(inventory, col, 8 + col * 18, 142));
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();

            if (index == 9) { // 从输出槽移动
                if (!this.moveItemStackTo(itemstack1, 10, 46, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (index > 9) { // 从玩家物品栏移动到输入槽
                if (!this.moveItemStackTo(itemstack1, 0, 9, false)) {
                    return ItemStack.EMPTY;
                }
            } else { // 从输入槽移动到玩家物品栏
                if (!this.moveItemStackTo(itemstack1, 10, 46, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    @Override
    public boolean stillValid(Player player) {
        return blockEntity != null && blockEntity.stillValid(player);
    }
}