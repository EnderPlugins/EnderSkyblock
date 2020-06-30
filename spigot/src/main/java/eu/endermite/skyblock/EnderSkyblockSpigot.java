package eu.endermite.skyblock;

import com.grinderwolf.swm.api.SlimePlugin;
import eu.endermite.skyblock.configs.ConfigCache;
import eu.endermite.skyblock.worldmanager.IslandManager;
import eu.endermite.skyblock.worldmanager.SchematicImporter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class EnderSkyblockSpigot extends JavaPlugin {

    private static EnderSkyblockSpigot plugin;
    public static EnderSkyblockSpigot getPlugin() {return plugin;}
    private static ConfigCache configCache;
    public static ConfigCache getConfigCache() {return configCache;}
    private static SlimePlugin swm;
    public static SlimePlugin getSwm() {return swm;}
    private static SchematicImporter schematicImporter;
    public static SchematicImporter getSchematicImporter() {return schematicImporter;}
    private static IslandManager islandManager;
    public static IslandManager getIslandManager() {return islandManager;}

    @Override
    public void onEnable() {

        plugin = this;
        configCache = new ConfigCache();
        swm = (SlimePlugin) Bukkit.getPluginManager().getPlugin("SlimeWorldManager");
        schematicImporter = new SchematicImporter();
        islandManager = new IslandManager();

    }

}
