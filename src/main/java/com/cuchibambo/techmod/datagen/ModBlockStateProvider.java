package com.cuchibambo.techmod.datagen;

import com.cuchibambo.techmod.Techmod;
import com.cuchibambo.techmod.block.ModBlocks;
import com.cuchibambo.techmod.block.custom.ThalliumLampBlock;
import com.cuchibambo.techmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Techmod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.THALLIUM_BLOCK);
        blockWithItem(ModBlocks.MAGIC_BLOCK);
        blockWithItem(ModBlocks.DEEPSLATE_THALLIUM_ORE);
        blockWithItem(ModBlocks.THALLIUM_ORE);

        blockWithItem(ModBlocks.GREEN_BLOCK);
        stairsBlock(ModBlocks.GREEN_STAIRS.get(), blockTexture(ModBlocks.GREEN_BLOCK.get()));
        slabBlock(ModBlocks.GREEN_SLAB.get(), blockTexture(ModBlocks.GREEN_BLOCK.get()), blockTexture(ModBlocks.GREEN_BLOCK.get()));

        buttonBlock(ModBlocks.GREEN_BUTTON.get(), blockTexture(ModBlocks.GREEN_BLOCK.get()));
        pressurePlateBlock(ModBlocks.GREEN_PRESSURE_PLATE.get(), blockTexture(ModBlocks.GREEN_BLOCK.get()));

        fenceBlock(ModBlocks.GREEN_FENCE.get(), blockTexture(ModBlocks.GREEN_BLOCK.get()));
        fenceGateBlock(ModBlocks.GREEN_FENCE_GATE.get(), blockTexture(ModBlocks.GREEN_BLOCK.get()));
        wallBlock(ModBlocks.GREEN_WALL.get(), blockTexture(ModBlocks.GREEN_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.GREEN_DOOR.get(), modLoc("block/green_door_bottom"), modLoc("block/green_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.GREEN_TRAPDOOR.get(), modLoc("block/green_trapdoor"), true, "cutout");

        blockItem(ModBlocks.GREEN_STAIRS);
        blockItem(ModBlocks.GREEN_SLAB);
        blockItem(ModBlocks.GREEN_PRESSURE_PLATE);
        blockItem(ModBlocks.GREEN_FENCE_GATE);
        blockItem(ModBlocks.GREEN_TRAPDOOR, "_bottom");

        customLamp();
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.THALLIUM_LAMP.get()).forAllStates(state -> {
            if(state.getValue(ThalliumLampBlock.ISLIT)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("thallium_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(Techmod.MODID, "block/" + "thallium_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("thallium_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(Techmod.MODID, "block/" + "thallium_lamp_off")))};
            }
        });

        simpleBlockItem(ModBlocks.THALLIUM_LAMP.get(), models().cubeAll("thallium_lamp_off",
                ResourceLocation.fromNamespaceAndPath(Techmod.MODID, "block/" + "thallium_lamp_off")));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("techmod:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("techmod:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
