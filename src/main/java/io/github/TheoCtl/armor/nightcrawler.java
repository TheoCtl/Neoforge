package io.github.TheoCtl.armor;

import io.github.TheoCtl.XCraft;
import io.github.TheoCtl.init.ArmorMaterialInit;
import io.github.TheoCtl.utils.XCraftUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.extensions.IItemExtension;

public class nightcrawler extends ArmorItem implements IItemExtension {
    public static final ResourceLocation ENABLE_FLIGHT_RL = ResourceLocation.fromNamespaceAndPath(XCraft.MOD_ID, "enable_flight");
    public static final AttributeModifier ENABLE_FLIGHT = new AttributeModifier(ENABLE_FLIGHT_RL, 2.0D, AttributeModifier.Operation.ADD_VALUE);

    public nightcrawler(Type type, int durability) {
        super(ArmorMaterialInit.NIGHTCRAWLER, type, new Properties().durability(type.getDurability(durability)));
    }

    public static void handleEffects(Player player) {
        ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);

        if (isWearingFullSet(helmet)) {
            if (!player.hasEffect(MobEffects.MOVEMENT_SPEED)) {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, XCraftUtils.getTimeInTicks(1, XCraftUtils.TimeUnit.MINUTES), 0,
                        false, false, false));
            }
            if (!player.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, XCraftUtils.getTimeInTicks(1, XCraftUtils.TimeUnit.MINUTES), 0,
                        false, false, false));
            }
            if (!player.hasEffect(MobEffects.REGENERATION)) {
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, XCraftUtils.getTimeInTicks(1, XCraftUtils.TimeUnit.MINUTES), 0,
                        false, false, false));
            }
            giveInfiniteEnderpearl(player);
        } else {
            if (player.hasEffect(MobEffects.MOVEMENT_SPEED)) {
                player.removeEffect(MobEffects.MOVEMENT_SPEED);
            }
            if (player.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                player.removeEffect(MobEffects.DAMAGE_RESISTANCE);
            }
            if (player.hasEffect(MobEffects.REGENERATION)) {
                player.removeEffect(MobEffects.REGENERATION);
            }
        }
    }

    private static void giveInfiniteEnderpearl(Player player) {
        boolean hasEP = false;

        // Check if the player already has snowballs
        for (ItemStack itemStack : player.getInventory().items) {
            if (itemStack.getItem() == Items.ENDER_PEARL) {
                hasEP = true;
                break;
            }
        }

        // If the player has no snowballs, give them a snowball
        if (!hasEP) {
            player.getInventory().add(new ItemStack(Items.ENDER_PEARL, 16));  // Add a stack of snowballs
        }
    }

    private static boolean isWearingFullSet(ItemStack helmet) {
        return helmet.getItem() instanceof nightcrawler;
    }
}