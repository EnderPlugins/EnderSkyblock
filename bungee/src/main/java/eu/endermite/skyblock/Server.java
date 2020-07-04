package eu.endermite.skyblock;

import java.util.UUID;

public class Server {
    private final UUID serverId;

    public Server(UUID serverId) {
        this.serverId = serverId;
    }

    public UUID getServerId() {
        return serverId;
    }
}
