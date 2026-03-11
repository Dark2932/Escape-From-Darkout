package com.dark2932.efd.gui.blocks;

import com.dark2932.efd.gui.entity.MedicalCraftingTableEntities;
import com.dark2932.efd.gui.entity.MedicalCraftingTableEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class MedicalCraftingTableBlock extends Block implements EntityBlock {

    public MedicalCraftingTableBlock() {
        super(Properties.of()
                .strength(3.0f)
                .requiresCorrectToolForDrops());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MedicalCraftingTableEntity(pos, state);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        } else {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof MedicalCraftingTableEntity) {
                player.openMenu((MedicalCraftingTableEntity) blockEntity);
                return InteractionResult.CONSUME;
            }
            return InteractionResult.PASS;
        }
    }
}