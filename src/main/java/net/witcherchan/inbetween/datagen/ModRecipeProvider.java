package net.witcherchan.inbetween.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;
import net.witcherchan.inbetween.InBetween;
import net.witcherchan.inbetween.block.ModBlocks;
import net.witcherchan.inbetween.item.ModItems;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {


    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        oreBoth(
                consumer,
                List.of(ModItems.RAW_NICOL.get()),
                RecipeCategory.MISC,
                ModItems.NICOL_INGOT.get(),
                1.0f,
                200,
                100,
                "nicol"
        );

        oreBoth(
                consumer,
                List.of(ModBlocks.NICOL_ORE.get()),
                RecipeCategory.MISC,
                ModItems.NICOL_INGOT.get(),
                1.0f,
                200,
                100,
                "nicol"
        );

        oreSmelting(
                consumer,
                List.of(ModBlocks.SHADOW_COBBLESTONE.get()),
                RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.SHADOW_STONE.get(),
                0.1f,
                200,
                "stone"
        );

        oreSmelting(
                consumer,
                List.of(ModBlocks.SHADOW_STONE.get()),
                RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.SMOOTH_SHADOW_STONE.get(),
                0.1f,
                200,
                "stone"
        );

        oreSmelting(
                consumer,
                List.of(ModBlocks.SHADOW_STONE_BRICKS.get()),
                RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.CRACKED_SHADOW_STONE_BRICKS.get(),
                0.1f,
                200,
                "stone"
        );

        twoByTwoPacker(
                consumer,
                RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.SHADOW_COBBLESTONE.get(),
                ModBlocks.SHADOW_STONE_BRICKS.get(),
                4
        );

        nineBlockStorageRecipes(
                consumer,
                RecipeCategory.BUILDING_BLOCKS,
                ModItems.NICOL_INGOT.get(),
                RecipeCategory.MISC,
                ModBlocks.NICOL_BLOCK.get()
        );

        nineBlockStorageRecipes(
                consumer,
                RecipeCategory.BUILDING_BLOCKS,
                ModItems.RAW_NICOL.get(),
                RecipeCategory.MISC,
                ModBlocks.RAW_NICOL_BLOCK.get()
        );

        nineBlockStorageRecipes(
                consumer,
                RecipeCategory.BUILDING_BLOCKS,
                ModItems.FRAGANITE.get(),
                RecipeCategory.MISC,
                ModBlocks.FRAGANITE_BLOCK.get()
        );

        stonecutterResultFromBase(
                consumer,
                RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.SHADOW_STONE.get(),
                ModBlocks.SHADOW_STONE_BRICKS.get(),
                1
        );

        stonecutterResultFromBase(
                consumer,
                RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.SHADOW_STONE.get(),
                ModBlocks.CHISELED_SHADOW_STONE_BRICKS.get(),
                1
        );

        stonecutterResultFromBase(
                consumer,
                RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.SHADOW_STONE_BRICKS.get(),
                ModBlocks.CHISELED_SHADOW_STONE_BRICKS.get(),
                1
        );
    }

    protected static void twoByTwoPacker(Consumer<FinishedRecipe> consumer, RecipeCategory category, ItemLike item_used, ItemLike item_get, int amount) {
            ShapedRecipeBuilder.shaped(category, item_get, amount).define('#', item_used).pattern("##").pattern("##").unlockedBy(getHasName(item_used), has(item_used)).save(consumer, new ResourceLocation(InBetween.MOD_ID,getItemName(item_get)));
    }

    protected static void oreCooking(Consumer<FinishedRecipe> p_250791_, RecipeSerializer<? extends AbstractCookingRecipe> p_251817_, List<ItemLike> p_249619_, RecipeCategory p_251154_, ItemLike p_250066_, float p_251871_, int p_251316_, String group, String p_249236_) {
        for(ItemLike itemlike : p_249619_) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), p_251154_, p_250066_,p_251871_, p_251316_, p_251817_).group(group).unlockedBy(getHasName(itemlike), has(itemlike)).save(p_250791_, new ResourceLocation(InBetween.MOD_ID,getItemName(p_250066_)) + p_249236_ + "_" + getItemName(itemlike));
        }
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> p_250654_, List<ItemLike> p_250172_, RecipeCategory p_250588_, ItemLike p_251868_, float exp, int time, String group) {
        oreCooking(p_250654_, RecipeSerializer.SMELTING_RECIPE, p_250172_, p_250588_, p_251868_, exp, time, group, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> p_248775_, List<ItemLike> p_251504_, RecipeCategory p_248846_, ItemLike p_249735_, float exp, int time, String group) {
        oreCooking(p_248775_, RecipeSerializer.BLASTING_RECIPE, p_251504_, p_248846_, p_249735_, exp, time, group, "_from_blasting");
    }

    protected static void oreBoth(Consumer<FinishedRecipe> p_250654_, List<ItemLike> p_250172_, RecipeCategory p_250588_, ItemLike p_251868_, float exp, int time_smelt, int time_blast, String group) {
        oreSmelting(p_250654_,p_250172_,p_250588_,p_251868_,exp,time_smelt,group);
        oreBlasting(p_250654_,p_250172_,p_250588_,p_251868_,exp,time_blast,group);
    }
    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> p_249580_, RecipeCategory p_251203_, ItemLike p_251689_, RecipeCategory p_251376_, ItemLike p_248771_) {
        nineBlockStorageRecipes(p_249580_, p_251203_, p_251689_, p_251376_, p_248771_, getSimpleRecipeName(p_248771_), (String)null, getSimpleRecipeName(p_251689_), (String)null);
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> p_250423_, RecipeCategory p_250083_, ItemLike p_250042_, RecipeCategory p_248977_, ItemLike p_251911_, String p_250475_, @Nullable String p_248641_, String p_252237_, @Nullable String p_250414_) {
        ShapelessRecipeBuilder.shapeless(p_250083_, p_250042_, 9).requires(p_251911_).group(p_250414_).unlockedBy(getHasName(p_251911_), has(p_251911_)).save(p_250423_, new ResourceLocation(InBetween.MOD_ID, p_252237_));
        ShapedRecipeBuilder.shaped(p_248977_, p_251911_).define('#', p_250042_).pattern("###").pattern("###").pattern("###").group(p_248641_).unlockedBy(getHasName(p_250042_), has(p_250042_)).save(p_250423_, new ResourceLocation(InBetween.MOD_ID, p_250475_));
    }

    protected static void stonecutterResultFromBase(Consumer<FinishedRecipe> consumer, RecipeCategory category, ItemLike item_used, ItemLike item_get, int amount) {
        stonecutterResultFromBases(consumer, category, item_used, item_get,amount);
    }

    protected static void stonecutterResultFromBases(Consumer<FinishedRecipe> consumer, RecipeCategory recipeCategory, ItemLike item_used, ItemLike item_get, int amount) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(item_used), recipeCategory, item_get, amount).unlockedBy(getHasName(item_get), has(item_get)).save(consumer, new ResourceLocation(InBetween.MOD_ID,getConversionRecipeName(item_get, item_used) + "_stonecutting"));
    }

}
