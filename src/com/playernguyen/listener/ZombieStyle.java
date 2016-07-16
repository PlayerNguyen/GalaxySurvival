package com.playernguyen.listener;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class ZombieStyle implements Listener{
    private void WearClothesForZombie(Zombie zombie)
    {
        LivingEntity e = (Zombie) zombie;
        e.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
    }
    @EventHandler
    public void ZombieSpawn(CreatureSpawnEvent e)
    {
        if (e.getEntityType() == EntityType.ZOMBIE)
        {
            WearClothesForZombie((Zombie) e.getEntity());
        }
    }
    @EventHandler
    public void ZombieDied(EntityDeathEvent e)
    {
        if (e.getEntityType() == EntityType.ZOMBIE)
        {
            int ranValue = new Random().nextInt(2);
            if (ranValue == 1) {e.getDrops().add(new ItemStack(Material.COAL));}
        }
    }

    private boolean RandomPercentage(int percent, int getvalue)
    {
        int calulate = (100/percent);
        Random rand = new Random();
        int value = rand.nextInt(calulate);
        System.out.println(value);
        if (value == getvalue)
        {

            return true;
        }
        return false;
    }
}
