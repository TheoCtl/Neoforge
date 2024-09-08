package io.github.TheoCtl;

import io.github.TheoCtl.data.DataGenerators;
import io.github.TheoCtl.events.Events;
import io.github.TheoCtl.init.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(XCraft.MOD_ID)
public class XCraft {
    public static final String MOD_ID = "xcraft";
    public static final Logger logger = LoggerFactory.getLogger(XCraft.class);

    public XCraft(@NotNull IEventBus bus) {
        IEventBus neoForgeBus = NeoForge.EVENT_BUS;

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        CreativeModeTabInit.CREATIVE_MODE_TABS.register(bus);
        LootModifierInit.LOOT_MODIFIERS.register(bus);
        ArmorMaterialInit.ARMOR_MATERIALS.register(bus);


        bus.addListener(DataGenerators::gatherData);
        neoForgeBus.addListener(Events::onPlayerTickEventsPre);

        bus.addListener(FMLClientSetupEvent.class, (fmlClientSetupEvent -> {
            fmlClientSetupEvent.enqueueWork(() -> {
                ModList.get().getModContainerById(MOD_ID).ifPresent(modContainer -> {
                    logger.info("Hello from XCraft!, using version: {}", modContainer.getModInfo().getVersion());
                });
            });
        }));
    }
}