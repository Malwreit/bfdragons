package com.malwreit.bfdragons;

import com.malwreit.bfdragons.block.ModBlocks;
import com.malwreit.bfdragons.component.ModDataComponentsTypes;
import com.malwreit.bfdragons.effect.ModEffects;
import com.malwreit.bfdragons.enchantment.ModEnchantmentEffects;
import com.malwreit.bfdragons.item.ModFuelComponents;
import com.malwreit.bfdragons.item.ModItemGroups;
import com.malwreit.bfdragons.item.ModItems;
import com.malwreit.bfdragons.potion.ModPotions;
import com.malwreit.bfdragons.util.CultivatorUsageEvent;
import com.malwreit.bfdragons.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.FireBlock;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.potion.Potions;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BFDragons implements ModInitializer {
	public static final String MOD_ID = "bfdragons";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlock();
		ModItemGroups.registerItemGroups();
		ModFuelComponents.registerFuelComponents();
		ModDataComponentsTypes.registerDataComponentTypes();
		ModEffects.registerEffects();
		ModPotions.registerPotions();
		ModEnchantmentEffects.registerEnchantmentEffects();

		PlayerBlockBreakEvents.BEFORE.register(new CultivatorUsageEvent());
		FabricBrewingRecipeRegistryBuilder.BUILD.register(
				builder -> {
					builder.registerPotionRecipe(
							Potions.AWKWARD,
							ModItems.CRAM,
							ModPotions.SLIMEY_POTION
					);
				}
		);

		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if (entity instanceof SheepEntity sheepEntity && !world.isClient) {
				if(player.getMainHandStack().getItem() == ModItems.STEEL_SWORD) {
					player.sendMessage(Text.literal("beka3"));
					sheepEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 600, 2));
				}

				return ActionResult.PASS;
			}

			return ActionResult.PASS;
		});

		CompostingChanceRegistry.INSTANCE.add(ModItems.ONION, 0.5f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.ONION_SEEDS, 0.25f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.BLUEBERRIES, 0.25f);

		ModWorldGeneration.generateModWorldGen();

		StrippableBlockRegistry.register(ModBlocks.FINEWOOD_LOG, ModBlocks.STRIPPED_FINEWOOD_LOG);
		StrippableBlockRegistry.register(ModBlocks.FINEWOOD_WOOD, ModBlocks.STRIPPED_FINEWOOD_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.FINEWOOD_LOG,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_FINEWOOD_LOG,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.FINEWOOD_WOOD,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_FINEWOOD_WOOD,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.FINEWOOD_PLANKS,5,20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.FINEWOOD_LEAVES,30,60);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.FINEWOOD_SAPLING,60,20);

	}
}