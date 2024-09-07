package io.github.TheoCtl.data.lang;

import io.github.TheoCtl.XCraft;
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

         //Items
         addItem(ItemInit.XGENE, "X-Gene");

         //Others
         add(CreativeModeTabInit.XCRAFT_TAB_ONE_TITLE, "X-Craft");
     }
}
