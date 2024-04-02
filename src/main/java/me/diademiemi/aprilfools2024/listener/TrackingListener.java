package me.diademiemi.aprilfools2024.listener;

import com.google.gson.JsonElement;
import me.diademiemi.aprilfools2024.player.TrackedPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class TrackingListener implements Listener {

    /**
     * Track a player when they join the server and have the permission to be tracked
     * @param event
     */
    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Logic for tracking players

        // Get the player of the event
        Player player = event.getPlayer();

        // Check if the player should be tracked
        if (player.hasPermission("aprilfools2024.track")) {
            // Set temporary variable to null
            TrackedPlayer trackedPlayer = null;

            // Check if we already have data for this player
            if (TrackedPlayer.getTrackedPlayer(player.getUniqueId()) == null) {
                // If not, create a new TrackedPlayer object
                trackedPlayer = new TrackedPlayer(player.getUniqueId());
            } else {
                // If we do, get the existing TrackedPlayer object
                trackedPlayer = TrackedPlayer.getTrackedPlayer(player.getUniqueId());
            }

            // Because we know they're online, set the player object
            trackedPlayer.setOnlinePlayer();
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        // Attempt to get the TrackedPlayer object for the player
        TrackedPlayer trackedPlayer = TrackedPlayer.getTrackedPlayer(e.getPlayer().getUniqueId());
        // If not null
        if (trackedPlayer != null) {
            // Set the player object to null
            trackedPlayer.unsetOnlinePlayer();
        }
    }

}
