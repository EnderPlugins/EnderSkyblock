package eu.endermite.skyblock;

import codes.dashiell.standard.Bootloader;
import codes.dashiell.standard.Disableable;
import codes.dashiell.standard.Enableable;
import codes.dashiell.standard.SimpleResult;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BungeeBootloader implements Bootloader {

    private final Set<Enableable<SimpleResult>> enableableSet = new HashSet<>();
    private final Set<Disableable> disableableSet = new HashSet<>();

    public BungeeBootloader(EnderSkyblockBungee enderSkyblockBungee) {
        enderSkyblockBungee.setRedisManager(new RedisManager(enderSkyblockBungee));
        Set<?> responsibleFor = new HashSet<>(
                Arrays.asList(
                        enderSkyblockBungee.getRedisManager()
                ));

        responsibleFor.forEach((a) -> {
            if (a instanceof Enableable<?>) {
                this.enableableSet.add((Enableable<SimpleResult>) a);
            }
            if (a instanceof Disableable) {
                this.disableableSet.add((Disableable<?>) a);
            }
        });
    }

    @Override
    public SimpleResult enable() {
        for(Enableable<SimpleResult> enableable : this.enableableSet){
            if(enableable.enable().isBad()){
                return SimpleResult.FAILURE;
            }
        }
        this.registerCommands();
        this.registerEvents();
        return SimpleResult.SUCCESS;
    }

    @Override
    public void disable() {
        for(Disableable<?> disableable : this.disableableSet){
            disableable.disable();
        }
    }

    @Override
    public void registerCommands() {

    }

    @Override
    public void registerEvents() {

    }
}
