package me.diademiemi.aprilfools2024.dialogs;

import me.diademiemi.aprilfools2024.AprilFools2024;
import me.diademiemi.invuilib.menu.*;
import org.bukkit.Material;
import org.bukkit.entity.Player;


public class DgPopupDistanceFlown implements Dialog {

    @Override
    public Menu create(Player p, Object... args) {
        MenuBuilder builder = new MenuBuilder("Thank you for flying!", MenuSize.SIX_ROWS, p);


        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "Please rate your experience"), 3, 1, true);
        builder.addButtonByColumnRow(new MenuButton(Material.COAL, 1,
                "1 Star"), 1, 3, true);
        builder.addButtonByColumnRow(new MenuButton(Material.REDSTONE, 1,
                "2 Stars"), 2, 3, true);
        builder.addButtonByColumnRow(new MenuButton(Material.IRON_INGOT, 1,
                "3 Stars"), 3, 3, true);
        builder.addButtonByColumnRow(new MenuButton(Material.GOLD_INGOT, 1,
                "4 Stars"), 4, 3, true);
        builder.addButtonByColumnRow(new MenuButton(Material.DIAMOND, 1,
                "5 Stars") {
            @Override
            public void onLeftClick(Player p) {
                close(p);
            }

        }, 5, 3, true);
    
        // Close button
        builder.addButtonByColumnRow(new MenuButton(Material.BARRIER, 1, "Close") {
            @Override
            public void onLeftClick(Player p) {
                p.sendMessage("Error: You cannot close this menu. Please rate your experience.");
            }
        }, 6, 0, true);

        // Outer decoration
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 0, 0, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 0, 1, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 0, 2, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 0, 3, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 0, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 0, 5, true);

        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 6, 1, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 6, 2, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 6, 3, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 6, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 6, 5, true);

        // Prevent the player from force exiting the menu. its gotta be annoying!
        builder.setOnForceClose(() -> {
            AprilFools2024.getPlugin().getServer().getScheduler().runTaskLater(AprilFools2024.getPlugin(), () -> {
                new DgPopupDistanceFlown().show(p);
            }, 20);
        });

        return builder.build();
    }

}
