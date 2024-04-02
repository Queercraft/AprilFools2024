package me.diademiemi.aprilfools2024.dialogs;

import me.diademiemi.aprilfools2024.AprilFools2024;
import me.diademiemi.invuilib.menu.*;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.geysermc.geyser.api.GeyserApi;
import org.geysermc.geyser.api.connection.GeyserConnection;


public class DgGlobalCaptchaFail implements Dialog {

    @Override
    public Menu create(Player p, Object... args) {
        MenuBuilder builder = new MenuBuilder("I'm sorry...", MenuSize.THREE_ROWS, p);

        // Add info buttons
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1, "I'm sorry, our systems have detected you are a bot", "Please try again to proceed."), 3, 0, true);

        // Add continue button
        builder.addButtonByColumnRow(new MenuButton(Material.MAGENTA_GLAZED_TERRACOTTA, 1, "Try again") {
            @Override
            public void onLeftClick(Player p) {
                new DgGlobalCaptcha().show(p);
            }

        }, 3, 1, true);

        // Outer decoration
        builder.addButtonByColumnRow(new MenuButton(Material.RED_STAINED_GLASS_PANE, 1, " "), 0, 0, true);
        builder.addButtonByColumnRow(new MenuButton(Material.RED_STAINED_GLASS_PANE, 1, " "), 0, 1, true);
        builder.addButtonByColumnRow(new MenuButton(Material.RED_STAINED_GLASS_PANE, 1, " "), 0, 2, true);
        builder.addButtonByColumnRow(new MenuButton(Material.RED_STAINED_GLASS_PANE, 1, " "), 6, 0, true);
        builder.addButtonByColumnRow(new MenuButton(Material.RED_STAINED_GLASS_PANE, 1, " "), 6, 1, true);
        builder.addButtonByColumnRow(new MenuButton(Material.RED_STAINED_GLASS_PANE, 1, " "), 6, 2, true);

        // Prevent the player from closing the menu
        builder.setOnForceClose(() -> {
            AprilFools2024.getPlugin().getServer().getScheduler().runTaskLater(AprilFools2024.getPlugin(), () -> {
                new DgGlobalCaptchaFail().show(p);
            }, 20);
        });

        return builder.build();
    }

}
