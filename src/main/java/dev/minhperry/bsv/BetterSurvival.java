package dev.minhperry.bsv;

import dev.minhperry.bsv.Items.OreLocatorGUI;
import dev.minhperry.bsv.Items.Register;
import dev.minhperry.bsv.Items.OreLocator;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterSurvival implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("better-survival");

    public static final OreLocator OL = new OreLocator(new FabricItemSettings().maxDamage(20));

    private static final ItemGroup BSV = Register.registerItemGroup("bsv_items", OL);


    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        Register.registerItem(OL.getItemID(), OL);
        Register.addItemToGroup(OL, BSV);

        LOGGER.info("Hello Fabric world!");


    }
}