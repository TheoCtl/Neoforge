package io.github.TheoCtl.armor;

import io.github.TheoCtl.XCraft;
import io.github.TheoCtl.init.ArmorMaterialInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.common.extensions.IItemExtension;

import java.util.List;

public class magneto extends ArmorItem implements IItemExtension {
    public static final ResourceLocation ENABLE_FLIGHT_RL = ResourceLocation.fromNamespaceAndPath(XCraft.MOD_ID, "enable_flight");
    public static final AttributeModifier ENABLE_FLIGHT = new AttributeModifier(ENABLE_FLIGHT_RL, 2.0D, AttributeModifier.Operation.ADD_VALUE);

    public magneto(Type type, int durability) {
        super(ArmorMaterialInit.MAGNETO, type, new Properties().durability(type.getDurability(durability)));
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

            giveInfiniteTridents(player);
            killArmedOrArmoredMobs(player);

        } else {
            if (attributeInstance.hasModifier(ENABLE_FLIGHT_RL)) {
                attributeInstance.removeModifier(ENABLE_FLIGHT_RL);
            }
        }
    }

    private static void giveInfiniteTridents(Player player) {
        boolean hasTrident = false;

        // Check if the player already has snowballs
        for (ItemStack itemStack : player.getInventory().items) {
            if (itemStack.getItem() == Items.TRIDENT) {
                hasTrident = true;
                break;
            }
        }

        // If the player has no snowballs, give them a snowball
        if (!hasTrident) {
            player.getInventory().add(new ItemStack(Items.TRIDENT, 1));  // Add a stack of snowballs
        }
    }

    private static void killArmedOrArmoredMobs(Player player) {
        Level level = player.level();
        double radius = 10.0; // Define the radius for detecting mobs
        AABB area = new AABB(
                player.getX() - radius, player.getY() - radius, player.getZ() - radius,
                player.getX() + radius, player.getY() + radius, player.getZ() + radius
        );

        // Get all living entities within the radius
        List<LivingEntity> entities = level.getEntitiesOfClass(LivingEntity.class, area, entity -> entity != player);

        // Kill each entity that is wearing armor or holding a weapon
        for (LivingEntity entity : entities) {
            if (entity instanceof Mob) { // Only target mobs, not players
                if (isWearingArmorOrHoldingWeapon(entity)) {
                    entity.kill(); // Instantly kill the mob
                }
            }
        }
    }

    private static boolean isWearingArmorOrHoldingWeapon(LivingEntity entity) {
        // Check if the entity has armor equipped
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            ItemStack equipment = entity.getItemBySlot(slot);
            if (equipment.getItem() instanceof ArmorItem) {
                return true; // Wearing armor
            }
        }

        // Check if the entity is holding a weapon (e.g., sword, trident, axe)
        ItemStack mainHandItem = entity.getMainHandItem();
        if (mainHandItem.getItem() instanceof SwordItem || mainHandItem.getItem() instanceof ShieldItem || mainHandItem.getItem() == Items.TRIDENT) {
            return true; // Holding a weapon or shield
        }

        return false;
    }

    private static boolean isWearingFullSet(ItemStack helmet) {
        return helmet.getItem() instanceof magneto;
    }
}