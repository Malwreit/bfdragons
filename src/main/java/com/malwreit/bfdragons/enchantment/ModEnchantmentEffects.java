package com.malwreit.bfdragons.enchantment;

import com.malwreit.bfdragons.BFDragons;
import com.malwreit.bfdragons.enchantment.custom.LightningStrikeEnchantmentEffect;
import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {

    public static final MapCodec<? extends EnchantmentEntityEffect> LIGHTNING_STRIKE = registerEnchantmentEffect("lightning_strike", LightningStrikeEnchantmentEffect.CODEC);

    private static MapCodec<? extends EnchantmentEntityEffect> registerEnchantmentEffect(String name ,MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(BFDragons.MOD_ID, name), codec);
    }

    public static void registerEnchantmentEffects() {
        BFDragons.LOGGER.info("Registering Mod Enchantment Effects for " + BFDragons.MOD_ID);
    }
}
