package com.lierrepeur.hextech.entity;

import com.lierrepeur.hextech.innit.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class StabilizerBE extends BlockEntity {
    public StabilizerBE(BlockPos pos, BlockState state) {
        super(ModBlockEntities.STABILIZER.get(), pos, state);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
    }

    @Override
    public CompoundTag save(CompoundTag nbt) {
        return super.save(nbt);
    }

    public void tick() {

    }

}
