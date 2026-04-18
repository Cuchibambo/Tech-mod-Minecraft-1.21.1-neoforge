package com.cuchibambo.techmod.datagen;

import com.cuchibambo.techmod.Techmod;
import com.cuchibambo.techmod.block.ModBlocks;
import com.cuchibambo.techmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProviders extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProviders(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> THALLIUM_SMELTABLES = List.of(ModBlocks.THALLIUM_ORE, ModBlocks.DEEPSLATE_THALLIUM_ORE);
        List<ItemLike> IRONDUST_SMELTABLES = List.of(ModItems.IRON_DUST);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.THALLIUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.THALLIUM_SHARD.get())
                .unlockedBy("has_thallium", has(ModItems.THALLIUM_SHARD)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHISEL.get())
                .pattern("  B")
                .pattern(" A ")
                .pattern("A  ")
                .define('A', Items.STICK)
                .define('B', ModItems.THALLIUM_SHARD.get())
                .unlockedBy("has_thallium", has(ModItems.THALLIUM_SHARD)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.THALLIUM_LAMP.get())
                .pattern(" B ")
                .pattern("BAB")
                .pattern(" B ")
                .define('A', Items.GLOWSTONE)
                .define('B', ModItems.THALLIUM_SHARD.get())
                .unlockedBy("has_thallium", has(ModItems.THALLIUM_SHARD)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.THALLIUM_APPLE.get())
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('A', Items.APPLE)
                .define('B', ModItems.THALLIUM_SHARD.get())
                .unlockedBy("has_thallium", has(ModItems.THALLIUM_SHARD)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GREEN_BLOCK.get(), 4)
                .pattern("CBC")
                .pattern("BAB")
                .pattern("CBC")
                .define('A', Items.TORCH)
                .define('B', Items.LIME_DYE)
                .define('C', Items.LIME_CONCRETE)
                .unlockedBy("has_lime_dye", has(Items.LIME_DYE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.THALLIUM_HAMMER.get(), 1)
                .pattern("BBB")
                .pattern("BBB")
                .pattern(" A ")
                .define('A', Items.STICK)
                .define('B', ModItems.THALLIUM_SHARD)
                .unlockedBy("has_thallium", has(ModItems.THALLIUM_SHARD)).save(recipeOutput);

        stairBuilder(ModBlocks.GREEN_STAIRS.get(), Ingredient.of(ModBlocks.GREEN_BLOCK.asItem())).group("green_block")
                .unlockedBy("has_lime_dye", has(Items.LIME_DYE)).save(recipeOutput);

        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_SLAB.get(), ModBlocks.GREEN_BLOCK.asItem());

        buttonBuilder(ModBlocks.GREEN_BUTTON.get(), Ingredient.of(ModBlocks.GREEN_BLOCK.asItem())).group("green_block")
                .unlockedBy("has_lime_dye", has(Items.LIME_DYE)).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.GREEN_PRESSURE_PLATE.get(), ModBlocks.GREEN_BLOCK.asItem());

        fenceBuilder(ModBlocks.GREEN_FENCE.get(), Ingredient.of(ModBlocks.GREEN_BLOCK.asItem())).group("green_block")
                .unlockedBy("has_lime_dye", has(Items.LIME_DYE)).save(recipeOutput);
        fenceGateBuilder(ModBlocks.GREEN_FENCE_GATE.get(), Ingredient.of(ModBlocks.GREEN_BLOCK.asItem())).group("green_block")
                .unlockedBy("has_lime_dye", has(Items.LIME_DYE)).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_WALL.get(), ModBlocks.GREEN_BLOCK.asItem());

        doorBuilder(ModBlocks.GREEN_DOOR.get(), Ingredient.of(ModBlocks.GREEN_BLOCK.asItem())).group("green_block")
                .unlockedBy("has_lime_dye", has(Items.LIME_DYE)).save(recipeOutput);
        trapdoorBuilder(ModBlocks.GREEN_TRAPDOOR.get(), Ingredient.of(ModBlocks.GREEN_BLOCK.asItem())).group("green_block")
                .unlockedBy("has_lime_dye", has(Items.LIME_DYE)).save(recipeOutput);



        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.THALLIUM_SHARD.get(), 9)
                .requires(ModBlocks.THALLIUM_BLOCK)
                .unlockedBy("has_thallium_block", has(ModBlocks.THALLIUM_BLOCK)).save(recipeOutput);

        oreSmelting(recipeOutput, THALLIUM_SMELTABLES, RecipeCategory.MISC, ModItems.THALLIUM_SHARD.get(), 0.25f, 200, "thallium");
        oreBlasting(recipeOutput, THALLIUM_SMELTABLES, RecipeCategory.MISC, ModItems.THALLIUM_SHARD.get(), 0.25f, 100, "thallium");
        oreSmelting(recipeOutput, IRONDUST_SMELTABLES, RecipeCategory.MISC, Items.IRON_INGOT, 0.25f, 200, "iron_ingot");
        oreBlasting(recipeOutput, IRONDUST_SMELTABLES, RecipeCategory.MISC, Items.IRON_INGOT, 0.25f, 100, "iron_ingot");



    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Techmod.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

}
