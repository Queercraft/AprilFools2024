package me.diademiemi.aprilfools2024;

import me.diademiemi.aprilfools2024.command.CommandHandler;
import me.diademiemi.aprilfools2024.listener.EventListener;
import me.diademiemi.aprilfools2024.listener.RandomScheduler;
import me.diademiemi.aprilfools2024.listener.TrackingListener;
import me.diademiemi.aprilfools2024.player.TrackedPlayer;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class AprilFools2024 extends JavaPlugin {

    static {
        ConfigurationSerialization.registerClass(TrackedPlayer.class);
    }

    private static Plugin plugin;

    public static Plugin getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        // Plugin startup logic

        // Create data file if not exists
        AprilFools2024IO.init();
        // Load tracked players and their data
        AprilFools2024IO.loadConfig();

        // Register the tracking listener (join and quit)
        getServer().getPluginManager().registerEvents(new TrackingListener(), this);
        getServer().getPluginManager().registerEvents(new EventListener(), this);

        // Register CommandHandler
        getCommand("aprilfools2024").setExecutor(new CommandHandler());

        // Schedule the random global dialogues
        RandomScheduler.scheduleRandom();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        // Write data
        AprilFools2024IO.writeConfig();
    }
}
