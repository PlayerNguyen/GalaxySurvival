package com.playernguyen.packet;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;

/**
 * Packet for create titles
 * Created by Player Nguyen
 * @author Player Nguyen
 */
public class TitlePacket {

    public static void createTitle(String title, String subtitle, CraftPlayer player) {
        PacketPlayOutTitle titles =
                new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, IChatBaseComponent.ChatSerializer.a("{text:\" " + title + "\"}"), 20, 40, 20);
        PacketPlayOutTitle subtitles =
                new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, IChatBaseComponent.ChatSerializer.a("{text:\"" + subtitle +"\"}"));

        player.getHandle().playerConnection.sendPacket(titles);
        player.getHandle().playerConnection.sendPacket(subtitles);
    }
    public static void createTitleWithColor(String title, ChatColor colorTitle, String subtitle, ChatColor colorSubTitle, CraftPlayer player)
    {
        String colorTitles = colorTitle.toString().toLowerCase();
        String colorSubTitles = colorSubTitle.toString().toLowerCase();
        PacketPlayOutTitle titles =
                new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, IChatBaseComponent.ChatSerializer.a("{text:\" " + title + "\",color:\""+ colorTitles +"\"}"), 20, 40, 20);
        PacketPlayOutTitle subtitles =
                new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, IChatBaseComponent.ChatSerializer.a("{text:\"" + subtitle +"\",color:\""+colorSubTitles+"\"}"));
        player.getHandle().playerConnection.sendPacket(titles);
        player.getHandle().playerConnection.sendPacket(subtitles);
    }
}
