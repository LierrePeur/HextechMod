package com.lierrepeur.hextech.innit;

import com.lierrepeur.hextech.Hextech;
import com.lierrepeur.hextech.entity.StabilizerBE;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModBlockEntities {
    private ModBlockEntities() {
    }

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Hextech.MOD_ID);

    public static final RegistryObject<BlockEntityType<StabilizerBE>> STABILIZER = BLOCK_ENTITIES
            .register("stabilizer_mechanism", () -> BlockEntityType.Builder.
                    of(StabilizerBE::new, ModBlocks.STABILIZER_MECHANISM.get()).build(null));
}
