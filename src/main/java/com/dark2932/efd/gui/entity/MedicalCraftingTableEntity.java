package com.dark2932.efd.gui.entity;

import com.dark2932.efd.gui.container.MedicalCraftingContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class MedicalCraftingTableEntity extends BlockEntity implements Container, MenuProvider {
    // 9个输入槽位 + 1个输出槽位
    private final NonNullList<ItemStack> items = NonNullList.withSize(10, ItemStack.EMPTY);

    public MedicalCraftingTableEntity(BlockPos pos, BlockState state) {
        super(null, pos, state);
    }

    @Override
    public int getContainerSize() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        return items.stream().allMatch(ItemStack::isEmpty);
    }

    @Override
    public ItemStack getItem(int pSlot) {
        return items.get(pSlot);
    }

    @Override
    public ItemStack removeItem(int pSlot, int pAmount) {
        return ContainerHelper.removeItem(items, pSlot, pAmount);
    }

    @Override
    public ItemStack removeItemNoUpdate(int pSlot) {
        return ContainerHelper.takeItem(items, pSlot);
    }

    @Override
    public void setItem(int pSlot, ItemStack pStack) {
        items.set(pSlot, pStack);
        setChanged();
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        if (this.level == null) return false;
        BlockPos blockPos = this.getBlockPos();
        // 检查玩家距离方块是否在合理范围内
        return pPlayer.distanceToSqr(
                (double) blockPos.getX() + 0.5,
                (double) blockPos.getY() + 0.5,
                (double) blockPos.getZ() + 0.5
        ) < 64.0; // 8格距离
    }

    @Override
    public void clearContent() {
        items.clear();
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("医疗物品合成台");
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        ContainerHelper.saveAllItems(tag, items);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        ContainerHelper.loadAllItems(tag, items);
    }

    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInventory, Player player) {
        return new MedicalCraftingContainer(containerId, playerInventory, this);
    }
}
