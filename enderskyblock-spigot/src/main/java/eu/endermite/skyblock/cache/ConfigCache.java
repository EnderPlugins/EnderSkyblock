package eu.endermite.skyblock.cache;

import eu.endermite.skyblock.EnderSkyblockSpigot;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigCache {

    private final String pluginMode;
    private final boolean debugState;

    public ConfigCache() {

        FileConfiguration config = EnderSkyblockSpigot.getPlugin().getConfig();
        this.pluginMode = config.getString("mode");
        this.debugState = config.getBoolean("debug");

    }

    public String getPluginMode() {
        return pluginMode;
    }
    public boolean debugEnabled() {
        return debugState;
    }

}
