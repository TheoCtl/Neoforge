package io.github.TheoCtl.data.tag;

import io.github.TheoCtl.XCraft;
import io.github.TheoCtl.init.ItemInit;
import io.github.TheoCtl.init.TagsInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,  BlockTagsProvider provider, ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, provider.contentsGetter(), XCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(TagsInit.ItemTagsInit.XGENE_TAG).add(ItemInit.XGENE.get());

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ItemInit.WOLVERINE.get())
                .add(ItemInit.PROFESSORX.get())
                .add(ItemInit.CYCLOPS.get())
                .add(ItemInit.PHOENIX.get());
    }
}