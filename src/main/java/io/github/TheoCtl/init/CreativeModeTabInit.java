package io.github.TheoCtl.init;

import io.github.TheoCtl.XCraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashSet;
import java.util.Set;

public class CreativeModeTabInit {
    public static DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, XCraft.MOD_ID);

    public static String XCRAFT_TAB_ONE_TITLE = "xcraft.tab.one";

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> XCRAFT_TAB_ONE = CREATIVE_MODE_TABS.register("xcraft_tab_one", () -> {
        CreativeModeTab.Builder builder = CreativeModeTab.builder();

        builder.displayItems((itemDisplay, output) -> {
            Set<Item> addedItems = new HashSet<>();

            ItemInit.ITEMS.getEntries()
                    .stream()
                    .map((item) -> item.get().asItem())
                    .filter(addedItems::add)
                    .forEach(output::accept);
        });

        builder.icon(() -> new ItemStack(ItemInit.XGENE.get()));
        builder.title(Component.translatable(XCRAFT_TAB_ONE_TITLE));

        return builder.build();
    });
}
