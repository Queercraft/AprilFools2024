package me.diademiemi.aprilfools2024.dialogs;

import me.diademiemi.aprilfools2024.AprilFools2024;
import me.diademiemi.invuilib.menu.*;
import org.bukkit.Material;
import org.bukkit.entity.Player;


public class DgGlobalHasScienceGoneTooFar implements Dialog {

    @Override
    public Menu create(Player p, Object... args) {
        MenuBuilder builder = new MenuBuilder("HAS SCIENCE GONE TOO FAR?", MenuSize.SIX_ROWS, p);


        builder.addButtonByColumnRow(new MenuButton(Material.ITEM_FRAME, 1,
                "ERROR: You do not have the required resource pack to view this image"), 3, 1, true);

        // Close button
        builder.addButtonByColumnRow(new MenuButton(Material.BARRIER, 1, "Close") {
            @Override
            public void onLeftClick(Player p) {
                close(p);
            }
        }, 6, 0, true);

        builder.addButtonByColumnRow(new MenuButton(Material.DIAMOND_BLOCK, 1, " "), 1, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.EMERALD_BLOCK, 1, " "), 2, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.GOLD_BLOCK, 1, " "), 3, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.COAL_BLOCK, 1, " "), 4, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.IRON_BLOCK, 1, " "), 5, 5, true);

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
                new DgGlobalHasScienceGoneTooFar().show(p);
            }, 20);
        });

        return builder.build();
    }

}
