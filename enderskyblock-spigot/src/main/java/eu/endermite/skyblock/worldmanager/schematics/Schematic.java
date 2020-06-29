package eu.endermite.skyblock.worldmanager.schematics;


import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public interface Schematic {

    public String getName();
    public String getLoader();
    public String getDifficulty();
    public HashMap<String,Integer> getSpawnLocation();
    public boolean getAnimalSpawns();
    public boolean getMonsterSpawns();
    public boolean getPvp();
    public ArrayList<ItemStack> getStartingChestInv();

}

