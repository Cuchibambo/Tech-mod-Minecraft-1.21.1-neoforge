package com.cuchibambo.techmod.datagen;

import com.cuchibambo.techmod.block.ModBlocks;
import com.cuchibambo.techmod.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.THALLIUM_BLOCK.get());
        dropSelf(ModBlocks.GREEN_BLOCK.get());
        dropSelf(ModBlocks.MAGIC_BLOCK.get());

        add(ModBlocks.THALLIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.THALLIUM_ORE.get(), ModItems.THALLIUM_SHARD.get()));
        add(ModBlocks.DEEPSLATE_THALLIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_THALLIUM_ORE.get(), ModItems.THALLIUM_SHARD.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
