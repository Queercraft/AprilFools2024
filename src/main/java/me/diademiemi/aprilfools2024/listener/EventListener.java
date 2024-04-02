package me.diademiemi.aprilfools2024.listener;

import me.diademiemi.aprilfools2024.AprilFools2024;
import me.diademiemi.aprilfools2024.dialogs.*;
import me.diademiemi.aprilfools2024.player.TrackedPlayer;
import me.diademiemi.aprilfools2024.player.TrackedPlayerUtil;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;

public class EventListener implements Listener {

    /**
     * Event handler for when a player joins the server
     * Sets shit up for the fuckery we're bout to do!
     * @param event The event
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Attempt to get tracked player

        TrackedPlayer trackedPlayer = TrackedPlayer.getTrackedPlayer(event.getPlayer().getUniqueId());
        // If tracked player is not null
        if (trackedPlayer != null) {

            TrackedPlayerUtil.setFlags(trackedPlayer, event.getPlayer());

            // First join sequence
            // DgFirstJoin1
            if (!trackedPlayer.getBoolFlag("firstJoinComplete")) {
                // Show the first join dialog
                new DgFirstJoin1().show(event.getPlayer());
            }
        }

    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        // Return if the player is not in world "world" or not in gamemode survival
        if (!event.getPlayer().getWorld().getName().equals("world")) {
            return;
        }
        if (event.getPlayer().getGameMode() != org.bukkit.GameMode.SURVIVAL) {
            return;
        }


        TrackedPlayer trackedPlayer = TrackedPlayer.getTrackedPlayer(event.getPlayer());
        if (!trackedPlayer.getBoolFlag("blocksPlacedComplete")) {
            int current = trackedPlayer.getIntFlag("initBlocksPlaced");
            if (current + 1 == 64) {
                new DgPopupBlocksPlaced().show(event.getPlayer());
                trackedPlayer.setBoolFlag("blocksPlacedComplete", true);
            } else {
                trackedPlayer.setIntFlag("initBlocksPlaced", current + 1);
            }
        }
        if (!trackedPlayer.getBoolFlag("redstonePlacedComplete") && event.getBlock().getType() == Material.REDSTONE_WIRE) {
            new DgPopupRedstonePlaced().show(event.getPlayer());
            trackedPlayer.setBoolFlag("redstonePlacedComplete", true);
        }
    }

    @EventHandler
    public void onChatMessage(AsyncPlayerChatEvent event) {
        // Return if the player is not in world "world" or not in gamemode survival
        if (!event.getPlayer().getWorld().getName().equals("world")) {
            return;
        }
        if (event.getPlayer().getGameMode() != org.bukkit.GameMode.SURVIVAL) {
            return;
        }

        TrackedPlayer trackedPlayer = TrackedPlayer.getTrackedPlayer(event.getPlayer());
        if (trackedPlayer.getBoolFlag("chatMessagesComplete")) {
            return;
        }
        int current = trackedPlayer.getIntFlag("initChatMessages");
        if (current + 1 == 15) {
            // schedule this bcs we're on an async thread

            AprilFools2024.getPlugin().getServer().getScheduler().runTaskLater(AprilFools2024.getPlugin(), () -> {
                new DgPopupChatMessages().show(event.getPlayer());
            }, 1);
            trackedPlayer.setBoolFlag("chatMessagesComplete", true);
        } else {
            trackedPlayer.setIntFlag("initChatMessages", current + 1);
        }
    }

    @EventHandler
    // On player damage
    public void onPlayerDamage(org.bukkit.event.entity.EntityDamageEvent event) {
        // Return if the entity is not a player
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        // Return if the player is not in world "world" or not in gamemode survival
        if (!event.getEntity().getWorld().getName().equals("world")) {
            return;
        }
        if (((Player) event.getEntity()).getGameMode() != org.bukkit.GameMode.SURVIVAL) {
            return;
        }

        TrackedPlayer trackedPlayer = TrackedPlayer.getTrackedPlayer((Player) event.getEntity());
        if (trackedPlayer.getBoolFlag("lowHealthComplete")) {
            return;
        }
        if (((Player) event.getEntity()).getHealth() - event.getFinalDamage() <= 6) {
            new DgPopupLowHealth().show((Player) event.getEntity());
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        // Return if the player is not in world "world" or not in gamemode survival
        if (!event.getPlayer().getWorld().getName().equals("world")) {
            return;
        }
        if (event.getPlayer().getGameMode() != org.bukkit.GameMode.SURVIVAL) {
            return;
        }

        TrackedPlayer trackedPlayer = TrackedPlayer.getTrackedPlayer(event.getPlayer());

        if (trackedPlayer != null) {
            if (!trackedPlayer.getBoolFlag("distanceFlownComplete")) {
                if (event.getPlayer().getInventory().getChestplate() != null) {
                    if (event.getPlayer().getInventory().getChestplate().getType() == Material.ELYTRA) {
                        if (event.getPlayer().getStatistic(Statistic.FLY_ONE_CM) - trackedPlayer.getIntFlag("initDistanceFlown") >= 2000) {
                            new DgPopupDistanceFlown().show(event.getPlayer());
                            trackedPlayer.setBoolFlag("distanceFlownComplete", true);
                        }
                    }
                }
            }

            if (!trackedPlayer.getBoolFlag("distanceWalkedComplete")) {
                if (event.getPlayer().getStatistic(Statistic.WALK_ONE_CM) - trackedPlayer.getIntFlag("initDistanceWalked") >= 10000) {
                    new DgPopupDistanceWalked().show(event.getPlayer());
                    trackedPlayer.setBoolFlag("distanceWalkedComplete", true);
                }
            }

            if (!trackedPlayer.getBoolFlag("distanceByBoatComplete")) {
                if (event.getPlayer().getStatistic(Statistic.BOAT_ONE_CM) - trackedPlayer.getIntFlag("initDistanceByBoat") >= 1000) {
                    new DgPopupDistanceByBoat().show(event.getPlayer());
                    trackedPlayer.setBoolFlag("distanceByBoatComplete", true);
                }
            }

            if (!trackedPlayer.getBoolFlag("distanceWalkedOnWaterComplete")) {
                if (event.getPlayer().getStatistic(Statistic.WALK_ON_WATER_ONE_CM) - trackedPlayer.getIntFlag("initDistanceWalkedOnWater") >= 500) {
                    new DgPopupWalkedOnWater().show(event.getPlayer());
                }
            }

            if (!trackedPlayer.getBoolFlag("timeCrouchedComplete")) {
                if (event.getPlayer().isSneaking() && event.getPlayer().getStatistic(Statistic.SNEAK_TIME) - trackedPlayer.getIntFlag("initTimeCrouched") >= 100) {
                    new DgPopupTimeCrouched().show(event.getPlayer());
                }
            }

        }

    }


    /**
     * Event handler for when a player's statistics increment
     * HORRIBLY INEFFICIENT AND BULLSHIT. but its only for a day so idgaf.
     * @param event The event
     */
    @EventHandler
    public void onPlayerStatistic(PlayerStatisticIncrementEvent event) {
        // Return if the player is not in world "world" or not in gamemode survival
        if (!event.getPlayer().getWorld().getName().equals("world")) {
            return;
        }
        if (event.getPlayer().getGameMode() != org.bukkit.GameMode.SURVIVAL) {
            return;
        }
        if (event.getStatistic() == Statistic.JUMP) {
            TrackedPlayer trackedPlayer = TrackedPlayer.getTrackedPlayer(event.getPlayer());
            if (trackedPlayer != null) {
                if (!trackedPlayer.getBoolFlag("jumpsComplete")) {
                    if (event.getNewValue() - trackedPlayer.getIntFlag("initJumps") >= 75) {
                        new DgPopupJumps().show(event.getPlayer());
                        trackedPlayer.setBoolFlag("jumpsComplete", true);
                    }
                }
            }
        }
        if (event.getStatistic() == Statistic.INTERACT_WITH_CARTOGRAPHY_TABLE) {
            TrackedPlayer trackedPlayer = TrackedPlayer.getTrackedPlayer(event.getPlayer());
            if (trackedPlayer != null) {
                if (!trackedPlayer.getBoolFlag("timesUsedCartographyTableComplete")) {
                    if (event.getNewValue() - trackedPlayer.getIntFlag("initTimesUsedCartographyTable") >= 1) {
                        new DgPopupCartographyTable().show(event.getPlayer());
                    }
                }
            }
        }
        if (event.getStatistic() == Statistic.RECORD_PLAYED) {
            TrackedPlayer trackedPlayer = TrackedPlayer.getTrackedPlayer(event.getPlayer());
            if (trackedPlayer != null) {
                if (!trackedPlayer.getBoolFlag("musicDiscsComplete")) {
                    if (event.getNewValue() - trackedPlayer.getIntFlag("initMusicDiscsPlayed") >= 1) {
                        new DgPopupMusicDiscs().show(event.getPlayer());
                        trackedPlayer.setBoolFlag("musicDiscsComplete", true);
                    }
                }
            }
        }
    }

}
