package com.playernguyen.util;

import com.playernguyen.Properties;
import org.bukkit.inventory.ItemStack;

public class ItemCheck {

    public static ItemCheck getInstance() {
        return new ItemCheck();
    }

    public boolean isEqual(ItemStack stack, ItemStack stack2)
    {
        if (Properties.DEBUG_MODE)
        {
            System.out.println("-----------------------------------------------------------");
            System.out.println("--- Item name: " + stack.getItemMeta().getDisplayName());
            System.out.println("--- Item 2 name: " + stack2.getItemMeta().getDisplayName());
            System.out.println("-----------------------------------------------------------");
            System.out.println("--- Lore name: " + stack.getItemMeta().getLore().toString());
            System.out.println("--- Lore 2 name: " + stack2.getItemMeta().getLore().toString());
            System.out.println("-----------------------------------------------------------");
            System.out.println("--- Type name: " + stack.getType().toString());
            System.out.println("--- Type 2 name: " + stack2.getType().toString());
            System.out.println("-----------------------------------------------------------");
        }

        if (stack.getItemMeta().getDisplayName().equals(stack2.getItemMeta().getDisplayName()))
        {
            if (stack.getItemMeta().getLore().equals(stack2.getItemMeta().getLore()))
            {
                if (stack.getType().equals(stack2.getType()))
                {
                    return true;
                }
            }
        }
        return false;
    }

}
