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