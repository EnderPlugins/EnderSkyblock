package eu.endermite.skyblock;

import eu.endermite.skyblock.cache.ConfigCache;
import org.bukkit.plugin.java.JavaPlugin;

public class EnderSkyblockSpigot extends JavaPlugin {

    private static EnderSkyblockSpigot plugin;
    public static EnderSkyblockSpigot getPlugin() {return plugin;}
    private static ConfigCache configCache;
    public static ConfigCache getConfigCache() {return configCache;}

    @Override
    public void onEnable() {

        plugin = this;
        configCache = new ConfigCache();

        getLogger().info("Enabling EnderSkyblock...");

    }

}
