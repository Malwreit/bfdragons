package com.malwreit.bfdragons.datagen;

import com.malwreit.bfdragons.BFDragons;
import com.malwreit.bfdragons.block.ModBlocks;
import com.malwreit.bfdragons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
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
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.COIN, RecipeCategory.DECORATIONS, ModBlocks.COIN_PILE);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COIN_PILE)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.COIN)
                .criterion(hasItem(ModItems.COIN), conditionsFromItem(ModItems.COIN))
                .offerTo(recipeExporter, Identifier.of(BFDragons.MOD_ID, "coin_pile_from_coin"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COIN, 9)
                .input(ModBlocks.COIN_PILE)
                .criterion(hasItem(ModBlocks.COIN_PILE), conditionsFromItem(ModBlocks.COIN_PILE))
                .offerTo(recipeExporter, Identifier.of(BFDragons.MOD_ID, "coin_pile_from_coin_shapeless"));
    }
}
