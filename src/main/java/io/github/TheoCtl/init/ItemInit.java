package io.github.TheoCtl.init;

import io.github.TheoCtl.XCraft;
import io.github.TheoCtl.armor.professorx;
import io.github.TheoCtl.armor.wolverine;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemInit {
    public static DeferredRegister.Items ITEMS = DeferredRegister.createItems(XCraft.MOD_ID);

    public static final DeferredItem<Item> XGENE = ITEMS.register("xgene", () -> new Item(new Item.Properties()));

    public static DeferredItem<Item> WOLVERINE = ITEMS.register("wolverine", () -> new wolverine(ArmorItem.Type.HELMET, 1000));

    public static DeferredItem<Item> PROFESSORX = ITEMS.register("professorx", () -> new professorx(ArmorItem.Type.HELMET, 1000));

}
