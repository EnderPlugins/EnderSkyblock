package eu.endermite.skyblock.worldmanager;

import com.grinderwolf.swm.api.SlimePlugin;
import com.grinderwolf.swm.api.loaders.SlimeLoader;
import com.grinderwolf.swm.api.world.SlimeWorld;
import com.grinderwolf.swm.api.world.properties.SlimeProperties;
import com.grinderwolf.swm.api.world.properties.SlimePropertyMap;
import eu.endermite.skyblock.EnderSkyblockSpigot;

import java.util.UUID;

public class IslandCreate {

    SlimePlugin swm = EnderSkyblockSpigot.getSwm();


    /**
     * @param schematic Name of the SWM world to clone
     * @return UUID of created island. Null if failed to create island
     */
    public UUID createNewIsland(String schematic) {

        SlimeLoader loader = swm.getLoader("mysql");

        //TODO customisability support

        SlimePropertyMap props = new SlimePropertyMap();
        props.setString(SlimeProperties.DIFFICULTY, "normal");
        props.setInt(SlimeProperties.SPAWN_X, 0);
        props.setInt(SlimeProperties.SPAWN_Y, 0);
        props.setBoolean(SlimeProperties.PVP, false);

        try {
            SlimeWorld world = swm.loadWorld(loader, schematic, true, props);
            UUID island_uuid = UUID.randomUUID();
            world.clone(island_uuid.toString(), loader);
            return island_uuid;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
