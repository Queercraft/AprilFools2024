package me.diademiemi.aprilfools2024.player;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import me.diademiemi.aprilfools2024.AprilFools2024;
import me.diademiemi.aprilfools2024.listener.EventListener;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TrackedPlayer implements ConfigurationSerializable {

    // Serialization method
    @Override
    public Map<String, Object> serialize() {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("uuid", uuid.toString());
        data.put("jsonData", jsonData.toString());
        return data;
    }

    // Deserialization constructor
    public TrackedPlayer(Map<String, Object> data) {
        this.uuid = UUID.fromString(data.get("uuid").toString());
        this.player = AprilFools2024.getPlugin().getServer().getPlayer(uuid); // Can be null! (player is offline, we will set it upon login)
        this.jsonData = new Gson().fromJson(data.get("jsonData").toString(), JsonObject.class);

        trackedPlayers.put(uuid, this);
    }

    // Hashmap we use to store all tracked players and their data
    public static HashMap<UUID, TrackedPlayer> trackedPlayers = new HashMap<UUID, TrackedPlayer>();

    // Getter to return the HashMap
    public static HashMap<UUID, TrackedPlayer> getTrackedPlayers() {
        return trackedPlayers;
    }

    // Getter to only a non-keyset version of the HashMap, we store this in a new ArrayList
    public static ArrayList<TrackedPlayer> getTrackedPlayersList() {
        return new ArrayList<TrackedPlayer>(trackedPlayers.values());
    }

    // Get a specific player by UUID
    public static TrackedPlayer getTrackedPlayer(UUID uuid) {
        return trackedPlayers.get(uuid);
    }

    public static TrackedPlayer getTrackedPlayer(Player player) {
        return getTrackedPlayer(player.getUniqueId());
    }

    public static TrackedPlayer getTrackedPlayer(String playerName) {
        Player player = AprilFools2024.getPlugin().getServer().getPlayer(playerName);

        if (player == null) {
            return null;
        }

        return getTrackedPlayer(player);
    }

    // Store the Player object, is null when the player is offline
    public Player player;

    // UUID of the player
    public UUID uuid;

    // Json data for the player to be stored in de YML. This stores flags whether they've already had certain events happen.
    public JsonObject jsonData;

    // Constructor to create a new TrackedPlayer object
    public TrackedPlayer(UUID uuid) {
        this.uuid = uuid;
        this.player = null;
        this.jsonData = new JsonObject();

        trackedPlayers.put(uuid, this);
    }

    // When the player is online, set their player object
    public void setOnlinePlayer() {
        this.player = AprilFools2024.getPlugin().getServer().getPlayer(uuid);
    }

    // When the player is offline, set their player object to null
    public void unsetOnlinePlayer() {
        this.player = null;
    }

    public Player getPlayer() {
        return this.player;
    }

    public boolean getFlagExists(String flag) {
        return jsonData.get(flag) != null;
    }

    public void unsetFlag(String flag) {
        jsonData.remove(flag);
    }

    public void clearData() {
        jsonData = new JsonObject();
        TrackedPlayerUtil.setFlags(this, this.getPlayer());
    }

    public JsonElement getFlag(String flag) {
        return jsonData.get(flag);
    }

    // Get a flag from the json data
    public boolean getBoolFlag(String flag) {
        // This can be null, default to false
        return jsonData.get(flag) != null && jsonData.get(flag).getAsBoolean();
    }

    // Set a flag in the json data
    public void setBoolFlag(String flag, boolean value) {
        jsonData.addProperty(flag, value);
    }

    public int getIntFlag(String flag) {
        return jsonData.get(flag).getAsInt();
    }

    public void setIntFlag(String flag, int value) {
        jsonData.addProperty(flag, value);
    }

    public String getStringFlag(String flag) {
        return jsonData.get(flag).getAsString();
    }

    public void setStringFlag(String flag, String value) {
        jsonData.addProperty(flag, value);
    }

}
