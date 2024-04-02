package me.diademiemi.aprilfools2024.dialogs;

import me.diademiemi.aprilfools2024.AprilFools2024;
import me.diademiemi.aprilfools2024.player.TrackedPlayer;
import me.diademiemi.invuilib.menu.*;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Map;


public class DgPopupWalkedOnWater implements Dialog {

    @Override
    public Menu create(Player p, Object... args) {
        MenuBuilder builder = new MenuBuilder("ROMANS HATE HIM", MenuSize.SIX_ROWS, p);


        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "Learn how one man learned how to walk on water with one easy trick!"), 3, 1, true);

        builder.addButtonByColumnRow(new MenuButton(Material.LEATHER_BOOTS, 1, "Sandals") {
            @Override
            public void onLeftClick(Player p) {
                TrackedPlayer trackedPlayer = TrackedPlayer.getTrackedPlayer(p.getUniqueId());

                if (trackedPlayer != null) {
                    // If getFlagExists is false or getBoolFlag is false
                    if (!trackedPlayer.getBoolFlag("distanceWalkedOnWaterComplete")) {
                        ItemStack itemStack = new ItemStack(Material.LEATHER_BOOTS);
                        ItemMeta itemMeta = itemStack.getItemMeta();
                        itemMeta.setDisplayName("Sandals");
                        itemMeta.addEnchant(Enchantment.FROST_WALKER, 2, true);
                        itemMeta.addEnchant(Enchantment.DURABILITY, 3, true);

                        ArrayList<String> itemLore = new ArrayList<>();
                        itemLore.add("Queercraft April Fools 2024");
                        itemMeta.setLore(itemLore);
                        itemStack.setItemMeta(itemMeta);

                        final Map<Integer, ItemStack> itemsDidntFit = p.getInventory().addItem(itemStack);
                        for (final ItemStack item : itemsDidntFit.values()) {
                            p.getWorld().dropItemNaturally(p.getLocation(), item);
                        }

                        trackedPlayer.setBoolFlag("distanceWalkedOnWaterComplete", true);
                    }
                    close(p);
                }
            }
        }, 3, 3, true);

        builder.addButtonByColumnRow(new MenuButton(Material.WATER_BUCKET, 1, " "), 1, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.WATER_BUCKET, 1, " "), 2, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.WATER_BUCKET, 1, " "), 3, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.WATER_BUCKET, 1, " "), 4, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.WATER_BUCKET, 1, " "), 5, 5, true);


        // Close button
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
                new DgPopupWalkedOnWater().show(p);
            }, 20);
        });

        return builder.build();
    }

}
