package com.cuchibambo.techmod.datagen;

import com.cuchibambo.techmod.Techmod;
import com.cuchibambo.techmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

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
    }
}
