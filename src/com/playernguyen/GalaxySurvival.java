package com.playernguyen;

import com.playernguyen.command.GalaxySurvivalCommand;
import com.playernguyen.command.HelpGalaxySurvivalCommand;
import com.playernguyen.command.SetGalaxySurvivalCommand;
import com.playernguyen.listener.MobOxgenEvent;
import com.playernguyen.listener.OxyBarEvent;
import com.playernguyen.listener.PlayerEventClass;
import com.playernguyen.listener.ZombieStyle;
import com.playernguyen.weapon.WeaponTNTArrow;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class GalaxySurvival extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        log(ChatColor.GREEN + "-------------------");
        log(ChatColor.GREEN + "Loading core....");
        log(ChatColor.AQUA + "Loading core....DONE");
        log(ChatColor.GREEN + "Generator World...");
        log(ChatColor.AQUA + "Loading Generator World....DONE");
        log(ChatColor.GREEN+ "Loading Oxygen bar...");
        load(new OxyBarEvent());
        log(ChatColor.AQUA+ "Loading Oxygen bar...DONE");
        log(ChatColor.GREEN + "Loading enchantment...");
        log(ChatColor.AQUA + "Loading enchantment...DONE");
        log(ChatColor.GREEN + "-------------------");

        load(new PlayerEventClass());
        load(new ZombieStyle());

        load(new WeaponTNTArrow());

        load("gs", new GalaxySurvivalCommand());
        load("galaxysurvival", new GalaxySurvivalCommand());
        load("setgs", new SetGalaxySurvivalCommand());
        load("gshelp", new HelpGalaxySurvivalCommand());

        new BukkitRunnable(){

            int ticks;

            public void run() {
                ticks++;
                if (ticks == Properties.TICK_TO_DAMAGE_OXYGEN)
                {
                    for (Player player : getServer().getOnlinePlayers())
                    {
                        PlayerEventClass.executorPlayer(player);
                    }
                    for (Entity e : Properties.WORLD_DEFAULT.getEntities())
                    {
                        MobOxgenEvent.OnMobOxygen(e);
                    }
                    ticks=0;
                }
            }
        }.runTaskTimer(this, 1L, 1L);

    }

    private void load(Listener listener)
    {
        Bukkit.getServer().getPluginManager().registerEvents(listener, this);
    }
    private void log(String message)
    {
        Bukkit.getServer().getConsoleSender().sendMessage(message);
    }
    private void load(String command, CommandExecutor executor) {getCommand(command).setExecutor(executor);}
    public static Plugin getGalaxy() {return Bukkit.getServer().getPluginManager().getPlugin(Properties.PLUGIN_NAME);}
}