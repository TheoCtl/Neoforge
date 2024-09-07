package io.github.TheoCtl.init;

import io.github.TheoCtl.XCraft;
import io.github.TheoCtl.armor.wolverine;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemInit {
    public static DeferredRegister.Items ITEMS = DeferredRegister.createItems(XCraft.MOD_ID);

    public static final DeferredItem<Item> XGENE = ITEMS.register("xgene", () -> new Item(new Item.Properties()));

    public static DeferredItem<Item> RAW_EXAMPLE = ITEMS.register("raw_example", () -> new Item(new Item.Properties()));

    public static DeferredItem<Item> HELMET = ITEMS.register("helmet", () -> new wolverine(ArmorItem.Type.HELMET, 15));

    public static DeferredItem<Item> CHESTPLATE = ITEMS.register("chestplate", () -> new wolverine(ArmorItem.Type.CHESTPLATE, 15));

    public static DeferredItem<Item> LEGGINGS = ITEMS.register("leggings", () -> new wolverine(ArmorItem.Type.LEGGINGS, 15));

    public static DeferredItem<Item> BOOTS = ITEMS.register("boots", () -> new wolverine(ArmorItem.Type.BOOTS, 15));
}