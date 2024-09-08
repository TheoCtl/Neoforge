package io.github.TheoCtl.armor;

import io.github.TheoCtl.XCraft;
import io.github.TheoCtl.init.ArmorMaterialInit;
import io.github.TheoCtl.utils.XCraftUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.common.extensions.IItemExtension;

public class wolverine extends ArmorItem implements IItemExtension {
    public wolverine(Type type, int durability) {
        super(ArmorMaterialInit.WOLVERINE, type, new Item.Properties().durability(type.getDurability(durability)));
    }

    public static void handleEffects(Player player) {
        ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);

        if (isWearingFullSet(helmet)) {
            if (!player.hasEffect(MobEffects.REGENERATION)) {
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, XCraftUtils.getTimeInTicks(1, XCraftUtils.TimeUnit.MINUTES), 1,
                        false, false, false));
            }
            if (!player.hasEffect(MobEffects.DAMAGE_BOOST)) {
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, XCraftUtils.getTimeInTicks(1, XCraftUtils.TimeUnit.MINUTES), 2,
                        false, false, false));
            }
        } else {
            if (player.hasEffect(MobEffects.REGENERATION)) {
                player.removeEffect(MobEffects.REGENERATION);
            }
            if (player.hasEffect(MobEffects.DAMAGE_BOOST)) {
                player.removeEffect(MobEffects.DAMAGE_BOOST);
            }
        }
    }

    private static boolean isWearingFullSet(ItemStack helmet) {
        return helmet.getItem() instanceof wolverine;
    }
}