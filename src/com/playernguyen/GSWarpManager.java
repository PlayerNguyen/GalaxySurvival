package com.playernguyen;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class GSWarpManager
{
    private File file = new File(Bukkit.getServer().getPluginManager().getPlugin(Properties.PLUGIN_NAME).getDataFolder(), "warp.yml");
    private YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

    public static GSWarpManager getInstance() {
        return new GSWarpManager();
    }

    public File getFile() {
        return file;
    }

    private YamlConfiguration getConfig() {
        return config;
    }

    public void setup()
    {
        if (!file.exists())
        {
            save();
        }
    }

    private void save()
    {
        try {
            config.save(file);
        } catch (IOException e) {
            System.out.println("Have an error when I save. Cause by " + e.getCause());
        }
    }

    public void addWarp(Location location)
    {
        double
                x       = location.getX(),
                y       = location.getY(),
                z       = location.getZ()
        ;
        String w = location.getWorld().getName();

        getConfig().set("warp.x", x);
        getConfig().set("warp.y", y);
        getConfig().set("warp.z", z);
        getConfig().set("warp.world", w);
        save();
    }

    public Location getWarp()
    {
        double
            x       = getConfig().getDouble("warp.x"),
            y       = getConfig().getDouble("warp.y"),
            z       = getConfig().getDouble("warp.z")
        ;


        World w = Bukkit.getWorld(getConfig().getString("warp.world"));

        return new Location(w, x, y, z);
    }
}
