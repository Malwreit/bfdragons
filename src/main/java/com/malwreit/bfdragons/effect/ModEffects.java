package com.malwreit.bfdragons.effect;

import com.malwreit.bfdragons.BFDragons;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> SLIMEY = registerStatusEffect("slimey",
            new SlimeyEffect(StatusEffectCategory.NEUTRAL, 0x36e6bab)
                            .addAttributeModifier(
                                    EntityAttributes.GENERIC_MOVEMENT_SPEED,
                                    Identifier.of(BFDragons.MOD_ID, "slimey"), -0.25f,
                                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
            )
    );

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect effect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(BFDragons.MOD_ID, name), effect);
    }

    public static void registerEffects() {
        BFDragons.LOGGER.info("Registering Mod Effects for: " + BFDragons.MOD_ID);
    }
}
