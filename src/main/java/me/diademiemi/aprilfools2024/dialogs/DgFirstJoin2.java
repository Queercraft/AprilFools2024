package me.diademiemi.aprilfools2024.dialogs;

import me.diademiemi.aprilfools2024.AprilFools2024;
import me.diademiemi.aprilfools2024.player.TrackedPlayer;
import me.diademiemi.invuilib.menu.*;
import me.diademiemi.invuilib.menu.MenuBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Map;


public class DgFirstJoin2 implements Dialog {

    @Override
    public Menu create(Player p, Object... args) {
        MenuBuilder builder = new MenuBuilder("Please accept our cookies!", MenuSize.THREE_ROWS, p);

        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "By clicking “Accept cookies”, you agree Queercraft can store cookies",
                "on your device in accordance with our Cookie Policy."), 3, 0, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "Cookies are stored locally in your inventory. These allow us to track logins into the server.",
                "Our services include \"Third-Party Cookies\" for advertising purposes.",
                "Of course, you can also just eat the cookies."), 3, 2, true);

        builder.addButtonByColumnRow(new MenuButton(Material.BARRIER, 1, "Deny cookies") {
            @Override
            public void onLeftClick(Player p) {
                new DgFirstJoinFail().show(p);
            }

        }, 2, 1, true);

        builder.addButtonByColumnRow(new MenuButton(Material.COOKIE, 16, "Accept cookies") {
            @Override
            public void onLeftClick(Player p) {
                TrackedPlayer trackedPlayer = TrackedPlayer.getTrackedPlayer(p.getUniqueId());

                if (trackedPlayer != null) {
                    // If getFlagExists is false or getBoolFlag is false
                    if (!trackedPlayer.getBoolFlag("firstJoinCookies")) {
                        ItemStack cookiesItemStack = new ItemStack(Material.COOKIE, 16);
                        ItemMeta cookiesItemMeta = cookiesItemStack.getItemMeta();
                        cookiesItemMeta.setDisplayName("Cookies");
                        ArrayList<String> cookiesItemLore = new ArrayList<>();
                        cookiesItemLore.add("Queercraft April Fools 2024");
                        cookiesItemMeta.setLore(cookiesItemLore);
                        cookiesItemStack.setItemMeta(cookiesItemMeta);

                        final Map<Integer, ItemStack> cookiesDidntFit = p.getInventory().addItem(cookiesItemStack);
                        for (final ItemStack item : cookiesDidntFit.values()) {
                            p.getWorld().dropItemNaturally(p.getLocation(), item);
                        }

                        trackedPlayer.setBoolFlag("firstJoinCookies", true);
                    }
                }


                new DgFirstJoin3().show(p);
            }

        }, 4, 1, true);

        // Outer decoration
        builder.addButtonByColumnRow(new MenuButton(Material.RED_STAINED_GLASS_PANE, 1, " "), 0, 0, true);
        builder.addButtonByColumnRow(new MenuButton(Material.ORANGE_STAINED_GLASS_PANE, 1, " "), 0, 1, true);
        builder.addButtonByColumnRow(new MenuButton(Material.YELLOW_STAINED_GLASS_PANE, 1, " "), 0, 2, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIME_STAINED_GLASS_PANE, 1, " "), 6, 0, true);
        builder.addButtonByColumnRow(new MenuButton(Material.BLUE_STAINED_GLASS_PANE, 1, " "), 6, 1, true);
        builder.addButtonByColumnRow(new MenuButton(Material.PURPLE_STAINED_GLASS_PANE, 1, " "), 6, 2, true);

        // Prevent the player from closing the menu
        builder.setOnForceClose(() -> {
            AprilFools2024.getPlugin().getServer().getScheduler().runTaskLater(AprilFools2024.getPlugin(), () -> {
                new DgFirstJoin2().show(p);
            }, 20);
        });

        return builder.build();
    }

}
