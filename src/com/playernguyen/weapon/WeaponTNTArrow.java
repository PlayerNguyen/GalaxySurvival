package com.playernguyen.weapon;

import com.playernguyen.GalaxySurvival;
import com.playernguyen.Properties;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class WeaponTNTArrow implements Listener{

    private boolean start_optional_weapon = false;

    @EventHandler
    public void DropWeaponEvent(final PlayerDropItemEvent e)
    {
        Player p = e.getPlayer();
        if (e.getItemDrop().getItemStack().getType() == Material.TNT &&
                e.getItemDrop().getLocation().getWorld().equals(Properties.WORLD_DEFAULT))
        {
            e.getItemDrop().setPickupDelay(9999);
            new BukkitRunnable(){
                int tick = 0;
                public void run() {
                    tick++;
                    start_optional_weapon = true;
                    if (tick==40)
                    {
                        e.getItemDrop().setVelocity(new Vector(0, 1f, 0));
                    }

                    if (tick==60){

                        for (int is = 0;is<=e.getItemDrop().getItemStack().getAmount();is++){
                            for (int f = 0; f<=150; f++)
                            {
                                float degress = (float) (Math.random() * -5);
                                degress++;
                                Arrow arrow  = e.getItemDrop().getLocation().getWorld().spawn(e.getItemDrop().getLocation(), Arrow.class);
                                arrow.setVelocity(new Vector(
                                        Math.random() * 5 + degress,
                                        Math.random() * 5 + degress,
                                        Math.random() * 5 + degress));
                                arrow.setCritical(true);
                                arrow.setFireTicks(1500);

                            }
                        }
                    }
                    if (tick==100)
                    {
                        for (Entity en: e.getItemDrop().getLocation().getWorld().getEntitiesByClasses(Arrow.class))
                        {
                            en.getLocation().getWorld().createExplosion(en.getLocation(), 0.1f);
                        }
                    }
                    if (tick==120)
                    {
                        e.getItemDrop().remove();
                        for (Entity en: e.getItemDrop().getLocation().getWorld().getEntitiesByClasses(Arrow.class))
                        {
                            en.remove();
                        }
                        cancel();
                        start_optional_weapon = false;
                    }
                }
            }.runTaskTimer(GalaxySurvival.getGalaxy(), 1L, 1L);
        }
    }

    @EventHandler public void ProjectileShoot(EntityDamageByEntityEvent e)
    {
        if (e.getCause() == EntityDamageEvent.DamageCause.PROJECTILE)
        {
            if (e.getDamager() instanceof Snowball)
            {
                if (start_optional_weapon)
                {
                    e.setDamage(Math.random() * 5);
                }
            }
        }
    }

}
