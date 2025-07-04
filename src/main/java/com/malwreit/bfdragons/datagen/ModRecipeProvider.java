package com.malwreit.bfdragons.datagen;

import com.malwreit.bfdragons.BFDragons;
import com.malwreit.bfdragons.block.ModBlocks;
import com.malwreit.bfdragons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.STEEL, RecipeCategory.DECORATIONS, ModBlocks.STEEL_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.STEEL_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.STEEL)
                .criterion(hasItem(ModItems.STEEL), conditionsFromItem(ModItems.STEEL))
                .offerTo(recipeExporter, Identifier.of(BFDragons.MOD_ID, "steel_block_from_steel"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STEEL, 9)
                .input(ModBlocks.STEEL_BLOCK)
                .criterion(hasItem(ModBlocks.STEEL_BLOCK), conditionsFromItem(ModBlocks.STEEL_BLOCK))
                .offerTo(recipeExporter, Identifier.of(BFDragons.MOD_ID, "steel_block_from_steel_shapeless"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.STEEL_HORSE_ARMOR)
                .pattern("  R")
                .pattern("RFR")
                .pattern("R R")
                .input('R',ModItems.STEEL)
                .input('F', Items.IRON_HORSE_ARMOR)
                .criterion(hasItem(ModItems.STEEL), conditionsFromItem(ModItems.STEEL))
                .offerTo(recipeExporter, Identifier.of(BFDragons.MOD_ID, "steel_horse_armor_from_steel"));

        offerSmithingTrimRecipe(recipeExporter, ModItems.IRON_HILLS_SMITHING_TEMPLATE, Identifier.of(BFDragons.MOD_ID, "iron_hills"));

    }
}
