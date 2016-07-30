package com.playernguyen.command;

import com.playernguyen.GSWarpManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetGalaxySurvivalCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player))
        {
            commandSender.sendMessage("Cannot use this command for Console");
        } else {
            if (commandSender.hasPermission("galaxysurvival.setwarp"))
            {
                GSWarpManager.getInstance().addWarp(((Player) commandSender).getLocation());
                commandSender.sendMessage("Warp is set! Now you can teleport to there!");
            } else {
                commandSender.sendMessage("Don't have permission / Không đủ quyền thực hiện");
            }
        }
        return true;
    }
}
