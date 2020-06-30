package eu.endermite.skyblock.worldmanager;

import com.grinderwolf.swm.api.SlimePlugin;
import com.grinderwolf.swm.api.loaders.SlimeLoader;
import com.grinderwolf.swm.api.world.SlimeWorld;
import com.grinderwolf.swm.api.world.properties.SlimeProperties;
import com.grinderwolf.swm.api.world.properties.SlimePropertyMap;
import eu.endermite.skyblock.EnderSkyblockSpigot;

import java.util.UUID;

public class IslandLoad {

    SlimePlugin swm = EnderSkyblockSpigot.getSwm();

    /**
     * @param uuid UUID of an island to load
     * @return boolean if island loaded successfully
     */
    public boolean loadIsland(UUID uuid) {

        SlimeLoader loader = swm.getLoader("mysql");


        SlimePropertyMap props = new SlimePropertyMap();
        props.setString(SlimeProperties.DIFFICULTY, "normal");
        props.setInt(SlimeProperties.SPAWN_X, 0);
        props.setInt(SlimeProperties.SPAWN_Y, 0);

        try {
            SlimeWorld world = swm.loadWorld(loader, uuid.toString(), false, props);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
