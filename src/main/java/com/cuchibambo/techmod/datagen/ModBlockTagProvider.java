package com.cuchibambo.techmod.datagen;

import com.cuchibambo.techmod.Techmod;
import com.cuchibambo.techmod.block.ModBlocks;
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
                .add(ModBlocks.DEEPSLATE_THALLIUM_ORE.get())
                .add(ModBlocks.THALLIUM_ORE.get())
                .add(ModBlocks.THALLIUM_BLOCK.get())
                .add(ModBlocks.MAGIC_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.DEEPSLATE_THALLIUM_ORE.get())
                .add(ModBlocks.THALLIUM_ORE.get())
                .add(ModBlocks.THALLIUM_BLOCK.get())
                .add(ModBlocks.MAGIC_BLOCK.get());
    }
}
