package me.diademiemi.aprilfools2024.dialogs;

import me.diademiemi.aprilfools2024.AprilFools2024;
import me.diademiemi.invuilib.menu.*;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.checkerframework.common.returnsreceiver.qual.This;


public class DgFirstJoin4 implements Dialog {

    @Override
    public Menu create(Player p, Object... args) {
        MenuBuilder builder = new MenuBuilder("Accept the Privacy Policy", MenuSize.SIX_ROWS, p);


        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "We care about your privacy!",
                "Please read the Privacy Policy located below before proceeding."), 3, 1, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "- All of your data are belong to us."), 1, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "- In rare circumstances, select members of our tech team,",
                "may be able to see your private messages in server logs.",
                "This is not fair for the rest of us, so please ensure any",
                "roleplay is kept in main chat for public critique."), 2, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "- If you make a typo in the chat, it will be permanently immortalized via the",
                "QC Chat bot on our Discord server for people to laugh at.",
                "Better be careful with \"flag.\" It's happened before."), 3, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "- Train A is traveling at 60 mph and Train B is traveling 80 mph.",
                "Train A passes a station at 9:10 pm. If Train B passes the same station at 9:25 pm,",
                "at what time will Train B catch up to train A?."), 4, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "- We know about that really, really embarrassing thing you did",
                "in middle school that keeps you up at night.",
                "We won't tell anyone, promise."), 5, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "- We reserve the right to do things we won't tell you about,",
                "because in a privacy policy all about you, we were feeling left out."), 2, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "- There's nothing to worry about if you have nothing to hide.",
                "Except for the state of Ohio. We are very worried about Ohio."), 3, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "- In the event of a GDPR takeout request, your personal information will be given",
                "in the form of in-game books."), 4, 5, true);

        builder.addButtonByColumnRow(new MenuButton(Material.BARRIER, 1, "Deny Privacy Policy") {
            @Override
            public void onLeftClick(Player p) {
                new DgFirstJoinFail().show(p);
            }

        }, 2, 2, true);

        builder.addButtonByColumnRow(new MenuButton(Material.EMERALD_BLOCK, 1, "Accept Privacy Policy") {
            @Override
            public void onLeftClick(Player p) {
                new DgFirstJoin5().show(p);
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
                new DgFirstJoin4().show(p);
            }, 20);
        });

        return builder.build();
    }

}
