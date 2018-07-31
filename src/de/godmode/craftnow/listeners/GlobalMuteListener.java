package de.godmode.craftnow.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import de.godmode.craftnow.Main;
import de.godmode.craftnow.commands.GlobalMuteCommand;;

public class GlobalMuteListener implements Listener {

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		if (GlobalMuteCommand.globalmute) {
			if (e.getPlayer().hasPermission("system.globalmut.bypass") || e.getPlayer().hasPermission("system.*")) {
				return;
			}
			e.getPlayer().sendMessage(Main.PREFIX + "§7 Zuerzeit ist der Chat §4deaktiviert!");
			e.setCancelled(true);
		}
	}

}
