package io.github.TheoCtl.armor;

import io.github.TheoCtl.init.ArmorMaterialInit;
import io.github.TheoCtl.utils.XCraftUtils;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.common.extensions.IItemExtension;

import java.util.List;

public class professorx extends ArmorItem implements IItemExtension {
    public professorx(Type type, int durability) {
        super(ArmorMaterialInit.PROFESSORX, type, new Properties().durability(type.getDurability(durability)));
    }

    public static void handleEffects(Player player) {
        ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);

        if (isWearingFullSet(helmet)) {
            double radius = 10.0; // Example: 10 blocks radius

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
                    entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 2)); // Apply Weakness for 5 seconds
                    entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 5));
                }
            }
        }
    }

    private static boolean isWearingFullSet(ItemStack helmet) {
        return helmet.getItem() instanceof professorx;
    }
}