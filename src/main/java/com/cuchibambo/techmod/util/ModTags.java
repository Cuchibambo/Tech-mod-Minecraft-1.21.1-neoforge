package com.cuchibambo.techmod.util;

import com.cuchibambo.techmod.Techmod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_THALLIUM_TOOL = createTag("needs_thallium_tool");
        public static final TagKey<Block> INCORRECT_FOR_THALLIUM_TOOL = createTag("incorrect_for_thallium_tool");


        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Techmod.MODID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Techmod.MODID, name));
        }
    }
}
