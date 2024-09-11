package io.github.TheoCtl.data.texture;

import io.github.TheoCtl.XCraft;
import io.github.TheoCtl.init.ItemInit;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class ModItemStateProvider extends ItemModelProvider {
    public ModItemStateProvider(PackOutput output,  ExistingFileHelper existingFileHelper) {
        super(output, XCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        item(ItemInit.XGENE.get());

        item(ItemInit.WOLVERINE.get());
        item(ItemInit.PROFESSORX.get());
        item(ItemInit.CYCLOPS.get());
        item(ItemInit.PHOENIX.get());
        item(ItemInit.ICEMAN.get());
        item(ItemInit.BEAST.get());
        item(ItemInit.ANGEL.get());
        item(ItemInit.STORM.get());
        item(ItemInit.MAGNETO.get());
        item(ItemInit.NIGHTCRAWLER.get());
    }

    private void item(Item item) {
        String name = getItemName(item);
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", "item/" + name);
    }

    private @NotNull String getItemName(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).toString().replace(XCraft.MOD_ID + ":", "");
    }
}