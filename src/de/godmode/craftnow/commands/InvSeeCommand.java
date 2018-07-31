package de.godmode.craftnow.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.godmode.craftnow.Main;

public class InvSeeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (cs instanceof Player) {
			Player p = (Player) cs;
			if (p.hasPermission("system.invsee") || p.hasPermission("system.*")) {
				if (args.length == 1) {
					Player t = Bukkit.getPlayer(args[0]);
					if (t.getName() == p.getName()) {
						p.sendMessage(Main.PREFIX + "§cDu kannst es nicht bei dir selbst ausf§hren!");
					} else {
						p.openInventory(t.getInventory());
						p.sendMessage(Main.PREFIX + "§aDu siehst nun das Inventar von §e" + t.getName());
					}
				} else
					p.sendMessage(Main.PREFIX + "§cBitte nutze §e/invsee <Spieler>");
			} else
				p.sendMessage(Main.PREFIX + "§cDazu hast du keine Rechte!");
		} else
			cs.sendMessage(Main.PREFIX + "§cDu bist kein Spieler");
		return false;
	}

}
