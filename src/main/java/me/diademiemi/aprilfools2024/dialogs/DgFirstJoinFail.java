package me.diademiemi.aprilfools2024.dialogs;

import me.diademiemi.aprilfools2024.AprilFools2024;
import me.diademiemi.invuilib.menu.*;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.geysermc.geyser.api.GeyserApi;
import org.geysermc.geyser.api.connection.GeyserConnection;


public class DgFirstJoinFail implements Dialog {

    @Override
    public Menu create(Player p, Object... args) {
        MenuBuilder builder = new MenuBuilder("I'm sorry...", MenuSize.THREE_ROWS, p);

        // Set the text based on the player's platform
        GeyserConnection connection = GeyserApi.api().connectionByUuid(p.getUniqueId());

        String item1Text;

        if (connection == null) {
            // We can assume this is a Java player
            item1Text = "Hover over buttons to read them. Click this button to retry!";
        } else {
            // We can assume this is a Bedrock player
            item1Text = "Single tap buttons to read them. Double tap this button to retry!";
        }

        // Add info buttons
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1, "I'm sorry, our systems have detected you are a bot", "Please try again to proceed."), 3, 0, true);

        // Add continue button
        builder.addButtonByColumnRow(new MenuButton(Material.MAGENTA_GLAZED_TERRACOTTA, 1, item1Text) {
            @Override
            public void onLeftClick(Player p) {
                new DgFirstJoin1().show(p);
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
                new DgFirstJoinFail().show(p);
            }, 20);
        });

        return builder.build();
    }

}
