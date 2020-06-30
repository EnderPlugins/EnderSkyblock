package eu.endermite.skyblock.worldmanager.schematics;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class EnderIsland implements Schematic, Island {

    private final String worldname;
    private final String loader;
    private final String difficulty;
    private final HashMap<String,Integer> spawnLocation;
    private final boolean animalSpawns;
    private final boolean monsterSpawns;
    private final boolean pvp;
    private final ArrayList<ItemStack> startingChestInv;
    private int border;
    private HashMap<String, HashMap<String, Integer>> warpLocations;
    private int points;
    private float pointMultiplier;
    private float level;
    private HashMap<UUID, String> members;
    private int memberLimit;

    public EnderIsland(Builder builder) {
        this.worldname = builder.worldname;
        this.loader = builder.loader;
        this.difficulty = builder.difficulty;
        this.spawnLocation = builder.spawnLocation;
        this.animalSpawns = builder.animalSpawns;
        this.monsterSpawns = builder.monsterSpawns;
        this.pvp = builder.pvp;
        this.startingChestInv = builder.startingChestInv;
        this.border = builder.border;
        this.warpLocations = builder.warpLocations;
        this.points = builder.points;
        this.pointMultiplier = builder.pointMultiplier;
        this.level = builder.level;
        this.members = builder.members;
        this.memberLimit = builder.memberLimit;
    }


    public String getName() {
        return this.worldname;
    }

    public String getLoader() {
        return this.loader;
    }

    public String getDifficulty() {
        return this.difficulty;
    }

    public HashMap<String, Integer> getSpawnLocation() {
        return this.spawnLocation;
    }

    public boolean getAnimalSpawns() {
        return this.animalSpawns;
    }

    public boolean getMonsterSpawns() {
        return this.monsterSpawns;
    }

    public boolean getPvp() {
        return this.pvp;
    }

    public ArrayList<ItemStack> getStartingChestInv() {
        return this.startingChestInv;
    }

    public int getBorder() {
        return this.border;
    }

    @Override
    public HashMap<String, HashMap<String, Integer>> getWarpLocations() {
        return this.warpLocations;
    }

    @Override
    public void addWarpLocation(String name, int x, int y, int z) {
        HashMap<String, Integer> h = new HashMap<>();
        h.put("x", x);
        h.put("y", y);
        h.put("z", z);
        this.warpLocations.put(name, h);
    }

    @Override
    public void remWarpLocation(String name) {
        this.warpLocations.remove(name);
    }

    @Override
    public int getIslandPoints() {
        return points;
    }

    @Override
    public void setIslandPoints(int points) {
        this.points = points;
    }

    @Override
    public void setPointMultiplier(float multiplier) {
        this.pointMultiplier = multiplier;
    }

    @Override
    public float getPointMultiplier() {
        return this.pointMultiplier;
    }

    @Override
    public float getLevel() {
        return this.level;
    }

    @Override
    public void setLevel(float level) {
        this.level = level;
    }

    @Override
    public HashMap<UUID, String> getMembers() {
        return this.members;
    }

    @Override
    public int getMemberLimit() {
        return this.memberLimit;
    }

    @Override
    public void setMemberLimit(int limit) {
        this.memberLimit = limit;
    }

    @Override
    public void addMember(UUID uuid, String rank) {
        this.members.put(uuid, rank);
    }

    @Override
    public void remMember(UUID uuid) {
        this.members.remove(uuid);
    }

    @Override
    public void setMemberRank(UUID uuid, String rank) {
        this.members.replace(uuid, rank);
    }

    @Override
    public String getMemberRank(UUID uuid) {
        return this.members.get(uuid);
    }

    public static class Builder {
        private String worldname;
        private String loader;
        private String difficulty;
        private HashMap<String, Integer> spawnLocation;
        private boolean animalSpawns;
        private boolean monsterSpawns;
        private boolean pvp;
        private ArrayList<ItemStack> startingChestInv;
        private int border;
        private HashMap<String, HashMap<String,Integer>> warpLocations;
        private int points;
        private float pointMultiplier;
        private float level;
        private HashMap<UUID, String> members;
        private int memberLimit;

        public static Builder newInstance() {
            return new Builder();
        }

        private Builder() {}

        public Builder setName(String name) {
            this.worldname = name;
            return this;
        }

        public Builder setLoader(String loader) {
            this.loader = loader;
            return this;
        }

        public Builder setDifficulty(String difficulty) {
            this.difficulty = difficulty;
            return this;
        }

        public Builder setSpawnLocation(int x, int y, int z) {
            this.spawnLocation = new HashMap<>();
            this.spawnLocation.put("x", x);
            this.spawnLocation.put("y", y);
            this.spawnLocation.put("z", z);
            return this;
        }

        public Builder setAnimalSpawns(boolean state) {
            this.animalSpawns = state;
            return this;
        }

        public Builder setMonsterSpawns(boolean state) {
            this.monsterSpawns = state;
            return this;
        }

        public Builder setPvp(boolean pvp) {
            this.pvp = pvp;
            return this;
        }

        public Builder setStartingChestInv(ArrayList<ItemStack> itemlist) {
            this.startingChestInv = itemlist;
            return this;
        }

        public Builder setBorder(int radius) {
            this.border = radius;
            return this;
        }

        public Builder setWarpLocations(HashMap<String, HashMap<String,Integer>> locations) {
            this.warpLocations = locations;
            return this;
        }

        public Builder setPoints(int points) {
            this.points = points;
            return this;
        }

        public Builder setPointMultiplier(float multiplier) {
            this.pointMultiplier = multiplier;
            return this;
        }

        public Builder setLevel(float level) {
            this.level = level;
            return this;
        }

        public Builder setMembers(HashMap<UUID, String> members) {
            this.members = members;
            return this;
        }

        public Builder setMemberLimit(int limit) {
            this.memberLimit = limit;
            return this;
        }

        public EnderIsland build() {
            return new EnderIsland(this);
        }
    }

}
