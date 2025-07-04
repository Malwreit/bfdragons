package com.malwreit.bfdragons.datagen;

import com.malwreit.bfdragons.block.ModBlocks;
import com.malwreit.bfdragons.item.ModItems;
import com.malwreit.bfdragons.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(Items.COAL)
                .add(ModItems.STEEL);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.STEEL_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.STEEL_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.STEEL_AXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.STEEL_SHOVEL);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.STEEL_HELMET)
                .add(ModItems.STEEL_CHESTPLATE)
                .add(ModItems.STEEL_LEGGINGS)
                .add(ModItems.STEEL_BOOTS);

        getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModItems.STEEL);

        getOrCreateTagBuilder(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.IRON_HILLS_SMITHING_TEMPLATE);

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.FINEWOOD_LOG.asItem())
                .add(ModBlocks.FINEWOOD_WOOD.asItem())
                .add(ModBlocks.STRIPPED_FINEWOOD_LOG.asItem())
                .add(ModBlocks.STRIPPED_FINEWOOD_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.FINEWOOD_PLANKS.asItem());
    }
}
