package me.diademiemi.aprilfools2024.dialogs;

import me.diademiemi.aprilfools2024.AprilFools2024;
import me.diademiemi.invuilib.menu.*;
import org.bukkit.Material;
import org.bukkit.entity.Player;


public class DgGlobalGlutenRelatedEstablishment implements Dialog {

    @Override
    public Menu create(Player p, Object... args) {
        MenuBuilder builder = new MenuBuilder("Enjoying Queercraft?", MenuSize.SIX_ROWS, p);


        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "You might also like..."), 3, 1, true);
        builder.addButtonByColumnRow(new MenuButton(Material.BREAD, 1,
                "Bakeries"), 2, 3, true);
        builder.addButtonByColumnRow(new MenuButton(Material.WHEAT, 1,
                "Markets"), 3, 3, true);
        builder.addButtonByColumnRow(new MenuButton(Material.GRASS_BLOCK, 1,
                "Bisexuals"), 4, 3, true);
        // Close button
        builder.addButtonByColumnRow(new MenuButton(Material.BARRIER, 1, "Close") {
            @Override
            public void onLeftClick(Player p) {
                close(p);
            }
        }, 6, 0, true);

        builder.addButtonByColumnRow(new MenuButton(Material.BREAD, 1, " "), 1, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.BREAD, 1, " "), 2, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.BREAD, 1, " "), 3, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.BREAD, 1, " "), 4, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.BREAD, 1, " "), 5, 5, true);

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
                new DgGlobalGlutenRelatedEstablishment().show(p);
            }, 20);
        });

        return builder.build();
    }

}
