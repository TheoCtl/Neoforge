package com.theoctl.xcraft.item;

import com.theoctl.xcraft.XCraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, XCraft.MOD_ID);


    public static final Supplier<CreativeModeTab> XGENE_ITEMS_TAB = CREATIVE_MODE_TAB.register("xgene_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.XGENE.get()))
                    .title(Component.translatable("creativetab.xcraft.xgene_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.XGENE);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
