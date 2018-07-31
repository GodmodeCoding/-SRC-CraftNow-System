package de.godmode.craftnow.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.godmode.craftnow.Main;

public class HealCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (cs instanceof Player) {
			Player p = (Player) cs;
			if (cmd.getName().equalsIgnoreCase("heal") || p.hasPermission("system.*")) {
				if (p.hasPermission("system.heal")) {
					p.setHealth(20);
					p.sendMessage(Main.PREFIX + "§aDu hast nun wieder volles Leben!");
				} else
					p.sendMessage(Main.PREFIX + "§cDazu hast du keine Rechte!");
			}
			if (cmd.getName().equalsIgnoreCase("feed")) {
				if (p.hasPermission("system.feed") || p.hasPermission("system.*")) {
					p.setFoodLevel(20);
					p.sendMessage(Main.PREFIX + "§aDu hast nun wieder volles Essen!");
				} else
					p.sendMessage(Main.PREFIX + "§cDazu hast du keine Rechte!");
			}

		} else
			cs.sendMessage(Main.PREFIX + "§cDu bist kein Spieler.");

		return false;
	}

}
