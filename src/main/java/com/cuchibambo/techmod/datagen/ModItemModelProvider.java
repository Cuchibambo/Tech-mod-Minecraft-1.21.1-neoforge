package com.cuchibambo.techmod.datagen;

import com.cuchibambo.techmod.Techmod;
import com.cuchibambo.techmod.block.ModBlocks;
import com.cuchibambo.techmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Techmod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.THALLIUM_SHARD.get());
        basicItem(ModItems.IRON_DUST.get());
        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.SUPERDENSE_THALLIUM.get());
        basicItem(ModItems.THALLIUM_APPLE.get());

        buttonItem(ModBlocks.GREEN_BUTTON, ModBlocks.GREEN_BLOCK);
        fenceItem(ModBlocks.GREEN_FENCE, ModBlocks.GREEN_BLOCK);
        wallItem(ModBlocks.GREEN_WALL, ModBlocks.GREEN_BLOCK);

        basicItem(ModBlocks.GREEN_DOOR.asItem());

        handheldItem(ModItems.THALLIUM_SWORD.get());
        handheldItem(ModItems.THALLIUM_AXE.get());
        handheldItem(ModItems.THALLIUM_PICKAXE.get());
        handheldItem(ModItems.THALLIUM_SHOVEL.get());
        handheldItem(ModItems.THALLIUM_HOE.get());
        handheldItem(ModItems.THALLIUM_HAMMER.get());

    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Techmod.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Techmod.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(Techmod.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }
}
