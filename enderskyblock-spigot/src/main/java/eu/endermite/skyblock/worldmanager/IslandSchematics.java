package eu.endermite.skyblock.worldmanager;

import com.grinderwolf.swm.api.SlimePlugin;
import com.grinderwolf.swm.api.loaders.SlimeLoader;
import com.grinderwolf.swm.api.world.SlimeWorld;
import com.grinderwolf.swm.api.world.properties.SlimeProperties;
import com.grinderwolf.swm.api.world.properties.SlimePropertyMap;
import eu.endermite.skyblock.EnderSkyblockSpigot;

import java.util.HashMap;
import java.util.logging.Logger;

public class IslandSchematics {

    private final SlimePlugin swm = EnderSkyblockSpigot.getSwm();
    private final Logger logger = EnderSkyblockSpigot.getPlugin().getLogger();

    private HashMap<String, SlimeWorld> schematicWorlds = new HashMap<>();

    public IslandSchematics() {


        //loop for schematics loading here

        String schematic = "temp";

        SlimeLoader loader = swm.getLoader("file");
        SlimePropertyMap props = new SlimePropertyMap();
        props.setString(SlimeProperties.DIFFICULTY, "normal");
        props.setInt(SlimeProperties.SPAWN_X, 0);
        props.setInt(SlimeProperties.SPAWN_Y, 0);
        props.setInt(SlimeProperties.SPAWN_Z, 120);
        props.setBoolean(SlimeProperties.ALLOW_ANIMALS, true);
        props.setBoolean(SlimeProperties.ALLOW_MONSTERS, true);
        props.setBoolean(SlimeProperties.PVP, true);

        try {
            SlimeWorld world = swm.loadWorld(loader, schematic, true, props);
            schematicWorlds.put(schematic, world);

            if (EnderSkyblockSpigot.getConfigCache().debugEnabled())
                logger.info("Loaded schematic \""+schematic+"\"");

        } catch (Exception e) {
            if (EnderSkyblockSpigot.getConfigCache().debugEnabled())
                logger.severe("Failed to load schematic \""+schematic+"\"");
            e.printStackTrace();
        }

    }

    public HashMap<String, SlimeWorld> getList() {
        return schematicWorlds;
    }

    public SlimeWorld getSchematic(String name) {
        return schematicWorlds.get(name);
    }

}
