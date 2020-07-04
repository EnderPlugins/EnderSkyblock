package eu.endermite.skyblock.commands.eskyblock;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.ArrayList;
import java.util.List;

@org.bukkit.plugin.java.annotation.command.Command(name = "eskyblock", aliases = {"enderskyblock"})
public class Eskyblock implements TabExecutor {

    private List<String> commandsList = new ArrayList<>();

    public Eskyblock() {

    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (strings.length == 0) {
            EskyblockHelp.getMainPage(commandSender);
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return null;
    }
}
