package dev.minhperry.bsv.Items;

import dev.minhperry.bsv.Utils.BlockUtils;
import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class OreLocator extends Item {

    private String itemID = "ore_locator";

    public String getItemID() {
        return itemID;
    }

    public OreLocator(Settings settings) {
        super(settings);
    }

    public Map<Block, Integer> scanBlocks(World world, BlockPos center) {
        Map<Block, Integer> blockCounts = new HashMap<>();

        int radius = 10; // half of the cube size
        BlockPos.Mutable mutablePos = new BlockPos.Mutable();

        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    mutablePos.set(center.getX() + x, center.getY() + y, center.getZ() + z);
                    BlockState blockState = world.getBlockState(mutablePos);
                    Block block = blockState.getBlock();

                    int count = blockCounts.getOrDefault(block, 0);
                    blockCounts.put(block, count + 1);
                }
            }
        }

        return blockCounts;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        Map<Block, Integer> scanner = scanBlocks(world, player.getBlockPos());

        Iterator<Entry<Block, Integer>> scannerIter = scanner.entrySet().iterator();
        StringBuilder builder = new StringBuilder();
        builder.append("=======================================\n");
        while (scannerIter.hasNext()) {
            Entry<Block, Integer> current = scannerIter.next();
            Block block = current.getKey();
            Integer amount = current.getValue();
            if (BlockUtils.isOre(current.getKey()))
                builder.append(block.toString()).append("->").append(amount).append("\n");
        }
        builder.append("=======================================");

        player.sendMessage(Text.of(builder.toString()));

        try {
            MinecraftClient.getInstance().setScreen(new OreLocatorScreen(new OreLocatorGUI()));
        } catch (IllegalStateException ex) {
            player.sendMessage(Text.of("Error screen!"));
        }

        return TypedActionResult.success(player.getStackInHand(hand));
    }

}