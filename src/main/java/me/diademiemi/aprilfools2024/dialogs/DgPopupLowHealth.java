package me.diademiemi.aprilfools2024.dialogs;

import me.diademiemi.aprilfools2024.AprilFools2024;
import me.diademiemi.aprilfools2024.player.TrackedPlayer;
import me.diademiemi.invuilib.menu.*;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.Map;


public class DgPopupLowHealth implements Dialog {

    @Override
    public Menu create(Player p, Object... args) {
        MenuBuilder builder = new MenuBuilder("HEY! LISTEN!", MenuSize.SIX_ROWS, p);


        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "It's dangerous to go alone, take this!"), 3, 1, true);

        builder.addButtonByColumnRow(new MenuButton(Material.POTION, 1,
                "Red Potion") {
            public void onLeftClick(Player p) {
                TrackedPlayer trackedPlayer = TrackedPlayer.getTrackedPlayer(p.getUniqueId());

                if (trackedPlayer != null) {
                    // If getFlagExists is false or getBoolFlag is false
                    if (!trackedPlayer.getBoolFlag("lowHealthComplete")) {
                        Potion potion = new Potion(PotionType.INSTANT_HEAL, 2);
                        ItemStack itemStack = potion.toItemStack(1);
                        ItemMeta itemMeta = itemStack.getItemMeta();
                        itemMeta.setDisplayName("Red Potion");
                        ArrayList<String> itemLore = new ArrayList<>();
                        itemLore.add("Queercraft April Fools 2024");
                        itemMeta.setLore(itemLore);
                        itemStack.setItemMeta(itemMeta);

                        final Map<Integer, ItemStack> itemsDidntFit = p.getInventory().addItem(itemStack);
                        for (final ItemStack item : itemsDidntFit.values()) {
                            p.getWorld().dropItemNaturally(p.getLocation(), item);
                        }

                        trackedPlayer.setBoolFlag("lowHealthComplete", true);
                    }
                    close(p);
                }
            }
        }, 3, 2, true);

        builder.addButtonByColumnRow(new MenuButton(Material.REDSTONE_BLOCK, 1, " "), 1, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.REDSTONE_BLOCK, 1, " "), 2, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.REDSTONE_BLOCK, 1, " "), 3, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.REDSTONE_BLOCK, 1, " "), 4, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.REDSTONE_BLOCK, 1, " "), 5, 5, true);


        // Close button
//        trackedPlayer.setBoolFlag("lowHealthComplete", true);

        // Outer decoration
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 0, 0, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 0, 1, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 0, 2, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 0, 3, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 0, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 0, 5, true);

        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 6, 0, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 6, 1, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 6, 2, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 6, 3, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 6, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 6, 5, true);

        // Prevent the player from force exiting the menu. its gotta be annoying!
        builder.setOnForceClose(() -> {
            AprilFools2024.getPlugin().getServer().getScheduler().runTaskLater(AprilFools2024.getPlugin(), () -> {
                new DgPopupLowHealth().show(p);
            }, 20);
        });

        return builder.build();
    }

}
