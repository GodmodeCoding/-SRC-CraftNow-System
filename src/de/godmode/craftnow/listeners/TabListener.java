package de.godmode.craftnow.listeners;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;

public class TabListener implements Listener {

	public void sendTablistHeaderAndFooter(Player p, String header, String footer) {
		if (header == null)
			header = "";
		if (footer == null)
			footer = "";

		IChatBaseComponent tabHeader = ChatSerializer.a("{\"text\":\"" + header + "\"}");
		IChatBaseComponent tabFooter = ChatSerializer.a("{\"text\":\"" + footer + "\"}");

		PacketPlayOutPlayerListHeaderFooter headerPacket = new PacketPlayOutPlayerListHeaderFooter(tabHeader);
		try {
			Field field = headerPacket.getClass().getDeclaredField("b");
			field.setAccessible(true);
			field.set(headerPacket, tabFooter);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(headerPacket);
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		for (Player all : Bukkit.getOnlinePlayers()) {

			sendTablistHeaderAndFooter(all,
					"\n" + "§cCraftNow§eNET" + "\n" + " §7» §aKreiere jetzt deine eigene kleine Welt! §7«" + "\n",

					"\n" + "§3Website: §acraft-now.net §7| §3TeamSpeak: §acraft-now.net" + "\n");
		}
	}


}
