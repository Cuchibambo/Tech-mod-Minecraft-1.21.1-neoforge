package com.cuchibambo.techmod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties THALLIUM_APPLE = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.25f)
            .alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 12000),1f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 400,3),1f)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 100),0.5f)
            .build();
}
