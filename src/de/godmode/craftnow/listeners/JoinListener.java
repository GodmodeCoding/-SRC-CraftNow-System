package de.godmode.craftnow.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import de.godmode.craftnow.Main;
import de.godmode.craftnow.utils.BanManager;
import de.godmode.craftnow.utils.TitleAPI;

public class JoinListener implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		e.setJoinMessage("§7Der Spieler §6" + p.getName() + " §7hat den Server betreten.");

		TitleAPI.sendTitle(p, 20, 20, 20, "§cCraftNow§eNET", "§aWillkommen " + p.getName());

		if (p.hasPermission("system.fly") || e.getPlayer().hasPermission("system.*")) {
			p.setAllowFlight(true);
			p.setFlying(true);
		}

		if (p.hasPermission("system.admin")) {
			p.setAllowFlight(true);
			p.setFlying(true);
			p.setFoodLevel(20);
			p.setHealth(20);
		}

		if (BanManager.isBanned(p.getUniqueId().toString())) {
			BanManager.unban(p.getUniqueId().toString());
		}

	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity().getPlayer();

	}

}
