package com.cuchibambo.techmod.datagen;

import com.cuchibambo.techmod.Techmod;
import com.cuchibambo.techmod.block.ModBlocks;
import com.cuchibambo.techmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Techmod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.GREEN_BLOCK.get())
                .add(ModBlocks.GREEN_BUTTON.get())
                .add(ModBlocks.GREEN_STAIRS.get())
                .add(ModBlocks.GREEN_TRAPDOOR.get())
                .add(ModBlocks.GREEN_FENCE_GATE.get())
                .add(ModBlocks.GREEN_FENCE.get())
                .add(ModBlocks.GREEN_PRESSURE_PLATE.get())
                .add(ModBlocks.GREEN_SLAB.get())
                .add(ModBlocks.GREEN_WALL.get())
                .add(ModBlocks.GREEN_DOOR.get())
                .add(ModBlocks.DEEPSLATE_THALLIUM_ORE.get())
                .add(ModBlocks.THALLIUM_ORE.get())
                .add(ModBlocks.THALLIUM_BLOCK.get())
                .add(ModBlocks.THALLIUM_LAMP.get())
                .add(ModBlocks.MAGIC_BLOCK.get());


        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.DEEPSLATE_THALLIUM_ORE.get())
                .add(ModBlocks.THALLIUM_ORE.get())
                .add(ModBlocks.THALLIUM_BLOCK.get())
                .add(ModBlocks.THALLIUM_LAMP.get())
                .add(ModBlocks.MAGIC_BLOCK.get());

        tag(BlockTags.FENCES)
                .add(ModBlocks.GREEN_FENCE.get());
        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.GREEN_FENCE_GATE.get());
        tag(BlockTags.WALLS)
                .add(ModBlocks.GREEN_WALL.get());

        tag(ModTags.Blocks.NEEDS_THALLIUM_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
        tag(ModTags.Blocks.INCORRECT_FOR_THALLIUM_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(ModTags.Blocks.NEEDS_THALLIUM_TOOL);
    }
}
