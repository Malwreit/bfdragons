package com.malwreit.bfdragons;

import com.malwreit.bfdragons.block.ModBlocks;
import com.malwreit.bfdragons.item.ModFuelComponents;
import com.malwreit.bfdragons.item.ModItemGroups;
import com.malwreit.bfdragons.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
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
	}
}