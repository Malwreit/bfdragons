package com.malwreit.bfdragons.datagen;

import com.malwreit.bfdragons.block.ModBlocks;
import com.malwreit.bfdragons.block.custom.BlueberryBushBlock;
import com.malwreit.bfdragons.block.custom.OnionCropBlock;
import com.malwreit.bfdragons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.STEEL_BLOCK);
        addDrop(ModBlocks.STEEL_FENCE);
        addDrop(ModBlocks.STEEL_SLAB, slabDrops(ModBlocks.STEEL_SLAB));
        addDrop(ModBlocks.STEEL_STAIRS);
        addDrop(ModBlocks.STEEL_WALL);
        addDrop(ModBlocks.STEEL_TRAPDOOR);
        addDrop(ModBlocks.STEEL_FENCE_GATE);
        addDrop(ModBlocks.STEEL_BUTTON);
        addDrop(ModBlocks.STEEL_DOOR, doorDrops(ModBlocks.STEEL_DOOR));
        addDrop(ModBlocks.STEEL_PRESSURE_PLATE);

        addDrop(ModBlocks.GRINDER);

        addDrop(ModBlocks.SILVER_ORE, multipleOreDrops(ModBlocks.SILVER_ORE, ModItems.SILVER,4,6));

        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        this.addDrop(ModBlocks.BLUEBERRY_BUSH, (block) -> (LootTable.Builder)
                this.applyExplosionDecay(block, LootTable.builder().pool(LootPool.builder().conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.BLUEBERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(BlueberryBushBlock.AGE, 3))).with(ItemEntry.builder(ModItems.BLUEBERRIES)).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F))).apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))).pool(LootPool.builder().conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.BLUEBERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(BlueberryBushBlock.AGE, 2))).with(ItemEntry.builder(ModItems.BLUEBERRIES)).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F))).apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))));



        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.ONION_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(OnionCropBlock.AGE,6));
        this.addDrop(ModBlocks.ONION_CROP, this.cropDrops(ModBlocks.ONION_CROP, ModItems.ONION, ModItems.ONION_SEEDS, builder2));
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay((ItemConvertible) drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
