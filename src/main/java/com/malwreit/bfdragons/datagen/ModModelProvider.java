package com.malwreit.bfdragons.datagen;

import com.malwreit.bfdragons.block.ModBlocks;
import com.malwreit.bfdragons.block.custom.SteelLampBlock;
import com.malwreit.bfdragons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool coinPile = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.COIN_PILE);
        coinPile.stairs(ModBlocks.COIN_STAIRS);
        coinPile.button(ModBlocks.COIN_BUTTON);
        coinPile.fence(ModBlocks.COIN_FENCE);
        coinPile.fenceGate(ModBlocks.COIN_FENCE_GATE);
        coinPile.slab(ModBlocks.COIN_SLAB);
        coinPile.pressurePlate(ModBlocks.COIN_PRESSURE_PLATE);
        coinPile.wall(ModBlocks.COIN_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.COIN_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.COIN_TRAPDOOR);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRINDER);

        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.STEEL_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.STEEL_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.STEEL_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(SteelLampBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.COIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRAM, Models.GENERATED);
        itemModelGenerator.register(ModItems.HAMMER, Models.GENERATED);
        itemModelGenerator.register(ModItems.FINEWOOD, Models.GENERATED);
    }
}
