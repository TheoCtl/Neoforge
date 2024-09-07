package io.github.TheoCtl.data.recipe;

import io.github.TheoCtl.XCraft;
import io.github.TheoCtl.data.recipe.provider.FurnaceRecipeProvider;
import io.github.TheoCtl.data.recipe.provider.NormalCraftingTableRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;

import java.util.concurrent.CompletableFuture;

public class MainModRecipeProvider extends RecipeProvider {
    protected final DataGenerator generator;
    private final CompletableFuture<HolderLookup.Provider> registries;

    public MainModRecipeProvider(DataGenerator generator, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(generator.getPackOutput(), pRegistries);
        this.generator = generator;
        this.registries = pRegistries;
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        new NormalCraftingTableRecipeProvider(generator, registries, pRecipeOutput).build();
        new FurnaceRecipeProvider(generator, registries, pRecipeOutput).build();
    }

    public ResourceLocation getModId(String path) {
        return ResourceLocation.fromNamespaceAndPath(XCraft.MOD_ID, path);
    }
}