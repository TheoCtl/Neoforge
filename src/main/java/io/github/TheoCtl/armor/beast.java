package io.github.TheoCtl.armor;

import io.github.TheoCtl.init.ArmorMaterialInit;
import io.github.TheoCtl.utils.XCraftUtils;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.extensions.IItemExtension;

public class beast extends ArmorItem implements IItemExtension {
    public beast(Type type, int durability) {
        super(ArmorMaterialInit.BEAST, type, new Properties().durability(type.getDurability(durability)));
    }

    public static void handleEffects(Player player) {
        ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);

        if (isWearingFullSet(helmet)) {
            if (!player.hasEffect(MobEffects.MOVEMENT_SPEED)) {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, XCraftUtils.getTimeInTicks(1, XCraftUtils.TimeUnit.MINUTES), 1,
                        false, false, false));
            }
            if (!player.hasEffect(MobEffects.DAMAGE_BOOST)) {
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, XCraftUtils.getTimeInTicks(1, XCraftUtils.TimeUnit.MINUTES), 1,
                        false, false, false));
            }
            if (!player.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, XCraftUtils.getTimeInTicks(1, XCraftUtils.TimeUnit.MINUTES), 1,
                        false, false, false));
            }
            if (!player.hasEffect(MobEffects.JUMP)) {
                player.addEffect(new MobEffectInstance(MobEffects.JUMP, XCraftUtils.getTimeInTicks(1, XCraftUtils.TimeUnit.MINUTES), 1,
                        false, false, false));
            }
        } else {
            if (player.hasEffect(MobEffects.MOVEMENT_SPEED)) {
                player.removeEffect(MobEffects.MOVEMENT_SPEED);
            }
            if (player.hasEffect(MobEffects.DAMAGE_BOOST)) {
                player.removeEffect(MobEffects.DAMAGE_BOOST);
            }
            if (player.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                player.removeEffect(MobEffects.DAMAGE_RESISTANCE);
            }
            if (player.hasEffect(MobEffects.JUMP)) {
                player.removeEffect(MobEffects.JUMP);
            }
        }
    }

    private static boolean isWearingFullSet(ItemStack helmet) {
        return helmet.getItem() instanceof beast;
    }
}