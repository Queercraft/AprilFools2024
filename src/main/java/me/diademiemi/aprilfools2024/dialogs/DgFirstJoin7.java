package me.diademiemi.aprilfools2024.dialogs;

import me.diademiemi.aprilfools2024.AprilFools2024;
import me.diademiemi.aprilfools2024.player.TrackedPlayer;
import me.diademiemi.invuilib.menu.*;
import org.bukkit.Material;
import org.bukkit.entity.Player;


public class DgFirstJoin7 implements Dialog {

    @Override
    public Menu create(Player p, Object... args) {
        MenuBuilder builder = new MenuBuilder("Thank you!", MenuSize.THREE_ROWS, p);


        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "You've proven you're a human!", "You can now play on Queercraft!"), 3, 0, true);
        builder.addButtonByColumnRow(new MenuButton(Material.DIAMOND_BLOCK, 1, "Play on the server!") {
            @Override
            public void onLeftClick(Player p) {
                close(p);
                TrackedPlayer trackedPlayer = TrackedPlayer.getTrackedPlayer(p.getUniqueId());
                trackedPlayer.setBoolFlag("firstJoinComplete", true);
                AprilFools2024.getPlugin().getServer().getScheduler().runTaskLater(AprilFools2024.getPlugin(), () -> {
                    new DgFirstJoin8().show(p);
                }, 600);
            }

        }, 3, 1, true);

        // Outer decoration
        builder.addButtonByColumnRow(new MenuButton(Material.RED_STAINED_GLASS_PANE, 1, " "), 0, 0, true);
        builder.addButtonByColumnRow(new MenuButton(Material.ORANGE_STAINED_GLASS_PANE, 1, " "), 0, 1, true);
        builder.addButtonByColumnRow(new MenuButton(Material.YELLOW_STAINED_GLASS_PANE, 1, " "), 0, 2, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIME_STAINED_GLASS_PANE, 1, " "), 6, 0, true);
        builder.addButtonByColumnRow(new MenuButton(Material.BLUE_STAINED_GLASS_PANE, 1, " "), 6, 1, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PURPLE_STAINED_GLASS_PANE, 1, " "), 6, 2, true);

        // Prevent the player from closing the menu
        builder.setOnForceClose(() -> {
            AprilFools2024.getPlugin().getServer().getScheduler().runTaskLater(AprilFools2024.getPlugin(), () -> {
                new DgFirstJoin7().show(p);
            }, 20);
        });

        return builder.build();
    }

}
