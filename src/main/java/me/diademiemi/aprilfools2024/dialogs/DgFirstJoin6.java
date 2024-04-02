package me.diademiemi.aprilfools2024.dialogs;

import me.diademiemi.aprilfools2024.AprilFools2024;
import me.diademiemi.invuilib.menu.*;
import org.bukkit.Material;
import org.bukkit.entity.Player;


public class DgFirstJoin6 implements Dialog {

    @Override
    public Menu create(Player p, Object... args) {
        MenuBuilder builder = new MenuBuilder("Confirm you're not a bot.", MenuSize.SIX_ROWS, p);

        // arg 1 is string
        if (args.length == 0) {
            args = new Object[]{""};
        }
        String captcha = (String) args[0];
        String goalString = "8008135";

        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "Please solve the CAPTCHA below.", "Click the numbers in order \"8008135\""), 2, 1, true);

        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "Currently entered:", captcha), 4, 1, true);
        builder.addButtonByColumnRow(new MenuButton(Material.RED_CONCRETE, 1, "7") {
            @Override
            public void onLeftClick(Player p) {
                if (goalString.startsWith(captcha + "7")) {
                    new DgFirstJoin6().show(p, captcha + "7");
                } else {
                    new DgFirstJoinFail().show(p);
                }

            }
        }, 2, 2, true);
        builder.addButtonByColumnRow(new MenuButton(Material.ORANGE_CONCRETE, 1, "8") {
            @Override
            public void onLeftClick(Player p) {
                if (goalString.startsWith(captcha + "8")) {
                    new DgFirstJoin6().show(p, captcha + "8");
                } else {
                    new DgFirstJoinFail().show(p);
                }
            }
        }, 3, 2, true);
        builder.addButtonByColumnRow(new MenuButton(Material.YELLOW_CONCRETE, 1, "9") {
            @Override
            public void onLeftClick(Player p) {
                if (goalString.startsWith(captcha + "9")) {
                    new DgFirstJoin6().show(p, captcha + "9");
                } else {
                    new DgFirstJoinFail().show(p);
                }
            }
        }, 4, 2, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIME_CONCRETE, 1, "4") {
            @Override
            public void onLeftClick(Player p) {
                if (goalString.startsWith(captcha + "4")) {
                    new DgFirstJoin6().show(p, captcha + "4");
                } else {
                    new DgFirstJoinFail().show(p);
                }
            }
        }, 2, 3, true);
        builder.addButtonByColumnRow(new MenuButton(Material.GREEN_CONCRETE, 1, "5") {
            @Override
            public void onLeftClick(Player p) {
                if (goalString.startsWith(captcha + "5")) {
                    if ((captcha + "5").equals("8008135")) {
                        new DgFirstJoin7().show(p);
                    } else {
                        new DgFirstJoinFail().show(p);
                    }
                } else {
                    new DgFirstJoinFail().show(p);
                }
            }
        }, 3, 3, true);
        builder.addButtonByColumnRow(new MenuButton(Material.CYAN_CONCRETE, 1, "6") {
            @Override
            public void onLeftClick(Player p) {
                if (goalString.startsWith(captcha + "6")) {
                    new DgFirstJoin6().show(p, captcha + "6");
                } else {
                    new DgFirstJoinFail().show(p);
                }
            }
        }, 4, 3, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_CONCRETE, 1, "1") {
            @Override
            public void onLeftClick(Player p) {
                if (goalString.startsWith(captcha + "1")) {
                    new DgFirstJoin6().show(p, captcha + "1");
                } else {
                    new DgFirstJoinFail().show(p);
                }
            }
        }, 2, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.BLUE_CONCRETE, 1, "2") {
            @Override
            public void onLeftClick(Player p) {
                if (goalString.startsWith(captcha + "2")) {
                    new DgFirstJoin6().show(p, captcha + "2");
                } else {
                    new DgFirstJoinFail().show(p);
                }
            }
        }, 3, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PURPLE_CONCRETE, 1, "3") {
            @Override
            public void onLeftClick(Player p) {
                if (goalString.startsWith(captcha + "3")) {
                    new DgFirstJoin6().show(p, captcha + "3");
                } else {
                    new DgFirstJoinFail().show(p);
                }
            }
        }, 4, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.MAGENTA_CONCRETE, 1, "0") {
            @Override
            public void onLeftClick(Player p) {
                if (goalString.startsWith(captcha + "0")) {
                    new DgFirstJoin6().show(p, captcha + "0");
                } else {
                    new DgFirstJoinFail().show(p);
                }
            }
        }, 3, 5, true);

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
                new DgFirstJoin6().show(p);
            }, 20);
        });

        return builder.build();
    }

}
