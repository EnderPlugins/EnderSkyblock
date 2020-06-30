package eu.endermite.skyblock.worldmanager.schematics;

import java.util.HashMap;

public interface Island {

    public int getBorder();
    public HashMap<String, HashMap<String, Integer>> getWarpLocations();
    public void addWarpLocation(String name, int x, int y, int z);
    public void remWarpLocation(String name);
    public int getIslandPoints();
    public void setIslandPoints(int points);
    public void setPointMultiplier(float multiplier);
    public float getPointMultiplier();
    public float getLevel();

}
