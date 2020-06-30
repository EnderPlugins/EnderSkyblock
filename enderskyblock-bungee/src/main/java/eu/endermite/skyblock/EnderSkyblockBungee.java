package eu.endermite.skyblock;

import codes.dashiell.standard.Bootloader;
import codes.dashiell.standard.SimpleResult;
import net.md_5.bungee.api.plugin.Plugin;

public class EnderSkyblockBungee extends Plugin {

    private final Bootloader bootloader = new BungeeBootloader(this);
    private RedisManager redisManager;

    @Override
    public void onEnable() {
        SimpleResult result = bootloader.enable();
        if(result.isBad()){
            this.onDisable();
        }
    }

    @Override
    public void onDisable() {
        bootloader.disable();
        this.getProxy().getPluginManager().unregisterCommands(this);
        this.getProxy().getPluginManager().unregisterListeners(this);
    }

    public RedisManager getRedisManager() {
        return redisManager;
    }

    public void setRedisManager(RedisManager redisManager) {
        this.redisManager = redisManager;
    }
}
