package io.github.TheoCtl.armor;

import io.github.TheoCtl.init.ArmorMaterialInit;
import io.github.TheoCtl.utils.XCraftUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.extensions.IItemExtension;

public class cyclops extends ArmorItem implements IItemExtension {
    public cyclops(Type type, int durability) {
        super(ArmorMaterialInit.CYCLOPS, type, new Properties().durability(type.getDurability(durability)));
    }

    public static void handleEffects(Player player) {
        ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);

        if (isWearingFullSet(helmet)) {
            applyFireEffect(player);
            if (!player.hasEffect(MobEffects.FIRE_RESISTANCE)) {
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, XCraftUtils.getTimeInTicks(1, XCraftUtils.TimeUnit.MINUTES), 0,
                        false, false, false));
            }
        } else {
            if (player.hasEffect(MobEffects.FIRE_RESISTANCE)) {
                player.removeEffect(MobEffects.FIRE_RESISTANCE);
            }
        }
    }

    private static boolean isWearingFullSet(ItemStack helmet) {
        return helmet.getItem() instanceof cyclops;
    }

    // Method to apply fire to blocks and entities the player is looking at
    private static void applyFireEffect(Player player) {
        // Ray trace to find what the player is looking at (maximum distance: 20 blocks)
        HitResult hitResult = rayTrace(player, 50.0);

        if (hitResult != null) {
            // If the player is looking at a block, set the block on fire
            if (hitResult.getType() == HitResult.Type.BLOCK) {
                BlockHitResult blockHitResult = (BlockHitResult) hitResult;
                BlockPos blockPos = blockHitResult.getBlockPos();
                BlockPos firePos = blockPos.relative(blockHitResult.getDirection());

                // Only place fire if the target block is air (to avoid replacing existing blocks)
                if (player.level().getBlockState(firePos).isAir()) {
                    player.level().setBlock(firePos, Blocks.FIRE.defaultBlockState(), 11);
                }
            }

            // If the player is looking at an entity, set the entity on fire
            if (hitResult.getType() == HitResult.Type.ENTITY) {
                EntityHitResult entityHitResult = (EntityHitResult) hitResult;
                if (entityHitResult.getEntity() instanceof LivingEntity) {
                    LivingEntity entity = (LivingEntity) entityHitResult.getEntity();
                    entity.setRemainingFireTicks(100);  // Set the entity on fire for 5 seconds
                }
            }
        }
    }

    private static HitResult rayTrace(Player player, double distance) {
        Vec3 startVec = player.getEyePosition(1.0F);
        Vec3 lookVec = player.getViewVector(1.0F);
        Vec3 endVec = startVec.add(lookVec.x * distance, lookVec.y * distance, lookVec.z * distance);

        // Perform the ray trace for both blocks and entities
        return player.level().clip(new net.minecraft.world.level.ClipContext(startVec, endVec, net.minecraft.world.level.ClipContext.Block.COLLIDER, net.minecraft.world.level.ClipContext.Fluid.NONE, player));
    }
}