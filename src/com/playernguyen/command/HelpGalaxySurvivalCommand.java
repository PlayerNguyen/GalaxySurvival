package com.playernguyen.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpGalaxySurvivalCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player))
        {
            commandSender.sendMessage(ChatColor.RED + "Cannot use for Console");
            return true;
        } else {
            if (strings.length == 1)
            {
                if (strings[0] == null )
                {
                    commandSender.sendMessage(ChatColor.RED + "/gshelp [vi/en]");
                    commandSender.sendMessage(ChatColor.RED + "Language: vi / en");
                    return true;
                }
                System.out.println(strings.length);

                if (strings[0].equalsIgnoreCase("vi"))
                {
                    commandSender.sendMessage(ChatColor.RED + "- - - Chào mừng bạn đến với Galaxy Survival - - -");
                    commandSender.sendMessage(ChatColor.RED + "# " + ChatColor.AQUA + "Galaxy Survival là chế độ chơi sẽ khiến bạn cảm thấy thú vị hơn về Minecraft Survival");
                    commandSender.sendMessage(ChatColor.RED + "# " + ChatColor.AQUA + "Luôn nhớ! Bạn phải kiểm tra mũ của mình trước khi ra khỏi vùng thiếu oxi vì mũ sẽ cung cấp oxi cho bạn.");
                    commandSender.sendMessage(ChatColor.RED + "# " + ChatColor.AQUA + "Vùng thiếu oxi là những vùng có những block dưới chân bạn không phải là khối sắt.");
                    commandSender.sendMessage(ChatColor.RED + "# " + ChatColor.AQUA + "Thanh thức ăn của bạn hiện tại là thanh oxi. Khi yếu oxi bạn cần phải thức ăn để bơm thêm oxi vào");
                    commandSender.sendMessage(ChatColor.RED + "# " + ChatColor.AQUA + "Ngoài ra. Trên màn hình. Khi bạn bị tấn công! Sẽ có thông báo giúp dễ nhận biết hơn.");
                    commandSender.sendMessage(ChatColor.RED + "# " + ChatColor.AQUA + "Giết quái, giết người điều nhận được tiền. Đào đất và đem đi đổi cũng được tiền!");
                    return true;
                }
                if (strings[0].equalsIgnoreCase("en"))
                {
                    commandSender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "- - - Welcome to Galaxy Survival - - -");
                    commandSender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "# " + ChatColor.AQUA + "Galaxy Survival is a gamemode would make you feel exciting about normal Minecraft Survival");
                    commandSender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "# " + ChatColor.AQUA + "Remeber! You need to always check your helmet before you go out oxygen because helmet will supply oxygen for you.");
                    commandSender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "# " + ChatColor.AQUA + "Low oxygen area is areas with blocks under your feet is not Iron Block.");
                    commandSender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "# " + ChatColor.AQUA + "Your food bar now is a oxygen level. When low oxygen you need to eat food to pump more oxygen");
                    commandSender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "# " + ChatColor.AQUA + "On your screen. When you have been attacked, you will have notify to know.");
                    commandSender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "# " + ChatColor.AQUA + "Kill monster or dig making you have money!");
                    return true;
                }
                commandSender.sendMessage(ChatColor.RED + "/gshelp [vi/en]");
                commandSender.sendMessage(ChatColor.RED + "Language: vi / en");
            } else {
                commandSender.sendMessage(ChatColor.RED + "/gshelp [vi/en]");
                commandSender.sendMessage(ChatColor.RED + "Language: vi / en");
                return true;
            }
        }
        return true;
    }
}
