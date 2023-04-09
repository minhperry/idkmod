package dev.minhperry.bsv.Items;

import dev.minhperry.bsv.Configs.Config;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Register {

    public static Item registerItem(String itemID, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Config.getModNamespace(), itemID), item);
    }

    public static ItemGroup registerItemGroup(String groupID, Item groupIcon) {
        return FabricItemGroup.builder(new Identifier(Config.getModNamespace(), groupID))
                .icon(() -> new ItemStack(groupIcon))
                .build();
    }

    public static void addItemToGroup(Item item, ItemGroup group) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
}
