package com.malwreit.bfdragons.item;

import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModFuelComponents {
    public static void registerFuelComponents() {
        com.malwreit.bfdragons.BFDragons.LOGGER.info("Registering Mod FuelComponents for " + com.malwreit.bfdragons.BFDragons.MOD_ID);

        FuelRegistry.INSTANCE.add(ModItems.FINEWOOD, 60);
    }

}
