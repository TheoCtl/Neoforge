package io.github.TheoCtl.init;

import io.github.TheoCtl.XCraft;
import io.github.TheoCtl.armor.*;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemInit {
    public static DeferredRegister.Items ITEMS = DeferredRegister.createItems(XCraft.MOD_ID);

    public static final DeferredItem<Item> XGENE = ITEMS.register("xgene", () -> new Item(new Item.Properties()));

    public static DeferredItem<Item> ANGEL = ITEMS.register("angel", () -> new angel(ArmorItem.Type.HELMET, 1000));
    public static DeferredItem<Item> BEAST = ITEMS.register("beast", () -> new beast(ArmorItem.Type.HELMET, 1000));
    public static DeferredItem<Item> CYCLOPS = ITEMS.register("cyclops", () -> new cyclops(ArmorItem.Type.HELMET, 1000));
    public static DeferredItem<Item> ICEMAN = ITEMS.register("iceman", () -> new iceman(ArmorItem.Type.HELMET, 1000));
    public static DeferredItem<Item> PHOENIX = ITEMS.register("phoenix", () -> new phoenix(ArmorItem.Type.HELMET, 1000));
    public static DeferredItem<Item> PROFESSORX = ITEMS.register("professorx", () -> new professorx(ArmorItem.Type.HELMET, 1000));
    public static DeferredItem<Item> WOLVERINE = ITEMS.register("wolverine", () -> new wolverine(ArmorItem.Type.HELMET, 1000));
}
