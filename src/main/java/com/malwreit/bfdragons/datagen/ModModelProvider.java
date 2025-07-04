package com.malwreit.bfdragons.datagen;

import com.malwreit.bfdragons.block.ModBlocks;
import com.malwreit.bfdragons.block.custom.BlueberryBushBlock;
import com.malwreit.bfdragons.block.custom.OnionCropBlock;
import com.malwreit.bfdragons.block.custom.SteelLampBlock;
import com.malwreit.bfdragons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool coinPile = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.STEEL_BLOCK);
        coinPile.stairs(ModBlocks.STEEL_STAIRS);
        coinPile.button(ModBlocks.STEEL_BUTTON);
        coinPile.fence(ModBlocks.STEEL_FENCE);
        coinPile.fenceGate(ModBlocks.STEEL_FENCE_GATE);
        coinPile.slab(ModBlocks.STEEL_SLAB);
        coinPile.pressurePlate(ModBlocks.STEEL_PRESSURE_PLATE);
        coinPile.wall(ModBlocks.STEEL_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.STEEL_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.STEEL_TRAPDOOR);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRINDER);

        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.STEEL_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.STEEL_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.STEEL_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(SteelLampBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));

        blockStateModelGenerator.registerCrop(ModBlocks.ONION_CROP, OnionCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.BLUEBERRY_BUSH, BlockStateModelGenerator.TintType.NOT_TINTED, BlueberryBushBlock.AGE,0, 1, 2, 3);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SILVER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SILVER_ORE);

        blockStateModelGenerator.registerLog(ModBlocks.FINEWOOD_LOG).log(ModBlocks.FINEWOOD_LOG).wood(ModBlocks.FINEWOOD_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_FINEWOOD_LOG).log(ModBlocks.STRIPPED_FINEWOOD_LOG).wood(ModBlocks.STRIPPED_FINEWOOD_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FINEWOOD_PLANKS);
        blockStateModelGenerator.registerSingleton(ModBlocks.FINEWOOD_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.FINEWOOD_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.STEEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRAM, Models.GENERATED);
        itemModelGenerator.register(ModItems.ONION, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_CULTIVATOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.FINEWOOD, Models.GENERATED);

        itemModelGenerator.register(ModItems.STEEL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_SHOVEL, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.STEEL_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.STEEL_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.STEEL_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.STEEL_BOOTS);

        itemModelGenerator.register(ModItems.STEEL_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_HILLS_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BAR_BRAWL_MUSIC_DISC, Models.GENERATED);

        itemModelGenerator.register(ModItems.SILVER, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.FINEWOOD_SAPLING.asItem(), Models.GENERATED);
    }
}
