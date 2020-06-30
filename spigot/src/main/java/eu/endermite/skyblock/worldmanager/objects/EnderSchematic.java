package eu.endermite.skyblock.worldmanager.objects;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public final class EnderSchematic implements Schematic {

    private final String worldname;
    private final String loader;
    private final String difficulty;
    private final HashMap<String,Integer> spawnLocation;
    private final boolean animalSpawns;
    private final boolean monsterSpawns;
    private final boolean pvp;
    private final ArrayList<ItemStack> startingChestInv;

    public EnderSchematic(Builder builder) {
        this.worldname = builder.worldname;
        this.loader = builder.loader;
        this.difficulty = builder.difficulty;
        this.spawnLocation = builder.spawnLocation;
        this.animalSpawns = builder.animalSpawns;
        this.monsterSpawns = builder.monsterSpawns;
        this.pvp = builder.pvp;
        this.startingChestInv = builder.startingChestInv;
    }

    @Override
    public String getName() {
        return this.worldname;
    }

    @Override
    public String getLoader() {
        return this.loader;
    }

    @Override
    public String getDifficulty() {
        return this.difficulty;
    }

    @Override
    public HashMap<String, Integer> getSpawnLocation() {
        return this.spawnLocation;
    }

    @Override
    public boolean getAnimalSpawns() {
        return this.animalSpawns;
    }

    @Override
    public boolean getMonsterSpawns() {
        return this.monsterSpawns;
    }

    @Override
    public boolean getPvp() {
        return this.pvp;
    }

    @Override
    public ArrayList<ItemStack> getStartingChestInv() {
        return this.startingChestInv;
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

        public EnderSchematic build() {
            return new EnderSchematic(this);
        }
    }
}
