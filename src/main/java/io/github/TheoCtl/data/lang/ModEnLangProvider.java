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

        // Armor
        addItem(ItemInit.WOLVERINE, "Wolverine's Mask");
        addItem(ItemInit.PROFESSORX, "Professor X's Cerebro");
        addItem(ItemInit.CYCLOPS, "Cyclops' Mask");
        addItem(ItemInit.PHOENIX, "Phoenix's Mask");
        addItem(ItemInit.ICEMAN, "Iceman's Mask");
        addItem(ItemInit.BEAST, "Beast's Mask");
        addItem(ItemInit.ANGEL, "Angel's Mask");
        addItem(ItemInit.STORM, "Storm's Mask");
        addItem(ItemInit.MAGNETO, "Magneto's Helmet");
        addItem(ItemInit.NIGHTCRAWLER, "Nightcrawler's Mask");

        //Blocks

        // Ores

        // Deepslate Ores

        // others
        add(CreativeModeTabInit.XCRAFT_TAB_ONE_TITLE, "X-Craft");
    }
}