package com.playernguyen.listener;

import com.playernguyen.Properties;
import com.playernguyen.packet.TitlePacket;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class OxyBarEvent implements Listener {

    @EventHandler public void OxygenChangeEvent(FoodLevelChangeEvent e)
    {
        if (Properties.DEBUG_MODE) {
            System.out.print("--- " + e.getEntity().getName() + " | " + e.getFoodLevel());
            e.getEntity().sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD +"----------");
            e.getEntity().sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "Oxygen: " + String.valueOf(e.getFoodLevel()));
            e.getEntity().sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD +"----------");
            e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.NOTE_PIANO
                    , 1, 15);
        }
        ProcessLowOxygen((Player) e.getEntity());
    }

    public void ProcessLowOxygen(Player player)
    {
        if (player.getFoodLevel() <= Properties.MIN_OXYGEN_TO_CAUTION)
        {
            TitlePacket.createTitle(ChatColor.RED + "Low Oxygen", "Your oxygen is decreasing to dangerously" , (CraftPlayer) player);

            player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD +"----------");
            player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "Oxygen: " + String.valueOf(player.getFoodLevel()));
            player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD +"----------");
        }
        if (player.getFoodLevel() <= 20)
        {

        }
    }

    public void ReloadOxygen(PlayerInteractEvent e)
    {
        Player p = e.getPlayer();
        if (Properties.DEBUG_MODE)
        {
            System.out.println("--- Has Oxygen: " + p.getItemInHand().getItemMeta().hasEnchant(Enchantment.OXYGEN) + " | ");
            System.out.println("--- Level: " + p.getInventory().getItemInHand().getEnchantmentLevel(Enchantment.OXYGEN) + "|");
            System.out.println("--- Name: " + p.getItemInHand().getItemMeta().getDisplayName() + " | ");
        }

        if (p.getItemInHand().getItemMeta().hasEnchant(Enchantment.OXYGEN)&&p.getInventory().getItemInHand().getEnchantmentLevel(Enchantment.OXYGEN) == 1000&&p.getDisplayName().equals(Properties.getReloadOxygenItem().getItemMeta().getDisplayName()))
        {
            e.getPlayer().setFoodLevel(20);
        }
    }

    @EventHandler public void CommandPlayer(AsyncPlayerChatEvent e)
    {
        if (Properties.DEBUG_MODE && Properties.BETA_BUILD_DEVELOPER)
        {
            if (e.getMessage().contains("!wand"))
            {
                e.getPlayer().getInventory().addItem(Properties.getReloadOxygenItem());
                e.getPlayer().sendMessage(ChatColor.RED + "Give to you 1 Oxygen!");
                System.out.println("--- " + Properties.getReloadOxygenItem() + " ||| " + e.getPlayer() + " in hand " + e.getPlayer().getItemInHand());
            }
            if (e.getMessage().contains("!enchant"))
            {
                ItemStack s = e.getPlayer().getItemInHand();

                e.getPlayer().updateInventory();
            }
            if (e.getMessage().contains("!return"))
            {
                e.getPlayer().setFlySpeed(1f);
                e.getPlayer().getActivePotionEffects().clear();

                e.getPlayer().sendMessage("Return all");
            }
        }
    }
}
