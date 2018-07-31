package de.godmode.craftnow.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.godmode.craftnow.Main;

public class ClearChatCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {

		if (cs instanceof Player) {
			Player p = (Player) cs;
			if (p.hasPermission("system.admin") || p.hasPermission("system.cc") || p.hasPermission("system.*")) {
				if (args.length == 0) {

					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(" ");
					Bukkit.broadcastMessage(Main.PREFIX + "§cDer Chat wurde von §6" + p.getName() + " " + "§cgeleert.");
					p.sendMessage(Main.PREFIX + "§aDu hast deinen Chat geleert.");
				} else
					p.sendMessage(Main.PREFIX + "§cNutze /cc");
			} else
				p.sendMessage(Main.PREFIX + "§cDazu hast du keine Rechte!");
		} else
			cs.sendMessage(Main.PREFIX + "§cDu bist kein Spieler!");

		return false;
	}

}
