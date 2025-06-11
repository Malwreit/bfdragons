package com.malwreit.bfdragons.sound;

import com.malwreit.bfdragons.BFDragons;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;


public class ModSounds {
    public static final SoundEvent HAMMER_USE =registerSoundEvent("hammer_use");

    public static final SoundEvent STEEL_BLOCK_BREAK = registerSoundEvent("steel_block_break");
    public static final SoundEvent STEEL_BLOCK_STEP = registerSoundEvent("steel_block_step");
    public static final SoundEvent STEEL_BLOCK_PLACE = registerSoundEvent("steel_block_place");
    public static final SoundEvent STEEL_BLOCK_HIT = registerSoundEvent("steel_block_hit");
    public static final SoundEvent STEEL_BLOCK_FALL = registerSoundEvent("steel_block_fall");

    public static final BlockSoundGroup STEEL_BLOCK_SOUNDS = new BlockSoundGroup(1f, 1f, STEEL_BLOCK_BREAK, STEEL_BLOCK_STEP, STEEL_BLOCK_PLACE, STEEL_BLOCK_HIT, STEEL_BLOCK_FALL);

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(BFDragons.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        BFDragons.LOGGER.info("Registering Mod Sounds for " + BFDragons.MOD_ID);
    }
}
