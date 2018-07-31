package de.godmode.craftnow.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.godmode.craftnow.Main;

public class GlobalMuteCommand implements CommandExecutor {

	public static boolean globalmute = true;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Main.PREFIX + "§cDu musst ein Spieler sein!");
		} else {
			Player p = (Player) sender;

			if (!(p.hasPermission("system.globalmute") || p.hasPermission("system.*"))) {
				p.sendMessage(Main.PREFIX + "§4 Dazu hast du keine Rechte!");
				return true;
			}
			if (globalmute) {
				globalmute = false;
				p.sendMessage(Main.PREFIX + "§7Der Chat wurde von §e" + sender.getName() + " §aaktiviert!");
			} else {
				globalmute = true;
				p.sendMessage(Main.PREFIX + "§7Der Chat wurde von §e" + sender.getName() + " §4deaktiviert!");
			}

		}

		return true;

	}
}