package io.github.TheoCtl;

import io.github.TheoCtl.data.DataGenerators;
import io.github.TheoCtl.init.CreativeModeTabInit;
import io.github.TheoCtl.init.ItemInit;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import org.slf4j.LoggerFactory;

@Mod(XCraft.MOD_ID)
public class XCraft {
    public static final String MOD_ID = "xcraft";
    public static final Logger logger = LoggerFactory.getLogger(XCraft.class);

    public XCraft(@NotNull IEventBus bus) {
        ItemInit.ITEMS.register(bus);
        CreativeModeTabInit.CREATIVE_MODE_TABS.register(bus);

        bus.addListener(DataGenerators::gatherData);

        bus.addListener(FMLClientSetupEvent.class, (fmlClientSetupEvent -> {
            fmlClientSetupEvent.enqueueWork(() -> {
                ModList.get().getModContainerById(MOD_ID).ifPresent(modContainer -> {
                    logger.info("Hello from X-Craft, using version: {}", modContainer.getModInfo().getVersion());
                });
            });
        }));
    }
}