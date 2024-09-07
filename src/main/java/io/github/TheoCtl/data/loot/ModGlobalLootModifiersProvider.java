package io.github.TheoCtl.data.loot;

import io.github.TheoCtl.XCraft;
import io.github.TheoCtl.init.ItemInit;
import io.github.TheoCtl.loot.AddItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, XCraft.MOD_ID);
    }

    @Override
    protected void start() {
        add("xgene_from_villager", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("entities/villager")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build()},
                ItemInit.XGENE.get()));
    }
}
