package com.malwreit.bfdragons.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.Vec3d;

public class SlimeyEffect extends StatusEffect {
    protected SlimeyEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {

        if (entity.horizontalCollision) {
            Vec3d initialVelocity = entity.getVelocity();
            Vec3d climbedVelocity = new Vec3d(initialVelocity.x, 0.2D, initialVelocity.z);
            entity.setVelocity(climbedVelocity.multiply(0.96D));
            return true;
        }
        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
