package com.playernguyen.enchant;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Field;


public class OxyregenEnchant extends EnchantmentWrapper {

    private static Enchantment oxyGlow;

    public OxyregenEnchant(int id) {
        super(id);
    }

    @Override
    public String getName() {
        return "Oxyregen";
    }

    @Override
    public int getMaxLevel() {
        return 100;
    }

    @Override
    public boolean conflictsWith(Enchantment other) {
        return false;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return null;
    }
    @Override
    public boolean canEnchantItem(ItemStack item)
    {
        return false;
    }

    @Override
    public int getStartLevel()
    {
        return 1;
    }

    public static Enchantment getOxyregen()
    {
        if (oxyGlow != null) return oxyGlow;

        if(Enchantment.getByName("Oxyregen") != null)
            return Enchantment.getByName("Glow");

        try
        {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        oxyGlow = new OxyregenEnchant(255);
        Enchantment.registerEnchantment(oxyGlow);
        return oxyGlow;
    }

    public static ItemStack addOxyregen(ItemStack item)
    {
        Enchantment glow = getOxyregen();

        if(!item.containsEnchantment(glow))
            item.addUnsafeEnchantment(glow, 1);

        return item;
    }

    public static ItemStack removeOxyregen(ItemStack item)
    {
        Enchantment glow = getOxyregen();

        if(item.containsEnchantment(glow))
            item.removeEnchantment(glow);

        return item;
    }
}
