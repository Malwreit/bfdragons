package com.malwreit.bfdragons.item;

import com.malwreit.bfdragons.item.custom.HammerItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item COIN = registerItem("coin", new Item(new Item.Settings()));
    public static final Item HAMMER = registerItem("hammer", new HammerItem(new Item.Settings().maxDamage(32)));
    public static final Item CRAM = registerItem("cram", new Item(new Item.Settings().food(ModFoodComponents.CRAM)));
    public static final Item FINEWOOD = registerItem("finewood", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(com.malwreit.bfdragons.BFDragons.MOD_ID, name), item);
    }

    public static void registerModItems() {
        com.malwreit.bfdragons.BFDragons.LOGGER.info("Registering Mod Items for " + com.malwreit.bfdragons.BFDragons.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(COIN);
        });
    }
}
