package com.malwreit.bfdragons.world.gen;

import com.malwreit.bfdragons.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {

    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BEACH, BiomeKeys.MEADOW), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.FINEWOOD_PLACED_KEY);
    }

}
