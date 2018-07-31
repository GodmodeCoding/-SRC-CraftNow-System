package de.godmode.craftnow.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.godmode.craftnow.*;

public class MessageCommand implements CommandExecutor {

	String message = "";

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player) cs;
		if (args.length >= 2) {
			Player target = Bukkit.getPlayer(args[0]);

			if (target != null) {
				for (int i = 1; i < args.length; i++) {

					message = message + args[i] + " ";

				}
				p.sendMessage(Main.msgprefix + "§c" + p.getName() + " §7»§c " + target.getName() + " §7» " + message);
				target.sendMessage(
						Main.msgprefix + "§c" + target.getName() + " §7»§c " + p.getName() + " §7» " + message);
				message = "";
			} else
				p.sendMessage(Main.PREFIX + "Dieser Spieler ist nicht online.");
		} else
			p.sendMessage(Main.PREFIX + "§cBitte nutze §6/msg <Spieler> <Nachricht>");

		return false;
	}

}
