package de.godmode.craftnow.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.godmode.craftnow.Main;

public class SimpleCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (cs instanceof Player) {
			Player p = (Player) cs;
			if (cmd.getName().equalsIgnoreCase("gm") || cmd.getName().equalsIgnoreCase("gamemode")) {
				if (p.hasPermission("system.gm") || p.hasPermission("system.*")) {
					if (args[0].equalsIgnoreCase("0")) {
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage(Main.PREFIX + "§aDu bist nun im §6Survival-Mode§a.");
					} else if (args[0].equalsIgnoreCase("1")) {
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage(Main.PREFIX + "§aDu bist nun im §6Creative-Mode§a.");
					} else if (args[0].equalsIgnoreCase("2")) {
						p.setGameMode(GameMode.ADVENTURE);
						p.sendMessage(Main.PREFIX + "§aDu bist nun im §6Adventure-Mode§a.");
					} else if (args[0].equalsIgnoreCase("3")) {
						p.setGameMode(GameMode.SPECTATOR);
						p.sendMessage(Main.PREFIX + "§aDu bist nun im §6Spectator-Mode§a.");
					}
				}
			}

		}
		return false;
	}

}
