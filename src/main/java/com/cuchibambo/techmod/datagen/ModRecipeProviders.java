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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GREEN_BLOCK.get())
                .pattern("CBC")
                .pattern("BAB")
                .pattern("CBC")
                .define('A', Items.TORCH)
                .define('B', Items.GREEN_DYE)
                .define('C', Items.GREEN_CONCRETE)
                .unlockedBy("has_green_dye", has(Items.GREEN_DYE)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.THALLIUM_SHARD.get(), 9)
                .requires(ModBlocks.THALLIUM_BLOCK)
                .unlockedBy("has_thallium_block", has(ModBlocks.THALLIUM_BLOCK)).save(recipeOutput);

        oreSmelting(recipeOutput, THALLIUM_SMELTABLES, RecipeCategory.MISC, ModItems.THALLIUM_SHARD.get(), 0.25f, 200, "thallium");
        oreBlasting(recipeOutput, THALLIUM_SMELTABLES, RecipeCategory.MISC, ModItems.THALLIUM_SHARD.get(), 0.25f, 100, "thallium");
        oreSmelting(recipeOutput, IRONDUST_SMELTABLES, RecipeCategory.MISC, Items.IRON_INGOT, 0.25f, 200, "iron");
        oreBlasting(recipeOutput, IRONDUST_SMELTABLES, RecipeCategory.MISC, Items.IRON_INGOT, 0.25f, 100, "iron");


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
