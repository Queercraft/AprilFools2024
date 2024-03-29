package me.diademiemi.aprilfools2024;

import me.diademiemi.aprilfools2024.player.TrackedPlayer;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AprilFools2024IO {

    private static File dataFile;

    private static YamlConfiguration data;

    public static void init() {
        dataFile = new File("plugins/AprilFools2024/data.yml");
        if (!dataFile.exists()) {
            dataFile.getParentFile().mkdirs();
            AprilFools2024.getPlugin().saveResource("data.yml", false);
        }
    }

    public static void writeConfig() {
        try {
            data.set("trackedPlayers", TrackedPlayer.getTrackedPlayersList());
            data.save(dataFile);
        } catch (Exception e) {
            AprilFools2024.getPlugin().getLogger().severe("Could not save data file!");
            AprilFools2024.getPlugin().getLogger().severe(e.getMessage());
        }
    }
    public static void loadConfig() {
        try {
            data = YamlConfiguration.loadConfiguration(dataFile);
        } catch (Exception e) {
            AprilFools2024.getPlugin().getLogger().severe("Could not load data file!");
            e.printStackTrace();
        }
    }


}
