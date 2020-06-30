package eu.endermite.skyblock;

import codes.dashiell.standard.*;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

import java.util.Optional;

public class RedisManager extends Manager implements Enableable<SimpleResult>, Disableable<Void> {

    private RedisClient redisClient;
    private StatefulRedisConnection<String, String> connection;

    protected RedisManager(EnderSkyblockBungee enderSkyblockBungee) {
        super(enderSkyblockBungee);
    }

    @Override
    public SimpleResult enable() {
        this.redisClient = RedisClient.create(""); //todo config
        this.connection = redisClient.connect();
        String result = this.connection.sync().ping();
        return (result == null) ? SimpleResult.FAILURE : SimpleResult.SUCCESS;
    }

    @Override
    public Void disable() {
        this.connection.close();
        this.redisClient.shutdown();
        return null;
    }

    public String getSync(String getText){
        RedisCommands<String, String> commands = connection.sync();
        return commands.get(getText);
    }

    public void getAsync(String getText, Callback<String> callback){
        //todo
    }

    //todo a lot of methods
}
