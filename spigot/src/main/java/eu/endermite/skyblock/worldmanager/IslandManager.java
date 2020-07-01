package eu.endermite.skyblock.worldmanager;

import com.grinderwolf.swm.api.SlimePlugin;
import com.grinderwolf.swm.api.loaders.SlimeLoader;
import com.grinderwolf.swm.api.world.SlimeWorld;
import com.grinderwolf.swm.api.world.properties.SlimeProperties;
import com.grinderwolf.swm.api.world.properties.SlimePropertyMap;
import eu.endermite.skyblock.EnderSkyblockSpigot;
import eu.endermite.skyblock.worldmanager.objects.EnderIsland;
import eu.endermite.skyblock.worldmanager.objects.EnderSchematic;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class IslandManager {

    private SlimePlugin swm = EnderSkyblockSpigot.getSwm();
    private List<EnderIsland> loadedIslands = new ArrayList<EnderIsland>();
    public List<EnderIsland> getLoadedIslands() {return loadedIslands;}

    /**
     * @param schematic name of island schematic from configuration
     * @return UUID of created island. Null if failed to create island
     */
    public UUID createIsland(EnderSchematic schematic) {

        try {
            SlimeLoader loader = swm.getLoader(schematic.getLoader());
            SlimeWorld world = EnderSkyblockSpigot.getSchematicImporter().getSchematic(schematic.getName());
            UUID island_uuid = UUID.randomUUID();
            world.clone(island_uuid.toString(), loader);

            //TODO create database entry

            return island_uuid;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param uuid UUID of an island to load
     * @return boolean if island loaded successfully
     */
    public boolean loadIsland(UUID uuid) {

        //TODO Load island data from database and dump it into islandData hashmap

        HashMap<String, Object> islandData = new HashMap<>();

        SlimeLoader loader = swm.getLoader((String) islandData.get("loader"));
        SlimePropertyMap props = new SlimePropertyMap();
        props.setString(SlimeProperties.DIFFICULTY, (String) islandData.get("difficulty"));
        props.setBoolean(SlimeProperties.PVP, true);
        props.setBoolean(SlimeProperties.ALLOW_MONSTERS, true);
        props.setBoolean(SlimeProperties.ALLOW_ANIMALS, true);

        //TODO get coords properly
        props.setInt(SlimeProperties.SPAWN_X, (Integer) islandData.get("spawnLoc"));
        props.setInt(SlimeProperties.SPAWN_Y, (Integer) islandData.get("spawnLoc"));
        props.setInt(SlimeProperties.SPAWN_Z, (Integer) islandData.get("spawnLoc"));

        try {
            swm.loadWorld(loader, uuid.toString(), false, props);

            // Load neccesary data
            EnderIsland.Builder builder = EnderIsland.Builder.newInstance();
            builder.setUuid(uuid);
            builder.setBorder((Integer) islandData.get("size"));
            builder.setAnimalSpawns((Boolean) islandData.get("animalspawns"));
            builder.setAnimalSpawns((Boolean) islandData.get("monsterspawns"));
            builder.setDifficulty((String) islandData.get("difficulty"));
            builder.setName((String) islandData.get("worldname"));
            builder.setPvp((Boolean) islandData.get("pvp"));
            builder.setLevel((Float) islandData.get("level"));
            builder.setLoader((String) islandData.get("loader"));
            builder.setMemberLimit((Integer) islandData.get("memberlimit"));
            builder.setPoints((Integer) islandData.get("points"));
            builder.setPointMultiplier((Float) islandData.get("pointsmultiplier"));

            // Load data that can be null
            try {
                builder.setStartingChestInv((ArrayList<ItemStack>) islandData.get("startingchest"));
            } catch (NullPointerException ignored) {}
            try {
                builder.setWarpLocations((HashMap<String, HashMap<String, Integer>>) islandData.get("warplocations"));
            } catch (NullPointerException ignored) {}
            try {
                builder.setMembers((HashMap<UUID, String>) islandData.get("members"));
            } catch (NullPointerException ignored) {}

            //Build and load island object
            EnderIsland island = builder.build();
            loadedIslands.add(island);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param uuid UUID of island to delete
     * @return boolean if island was deleted successfully
     */
    public UUID removeIsland(UUID uuid) {

        /*
        TODO island deletion logic
        Yes, it has to be handled spigot-side since need SWM api, unless we find workaround.
         */

        return null;
    }

    /**
     * @param uuid UUID of an island to unload
     * @return boolean if island loaded successfully
     */
    public boolean unloadIsland(UUID uuid) {

        EnderIsland islandToUnload = null;

        for (EnderIsland island : getLoadedIslands()) {
            if (island.getName().equals(uuid.toString())) {
                islandToUnload = island;
                break;
            }
        }

        if (islandToUnload == null)
            return false;

        saveIsland(uuid, false);

        for (World world : EnderSkyblockSpigot.getPlugin().getServer().getWorlds()) {
            if (world.getName().contains(uuid.toString())) {
                EnderSkyblockSpigot.getPlugin().getServer().unloadWorld(world, true);
                break;
            }
        }

        loadedIslands.remove(islandToUnload);
        return true;
    }

    /**
     * @param uuid UUID of an island to save
     * @param bukkitsave true to save island data and world, false to save only island data
     * @return boolean if island was saved successfully
     */
    public boolean saveIsland(UUID uuid, boolean bukkitsave) {


        return false;
    }

}
