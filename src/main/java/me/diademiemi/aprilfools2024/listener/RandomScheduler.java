package me.diademiemi.aprilfools2024.listener;

import me.diademiemi.aprilfools2024.AprilFools2024;
import me.diademiemi.aprilfools2024.dialogs.*;
import me.diademiemi.aprilfools2024.player.TrackedPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class RandomScheduler {

    /**
     * Schedule a random global dialogue every randomly between 10 and 30 minutes
     * This method will call itself after the random delay so it will loop indefinitely
     */
    public static void scheduleRandom() {
        // Schedule a random global dialogue every randomly between 10 and 30 minutes
        int tickDelay = 20 * 60 * (10 + new Random().nextInt(20));
        AprilFools2024.getPlugin().getServer().getLogger().info("[APRILFOOLS2024] Next global in " + tickDelay + " ticks");

        Bukkit.getScheduler().runTaskLater(AprilFools2024.getPlugin(), RandomScheduler::showToAll, tickDelay);
        Bukkit.getScheduler().runTaskLater(AprilFools2024.getPlugin(), RandomScheduler::scheduleRandom, tickDelay); // Loop

    }

    /**
     * Show a random global dialogue to all online players
     */
    public static void showToAll() {

        ArrayList<Player> players = new ArrayList<>(Bukkit.getOnlinePlayers());

        List<Consumer<Player>> globals = Arrays.asList(
                player -> new DgGlobalCaptcha().show(player),
                player -> new DgGlobalCelestialClock().show(player),
                player -> new DgGlobalGlutenRelatedEstablishment().show(player),
                player -> new DgGlobalHasScienceGoneTooFar().show(player),
                player -> new DgGlobalHaveYouSeenThisShark().show(player),
                player -> new DgGlobalMarbleHacks().show(player),
                player -> new DgGlobalMesothelioma().show(player),
                player -> new DgGlobalStriders().show(player),
                player -> new DgGlobalVillagersHateHim().show(player)
        );

        // Select a random dialogue once
        Consumer<Player> selectedGlobal = globals.get(new Random().nextInt(globals.size()));

        AprilFools2024.getPlugin().getServer().getLogger().info("[APRILFOOLS2024] Showing global to all players: " + selectedGlobal.toString());

        // Show the same dialogue to all players in the list
        for (Player player : players) {
            TrackedPlayer trackedPlayer = TrackedPlayer.getTrackedPlayer(player.getUniqueId());

            if (trackedPlayer == null) {
                continue;
            }
            selectedGlobal.accept(player);
        }

    }

}
