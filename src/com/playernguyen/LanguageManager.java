package com.playernguyen;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class LanguageManager {
    private File f = new File(Bukkit.getServer().getPluginManager().getPlugin(Properties.PLUGIN_NAME).getDataFolder(), "language.yml");
    private YamlConfiguration cf = YamlConfiguration.loadConfiguration(f);

    public static LanguageManager getInstance()
    {
        return new LanguageManager();
    }

    private void save()
    {
        try {
            cf.save(f);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void setPlayerLanguage(Player p, GalaxySurvivalLanguage lang)
    {
        cf.set(p+".language", lang.getDomain());
        cf.set(p+".uuid", p.getUniqueId().toString());
        save();
    }

    public GalaxySurvivalLanguage getPlayerLanguage(Player p)
    {
        return GalaxySurvivalLanguage.domainFrom((String) cf.get(p+".language"));
    }

}
