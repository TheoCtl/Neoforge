package io.github.TheoCtl.init;

import io.github.TheoCtl.XCraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class TagsInit {
    public static ResourceLocation createOreLocation(String name) {
        return ResourceLocation.fromNamespaceAndPath(XCraft.MOD_ID,  "ores/" + name);
    }

    public static ResourceLocation createBlockLocation(String name) {
        return ResourceLocation.fromNamespaceAndPath(XCraft.MOD_ID, name);
    }

    public static ResourceLocation createGenericItemsLocation(String name) {
        return ResourceLocation.fromNamespaceAndPath(XCraft.MOD_ID, name);
    }

    public static ResourceLocation createRawItemsLocation(String name) {
        return  ResourceLocation.fromNamespaceAndPath(XCraft.MOD_ID, "raw/" + name);
    }

    public static TagKey<Block> createToolTag(String name) {
        return TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(XCraft.MOD_ID, name));
    }

    public static class ItemTagsInit {
        // Items
        public static final TagKey<Item> XGENE_TAG = ItemTags.create(createGenericItemsLocation("xgene"));

        // Blocks
    }
}