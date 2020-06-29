package eu.endermite.skyblock.worldmanager;

import com.grinderwolf.swm.api.SlimePlugin;
import com.grinderwolf.swm.api.loaders.SlimeLoader;
import com.grinderwolf.swm.api.world.SlimeWorld;
import com.grinderwolf.swm.api.world.properties.SlimeProperties;
import com.grinderwolf.swm.api.world.properties.SlimePropertyMap;
import eu.endermite.skyblock.EnderSkyblockSpigot;
import eu.endermite.skyblock.worldmanager.schematics.EnderSchematic;

import java.util.UUID;

public class IslandCreate {

    SlimePlugin swm = EnderSkyblockSpigot.getSwm();

    /**
     * @param schematic name of island schematic from configuration
     * @return UUID of created island. Null if failed to create island
     */
    public UUID createNewIsland(EnderSchematic schematic) {

        SlimeLoader loader = swm.getLoader(schematic.getLoader());

        SlimePropertyMap props = new SlimePropertyMap();
        props.setString(SlimeProperties.DIFFICULTY, schematic.getDifficulty());
        props.setInt(SlimeProperties.SPAWN_X, schematic.getSpawnLocation().get("x"));
        props.setInt(SlimeProperties.SPAWN_Y, schematic.getSpawnLocation().get("y"));
        props.setInt(SlimeProperties.SPAWN_Z, schematic.getSpawnLocation().get("z"));
        props.setBoolean(SlimeProperties.ALLOW_ANIMALS, schematic.getAnimalSpawns());
        props.setBoolean(SlimeProperties.ALLOW_MONSTERS, schematic.getMonsterSpawns());
        props.setBoolean(SlimeProperties.PVP, schematic.getPvp());

        try {
            SlimeWorld world = EnderSkyblockSpigot.getIslandSchematics().getSchematic(schematic.getName());
            UUID island_uuid = UUID.randomUUID();
            world.clone(island_uuid.toString(), loader);
            return island_uuid;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
