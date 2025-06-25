package com.malwreit.bfdragons.potion;

import com.malwreit.bfdragons.BFDragons;
import com.malwreit.bfdragons.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {

    public static final RegistryEntry<Potion> SLIMEY_POTION = registerPotion("slimey_potion", new Potion(new StatusEffectInstance(ModEffects.SLIMEY, 1200, 0)));

    public static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(
                Registries.POTION,
                Identifier.of(BFDragons.MOD_ID, name),
                potion
        );
    }

    public static void registerPotions() {
        BFDragons.LOGGER.info("Registering Mod Potions for: " + BFDragons.MOD_ID);
    }
}
