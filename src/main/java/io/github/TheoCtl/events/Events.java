package io.github.TheoCtl.events;

import io.github.TheoCtl.armor.cyclops;
import io.github.TheoCtl.armor.wolverine;
import io.github.TheoCtl.armor.professorx;
import io.github.TheoCtl.armor.phoenix;
import io.github.TheoCtl.armor.iceman;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import org.jetbrains.annotations.NotNull;

public class Events {

    public static void onPlayerTickEventsPre(PlayerTickEvent.@NotNull Pre event) {
        Player player = event.getEntity();
        Level level = player.level();

        if (level.isClientSide()) {
            return;
        }

        if (level.getServer() == null) {
            return;
        }

        if (level.getServer().getTickCount() % 5 == 0) {
            wolverine.handleEffects(player);
            professorx.handleEffects(player);
            cyclops.handleEffects(player);
            phoenix.handleEffects(player);
            iceman.handleEffects(player);
        }
    }
}