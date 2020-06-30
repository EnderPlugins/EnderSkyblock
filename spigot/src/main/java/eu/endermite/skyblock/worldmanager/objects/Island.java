package eu.endermite.skyblock.worldmanager.objects;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public interface Island {

    public int getBorder();
    public HashMap<String, HashMap<String, Integer>> getWarpLocations();
    public void addWarpLocation(String name, int x, int y, int z);
    public void remWarpLocation(String name);
    public int getIslandPoints();
    public void setIslandPoints(int points);
    public float getPointMultiplier();
    public void setPointMultiplier(float multiplier);
    public float getLevel();
    public void setLevel(float level);
    public HashMap<UUID, String> getMembers();
    public void addMember(UUID uuid, String rank);
    public void remMember(UUID uuid);
    public void setMemberRank(UUID uuid, String rank);
    public String getMemberRank(UUID uuid);
    public int getMemberLimit();
    public void setMemberLimit(int limit);
    public void setStartingChestItems(ArrayList<ItemStack> list);

}
