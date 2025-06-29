package com.malwreit.bfdragons.world.tree;

import com.malwreit.bfdragons.BFDragons;
import com.malwreit.bfdragons.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerators {

    public static final SaplingGenerator FINEWOOD = new SaplingGenerator(BFDragons.MOD_ID + ":finewood", Optional.empty(), Optional.of(ModConfiguredFeatures.FINEWOOD_KEY), Optional.empty());

}
