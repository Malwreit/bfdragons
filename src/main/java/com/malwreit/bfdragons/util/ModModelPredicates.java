package com.malwreit.bfdragons.util;

import com.malwreit.bfdragons.BFDragons;
import com.malwreit.bfdragons.component.ModDataComponentsTypes;
import com.malwreit.bfdragons.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModModelPredicates {

    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.HAMMER, Identifier.of(BFDragons.MOD_ID, "used"),
                ((stack, world, entity, seed) -> stack.get(ModDataComponentsTypes.COORDINATES) != null ? 1f : 0f)
        );
    }
}
