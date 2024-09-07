package io.github.TheoCtl.init;

import com.mojang.serialization.MapCodec;
import io.github.TheoCtl.XCraft;
import io.github.TheoCtl.loot.AddItemModifier;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Map;

public class LootModifierInit {
    public static DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(NeoForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS, XCraft.MOD_ID);

    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<AddItemModifier>> ADD_ITEM_MODIFIER = LOOT_MODIFIERS.register("add_item", AddItemModifier.CODEC_SUPPLIER);
}
