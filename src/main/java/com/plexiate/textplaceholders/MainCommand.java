package com.plexiate.textplaceholders;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class MainCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (command.getName().equalsIgnoreCase("textplaceholders"))
        {
            if(args.length == 1 && args[0].equalsIgnoreCase("reload"))
            {
                if (sender.hasPermission("textplaceholders.admin"))
                {
                    TextPlaceholders.plugin.reloadConfig();
                    TextPlaceholders.plugin.loadPlaceholders();
                    sender.sendMessage(ChatColor.BLUE + "Reloaded TextPlaceholders by Sek.");
                    return true;
                }
                else
                {
                    sender.sendMessage(ChatColor.RED + "You do not have permission.");
                    return true;
                }
            }
            else
            {
                return true;
            }

        }
        return true;

    }
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("textplaceholders")) {
            if (!sender.hasPermission("textplaceholders.admin")) {
                return null;
            }
            List<String> l = new ArrayList<>();
            if (args.length == 1) {
                l.add("reload");
                return l;
            }
        }
        return null;
    }
}
