package com.lierrepeur.hextech.innit;

import com.lierrepeur.hextech.Hextech;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModBlocks {
    private ModBlocks() {}

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Hextech.MOD_ID);

    public static final RegistryObject<Block> HEXTECH_ORE = BLOCKS.register("hextech_ore", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.5f,
                    1.0f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> STABILIZER_MECHANISM = BLOCKS.register("stabilizer_mechanism", () ->
            new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(1.5f,
                    1.0f).sound(SoundType.ANVIL)));
}
