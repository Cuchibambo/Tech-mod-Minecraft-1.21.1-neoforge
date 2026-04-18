package com.cuchibambo.techmod.item.custom;

import com.cuchibambo.techmod.item.ModItems;
import com.cuchibambo.techmod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier THALLIUM = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_THALLIUM_TOOL,
            1200,8f,3f,15,() -> Ingredient.of(ModItems.THALLIUM_SHARD));
}
