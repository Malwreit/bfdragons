package com.malwreit.bfdragons.block;

import com.malwreit.bfdragons.BFDragons;
import com.malwreit.bfdragons.block.custom.*;
import com.malwreit.bfdragons.sound.ModSounds;
import com.malwreit.bfdragons.world.tree.ModSaplingGenerators;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            new Block(
                    AbstractBlock.Settings.create()
                            .strength(4f)
                            .requiresTool()
                            .sounds(ModSounds.STEEL_BLOCK_SOUNDS)
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

    public static final Block STEEL_STAIRS = registerBlock("steel_stairs",
        new StairsBlock(ModBlocks.STEEL_BLOCK.getDefaultState(),
                AbstractBlock.Settings.create()
                        .strength(2f)
                        .requiresTool()
        )
    );

    public static final Block STEEL_SLAB = registerBlock("steel_slab",
        new SlabBlock(
                AbstractBlock.Settings.create()
                        .strength(2f)
                        .requiresTool()
        )
    );

    public static final Block STEEL_BUTTON = registerBlock("steel_button",
        new ButtonBlock(BlockSetType.IRON, 2,
                AbstractBlock.Settings.create()
                        .strength(2f)
                        .requiresTool()
                        .noCollision()
        )
    );

    public static final Block STEEL_PRESSURE_PLATE = registerBlock("steel_pressure_plate",
        new PressurePlateBlock(BlockSetType.IRON,
                AbstractBlock.Settings.create()
                        .strength(2f)
                        .requiresTool()
        )
    );

    public static final Block STEEL_FENCE = registerBlock("steel_fence",
        new FenceBlock(
                AbstractBlock.Settings.create()
                        .strength(2f)
                        .requiresTool()
        )
    );

    public static final Block STEEL_FENCE_GATE = registerBlock("steel_fence_gate",
        new FenceGateBlock(WoodType.OAK,
                AbstractBlock.Settings.create()
                        .strength(2f)
                        .requiresTool()
        )
    );

    public static final Block STEEL_WALL = registerBlock("steel_wall",
        new WallBlock(
                AbstractBlock.Settings.create()
                        .strength(2f)
                        .requiresTool()
        )
    );

    public static final Block STEEL_DOOR = registerBlock("steel_door",
        new DoorBlock(BlockSetType.OAK,
                AbstractBlock.Settings.create()
                        .strength(2f)
                        .requiresTool()
                        .nonOpaque()
        )
    );

    public static final Block STEEL_TRAPDOOR = registerBlock("steel_trapdoor",
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

    public static final Block ONION_CROP = registerBlockWithoutBlockItem("onion_crop",
        new OnionCropBlock(AbstractBlock.Settings.create()
                .ticksRandomly()
                .breakInstantly()
                .noCollision()
                .sounds(BlockSoundGroup.CROP)
                .pistonBehavior(PistonBehavior.DESTROY)
                .mapColor(MapColor.YELLOW)
        )
    );

    public static final Block BLUEBERRY_BUSH = registerBlockWithoutBlockItem("blueberry_bush",
        new BlueberryBushBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH))
    );

    public static final Block SILVER_ORE = registerBlock("silver_ore",
        new Block(AbstractBlock.Settings.create()
                .strength(3f, 3f)
                .requiresTool()
                .sounds(BlockSoundGroup.STONE)
        )
    );
    public static final Block DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
        new Block(AbstractBlock.Settings.create()
                .strength(3f, 3f)
                .requiresTool()
                .sounds(BlockSoundGroup.STONE)
        )
    );

    public static final Block FINEWOOD_LOG = registerBlock("finewood_log",
        new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)
        )
    );

    public static final Block STRIPPED_FINEWOOD_LOG = registerBlock("stripped_finewood_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)
            )
    );

    public static final Block FINEWOOD_WOOD = registerBlock("finewood_wood",
        new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)
        )
    );

    public static final Block STRIPPED_FINEWOOD_WOOD = registerBlock("stripped_finewood_wood",
        new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)
        )
    );

    public static final Block FINEWOOD_PLANKS = registerBlock("finewood_planks",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
            )
    );

    public static final Block FINEWOOD_LEAVES = registerBlock("finewood_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)
            )
    );

    public static final Block FINEWOOD_SAPLING = registerBlock("finewood_sapling",
            new ModSaplingBlock(ModSaplingGenerators.FINEWOOD, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING), Blocks.STONE
            )
    );



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(BFDragons.MOD_ID, name), block);
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
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
                entries.add(ModBlocks.STEEL_BLOCK));
    }
}
