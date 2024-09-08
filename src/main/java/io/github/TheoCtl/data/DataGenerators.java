package io.github.TheoCtl.data;

import io.github.TheoCtl.XCraft;
import io.github.TheoCtl.data.lang.ModEnLangProvider;
import io.github.TheoCtl.data.loot.ModGlobalLootModifiersProvider;
import io.github.TheoCtl.data.loottable.ModLootTables;
import io.github.TheoCtl.data.recipe.MainModRecipeProvider;
import io.github.TheoCtl.data.tag.ModBlockTagsProvider;
import io.github.TheoCtl.data.tag.ModItemTagProvider;
import io.github.TheoCtl.data.texture.ModBlockStateProvider;
import io.github.TheoCtl.data.texture.ModItemStateProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class DataGenerators {

    public static void gatherData(GatherDataEvent event) {
        try {
            DataGenerator generator = event.getGenerator();
            PackOutput output = generator.getPackOutput();
            ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

            generator.addProvider(true, new ModEnLangProvider(output));
            generator.addProvider(true, new ModItemStateProvider(output, existingFileHelper));
            generator.addProvider(true, new ModBlockStateProvider(output, existingFileHelper));
            ModBlockTagsProvider modBlockTagsProvider = new ModBlockTagsProvider(output, event.getLookupProvider(), existingFileHelper);
            generator.addProvider(true, modBlockTagsProvider);
            generator.addProvider(true, new ModItemTagProvider(output, event.getLookupProvider(), modBlockTagsProvider, existingFileHelper));
            generator.addProvider(true, new ModLootTables(output, event.getLookupProvider()));
            generator.addProvider(true, new MainModRecipeProvider(generator, event.getLookupProvider()));
            generator.addProvider(true, new ModGlobalLootModifiersProvider(output, event.getLookupProvider()));
        } catch (RuntimeException e) {
            XCraft.logger.error("Failed to gather data", e);
        }
    }
}