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
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.COIN))
                    .displayName(Text.translatable("itemgroup.bfdragons.bfdragons_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.COIN);
                        entries.add(ModItems.HAMMER);
                        entries.add(ModItems.CRAM);
                        entries.add(ModItems.FINEWOOD);
                    }).build());

    public static final ItemGroup BFDRAGONS_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(BFDragons.MOD_ID, "bfdragons_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.COIN_PILE))
                    .displayName(Text.translatable("itemgroup.bfdragons.bfdragons_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.COIN_PILE);
                        entries.add(ModBlocks.COIN_STAIRS);
                        entries.add(ModBlocks.COIN_DOOR);
                        entries.add(ModBlocks.COIN_WALL);
                        entries.add(ModBlocks.COIN_FENCE);
                        entries.add(ModBlocks.COIN_FENCE_GATE);
                        entries.add(ModBlocks.COIN_PRESSURE_PLATE);
                        entries.add(ModBlocks.COIN_SLAB);
                        entries.add(ModBlocks.COIN_TRAPDOOR);
                        entries.add(ModBlocks.COIN_BUTTON);

                        entries.add(ModBlocks.GRINDER);
                        entries.add(ModBlocks.STEEL_LAMP);
                    }).build());

    public static void registerItemGroups() {
        BFDragons.LOGGER.info("Registering Item Groups for " + BFDragons.MOD_ID);
    }
}
