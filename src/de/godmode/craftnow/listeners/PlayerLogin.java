package de.godmode.craftnow.listeners;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import de.godmode.craftnow.Main;
import de.godmode.craftnow.utils.BanManager;

public class PlayerLogin implements Listener {

	@EventHandler
	public void onLogin(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		if (BanManager.isBanned(p.getUniqueId().toString())) {
			long current = System.currentTimeMillis();
			long end = BanManager.getEnd(p.getUniqueId().toString());
			if (current < end) {
				e.disallow(Result.KICK_BANNED,
						"§cDu wurdest vom Server gebannt\n" + "\n" + "§3Grund: §e"
								+ BanManager.getReason(p.getUniqueId().toString()) + "\n" + "§3Verbleibende Zeit: §e"
								+ BanManager.getRemainingTime(p.getUniqueId().toString()) + "\n"
								+ "§cStelle einen Entbannungsantrag unter §ecraft-now.net");
			}
		}
	}

/**	@EventHandler
	public void onALogin(AsyncPlayerPreLoginEvent e) {
		if(Main.wartung = true) {
		for (OfflinePlayer op : Bukkit.getWhitelistedPlayers()) {
			if (!op.getName().equalsIgnoreCase(e.getName())) {
				e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, "§cWir sind derzeit in Wartungen!");
				return;
			}
		}
	}
	} **/
}
