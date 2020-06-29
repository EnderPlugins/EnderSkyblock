package eu.endermite.skyblock;

import com.grinderwolf.swm.api.SlimePlugin;
import eu.endermite.skyblock.cache.ConfigCache;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class EnderSkyblockSpigot extends JavaPlugin {

    private static EnderSkyblockSpigot plugin;
    public static EnderSkyblockSpigot getPlugin() {return plugin;}
    private static ConfigCache configCache;
    public static ConfigCache getConfigCache() {return configCache;}
    private static SlimePlugin swm;
    public static SlimePlugin getSwm() {return swm;}


    @Override
    public void onEnable() {

        plugin = this;
        configCache = new ConfigCache();
        swm = (SlimePlugin) Bukkit.getPluginManager().getPlugin("SlimeWorldManager");

        getLogger().info("Enabling EnderSkyblock...");

    }

}
