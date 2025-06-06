package com.malwreit.bfdragons.item;

import com.malwreit.bfdragons.item.custom.HammerItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item STEEL = registerItem("steel", new Item(new Item.Settings()));
    public static final Item HAMMER = registerItem("hammer", new HammerItem(new Item.Settings().maxDamage(32)));
    public static final Item CRAM = registerItem("cram", new Item(new Item.Settings().food(ModFoodComponents.CRAM)));
    public static final Item FINEWOOD = registerItem("finewood", new Item(new Item.Settings()));

    public static final Item STEEL_SWORD = registerItem("steel_sword",
            new SwordItem(ModToolMaterials.STEEL, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STEEL, 3, -3f) )
            )
    );
    public static final Item STEEL_PICKAXE = registerItem("steel_pickaxe",
            new PickaxeItem(ModToolMaterials.STEEL, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.STEEL, 2, -2f) )
            )
    );
    public static final Item STEEL_AXE = registerItem("steel_axe",
            new AxeItem(ModToolMaterials.STEEL, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.STEEL, 3,-3f) )
            )
    );
    public static final Item STEEL_SHOVEL = registerItem("steel_shovel",
            new ShovelItem(ModToolMaterials.STEEL, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.STEEL, 1, -2f) )
            )
    );

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(com.malwreit.bfdragons.BFDragons.MOD_ID, name), item);
    }

    public static void registerModItems() {
        com.malwreit.bfdragons.BFDragons.LOGGER.info("Registering Mod Items for " + com.malwreit.bfdragons.BFDragons.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(STEEL);
        });
    }
}
