package com.dark2932.efd.gui.entity;


import com.dark2932.efd.EFD;
import com.dark2932.efd.registry.EFDBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MedicalCraftingTableEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, EFD.MODID);

    public static final RegistryObject<BlockEntityType<MedicalCraftingTableEntity>> MEDICAL_CRAFTING_TABLE = 
            BLOCK_ENTITIES.register("medical_crafting_table", () -> 
                BlockEntityType.Builder.of(MedicalCraftingTableEntity::new, 
                    EFDBlocks.MEDICAL_CRAFTING_TABLE.get()).build(null)
            );
}
