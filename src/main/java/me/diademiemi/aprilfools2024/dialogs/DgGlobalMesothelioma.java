package me.diademiemi.aprilfools2024.dialogs;

import me.diademiemi.aprilfools2024.AprilFools2024;
import me.diademiemi.invuilib.menu.*;
import org.bukkit.Material;
import org.bukkit.entity.Player;


public class DgGlobalMesothelioma implements Dialog {

    @Override
    public Menu create(Player p, Object... args) {
        MenuBuilder builder = new MenuBuilder("Mesothelioma", MenuSize.SIX_ROWS, p);


        builder.addButtonByColumnRow(new MenuButton(Material.BLAZE_ROD, 1,
                "Attention: If you or a loved one has been diagnosed with Mesothelioma you may to be entitled to financial compensation.",
                "Mesothelioma is a rare cancer linked to asbestos exposure.",
                "Exposure to asbestos in shipyards, mills, heating, construction, or the automotive industries may put you at risk."), 3, 1, true);

        // Close button
        builder.addButtonByColumnRow(new MenuButton(Material.BARRIER, 1, "Close") {
            @Override
            public void onLeftClick(Player p) {
                close(p);
            }
        }, 6, 0, true);

        builder.addButtonByColumnRow(new MenuButton(Material.POTION, 1, " "), 1, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.NETHER_WART, 1, " "), 2, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.NETHER_WART, 1, " "), 3, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.NETHER_WART, 1, " "), 4, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.POTION, 1, " "), 5, 5, true);

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
                new DgGlobalMesothelioma().show(p);
            }, 20);
        });

        return builder.build();
    }

}
