package de.godmode.craftnow.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

	public static String ServerInhaber = "§4Inhaber §7| §4";
	public static String Moderator = "§6Mod §7| §6";
	public static String Builder = "§2Builder §7| §2";
	public static String Developer = "§3Dev §7| §3";
	public static String Admin = "§9Admin §7| §9";
	// public static String Bauleitung = "§2Builder §7| §2";
	public static String VIP = "§eVIP §7| §e";
	public static String Spieler = "§7Spieler | ";

	@EventHandler
	public static void onChat(AsyncPlayerChatEvent event) {
		Player player = (Player) event.getPlayer();
		String Msg = event.getMessage();

		Msg = Msg.replace("&", "§");

		if (player.hasPermission("group.serverleitung")) {
			event.setFormat(ServerInhaber + player.getName() + "§7 » §l" + Msg);
		} else if (player.hasPermission("group.moderator")) {
			event.setFormat(Moderator + player.getName() + "§7 » " + Msg);
		} else if (player.hasPermission("group.developer")) {
			event.setFormat(Developer + player.getName() + "§7 » " + Msg);
		} else if (player.hasPermission("group.builder")) {
			event.setFormat(Builder + player.getName() + "§7 » " + Msg);
			// } else if (player.hasPermission("group.bauleitung")) {
			// event.setFormat(Bauleitung + player.getName() + "§7 » " + Msg);
		} else if (player.hasPermission("group.premium")) {
			event.setFormat(VIP + player.getName() + "§7 » " + Msg);
		} else if (player.hasPermission("group.admin")) {
			event.setFormat(Admin + player.getName() + "§7 » " + Msg);
		} else if (player.hasPermission("group.player")) {
			player.setDisplayName(Spieler + player.getName() + "§7 » " + Msg);
		}

		if (player.hasPermission("group.serverleitung")) {
			player.setDisplayName(ServerInhaber + player.getName() + "§7 »");
		} else if (player.hasPermission("group.moderator")) {
			player.setDisplayName(Moderator + player.getName() + "§7 » ");
		} else if (player.hasPermission("group.developer")) {
			player.setDisplayName(Developer + player.getName() + "§7 » ");
		} else if (player.hasPermission("group.builder")) {
			player.setDisplayName(Builder + player.getName() + "§7 » ");
			// } else if (player.hasPermission("group.bauleitung")) {
			// player.setDisplayName(Bauleitung + player.getName() + "§7 » ");
		} else if (player.hasPermission("group.premium")) {
			player.setDisplayName(VIP + player.getName() + "§7 » ");
		} else if (player.hasPermission("group.admin")) {
			player.setDisplayName(Admin + player.getName() + "§7 » ");
		} else if (player.hasPermission("group.player")) {
			player.setDisplayName(Spieler + player.getName() + "§7 » ");
		}

	}

	public void getChatListener() {
		ChatListener ChatListener = this;
	}

}
