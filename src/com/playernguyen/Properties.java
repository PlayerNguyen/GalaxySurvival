package com.playernguyen;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Properties {

    public static final String PLUGIN_NAME = "GalaxySurvival";

    public static final World WORLD_DEFAULT = Bukkit.getServer().getWorld(Bukkit.getServer().getPluginManager().getPlugin(PLUGIN_NAME).getConfig().getString("config.defaultWorld"));

    public static final boolean DEBUG_MODE = Bukkit.getServer().getPluginManager().getPlugin(PLUGIN_NAME).getConfig().getBoolean("config.debug");
    // TODO: 7/3/2016 Edit this code after work to false ___
    public static final boolean BETA_BUILD_DEVELOPER = false;

    public static final double DAMAGE_LOW_OXYGEN = Bukkit.getServer().getPluginManager().getPlugin(PLUGIN_NAME).getConfig().getDouble("config.damageLowOxygen");
    public static final double MAX_HIGH_CAN_FLY = Bukkit.getServer().getPluginManager().getPlugin(PLUGIN_NAME).getConfig().getDouble("config.maxCanFly");
    public static final double DAMAGE_FLY_TO_HIGH = Bukkit.getServer().getPluginManager().getPlugin(PLUGIN_NAME).getConfig().getDouble("config.damageFlyToHigh");

    private static final int SECOND_TO_DAMAGE_OXYGEN = 1;
    public static final int MIN_OXYGEN_TO_CAUTION = Bukkit.getServer().getPluginManager().getPlugin(PLUGIN_NAME).getConfig().getInt("config.minOxygenLevelToCaution");

    public static final double OXYGEN_DAMAGE_ANIMAL = Bukkit.getServer().getPluginManager().getPlugin(PLUGIN_NAME).getConfig().getDouble("config.damageAnimalLowOxygen");

    public static final int TICK_TO_DAMAGE_OXYGEN = SECOND_TO_DAMAGE_OXYGEN * 20;

    public static boolean isInGalaxyWorld(Player p)
    {
        return p.getWorld().getName().equals(WORLD_DEFAULT.getName());
    }

    public static ItemStack getReloadOxygenItem()
    {
        ItemStack stack = new ItemStack(Material.POTION);

        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "Oxygen");
        meta.addEnchant(Enchantment.OXYGEN, 1000, true);
        meta.setLore(Arrays.asList
                (
                        ChatColor.AQUA + "Press to reload Oxygen",
                        ChatColor. RED + "Cannot recycle"
                )
        );
        stack.setItemMeta(meta);
        return stack;
    }

}
