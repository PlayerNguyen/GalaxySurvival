package com.playernguyen.listener;

import com.playernguyen.Properties;
import com.playernguyen.packet.TitlePacket;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerEventClass  implements Listener {

    public static void executorPlayer(Player p) {
        if (p.getInventory().getHelmet() == null && p.getPlayer().getGameMode() == GameMode.SURVIVAL && Properties.isInGalaxyWorld(p) && p.getLocation().add(0, -1, 0).getBlock().getType() != Material.IRON_BLOCK) {
            TitlePacket.createTitle(ChatColor.RED + "Low Oxygen", "Wear your helmet now!!", (CraftPlayer) p);
            p.damage(Properties.DAMAGE_LOW_OXYGEN);
        }
        if (p.getLocation().getY() > p.getWorld().getHighestBlockYAt(p.getLocation()) + Properties.MAX_HIGH_CAN_FLY && p.getGameMode() == GameMode.SURVIVAL && Properties.isInGalaxyWorld(p)) {
            if (Properties.DEBUG_MODE) {
                // Detect Y
                System.out.print("------- | " + p.getWorld().getHighestBlockAt(p.getLocation()).getType() + " | " + p.getLocation().getY());
            }

            p.damage(Properties.DAMAGE_FLY_TO_HIGH);
            TitlePacket.createTitle(ChatColor.RED + "Low Pressure", "You're flying so high", (CraftPlayer) p);
        }
    }

    @EventHandler
    public void PlayerConnectToServer(PlayerJoinEvent e) {
        if (e.getPlayer().getGameMode() == GameMode.SURVIVAL && Properties.isInGalaxyWorld(e.getPlayer())) {
            Player p = e.getPlayer();
//            p.setAllowFlight(false);
//            p.setFlying(false);
            p.setFlySpeed(0.1f);
            if (Properties.DEBUG_MODE) {
                System.out.println("--- " + e.getPlayer().getName() + " | " + e.getPlayer().getAllowFlight());
            }
        }
    }

    @EventHandler
    public void PlayerRespawn(PlayerRespawnEvent e) {
        if (Properties.DEBUG_MODE) {
            System.out.println("--- " + e.getPlayer().getName() + " respawn and add helmet.");
        }
        e.getPlayer().getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
    }

    @EventHandler
    public void PlayerDamagerEvent(EntityDamageByEntityEvent e)
    {
        if (e.getEntity() instanceof Player)
        {
            Player p = (Player) e.getEntity();
            TitlePacket.createTitle(ChatColor.RED + "Warning", "You've been attacked!", (CraftPlayer) p);

        }
    }

    // @EventHandler
    public void PlayerMoveOnSand(PlayerMoveEvent e)
    {
        Player p = e.getPlayer();

        if (p.getLocation().add(0, -1, 0).getBlock().getType() == Material.SAND
                && Properties.isInGalaxyWorld(p)
                && p.getPlayer().getInventory().getBoots() == null
                && p.getGameMode() == GameMode.SURVIVAL)
        {
            if (p.isSprinting())
            {
                p.setSprinting(false);
            }

            p.setWalkSpeed(0.11f);
        }
        else {
            p.setWalkSpeed(0.2f);
        }
    }

    @EventHandler
    public void PlayerChatEvents(AsyncPlayerChatEvent event)
    {
        event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.NOTE_PIANO, 1, 1);
    }

}
