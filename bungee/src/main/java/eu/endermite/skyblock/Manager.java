package eu.endermite.skyblock;

abstract public class Manager {
    private final EnderSkyblockBungee enderSkyblockBungee;

    protected Manager(EnderSkyblockBungee enderSkyblockBungee) {
        this.enderSkyblockBungee = enderSkyblockBungee;
    }

    public EnderSkyblockBungee getEnderSkyblockBungee() {
        return enderSkyblockBungee;
    }
}
