package com.lierrepeur.hextech.event;

import com.lierrepeur.hextech.innit.ModBlockEntities;
import com.lierrepeur.hextech.entity.StabilizerBE;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class StabilizerBlock implements EntityBlock {
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return ModBlockEntities.STABILIZER.get().create(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level lvl, BlockState state, BlockEntityType<T> entity) {
        return lvl.isClientSide ? null : ($0, $1, $2, blockEntity) -> ((StabilizerBE) blockEntity).tick();
    }
}
