package com.malwreit.bfdragons.datagen;

import com.malwreit.bfdragons.block.ModBlocks;
import com.malwreit.bfdragons.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.STEEL_BLOCK)
                .add(ModBlocks.GRINDER);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.STEEL_BLOCK);

        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.STEEL_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.STEEL_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.STEEL_WALL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_STEEL_TOOL)
                .add(ModBlocks.STEEL_BLOCK)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.FINEWOOD_LOG)
                .add(ModBlocks.FINEWOOD_WOOD)
                .add(ModBlocks.STRIPPED_FINEWOOD_LOG)
                .add(ModBlocks.STRIPPED_FINEWOOD_WOOD);
    }
}
