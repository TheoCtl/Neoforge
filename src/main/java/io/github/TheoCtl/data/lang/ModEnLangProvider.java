package io.github.TheoCtl.data.lang;

import io.github.TheoCtl.XCraft;
import io.github.TheoCtl.init.BlockInit;
import io.github.TheoCtl.init.CreativeModeTabInit;
import io.github.TheoCtl.init.ItemInit;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModEnLangProvider extends LanguageProvider {

    public ModEnLangProvider(PackOutput output) {
        super(output, XCraft.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // Items
        addItem(ItemInit.XGENE, "X-Gene");
        addItem(ItemInit.RAW_EXAMPLE, "Raw Example");

        // Armor
        addItem(ItemInit.HELMET, "Helmet");
        addItem(ItemInit.CHESTPLATE, "Chestplate");
        addItem(ItemInit.LEGGINGS, "Leggings");
        addItem(ItemInit.BOOTS, "Boots");

        //Blocks
        addBlock(BlockInit.EXAMPLE_BLOCK, "Example Block");

        // Ores
        addBlock(BlockInit.EXAMPLE_ORE, "Example Ore");

        // Deepslate Ores
        addBlock(BlockInit.DEEPSLATE_EXAMPLE_ORE, "Deepslate Example Ore");

        // others
        add(CreativeModeTabInit.XCRAFT_TAB_ONE_TITLE, "X-Craft");
    }
}