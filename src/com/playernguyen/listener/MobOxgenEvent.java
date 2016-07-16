package com.playernguyen.listener;

import com.playernguyen.Properties;
import net.minecraft.server.v1_8_R3.EntityLiving;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;

public class MobOxgenEvent implements Listener {

    /**
     *
     * @param entity Entity Privets
     */
    public static void OnMobOxygen(Entity entity)
    {
        if (entity instanceof Sheep || entity instanceof Cow || entity instanceof Rabbit || entity instanceof Chicken || entity instanceof Horse || entity instanceof  Pig || entity instanceof Ocelot)
        {
            if (entity.getLocation().add(0, -1 , 0).getBlock().getType() != Material.IRON_BLOCK)
            {
                Damageable d = (Damageable) entity;
                d.damage(Properties.OXYGEN_DAMAGE_ANIMAL);
                d.setCustomNameVisible(true);
                d.setCustomName(ChatColor.RED + "Warning: Animal Low Oxygen");
            }
            else {
                entity.setCustomNameVisible(false);
                entity.setCustomName(entity.getType().toString());
            }
        }
    }
}
