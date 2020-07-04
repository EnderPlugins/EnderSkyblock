package eu.endermite.skyblock.commands.eskyblock;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class EskyblockHelp {

    public static void getMainPage(CommandSender commandSender) {

        String[] message = new String[0];
        message[0] = ChatColor.YELLOW+"+----------------------------------------+";
        message[1] = ChatColor.YELLOW+"|             Ender Skyblock             |";
        message[2] = ChatColor.YELLOW+"+----------------------------------------+";
        message[3] = ChatColor.YELLOW+"|     by YouHaveTrouble and Dashiell     |";
        message[4] = ChatColor.YELLOW+"|        github.com/EnderPlugins         |";
        message[5] = ChatColor.YELLOW+"+----------------------------------------+";

        commandSender.sendMessage(message);
    }

}
