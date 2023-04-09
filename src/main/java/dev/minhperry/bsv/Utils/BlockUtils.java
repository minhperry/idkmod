package dev.minhperry.bsv.Utils;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;

import java.util.Arrays;
import java.util.List;

public class BlockUtils {
    public static boolean isOre(Block block) {
        Block[] ores = {
                Blocks.COAL_ORE,
                Blocks.DEEPSLATE_COAL_ORE,
                Blocks.COPPER_ORE,
                Blocks.DEEPSLATE_COPPER_ORE,
                Blocks.IRON_ORE,
                Blocks.DEEPSLATE_IRON_ORE,
                Blocks.DIAMOND_ORE,
                Blocks.DEEPSLATE_DIAMOND_ORE,
                Blocks.EMERALD_ORE,
                Blocks.DEEPSLATE_EMERALD_ORE,
                Blocks.GOLD_ORE,
                Blocks.DEEPSLATE_GOLD_ORE,
                Blocks.REDSTONE_ORE,
                Blocks.DEEPSLATE_REDSTONE_ORE,
                Blocks.LAPIS_ORE,
                Blocks.DEEPSLATE_LAPIS_ORE,
                Blocks.NETHER_QUARTZ_ORE,
                Blocks.NETHER_GOLD_ORE
        };
        return Arrays.asList(ores).contains(block);
    }
}
