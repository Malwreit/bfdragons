package com.malwreit.bfdragons.util;

import com.malwreit.bfdragons.BFDragons;
import com.malwreit.bfdragons.component.ModDataComponentsTypes;
import com.malwreit.bfdragons.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class ModModelPredicates {

    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.HAMMER, Identifier.of(BFDragons.MOD_ID, "used"),
                ((stack, world, entity, seed) -> stack.get(ModDataComponentsTypes.COORDINATES) != null ? 1f : 0f)
        );

        registerCustomBow(ModItems.IRON_HILLS_BOW);
    }

    private static void registerCustomBow(Item item) {
        ModelPredicateProviderRegistry.register(
                item, Identifier.ofVanilla("pull"),
                (stack, world, entity, seed) -> {
                    if (entity == null) {
                        return 0.0F;
                    } else {
                        return entity.getActiveItem() != stack ? 0.0F : (float)(stack.getMaxUseTime(entity) - entity.getItemUseTimeLeft()) / 20.0F;
                    }
        });
        ModelPredicateProviderRegistry.register(
                item, Identifier.ofVanilla("pulling"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F
        );
    }
}
