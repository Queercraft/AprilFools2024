package me.diademiemi.aprilfools2024.command;

import me.diademiemi.aprilfools2024.AprilFools2024;
import me.diademiemi.aprilfools2024.AprilFools2024IO;
import me.diademiemi.aprilfools2024.listener.RandomScheduler;
import me.diademiemi.aprilfools2024.dialogs.*;
import me.diademiemi.aprilfools2024.player.TrackedPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Very ugly CommandHandler with no tab completion.
 * I would've made this better but... honestly no i wouldn't have, it's just for an april fools joke
 * You think im putting EFFORT into this???
 */
public class CommandHandler implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("aprilfools2024.admin")) {
            if (args.length == 0) {
                sender.sendMessage("Usage: /aprilfools2024 unset/setbool/setstring/setint <player>");
                return true;
            }

            switch (args[0].toLowerCase()) {
                case "unset":
                    return unsetCommand(sender, args);
                case "setbool":
                    return setBoolCommand(sender, args);
                case "setstring":
                    return setStringCommand(sender, args);
                case "setint":
                    return setIntCommand(sender, args);
                case "get":
                    return getCommand(sender, args);
                case "clear":
                    return clearCommand(sender, args);
                case "save":
                    AprilFools2024IO.writeConfig();
                    sender.sendMessage("Data saved.");
                    return true;
                case "global":
                    RandomScheduler.showToAll();
                    return true;
                case "test":
                    return testCommand(sender, args);
                default:
                    sender.sendMessage("Unknown subcommand. Usage: /aprilfools2024 unset/set <player>");
                    return true;
            }
        } else {
            sender.sendMessage("You do not have permission to use this command.");
            return true;
        }

    }

    public boolean testCommand(CommandSender sender, String[] args) {
        if (args.length < 3) {
            sender.sendMessage("Usage: /aprilfools2024 test <player> <dialog>");
            return true;
        }

        // Get player by name or UUID (args[1]) here
        // If args[1] == all, get all players
        ArrayList<Player> players = new ArrayList<>();
        if (!Objects.equals(args[1], "*")) {
            Player player = null;

            try {
                player = AprilFools2024.getPlugin().getServer().getPlayer(args[1]);
            } catch (Exception e) {
                player = AprilFools2024.getPlugin().getServer().getPlayer(java.util.UUID.fromString(args[1]));
            }

            if (player == null) {
                sender.sendMessage("Player not found.");
                return true;
            }
            players.add(player);
        } else {
            players.addAll(AprilFools2024.getPlugin().getServer().getOnlinePlayers());
        }


        for (Player p : players) {
            switch (args[2].toLowerCase()) {
                case "firstjoin1":
                    new DgFirstJoin1().show(p);
                    break;
                case "firstjoin2":
                    new DgFirstJoin2().show(p);
                    break;
                case "firstjoin3":
                    new DgFirstJoin3().show(p);
                    break;
                case "firstjoin4":
                    new DgFirstJoin4().show(p);
                    break;
                case "firstjoin5":
                    new DgFirstJoin5().show(p);
                    break;
                case "firstjoin6":
                    new DgFirstJoin6().show(p);
                    break;
                case "firstjoin7":
                    new DgFirstJoin7().show(p);
                    break;
                case "firstjoin8":
                    new DgFirstJoin8().show(p);
                    break;
                case "globalcaptcha":
                    new DgGlobalCaptcha().show(p);
                    break;
                case "globalcelestialclock":
                    new DgGlobalCelestialClock().show(p);
                    break;
                case "globalglutenrelatedestablishment":
                    new DgGlobalGlutenRelatedEstablishment().show(p);
                    break;
                case "globalhassciencegonetoofar":
                    new DgGlobalHasScienceGoneTooFar().show(p);
                    break;
                case "globalhaveyouseenthisshark":
                    new DgGlobalHaveYouSeenThisShark().show(p);
                    break;
                case "globalmarblehacks":
                    new DgGlobalMarbleHacks().show(p);
                    break;
                case "globalmesothelioma":
                    new DgGlobalMesothelioma().show(p);
                    break;
                case "globalstriders":
                    new DgGlobalStriders().show(p);
                    break;
                case "globalvillagershatehim":
                    new DgGlobalVillagersHateHim().show(p);
                    break;
                case "firstjoinfail":
                    new DgFirstJoinFail().show(p);
                    break;
                case "popupblocksplaced":
                    new DgPopupBlocksPlaced().show(p);
                    break;
                case "popupcartographytable":
                    new DgPopupCartographyTable().show(p);
                    break;
                case "popupchatmessages":
                    new DgPopupChatMessages().show(p);
                    break;
                case "popupdistancebyboat":
                    new DgPopupDistanceByBoat().show(p);
                    break;
                case "popupdistanceflown":
                    new DgPopupDistanceFlown().show(p);
                    break;
                case "popupdistancewalked":
                    new DgPopupDistanceWalked().show(p);
                    break;
                case "popupjumps":
                    new DgPopupJumps().show(p);
                    break;
                case "popuplowhealth":
                    new DgPopupLowHealth().show(p);
                    break;
                case "popupmusicdiscs":
                    new DgPopupMusicDiscs().show(p);
                    break;
                case "popupredstoneplaced":
                    new DgPopupRedstonePlaced().show(p);
                    break;
                case "popuptimecrouched":
                    new DgPopupTimeCrouched().show(p);
                    break;
                case "popupwalkedonwater":
                    new DgPopupWalkedOnWater().show(p);
                    break;
                default:
                    sender.sendMessage("Unknown dialog.");
                    return true;
            }

        }

        return true;
    }

    public boolean clearCommand(CommandSender sender, String[] args) {
        if (args.length < 2) {
            sender.sendMessage("Usage: /aprilfools2024 clear <player>");
            return true;
        }

        // Get player by name or UUID (args[1]) here
        Player player = null;

        try {
            player = AprilFools2024.getPlugin().getServer().getPlayer(args[1]);
        } catch (Exception e) {
            player = AprilFools2024.getPlugin().getServer().getPlayer(java.util.UUID.fromString(args[1]));
        }

        if (player == null) {
            sender.sendMessage("Player not found.");
            return true;
        }

        // Clear the player's data
        TrackedPlayer trackedPlayer = TrackedPlayer.getTrackedPlayer(player.getUniqueId());

        if (trackedPlayer == null) {
            sender.sendMessage("Player not tracked.");
            return true;
        }

        trackedPlayer.clearData();

        sender.sendMessage("Data cleared for " + player.getName());
        return true;
    }

    // Example command: /aprilfools2024 unset <player> <flag>
    public boolean unsetCommand(CommandSender sender, String[] args) {
        if (args.length < 3) {
            sender.sendMessage("Usage: /aprilfools2024 unset <player> <flag>");
            return true;
        }

        // Get player by name or UUID (args[1]) here
        Player player = null;

        try {
            player = AprilFools2024.getPlugin().getServer().getPlayer(args[1]);
        } catch (Exception e) {
            player = AprilFools2024.getPlugin().getServer().getPlayer(java.util.UUID.fromString(args[1]));
        }

        if (player == null) {
            sender.sendMessage("Player not found.");
            return true;
        }

        // Unset the flag
        TrackedPlayer trackedPlayer = TrackedPlayer.getTrackedPlayer(player.getUniqueId());

        if (trackedPlayer == null) {
            sender.sendMessage("Player not tracked.");
            return true;
        }

        trackedPlayer.unsetFlag(args[2]);

        sender.sendMessage("Flag " + args[2] + " unset for " + player.getName());
        return true;
    }

    // Example command: /aprilfools2024 setbool <player> <flag> <value>
    public boolean setBoolCommand(CommandSender sender, String[] args) {
        if (args.length < 4) {
            sender.sendMessage("Usage: /aprilfools2024 setbool <player> <flag> <value>");
            return true;
        }

        // Get player by name or UUID (args[1]) here
        Player player = null;

        try {
            player = AprilFools2024.getPlugin().getServer().getPlayer(args[1]);
        } catch (Exception e) {
            player = AprilFools2024.getPlugin().getServer().getPlayer(java.util.UUID.fromString(args[1]));
        }

        if (player == null) {
            sender.sendMessage("Player not found.");
            return true;
        }

        // Set the flag
        TrackedPlayer trackedPlayer = TrackedPlayer.getTrackedPlayer(player.getUniqueId());

        if (trackedPlayer == null) {
            sender.sendMessage("Player not tracked.");
            return true;
        }

        trackedPlayer.setBoolFlag(args[2], Boolean.parseBoolean(args[3]));

        sender.sendMessage("Flag " + args[2] + " set to " + args[3] + " for " + player.getName());
        return true;
    }

    // Example command: /aprilfools2024 setstring <player> <flag> <value>
    public boolean setStringCommand(CommandSender sender, String[] args) {
        if (args.length < 4) {
            sender.sendMessage("Usage: /aprilfools2024 setstring <player> <flag> <value>");
            return true;
        }

        // Get player by name or UUID (args[1]) here
        Player player = null;

        try {
            player = AprilFools2024.getPlugin().getServer().getPlayer(args[1]);
        } catch (Exception e) {
            player = AprilFools2024.getPlugin().getServer().getPlayer(java.util.UUID.fromString(args[1]));
        }

        if (player == null) {
            sender.sendMessage("Player not found.");
            return true;
        }

        // Set the flag
        TrackedPlayer trackedPlayer = TrackedPlayer.getTrackedPlayer(player.getUniqueId());

        if (trackedPlayer == null) {
            sender.sendMessage("Player not tracked.");
            return true;
        }

        trackedPlayer.setStringFlag(args[2], args[3]);

        sender.sendMessage("Flag " + args[2] + " set to " + args[3] + " for " + player.getName());
        return true;
    }

    // Example command: /aprilfools2024 setint <player> <flag> <value>
    public boolean setIntCommand(CommandSender sender, String[] args) {
        if (args.length < 4) {
            sender.sendMessage("Usage: /aprilfools2024 setint <player> <flag> <value>");
            return true;
        }

        // Get player by name or UUID (args[1]) here
        Player player = null;

        try {
            player = AprilFools2024.getPlugin().getServer().getPlayer(args[1]);
        } catch (Exception e) {
            player = AprilFools2024.getPlugin().getServer().getPlayer(java.util.UUID.fromString(args[1]));
        }

        if (player == null) {
            sender.sendMessage("Player not found.");
            return true;
        }

        // Set the flag
        TrackedPlayer trackedPlayer = TrackedPlayer.getTrackedPlayer(player.getUniqueId());

        if (trackedPlayer == null) {
            sender.sendMessage("Player not tracked.");
            return true;
        }

        trackedPlayer.setIntFlag(args[2], Integer.parseInt(args[3]));

        sender.sendMessage("Flag " + args[2] + " set to " + args[3] + " for " + player.getName());
        return true;
    }

    // Example command: /aprilfools2024 get <player> <flag>
    public boolean getCommand(CommandSender sender, String[] args) {
        if (args.length < 3) {
            sender.sendMessage("Usage: /aprilfools2024 get <player> <flag>");
            return true;
        }

        // Get player by name or UUID (args[1]) here
        Player player = null;

        try {
            player = AprilFools2024.getPlugin().getServer().getPlayer(args[1]);
        } catch (Exception e) {
            player = AprilFools2024.getPlugin().getServer().getPlayer(java.util.UUID.fromString(args[1]));
        }

        if (player == null) {
            sender.sendMessage("Player not found.");
            return true;
        }

        // Get the flag
        TrackedPlayer trackedPlayer = TrackedPlayer.getTrackedPlayer(player.getUniqueId());

        if (trackedPlayer == null) {
            sender.sendMessage("Player not tracked.");
            return true;
        }

        if (!trackedPlayer.getFlagExists(args[2])) {
            sender.sendMessage("Flag " + args[2] + " does not exist for " + player.getName());
            return true;
        }

        if (trackedPlayer.getFlagExists(args[2])) {

        } else {
            sender.sendMessage("Flag " + args[2] + " does not exist for " + player.getName());
            return true;
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
