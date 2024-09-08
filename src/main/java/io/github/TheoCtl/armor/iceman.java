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
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.common.extensions.IItemExtension;

import java.util.List;

public class iceman extends ArmorItem implements IItemExtension {
    public static final ResourceLocation ENABLE_FLIGHT_RL = ResourceLocation.fromNamespaceAndPath(XCraft.MOD_ID, "enable_flight");
    public static final AttributeModifier ENABLE_FLIGHT = new AttributeModifier(ENABLE_FLIGHT_RL, 2.0D, AttributeModifier.Operation.ADD_VALUE);

    public iceman(Type type, int durability) {
        super(ArmorMaterialInit.ICEMAN, type, new Properties().durability(type.getDurability(durability)));
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

            giveInfiniteSnowballs(player);

            double radius = 5.0; // Example: 10 blocks radius

            // Create an AABB (Axis-Aligned Bounding Box) for the radius around the player
            AABB area = new AABB(
                    player.getX() - radius, player.getY() - radius, player.getZ() - radius,
                    player.getX() + radius, player.getY() + radius, player.getZ() + radius
            );

            // Get all living entities within the radius
            List<LivingEntity> entities = player.level().getEntitiesOfClass(LivingEntity.class, area);

            // Apply the Weakness effect to each entity for 5 seconds (100 ticks)
            for (LivingEntity entity : entities) {
                if (entity != player) {  // Exclude the player themselves
                    entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 5));
                }
            }

            if (!player.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, XCraftUtils.getTimeInTicks(1, XCraftUtils.TimeUnit.MINUTES), 2,
                        false, false, false));
            }
        } else {
            if (attributeInstance.hasModifier(ENABLE_FLIGHT_RL)) {
                attributeInstance.removeModifier(ENABLE_FLIGHT_RL);
            }

            if (player.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                player.removeEffect(MobEffects.DAMAGE_RESISTANCE);
            }
        }
    }

    private static void giveInfiniteSnowballs(Player player) {
        boolean hasSnowballs = false;

        // Check if the player already has snowballs
        for (ItemStack itemStack : player.getInventory().items) {
            if (itemStack.getItem() == Items.SNOWBALL) {
                hasSnowballs = true;
                break;
            }
        }

        // If the player has no snowballs, give them a snowball
        if (!hasSnowballs) {
            player.getInventory().add(new ItemStack(Items.SNOWBALL, 16));  // Add a stack of snowballs
        }
    }

    private static boolean isWearingFullSet(ItemStack helmet) {
        return helmet.getItem() instanceof iceman;
    }
}