package me.diademiemi.aprilfools2024.dialogs;

import me.diademiemi.aprilfools2024.AprilFools2024;
import me.diademiemi.invuilib.menu.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.UUID;


public class DgGlobalHaveYouSeenThisShark implements Dialog {

    @Override
    public Menu create(Player p, Object... args) {
        MenuBuilder builder = new MenuBuilder("HAVE YOU SEEN", MenuSize.SIX_ROWS, p);


        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "HAVE YOU SEEN THIS SHARK?"), 3, 1, true);

        // Get from url
        ItemStack blahajHead = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta blahajHeadMeta = blahajHead.getItemMeta();
        blahajHeadMeta.setDisplayName("Blahaj!!!");
        blahajHead.setItemMeta(blahajHeadMeta);
        Bukkit.getUnsafe().modifyItemStack(blahajHead, "{SkullOwner: {Name: \"Blahaj\", Id: [I; 67411088, -739686879, -1666252800, -1432143867], Properties: {textures: [{Value: \"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWRmZjkwNDEyNGVmZTQ4NmIzYTU0MjYxZGJiODA3MmIwYTRlMTE2MTVhZDhkNzM5NGQ4MTRlMGU4YzhlZjllYiJ9fX0=\"}]}}}");
        MenuButton blahajButton = new MenuButton(Material.PLAYER_HEAD, 1, "Blahaj!!!") {
            @Override
            public void onLeftClick(Player p) {
                p.sendMessage("You have seen the shark!");
            }
        };
        blahajButton.setItemStack(blahajHead);

        builder.addButtonByColumnRow(blahajButton, 3, 2, true);

        builder.addButtonByColumnRow(new MenuButton(Material.PAPER, 1,
                "Now you have"), 3, 3, true);

        builder.addButtonByColumnRow(new MenuButton(Material.HEART_OF_THE_SEA, 1, " "), 1, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.HEART_OF_THE_SEA, 1, " "), 2, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.HEART_OF_THE_SEA, 1, " "), 3, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.HEART_OF_THE_SEA, 1, " "), 4, 5, true);
        builder.addButtonByColumnRow(new MenuButton(Material.HEART_OF_THE_SEA, 1, " "), 5, 5, true);

        // Close button
        builder.addButtonByColumnRow(new MenuButton(Material.BARRIER, 1, "Close") {
            @Override
            public void onLeftClick(Player p) {
                close(p);
            }
        }, 6, 0, true);

        // Outer decoration
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 0, 0, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 0, 1, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 0, 2, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 0, 3, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 0, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 0, 5, true);

        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 6, 1, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 6, 2, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 6, 3, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 6, 4, true);
        builder.addButtonByColumnRow(new MenuButton(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, " "), 6, 5, true);

        // Prevent the player from force exiting the menu. its gotta be annoying!
        builder.setOnForceClose(() -> {
            AprilFools2024.getPlugin().getServer().getScheduler().runTaskLater(AprilFools2024.getPlugin(), () -> {
                new DgGlobalHaveYouSeenThisShark().show(p);
            }, 20);
        });

        return builder.build();
    }

}
