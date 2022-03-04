package com.lierrepeur.hextech.innit;

import com.lierrepeur.hextech.Hextech;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public final class ModItems {
    private ModItems() {}
    //Items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Hextech.MOD_ID);

    public static final RegistryObject<Item> HEXTECH_STABILIZED_CRYSTAL = ITEMS.register("hextech_crystal_stabilized", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    public static final RegistryObject<Item> HEXTECH_CRYSTAL = ITEMS.register("hextech_crystal", () ->
            new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    //Block items
    public static final RegistryObject<BlockItem> HEXTECH_ORE_BLOCK = ITEMS.register("hextech_ore_block", () ->
            new BlockItem(ModBlocks.HEXTECH_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> STABILIZER_MECHANISM_BLOCK = ITEMS.register("stabilizer_mechanism_block", () ->
            new BlockItem(ModBlocks.STABILIZER_MECHANISM.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
}
