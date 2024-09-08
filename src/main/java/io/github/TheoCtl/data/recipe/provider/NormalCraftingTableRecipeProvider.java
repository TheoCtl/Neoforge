package io.github.TheoCtl.data.recipe.provider;

import io.github.TheoCtl.data.recipe.MainModRecipeProvider;
import io.github.TheoCtl.init.BlockInit;
import io.github.TheoCtl.init.ItemInit;
import io.github.TheoCtl.init.TagsInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class NormalCraftingTableRecipeProvider extends MainModRecipeProvider {
    private final RecipeOutput recipeOutput;


    public NormalCraftingTableRecipeProvider(DataGenerator generator, CompletableFuture<HolderLookup.Provider> pRegistries, RecipeOutput recipeOutput) {
        super(generator, pRegistries);
        this.recipeOutput = recipeOutput;
    }

    public void build() {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ItemInit.WOLVERINE.get(), 1)
                .pattern("BBB")
                .pattern("C#J")
                .pattern("BBB")
                .define('#', TagsInit.ItemTagsInit.XGENE_TAG)
                .define('B', Items.IRON_BLOCK)
                .define('C', Items.YELLOW_DYE)
                .define('J', Items.BLUE_DYE)
                .unlockedBy("has_item", has(TagsInit.ItemTagsInit.XGENE_TAG))
                .save(this.recipeOutput, getModId("wolverine_recipe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ItemInit.PROFESSORX.get(), 1)
                .pattern("BBB")
                .pattern("G#W")
                .pattern("ACD")
                .define('#', TagsInit.ItemTagsInit.XGENE_TAG)
                .define('B', Items.IRON_HELMET)
                .define('G', Items.GRAY_DYE)
                .define('W', Items.WHITE_DYE)
                .define('A', Items.NETHER_STAR)
                .define('C', Items.TOTEM_OF_UNDYING)
                .define('D', Items.HEART_OF_THE_SEA)
                .unlockedBy("has_item", has(TagsInit.ItemTagsInit.XGENE_TAG))
                .save(this.recipeOutput, getModId("professorx_recipe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ItemInit.CYCLOPS.get(), 1)
                .pattern("BBB")
                .pattern("G#W")
                .pattern("BBB")
                .define('#', TagsInit.ItemTagsInit.XGENE_TAG)
                .define('B', Items.QUARTZ)
                .define('G', Items.YELLOW_DYE)
                .define('W', Items.RED_DYE)
                .unlockedBy("has_item", has(TagsInit.ItemTagsInit.XGENE_TAG))
                .save(this.recipeOutput, getModId("cyclops_recipe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ItemInit.PHOENIX.get(), 1)
                .pattern("BBB")
                .pattern("G#D")
                .pattern("AAA")
                .define('#', TagsInit.ItemTagsInit.XGENE_TAG)
                .define('B', Items.BLAZE_ROD)
                .define('A', Items.MAGMA_CREAM)
                .define('G', Items.GREEN_DYE)
                .define('D', Items.YELLOW_DYE)
                .unlockedBy("has_item", has(TagsInit.ItemTagsInit.XGENE_TAG))
                .save(this.recipeOutput, getModId("phoenix_recipe"));
    }
}