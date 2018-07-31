package de.godmode.craftnow.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.godmode.craftnow.Main;
import de.godmode.craftnow.listeners.ChatListener;

public class TeamChatCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (cs instanceof Player) {
			Player p = (Player) cs;
			if (p.hasPermission("system.tc")) {
				if (args.length >= 1) {

					String message = "";
					for (int i = 0; i < args.length; i++) {
						message += args[i] + " ";
					}

					for (Player all : Bukkit.getOnlinePlayers()) {
						if (!all.hasPermission("system.tc")) {
							return true;
						} else {
							all.sendMessage("§eTeamchat §7| §c" + p.getName() + " §7» " + message);
						}
					}
				} else
					p.sendMessage(Main.PREFIX + "§cBitte nutze §e/tc <Nachricht>");
			} else
				p.sendMessage(Main.PREFIX + "§cDazu hast du keine Rechte!");
		} else
			cs.sendMessage(Main.PREFIX + "§cDu bist kein Spieler!");
		return false;
	}

}
