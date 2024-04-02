package me.diademiemi.aprilfools2024.player;

import org.bukkit.Statistic;
import org.bukkit.entity.Player;

public class TrackedPlayerUtil {

    /**
     * This is fucking awful code but im on a time crunch rn
     * This sets the flags for the player when they first join / get cleared
     * @param trackedPlayer
     * @param player
     */
    public static void setFlags(TrackedPlayer trackedPlayer, Player player) {
        // Initialise player data

        // Jumps
        // DgPopupJumps
        // Inspo: music disc van halen jump
        if (!trackedPlayer.getFlagExists("initJumps")) {
            trackedPlayer.setIntFlag("initJumps", player.getStatistic(org.bukkit.Statistic.JUMP));
        }
        if (!trackedPlayer.getFlagExists("jumpsComplete")) {
            trackedPlayer.setBoolFlag("jumpsComplete", false);
        }

        // Distance flown
        // DgPopupDistanceFlown
        // Inspo: Get your flight insurance today!
        if (!trackedPlayer.getFlagExists("initDistanceFlown")) {
            trackedPlayer.setIntFlag("initDistanceFlown", player.getStatistic(org.bukkit.Statistic.FLY_ONE_CM));
        }
        if (!trackedPlayer.getFlagExists("distanceFlownComplete")) {
            trackedPlayer.setBoolFlag("distanceFlownComplete", false);
        }

        // Time crouched
        // DgPopupTimeCrouched
        // Inspo: Need a cardboard box, solid snake?
        if (!trackedPlayer.getFlagExists("initTimeCrouched")) {
            trackedPlayer.setIntFlag("initTimeCrouched", player.getStatistic(Statistic.SNEAK_TIME));
        }
        if (!trackedPlayer.getFlagExists("timeCrouchedComplete")) {
            trackedPlayer.setBoolFlag("timeCrouchedComplete", false);
        }

        // Distance walked
        // DgPopupDistanceWalked
        // Inspo: Walking cane for sale
        if (!trackedPlayer.getFlagExists("initDistanceWalked")) {
            trackedPlayer.setIntFlag("initDistanceWalked", player.getStatistic(org.bukkit.Statistic.WALK_ONE_CM));
        }
        if (!trackedPlayer.getFlagExists("distanceWalkedComplete")) {
            trackedPlayer.setBoolFlag("distanceWalkedComplete", false);
        }

        // Distance by boat
        // DgPopupDistanceByBoat
        // Inspo:
        if (!trackedPlayer.getFlagExists("initDistanceByBoat")) {
            trackedPlayer.setIntFlag("initDistanceByBoat", player.getStatistic(org.bukkit.Statistic.BOAT_ONE_CM));
        }
        if (!trackedPlayer.getFlagExists("distanceByBoatComplete")) {
            trackedPlayer.setBoolFlag("distanceByBoatComplete", false);
        }

        // Distance walked on water
        // DgPopupWalkedOnWater
        // Inspo: ROMANS HATE HIM: Learn how one man learned how to walk on water with one easy trick!
        if (!trackedPlayer.getFlagExists("initDistanceWalkedOnWater")) {
            trackedPlayer.setIntFlag("initDistanceWalkedOnWater", player.getStatistic(org.bukkit.Statistic.WALK_ON_WATER_ONE_CM));
        }
        if (!trackedPlayer.getFlagExists("distanceWalkedOnWaterComplete")) {
            trackedPlayer.setBoolFlag("distanceWalkedOnWaterComplete", false);
        }

        // Times used cartography table
        // DgPopupCartographyTable
        // Inspo: Lost? Try Queercraft Maps today!
        if (!trackedPlayer.getFlagExists("initTimesUsedCartographyTable")) {
            trackedPlayer.setIntFlag("initTimesUsedCartographyTable", player.getStatistic(Statistic.INTERACT_WITH_CARTOGRAPHY_TABLE));
        }
        if (!trackedPlayer.getFlagExists("timesUsedCartographyTableComplete")) {
            trackedPlayer.setBoolFlag("timesUsedCartographyTableComplete", false);
        }

        // Music discs played
        // DgPopupMusicDiscs
        // Inspo: AD: www.queercraft.net/radio, the old-fashioned way!
        if (!trackedPlayer.getFlagExists("initMusicDiscsPlayed")) {
            trackedPlayer.setIntFlag("initMusicDiscsPlayed", player.getStatistic(Statistic.RECORD_PLAYED));
        }
        if (!trackedPlayer.getFlagExists("musicDiscsComplete")) {
            trackedPlayer.setBoolFlag("musicDiscsComplete", false);
        }

        // The following ones don't use statistics, these are tracked via events

        // Blocks placed
        // DgPopupBlocksPlaced
        // Inspo: oi, your block license has ran out. renew it for M0.00.
        if (!trackedPlayer.getFlagExists("initBlocksPlaced")) {
            trackedPlayer.setIntFlag("initBlocksPlaced", 0);
        }
        if (!trackedPlayer.getFlagExists("blocksPlacedComplete")) {
            trackedPlayer.setBoolFlag("blocksPlacedComplete", false);
        }

        // Getting down to 3 hearts
        // DgPopupLowHealth
        // Inspo: Get Queercraft health insurance
        if (!trackedPlayer.getFlagExists("lowHealthComplete")) {
            trackedPlayer.setBoolFlag("lowHealthComplete", false);
        }

        // After 15 messages in chat
        // DgPopupChatMessages
        // Inspo: Get LGBTQ+ for the full Queercraft experience
        if (!trackedPlayer.getFlagExists("initChatMessages")) {
            trackedPlayer.setIntFlag("initChatMessages", 0);
        }
        if (!trackedPlayer.getFlagExists("chatMessagesComplete")) {
            trackedPlayer.setBoolFlag("chatMessagesComplete", false);
        }

        // After placing down redstone
        // DgPopupRedstonePlaced
        // Inspo: Get your "Redstone for dummies" book today
        if (!trackedPlayer.getFlagExists("redstonePlacedComplete")) {
            trackedPlayer.setBoolFlag("redstonePlacedComplete", false);
        }
    }
}
