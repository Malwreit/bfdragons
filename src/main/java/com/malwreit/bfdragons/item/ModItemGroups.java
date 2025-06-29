package com.malwreit.bfdragons.item;

import com.malwreit.bfdragons.BFDragons;
import com.malwreit.bfdragons.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModItemGroups {
    public static final ItemGroup BFDRAGONS_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(BFDragons.MOD_ID, "bfdragons_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.STEEL))
                    .displayName(Text.translatable("itemgroup.bfdragons.bfdragons_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.STEEL);
                        entries.add(ModItems.HAMMER);
                        entries.add(ModItems.CRAM);
                        entries.add(ModItems.FINEWOOD);

                        entries.add(ModItems.STEEL_SWORD);
                        entries.add(ModItems.STEEL_SHOVEL);
                        entries.add(ModItems.STEEL_AXE);
                        entries.add(ModItems.STEEL_PICKAXE);

                        entries.add(ModItems.STEEL_HELMET);
                        entries.add(ModItems.STEEL_CHESTPLATE);
                        entries.add(ModItems.STEEL_LEGGINGS);
                        entries.add(ModItems.STEEL_BOOTS);

                        entries.add(ModItems.IRON_HILLS_SMITHING_TEMPLATE);
                        entries.add(ModItems.IRON_HILLS_BOW);

                        entries.add(ModItems.STEEL_HORSE_ARMOR);
                        entries.add(ModItems.BAR_BRAWL_MUSIC_DISC);
                        entries.add(ModItems.ONION_SEEDS);
                        entries.add(ModItems.ONION);
                        entries.add(ModItems.BLUEBERRIES);

                        entries.add(ModItems.SILVER);
                    }).build());

    public static final ItemGroup BFDRAGONS_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(BFDragons.MOD_ID, "bfdragons_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.STEEL_BLOCK))
                    .displayName(Text.translatable("itemgroup.bfdragons.bfdragons_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.STEEL_BLOCK);
                        entries.add(ModBlocks.STEEL_STAIRS);
                        entries.add(ModBlocks.STEEL_DOOR);
                        entries.add(ModBlocks.STEEL_WALL);
                        entries.add(ModBlocks.STEEL_FENCE);
                        entries.add(ModBlocks.STEEL_FENCE_GATE);
                        entries.add(ModBlocks.STEEL_PRESSURE_PLATE);
                        entries.add(ModBlocks.STEEL_SLAB);
                        entries.add(ModBlocks.STEEL_TRAPDOOR);
                        entries.add(ModBlocks.STEEL_BUTTON);

                        entries.add(ModBlocks.GRINDER);
                        entries.add(ModBlocks.STEEL_LAMP);

                        entries.add(ModBlocks.SILVER_ORE);
                        entries.add(ModBlocks.DEEPSLATE_SILVER_ORE);

                        entries.add(ModBlocks.FINEWOOD_LOG);
                        entries.add(ModBlocks.STRIPPED_FINEWOOD_LOG);
                        entries.add(ModBlocks.FINEWOOD_WOOD);
                        entries.add(ModBlocks.STRIPPED_FINEWOOD_WOOD);
                        entries.add(ModBlocks.FINEWOOD_PLANKS);
                        entries.add(ModBlocks.FINEWOOD_LEAVES);
                        entries.add(ModBlocks.FINEWOOD_SAPLING);
                    }).build());

    public static void registerItemGroups() {
        BFDragons.LOGGER.info("Registering Item Groups for " + BFDragons.MOD_ID);
    }
}
