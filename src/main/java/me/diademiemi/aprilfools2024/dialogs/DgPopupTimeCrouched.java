package me.diademiemi.aprilfools2024.dialogs;

import me.diademiemi.aprilfools2024.AprilFools2024;
import me.diademiemi.aprilfools2024.player.TrackedPlayer;
import me.diademiemi.invuilib.menu.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.Map;


public class DgPopupTimeCrouched implements Dialog {

    @Override
    public Menu create(Player p, Object... args) {
        MenuBuilder builder = new MenuBuilder("Need a cardboard box, Snake?", MenuSize.SIX_ROWS, p);


        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "Don't Treat It As Another Box. Treat It With Love. Don't Be Rough. Okay?"), 3, 1, true);

        ItemStack boxHead = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta boxHeadMeta = boxHead.getItemMeta();
        boxHeadMeta.setDisplayName("Cardboard Box");
        boxHead.setItemMeta(boxHeadMeta);
        Bukkit.getUnsafe().modifyItemStack(boxHead, "{SkullOwner: {Name: \"Cardboard Box\", Id: [I; 67411088, -739686879, -1666252800, -1432143867], Properties: {textures: [{Value: \"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWYyNTg0OWU4Y2Q1ZTUzMmMzMGNiYThkZThiZWQwNjQwY2ZiMmVlYzUwOTI5OTk4YjEwNzgzOWJmYjBmMjRkNyJ9fX0=\"}]}}}");
        MenuButton boxButton = new MenuButton(Material.PLAYER_HEAD, 1, "Cardboard Box") {
            @Override
            public void onLeftClick(Player p) {
                TrackedPlayer trackedPlayer = TrackedPlayer.getTrackedPlayer(p.getUniqueId());

                if (trackedPlayer != null) {
                    // If getFlagExists is false or getBoolFlag is false
                    if (!trackedPlayer.getBoolFlag("timeCrouchedComplete")) {
                        ItemStack itemStack = boxHead;
                        ItemMeta itemMeta = itemStack.getItemMeta();
                        itemMeta.setDisplayName("Cardboard Box");
                        ArrayList<String> itemLore = new ArrayList<>();
                        itemLore.add("Queercraft April Fools 2024");
                        itemMeta.setLore(itemLore);
                        itemStack.setItemMeta(itemMeta);

                        final Map<Integer, ItemStack> itemsDidntFit = p.getInventory().addItem(itemStack);
                        for (final ItemStack item : itemsDidntFit.values()) {
                            p.getWorld().dropItemNaturally(p.getLocation(), item);
                        }

                        trackedPlayer.setBoolFlag("timeCrouchedComplete", true);
                    }
                    close(p);
                }
            }
        };
        boxButton.setItemStack(boxHead);

        builder.addButtonByColumnRow(boxButton, 3, 2, true);

        builder.addButtonByColumnRow(new MenuButton(Material.GUNPOWDER, 1, " "), 1, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.GUNPOWDER, 1, " "), 2, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.GUNPOWDER, 1, " "), 3, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.GUNPOWDER, 1, " "), 4, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.GUNPOWDER, 1, " "), 5, 5, true);

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
                new DgPopupTimeCrouched().show(p);
            }, 20);
        });

        return builder.build();
    }

}
