package me.diademiemi.aprilfools2024.dialogs;

import me.diademiemi.aprilfools2024.AprilFools2024;
import me.diademiemi.invuilib.menu.*;
import org.bukkit.Material;
import org.bukkit.entity.Player;


public class DgFirstJoin5 implements Dialog {

    @Override
    public Menu create(Player p, Object... args) {
        MenuBuilder builder = new MenuBuilder("Accept the EULA", MenuSize.SIX_ROWS, p);


        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "Please read and agree to our End User License Agreement to continue."), 3, 1, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "- Prism is a legal entity under intergalactic law operating",
                "from the planet Transsexual in the galaxy of Transylvania."), 1, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "- In the event of any legal claim, dispute, controversy,",
                "or other dumb bullshit, you agree not to sue us."), 2, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "- If you decide to sue us anyway, you may only pursue",
                "legal action in a Scottish court of law."), 3, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "- You agree not to use any skins depicting Bob the",
                "Builder or characters from the Bob the Builder Cinematic Universe.",
                "It upsets Beaupedia."), 4, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "- You agree that it's pronounced \"jif.\"",
                "(todo, remove before publication: Ryan, why is this here?)"), 5, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "- Alcohol is not allowed on Zoom unless it's Bud Light."), 3, 5, true);

        builder.addButtonByColumnRow(new MenuButton(Material.BARRIER, 1, "Deny EULA") {
            @Override
            public void onLeftClick(Player p) {
                new DgFirstJoinFail().show(p);
            }

        }, 2, 2, true);

        builder.addButtonByColumnRow(new MenuButton(Material.EMERALD_BLOCK, 1, "Accept EULA") {
            @Override
            public void onLeftClick(Player p) {
                new DgFirstJoin6().show(p, "");
            }

        }, 4, 2, true);

        // Outer decoration
        builder.addButtonByColumnRow(new MenuButton(Material.RED_STAINED_GLASS_PANE, 1, " "), 0, 0, true);
        builder.addButtonByColumnRow(new MenuButton(Material.ORANGE_STAINED_GLASS_PANE, 1, " "), 0, 1, true);
        builder.addButtonByColumnRow(new MenuButton(Material.YELLOW_STAINED_GLASS_PANE, 1, " "), 0, 2, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIME_STAINED_GLASS_PANE, 1, " "), 0, 3, true);
        builder.addButtonByColumnRow(new MenuButton(Material.BLUE_STAINED_GLASS_PANE, 1, " "), 0, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PURPLE_STAINED_GLASS_PANE, 1, " "), 0, 5, true);

        builder.addButtonByColumnRow(new MenuButton(Material.PURPLE_STAINED_GLASS_PANE, 1, " "), 6, 0, true);
        builder.addButtonByColumnRow(new MenuButton(Material.BLUE_STAINED_GLASS_PANE, 1, " "), 6, 1, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIME_STAINED_GLASS_PANE, 1, " "), 6, 2, true);
        builder.addButtonByColumnRow(new MenuButton(Material.YELLOW_STAINED_GLASS_PANE, 1, " "), 6, 3, true);
        builder.addButtonByColumnRow(new MenuButton(Material.ORANGE_STAINED_GLASS_PANE, 1, " "), 6, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.RED_STAINED_GLASS_PANE, 1, " "), 6, 5, true);

        // Prevent the player from closing the menu
        builder.setOnForceClose(() -> {
            AprilFools2024.getPlugin().getServer().getScheduler().runTaskLater(AprilFools2024.getPlugin(), () -> {
                new DgFirstJoin5().show(p);
            }, 20);
        });

        return builder.build();
    }

}
