package me.diademiemi.aprilfools2024.dialogs;

import me.diademiemi.aprilfools2024.AprilFools2024;
import me.diademiemi.invuilib.menu.*;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.geysermc.geyser.api.GeyserApi;
import org.geysermc.geyser.api.connection.GeyserConnection;

import java.util.*;


/**
 * Fucking awful code but i dont give a shit, time crunch and its 5am
 */
public class DgGlobalCaptcha implements Dialog {

    public String generateRandomDigits(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10)); // Append a random digit (0-9)
        }
        return sb.toString();
    }
    @Override
    public Menu create(Player p, Object... args) {
        MenuBuilder builder = new MenuBuilder("Confirm you're not a bot.", MenuSize.SIX_ROWS, p);

        // arg 1 is string
        if (args.length == 0) {
            args = new Object[]{"", ""};
        }

        String captcha = (String) args[0];

        // Random 8 character string of numbers
        String goalStringTmp = args[1].toString();



        if (goalStringTmp.isEmpty()) {
            goalStringTmp = generateRandomDigits(15);
        }

        String goalString = goalStringTmp;

        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "Please solve the CAPTCHA below.", "Click the numbers in order " + goalString), 2, 1, true);

        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "Currently entered:", captcha), 4, 1, true);

        // Array of 7,8,9,4,5,6,1,2,3,0
        List<Integer> numbers = Arrays.asList(7, 8, 9, 4, 5, 6, 1, 2, 3, 0);


        GeyserConnection connection = GeyserApi.api().connectionByUuid(p.getUniqueId());

        if (captcha.length() >= 8 && connection == null) { // Ignore Bedrock edition players. They're suffering enough.
            // Shuffle the numbers
            Collections.shuffle(numbers);
        }

        builder.addButtonByColumnRow(new MenuButton(Material.RED_CONCRETE, 1, numbers.get(0).toString()) {
            @Override
            public void onLeftClick(Player p) {
                if (goalString.startsWith(captcha + numbers.get(0).toString())) {
                    if ((captcha + numbers.get(0).toString()).equals(goalString)) {
                        new DgGlobalCaptchaSuccess().show(p);
                    } else {
                        new DgGlobalCaptcha().show(p, captcha + numbers.get(0).toString(), goalString);
                    }
                } else {
                    new DgGlobalCaptchaFail().show(p);
                }
            }

        }, 2, 2, true);
        builder.addButtonByColumnRow(new MenuButton(Material.ORANGE_CONCRETE, 1, numbers.get(1).toString()) {
            @Override
            public void onLeftClick(Player p) {
                if (goalString.startsWith(captcha + numbers.get(1).toString())) {
                    if ((captcha + numbers.get(1).toString()).equals(goalString)) {
                        new DgGlobalCaptchaSuccess().show(p);
                    } else {
                        new DgGlobalCaptcha().show(p, captcha + numbers.get(1).toString(), goalString);
                    }
                } else {
                    new DgGlobalCaptchaFail().show(p);
                }
            }

        }, 3, 2, true);
        builder.addButtonByColumnRow(new MenuButton(Material.YELLOW_CONCRETE, 1, numbers.get(2).toString()) {
            @Override
            public void onLeftClick(Player p) {
                if (goalString.startsWith(captcha + numbers.get(2).toString())) {
                    if ((captcha + numbers.get(2).toString()).equals(goalString)) {
                        new DgGlobalCaptchaSuccess().show(p);
                    } else {
                        new DgGlobalCaptcha().show(p, captcha + numbers.get(2).toString(), goalString);
                    }
                } else {
                    new DgGlobalCaptchaFail().show(p);
                }
            }

        }, 4, 2, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIME_CONCRETE, 1, numbers.get(3).toString()) {
            @Override
            public void onLeftClick(Player p) {
                if (goalString.startsWith(captcha + numbers.get(3).toString())) {
                    if ((captcha + numbers.get(3).toString()).equals(goalString)) {
                        new DgGlobalCaptchaSuccess().show(p);
                    } else {
                        new DgGlobalCaptcha().show(p, captcha + numbers.get(3).toString(), goalString);
                    }
                } else {
                    new DgGlobalCaptchaFail().show(p);
                }
            }

        }, 2, 3, true);
        builder.addButtonByColumnRow(new MenuButton(Material.GREEN_CONCRETE, 1, numbers.get(4).toString()) {
            @Override
            public void onLeftClick(Player p) {
                if (goalString.startsWith(captcha + numbers.get(4).toString())) {
                    if ((captcha + numbers.get(4).toString()).equals(goalString)) {
                        new DgGlobalCaptchaSuccess().show(p);
                    } else {
                        new DgGlobalCaptcha().show(p, captcha + numbers.get(4).toString(), goalString);
                    }
                } else {
                    new DgGlobalCaptchaFail().show(p);
                }
            }

        }, 3, 3, true);
        builder.addButtonByColumnRow(new MenuButton(Material.CYAN_CONCRETE, 1, numbers.get(5).toString()) {
            @Override
            public void onLeftClick(Player p) {
                if (goalString.startsWith(captcha + numbers.get(5).toString())) {
                    if ((captcha + numbers.get(5).toString()).equals(goalString)) {
                        new DgGlobalCaptchaSuccess().show(p);
                    } else {
                        new DgGlobalCaptcha().show(p, captcha + numbers.get(5).toString(), goalString);
                    }
                } else {
                    new DgGlobalCaptchaFail().show(p);
                }
            }

        }, 4, 3, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_CONCRETE, 1, numbers.get(6).toString()) {
            @Override
            public void onLeftClick(Player p) {
                if (goalString.startsWith(captcha + numbers.get(6).toString())) {
                    if ((captcha + numbers.get(6).toString()).equals(goalString)) {
                        new DgGlobalCaptchaSuccess().show(p);
                    } else {
                        new DgGlobalCaptcha().show(p, captcha + numbers.get(6).toString(), goalString);
                    }
                } else {
                    new DgGlobalCaptchaFail().show(p);
                }
            }

        }, 2, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.BLUE_CONCRETE, 1, numbers.get(7).toString()) {
            @Override
            public void onLeftClick(Player p) {
                if (goalString.startsWith(captcha + numbers.get(7).toString())) {
                    if ((captcha + numbers.get(7).toString()).equals(goalString)) {
                        new DgGlobalCaptchaSuccess().show(p);
                    } else {
                        new DgGlobalCaptcha().show(p, captcha + numbers.get(7).toString(), goalString);
                    }
                } else {
                    new DgGlobalCaptchaFail().show(p);
                }
            }

        }, 3, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PURPLE_CONCRETE, 1, numbers.get(8).toString()) {
            @Override
            public void onLeftClick(Player p) {
                if (goalString.startsWith(captcha + numbers.get(8).toString())) {
                    if ((captcha + numbers.get(8).toString()).equals(goalString)) {
                        new DgGlobalCaptchaSuccess().show(p);
                    } else {
                        new DgGlobalCaptcha().show(p, captcha + numbers.get(8).toString(), goalString);
                    }
                } else {
                    new DgGlobalCaptchaFail().show(p);
                }
            }

        }, 4, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.MAGENTA_CONCRETE, 1, numbers.get(9).toString()) {
            @Override
            public void onLeftClick(Player p) {
                if (goalString.startsWith(captcha + numbers.get(9).toString())) {
                    if ((captcha + numbers.get(9).toString()).equals(goalString)) {
                        new DgGlobalCaptchaSuccess().show(p);
                    } else {
                        new DgGlobalCaptcha().show(p, captcha + numbers.get(9).toString(), goalString);
                    }
                } else {
                    new DgGlobalCaptchaFail().show(p);
                }
            }

        }, 3, 5, true);

        // Outer decoration
        builder.addButtonByColumnRow(new MenuButton(Material.PURPLE_STAINED_GLASS_PANE, 1, " "), 0, 0, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PURPLE_STAINED_GLASS_PANE, 1, " "), 0, 1, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PURPLE_STAINED_GLASS_PANE, 1, " "), 0, 2, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PURPLE_STAINED_GLASS_PANE, 1, " "), 0, 3, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PURPLE_STAINED_GLASS_PANE, 1, " "), 0, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PURPLE_STAINED_GLASS_PANE, 1, " "), 0, 5, true);

        builder.addButtonByColumnRow(new MenuButton(Material.PURPLE_STAINED_GLASS_PANE, 1, " "), 6, 0, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PURPLE_STAINED_GLASS_PANE, 1, " "), 6, 1, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PURPLE_STAINED_GLASS_PANE, 1, " "), 6, 2, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PURPLE_STAINED_GLASS_PANE, 1, " "), 6, 3, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PURPLE_STAINED_GLASS_PANE, 1, " "), 6, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PURPLE_STAINED_GLASS_PANE, 1, " "), 6, 5, true);

        // Prevent the player from force exiting the menu. its gotta be annoying!
        builder.setOnForceClose(() -> {
            AprilFools2024.getPlugin().getServer().getScheduler().runTaskLater(AprilFools2024.getPlugin(), () -> {
                new DgGlobalCaptcha().show(p);
            }, 20);
        });

        return builder.build();
    }

}
