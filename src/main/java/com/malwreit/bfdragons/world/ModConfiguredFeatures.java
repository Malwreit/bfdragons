package com.malwreit.bfdragons.world;

import com.malwreit.bfdragons.BFDragons;
import com.malwreit.bfdragons.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> SILVER_ORE_KEY = registerKey("silver_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEEPSLATE_SILVER_ORE_KEY = registerKey("deepslate_silver_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> FINEWOOD_KEY = registerKey("finewood");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        RuleTest stoneReplaceable = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldSilverOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceable, ModBlocks.SILVER_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(deepslateReplaceable, ModBlocks.DEEPSLATE_SILVER_ORE.getDefaultState()));

        register(context, SILVER_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldSilverOres, 12));

        register(context, FINEWOOD_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.FINEWOOD_LOG),
                new StraightTrunkPlacer(5,6,3),

                BlockStateProvider.of(ModBlocks.FINEWOOD_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(1), 3),

                new TwoLayersFeatureSize(1,0,2)).dirtProvider(BlockStateProvider.of(Blocks.STONE)).build());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(BFDragons.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
