package eu.endermite.skyblock.configs;

import eu.endermite.skyblock.EnderSkyblockSpigot;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigCache {

    private final String pluginMode;
    private final boolean debugState;
    private final int islandLimit;

    public ConfigCache() {

        FileConfiguration config = EnderSkyblockSpigot.getPlugin().getConfig();
        this.pluginMode = config.getString("mode");
        this.debugState = config.getBoolean("debug");
        this.islandLimit = config.getInt("islands.worlds-limit");

    }

    public String getPluginMode() {
        return pluginMode;
    }
    public boolean debugEnabled() {
        return debugState;
    }
    public int getIslandLimit() {
        return islandLimit;
    }

}
