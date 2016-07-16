package com.playernguyen.command;

import com.playernguyen.GSWarpManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GalaxySurvivalCommand implements CommandExecutor
{

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (!(sender instanceof Player))
        {
            sender.sendMessage(ChatColor.RED + "Cannot use for Console");
            return true;
        } else {
            ((Player) sender).teleport(GSWarpManager.getInstance().getWarp());
            sender.sendMessage(ChatColor.RED + "[CraftVN - Galaxy] Teleport to world.");
            sender.sendMessage(ChatColor.AQUA + "[CraftVN - Galaxy] Use /gshelp to more information.");
        }   
        return true;
    }

}
