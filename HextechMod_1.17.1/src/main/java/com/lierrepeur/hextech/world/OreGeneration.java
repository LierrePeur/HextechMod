package com.lierrepeur.hextech.world;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Supplier;

import com.lierrepeur.hextech.Hextech;
import com.lierrepeur.hextech.innit.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public abstract class OreGeneration {

    public static final List<ConfiguredFeature<?, ?>> OVERWORLD_ORES = new ArrayList<>();

    public static void registerOres() {
        ConfiguredFeature<?, ?> hextechOre = Feature.ORE.configured(new OreConfiguration(List.of(OreConfiguration
                .target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES,
                ModBlocks.HEXTECH_ORE.get().defaultBlockState())), 30)).rangeUniform(VerticalAnchor.bottom(),
                VerticalAnchor.absolute(30)).squared().count(1500);
        OVERWORLD_ORES.add(register("hextech_ore", hextechOre));
    }

    private static <Config extends FeatureConfiguration> ConfiguredFeature<Config, ?> register(String name,
                                                                                               ConfiguredFeature<Config, ?> feature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Hextech.MOD_ID, name), feature);
    }

    @Mod.EventBusSubscriber(modid = Hextech.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeBusSubscriber {
        @SubscribeEvent
        public static void biomeLoading(BiomeLoadingEvent event) {
            List<Supplier<ConfiguredFeature<?, ?>>> features = event.getGeneration()
                    .getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);
            if("minecraft".equals(event.getName().getNamespace()) && event.getCategory() != Biome.BiomeCategory.NETHER && event.getCategory() != Biome.BiomeCategory.THEEND) {
                OreGeneration.OVERWORLD_ORES.forEach(ore -> features.add(() -> ore));
            }
        }
    }
}
/*
public class OreGeneration {
    public static final List<ConfiguredFeature<?, ?>> OVERWORLD_ORES = new ArrayList<>();

    public static void registerOres(final BiomeLoadingEvent event) {
        ConfiguredFeature<?, ?> hextechOre = Feature.ORE.configured(new OreConfiguration(List.of(OreConfiguration
                .target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES,
                        ModBlocks.HEXTECH_ORE.get().defaultBlockState())), 30)).rangeUniform(VerticalAnchor.bottom(),
                VerticalAnchor.absolute(30)).squared().count(1500);
        OVERWORLD_ORES.add(register("hextech_ore", hextechOre));
    }

    private static <Config extends FeatureConfiguration> ConfiguredFeature<Config, ?> register(String name,
                                                                                               ConfiguredFeature<Config, ?> feature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Hextech.MOD_ID, name), feature);
    }

    @Mod.EventBusSubscriber(modid = Hextech.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeBusSubscriber {
        @SubscribeEvent
        public static void biomeLoading(BiomeLoadingEvent event) {
            List<Supplier<ConfiguredFeature<?, ?>>> features = event.getGeneration()
                    .getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);
            if("minecraft".equals(event.getName().getNamespace()) && event.getCategory() != Biome.BiomeCategory.NETHER && event.getCategory() != Biome.BiomeCategory.THEEND) {
                OreGeneration.OVERWORLD_ORES.forEach(ore -> features.add(() -> ore));
            }
        }
    }
}
//Common mod events
*//*
package com.lierrepeur.hextech.event;


import com.lierrepeur.hextech.Hextech;
import com.lierrepeur.hextech.world.OreGeneration;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = Hextech.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonModEvents {
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(OreGeneration::registerOres);
    }
}

 */