package me.diademiemi.aprilfools2024.dialogs;

import me.diademiemi.aprilfools2024.AprilFools2024;
import me.diademiemi.invuilib.menu.*;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import me.diademiemi.invuilib.menu.MenuBuilder;
import org.geysermc.api.util.UiProfile;
import org.geysermc.geyser.api.GeyserApi;
import org.geysermc.geyser.api.connection.GeyserConnection;


public class DgFirstJoin1 implements Dialog {

    @Override
    public Menu create(Player p, Object... args) {
        MenuBuilder builder = new MenuBuilder("Welcome back to QC!", MenuSize.THREE_ROWS, p);

        // Set the text based on the player's platform
        GeyserConnection connection = GeyserApi.api().connectionByUuid(p.getUniqueId());

        String item3Text;
        String item4Text;

        if (connection == null) {
            // We can assume this is a Java player
            item3Text = "Hover over buttons to read them";
            item4Text = "Click this button to continue!";
        } else {
            // We can assume this is a Bedrock player
            item3Text = "Single tap buttons to read them";
            item4Text = "Double tap this button to continue!";
        }

        // Add info buttons
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1, "Hello! Welcome back to Queercraft"), 2, 0, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1, "Text will be shown in these pieces of paper"), 3, 0, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1, item3Text), 4, 0, true);

        // Add continue button
        builder.addButtonByColumnRow(new MenuButton(Material.EMERALD_BLOCK, 1, item4Text) {
            @Override
            public void onLeftClick(Player p) {
                new DgFirstJoin2().show(p);
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
                new DgFirstJoin1().show(p);
            }, 20);
        });

        return builder.build();
    }

}
