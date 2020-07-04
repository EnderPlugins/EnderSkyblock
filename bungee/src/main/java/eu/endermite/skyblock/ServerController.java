package eu.endermite.skyblock;

import codes.dashiell.standard.Callback;
import net.md_5.bungee.api.ProxyServer;

import java.util.HashSet;
import java.util.Set;

public class ServerController implements AsyncController<Server> {
    private final EnderSkyblockBungee enderSkyblockBungee;

    public ServerController(EnderSkyblockBungee enderSkyblockBungee) {
        this.enderSkyblockBungee = enderSkyblockBungee;
    }

    @Override
    public void getAll(Callback<Set<Server>> callback) {

        ProxyServer.getInstance().getScheduler().runAsync(this.enderSkyblockBungee, () -> {

            // getfromredismanager
            callback.callback(new HashSet<>());

        });

    }

}
