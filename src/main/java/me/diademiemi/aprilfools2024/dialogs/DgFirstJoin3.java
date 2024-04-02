package me.diademiemi.aprilfools2024.dialogs;

import me.diademiemi.aprilfools2024.AprilFools2024;
import me.diademiemi.invuilib.menu.*;
import org.bukkit.Material;
import org.bukkit.entity.Player;


public class DgFirstJoin3 implements Dialog {

    @Override
    public Menu create(Player p, Object... args) {
        MenuBuilder builder = new MenuBuilder("Accept the Terms of Service", MenuSize.SIX_ROWS, p);


        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "Please read and accept our Terms of Service located below before proceeding."), 3, 1, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "- You must be at least 13 years old or have written permission from your cat.",
                "Dogs are prohibited."), 1, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "- The first rule of Queercraft is is you do not-- wait, too late for that one."), 2, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "- It's \"Queercraft\", not \"QueerCraft\".",
                "Except when you're trying to annoy Beau. Then it's always QueerCraft."), 3, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "- You waive your right to be heterosexual. Them's the breaks, kid."), 4, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "- Queercraft does not assume liability for any revelations regarding gender identity.",
                "Besides, if you wanna make an omelet, you gotta crack a few eggs."), 5, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "- The #memes channel on Discord is strictly reserved for genuine,",
                "deep conversation about real-world news and politics with your peers.",
                "Please do not clutter the channel with shitposts."), 1, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "- The #news-politics-activism channel on Discord is strictly reserved for shitposting."), 2, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "- You will attend /warp radio at 8 PM ET on Saturday nights to listen to Queercraft Live."), 3, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "- Griefing is forbidden, except for Satanic Temples, because we love Jesus."), 4, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "- In the event of staff misconduct, inform twitter.com immediately."), 5, 5, true);

        builder.addButtonByColumnRow(new MenuButton(Material.BARRIER, 1, "Deny Terms of Service") {
            @Override
            public void onLeftClick(Player p) {
                new DgFirstJoinFail().show(p);
            }

        }, 2, 2, true);

        builder.addButtonByColumnRow(new MenuButton(Material.EMERALD_BLOCK, 1, "Accept Terms of Service") {
            @Override
            public void onLeftClick(Player p) {
                new DgFirstJoin4().show(p);
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
                new DgFirstJoin3().show(p);
            }, 20);
        });

        return builder.build();
    }

}
