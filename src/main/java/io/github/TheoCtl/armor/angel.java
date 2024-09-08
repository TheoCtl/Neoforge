package io.github.TheoCtl.armor;

import io.github.TheoCtl.XCraft;
import io.github.TheoCtl.init.ArmorMaterialInit;
import io.github.TheoCtl.utils.XCraftUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.common.extensions.IItemExtension;

import java.util.List;


public class angel extends ArmorItem implements IItemExtension {
    public static final ResourceLocation ENABLE_FLIGHT_RL = ResourceLocation.fromNamespaceAndPath(XCraft.MOD_ID, "enable_flight");
    public static final AttributeModifier ENABLE_FLIGHT = new AttributeModifier(ENABLE_FLIGHT_RL, 2.0D, AttributeModifier.Operation.ADD_VALUE);

    public angel(Type type, int durability) {
        super(ArmorMaterialInit.ANGEL, type, new Properties().durability(type.getDurability(durability)));
    }

    public static void handleEffects(Player player) {
        ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);

        if (player.isCreative() || player.isSpectator() || !player.isAlive()) {
            return;
        }

        AttributeInstance attributeInstance = player.getAttribute(NeoForgeMod.CREATIVE_FLIGHT);

        if (attributeInstance == null) {
            XCraft.logger.error("Failed to get attribute instance for creative flight");
            return;
        }

        if (attributeInstance.getValue() == 1.0 && !attributeInstance.hasModifier(ENABLE_FLIGHT_RL)) {
            return; // Creative flight is enabled, from another source
        }

        if (isWearingFullSet(helmet)) {
            if (!attributeInstance.hasModifier(ENABLE_FLIGHT_RL)) {
                attributeInstance.addTransientModifier(ENABLE_FLIGHT);
            }
            if (!player.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, XCraftUtils.getTimeInTicks(1, XCraftUtils.TimeUnit.MINUTES), 0,
                        false, false, false));
            }
            if (!player.hasEffect(MobEffects.DAMAGE_BOOST)) {
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, XCraftUtils.getTimeInTicks(1, XCraftUtils.TimeUnit.MINUTES), 1,
                        false, false, false));
            }
        } else {
            if (attributeInstance.hasModifier(ENABLE_FLIGHT_RL)) {
                attributeInstance.removeModifier(ENABLE_FLIGHT_RL);
            }
            if (player.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                player.removeEffect(MobEffects.DAMAGE_RESISTANCE);
            }
            if (player.hasEffect(MobEffects.DAMAGE_BOOST)) {
                player.removeEffect(MobEffects.DAMAGE_BOOST);
            }
        }
    }

    private static boolean isWearingFullSet(ItemStack helmet) {
        return helmet.getItem() instanceof angel;
    }
}