package me.diademiemi.aprilfools2024.dialogs;

import me.diademiemi.aprilfools2024.AprilFools2024;
import me.diademiemi.aprilfools2024.player.TrackedPlayer;
import me.diademiemi.invuilib.menu.*;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.Map;


public class DgPopupCartographyTable implements Dialog {

    @Override
    public Menu create(Player p, Object... args) {
        MenuBuilder builder = new MenuBuilder("Are you lost?", MenuSize.SIX_ROWS, p);

        // Close button

        builder.addButtonByColumnRow(new MenuButton(Material.MAP, 1,
                "Get Queercraft Maps today at https://www.queercraft.net/map/") {
            public void onLeftClick(Player p) {
                TrackedPlayer trackedPlayer = TrackedPlayer.getTrackedPlayer(p.getUniqueId());

                if (trackedPlayer != null) {
                    // If getFlagExists is false or getBoolFlag is false
                    if (!trackedPlayer.getBoolFlag("timesUsedCartographyTableComplete")) {
                        ItemStack itemStack = new ItemStack(Material.FILLED_MAP);
                        MapMeta itemMeta = (MapMeta) itemStack.getItemMeta();
                        itemMeta.setDisplayName("Queercraft Map");
                        ArrayList<String> itemLore = new ArrayList<>();
                        itemLore.add("Queercraft April Fools 2024");
                        itemMeta.setLore(itemLore);

                        itemMeta.setColor(Color.AQUA);
                        itemMeta.setMapId(8895);

                        itemStack.setItemMeta(itemMeta);

                        final Map<Integer, ItemStack> itemsDidntFit = p.getInventory().addItem(itemStack);
                        for (final ItemStack item : itemsDidntFit.values()) {
                            p.getWorld().dropItemNaturally(p.getLocation(), item);
                        }

                        trackedPlayer.setBoolFlag("timesUsedCartographyTableComplete", true);
                    }
                    close(p);
                }
            }
        }, 3, 1, true);


        builder.addButtonByColumnRow(new MenuButton(Material.MAP, 1, " "), 1, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.MAP, 1, " "), 2, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.MAP, 1, " "), 3, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.MAP, 1, " "), 4, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.MAP, 1, " "), 5, 5, true);

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
                new DgPopupCartographyTable().show(p);
            }, 20);
        });

        return builder.build();
    }

}
