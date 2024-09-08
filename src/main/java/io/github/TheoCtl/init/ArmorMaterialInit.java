package io.github.TheoCtl.init;

import io.github.TheoCtl.XCraft;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ArmorMaterialInit {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, XCraft.MOD_ID);

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> WOLVERINE = ARMOR_MATERIALS.register("wolverine", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), (Map<ArmorItem.Type, Integer> map) -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 7);
                map.put(ArmorItem.Type.BODY, 4);
            }),
            15,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            () -> Ingredient.of(TagsInit.ItemTagsInit.XGENE_TAG),
            List.of(
                    new ArmorMaterial.Layer(
                            ResourceLocation.fromNamespaceAndPath(XCraft.MOD_ID, "wolverine")
                    )

                    // Creates a new armor texture that will be rendered on top of the previous at:
                    // - 'assets/mod_id/textures/models/armor/example_layer_1_overlay.png' for the outer texture
                    // - 'assets/mod_id/textures/models/armor/example_layer_2_overlay.png' for the inner texture (only legs)
                    // 'true' means that the armor material is dyeable; however, the item must also be added to the 'minecraft:dyeable' tag
                    // new ArmorMaterial.Layer(
                    //       ResourceLocation.fromNamespaceAndPath(XCraft.MOD_ID, "example"), "_overlay", true
                    //)
            ),
            0,
            0
    ));

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> PROFESSORX = ARMOR_MATERIALS.register("professorx", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), (Map<ArmorItem.Type, Integer> map) -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 4);
            }),
            15,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            () -> Ingredient.of(TagsInit.ItemTagsInit.XGENE_TAG),
            List.of(
                    new ArmorMaterial.Layer(
                            ResourceLocation.fromNamespaceAndPath(XCraft.MOD_ID, "professorx")
                    )

                    // Creates a new armor texture that will be rendered on top of the previous at:
                    // - 'assets/mod_id/textures/models/armor/example_layer_1_overlay.png' for the outer texture
                    // - 'assets/mod_id/textures/models/armor/example_layer_2_overlay.png' for the inner texture (only legs)
                    // 'true' means that the armor material is dyeable; however, the item must also be added to the 'minecraft:dyeable' tag
                    // new ArmorMaterial.Layer(
                    //       ResourceLocation.fromNamespaceAndPath(XCraft.MOD_ID, "example"), "_overlay", true
                    //)
            ),
            0,
            0
    ));

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> CYCLOPS = ARMOR_MATERIALS.register("cyclops", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), (Map<ArmorItem.Type, Integer> map) -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 4);
                map.put(ArmorItem.Type.BODY, 4);
            }),
            15,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            () -> Ingredient.of(TagsInit.ItemTagsInit.XGENE_TAG),
            List.of(
                    new ArmorMaterial.Layer(
                            ResourceLocation.fromNamespaceAndPath(XCraft.MOD_ID, "cyclops")
                    )

                    // Creates a new armor texture that will be rendered on top of the previous at:
                    // - 'assets/mod_id/textures/models/armor/example_layer_1_overlay.png' for the outer texture
                    // - 'assets/mod_id/textures/models/armor/example_layer_2_overlay.png' for the inner texture (only legs)
                    // 'true' means that the armor material is dyeable; however, the item must also be added to the 'minecraft:dyeable' tag
                    // new ArmorMaterial.Layer(
                    //       ResourceLocation.fromNamespaceAndPath(XCraft.MOD_ID, "example"), "_overlay", true
                    //)
            ),
            0,
            0
    ));

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> PHOENIX = ARMOR_MATERIALS.register("phoenix", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), (Map<ArmorItem.Type, Integer> map) -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 6);
                map.put(ArmorItem.Type.BODY, 4);
            }),
            15,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            () -> Ingredient.of(TagsInit.ItemTagsInit.XGENE_TAG),
            List.of(
                    new ArmorMaterial.Layer(
                            ResourceLocation.fromNamespaceAndPath(XCraft.MOD_ID, "phoenix")
                    )

                    // Creates a new armor texture that will be rendered on top of the previous at:
                    // - 'assets/mod_id/textures/models/armor/example_layer_1_overlay.png' for the outer texture
                    // - 'assets/mod_id/textures/models/armor/example_layer_2_overlay.png' for the inner texture (only legs)
                    // 'true' means that the armor material is dyeable; however, the item must also be added to the 'minecraft:dyeable' tag
                    // new ArmorMaterial.Layer(
                    //       ResourceLocation.fromNamespaceAndPath(XCraft.MOD_ID, "example"), "_overlay", true
                    //)
            ),
            0,
            0
    ));

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> ICEMAN = ARMOR_MATERIALS.register("iceman", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), (Map<ArmorItem.Type, Integer> map) -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 10);
                map.put(ArmorItem.Type.BODY, 4);
            }),
            15,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            () -> Ingredient.of(TagsInit.ItemTagsInit.XGENE_TAG),
            List.of(
                    new ArmorMaterial.Layer(
                            ResourceLocation.fromNamespaceAndPath(XCraft.MOD_ID, "iceman")
                    )
            ),
            0,
            0
    ));
}