package com.malwreit.bfdragons.block;

import com.malwreit.bfdragons.BFDragons;
import com.malwreit.bfdragons.block.custom.GrinderBlock;
import com.malwreit.bfdragons.block.custom.SteelLampBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block COIN_PILE = registerBlock("coin_pile",
            new Block(
                    AbstractBlock.Settings.create()
                            .strength(4f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.GLASS)
            )
    );

    public static final Block GRINDER = registerBlock("grinder",
            new GrinderBlock(
                    AbstractBlock.Settings.create()
                            .strength(2f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.DEEPSLATE_TILES)
            )
    );

    public static final Block COIN_STAIRS = registerBlock("coin_stairs",
        new StairsBlock(ModBlocks.COIN_PILE.getDefaultState(),
                AbstractBlock.Settings.create()
                        .strength(2f)
                        .requiresTool()
        )
    );

    public static final Block COIN_SLAB = registerBlock("coin_slab",
        new SlabBlock(
                AbstractBlock.Settings.create()
                        .strength(2f)
                        .requiresTool()
        )
    );

    public static final Block COIN_BUTTON = registerBlock("coin_button",
        new ButtonBlock(BlockSetType.IRON, 2,
                AbstractBlock.Settings.create()
                        .strength(2f)
                        .requiresTool()
                        .noCollision()
        )
    );

    public static final Block COIN_PRESSURE_PLATE = registerBlock("coin_pressure_plate",
        new PressurePlateBlock(BlockSetType.IRON,
                AbstractBlock.Settings.create()
                        .strength(2f)
                        .requiresTool()
        )
    );

    public static final Block COIN_FENCE = registerBlock("coin_fence",
        new FenceBlock(
                AbstractBlock.Settings.create()
                        .strength(2f)
                        .requiresTool()
        )
    );

    public static final Block COIN_FENCE_GATE = registerBlock("coin_fence_gate",
        new FenceGateBlock(WoodType.OAK,
                AbstractBlock.Settings.create()
                        .strength(2f)
                        .requiresTool()
        )
    );

    public static final Block COIN_WALL = registerBlock("coin_wall",
        new WallBlock(
                AbstractBlock.Settings.create()
                        .strength(2f)
                        .requiresTool()
        )
    );

    public static final Block COIN_DOOR = registerBlock("coin_door",
        new DoorBlock(BlockSetType.OAK,
                AbstractBlock.Settings.create()
                        .strength(2f)
                        .requiresTool()
                        .nonOpaque()
        )
    );

    public static final Block COIN_TRAPDOOR = registerBlock("coin_trapdoor",
        new TrapdoorBlock(BlockSetType.OAK,
                AbstractBlock.Settings.create()
                        .strength(2f)
                        .requiresTool()
                        .nonOpaque()
        )
    );

    public static final Block STEEL_LAMP = registerBlock("steel_lamp",
        new SteelLampBlock(AbstractBlock.Settings.create()
                .strength(1f)
                .requiresTool()
                .luminance(state -> state.get(SteelLampBlock.CLICKED) ? 15 : 0)
        )
    );
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(BFDragons.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(BFDragons.MOD_ID,name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlock() {
        BFDragons.LOGGER.info("Registering Mod Blocks for " + BFDragons.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries ->
                entries.add(ModBlocks.COIN_PILE));
    }
}
