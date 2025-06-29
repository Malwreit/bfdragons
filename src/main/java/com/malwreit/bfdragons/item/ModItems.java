package com.malwreit.bfdragons.item;

import com.malwreit.bfdragons.BFDragons;
import com.malwreit.bfdragons.block.ModBlocks;
import com.malwreit.bfdragons.item.custom.HammerItem;
import com.malwreit.bfdragons.item.custom.ModArmorItem;
import com.malwreit.bfdragons.sound.ModSounds;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
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

    public static final Item STEEL_HELMET =registerItem("steel_helmet",
            new ModArmorItem(
                    ModArmorMaterials.STEEL_ARMOR_MATERIAL,
                    ArmorItem.Type.HELMET,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))
            )
    );
    public static final Item STEEL_CHESTPLATE =registerItem("steel_chestplate",
            new ArmorItem(
                    ModArmorMaterials.STEEL_ARMOR_MATERIAL,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))
            )
    );
    public static final Item STEEL_LEGGINGS =registerItem("steel_leggings",
            new ArmorItem(
                    ModArmorMaterials.STEEL_ARMOR_MATERIAL,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))
            )
    );
    public static final Item STEEL_BOOTS =registerItem("steel_boots",
            new ArmorItem(
                    ModArmorMaterials.STEEL_ARMOR_MATERIAL,
                    ArmorItem.Type.BOOTS,
                    new Item.Settings()
                            .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))
            )
    );

    public static final Item STEEL_CULTIVATOR = registerItem("steel_cultivator",
            new ShovelItem(ModToolMaterials.STEEL, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.STEEL, 7, -3.2f) )
            )
    );

    public static final Item STEEL_HORSE_ARMOR = registerItem("steel_horse_armor",
        new AnimalArmorItem(
                ModArmorMaterials.STEEL_ARMOR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN, false,
                new Item.Settings()
                        .maxCount(1))
    );

    public static final Item IRON_HILLS_SMITHING_TEMPLATE = registerItem("iron_hills_armor_trim_smithing_template",
            SmithingTemplateItem.of(Identifier.of(BFDragons.MOD_ID, "iron_hills"), FeatureFlags.VANILLA)
    );

    public static final Item IRON_HILLS_BOW = registerItem("iron_hills_bow",
            new BowItem(
                    new Item.Settings()
                            .maxDamage(500)
            )
    );

    public static final Item BAR_BRAWL_MUSIC_DISC = registerItem("bar_brawl_music_disc",
        new Item(new Item.Settings()
                .jukeboxPlayable(ModSounds.BAR_BRAWL_KEY)
                .maxCount(1)
        )
    );

    public static final Item ONION = registerItem("onion",
            new Item(new Item.Settings().food(ModFoodComponents.ONION))
    );

    public static final Item ONION_SEEDS = registerItem("onion_seeds",
            new AliasedBlockItem(ModBlocks.ONION_CROP, new Item.Settings())
    );

    public static final Item BLUEBERRIES = registerItem("blueberries",
            new AliasedBlockItem(ModBlocks.BLUEBERRY_BUSH, new Item.Settings().food(ModFoodComponents.BLUEBERRIES))
    );

    public static final Item SILVER = registerItem("silver", new Item(new Item.Settings()));

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
