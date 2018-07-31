package de.godmode.craftnow.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.godmode.craftnow.Main;

public class ReportCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (cs instanceof Player) {
			Player p = (Player) cs;

			if (args.length == 2) {

				Player t = Bukkit.getPlayer(args[0]);

				if (t == null) {
					p.sendMessage(Main.PREFIX + "§cDer angegebene Spieler ist nicht Online!");

					return true;
				}

				if (args[0].equals(p.getName())) {

					p.sendMessage(Main.PREFIX + "§cDu kannst dich nicht selber reporten!");

					return true;
				}

				String s = "";

				for (int i = 1; i < args.length; i++) {
					s = s + args[i] + " ";
				}

				for (Player all : Bukkit.getOnlinePlayers()) {
					if (!all.hasPermission("system.team") || p.hasPermission("system.*")) {
						return true;
					} else {
						all.sendMessage("§c=-------REPORT-------=");
						all.sendMessage("");
						all.sendMessage("§7> Von: §e" + p.getName());
						all.sendMessage("§7> Gemeldeter Spieler: §e" + t.getName());
						all.sendMessage("§7> Grund: §e" + s);
						all.sendMessage("");
						all.sendMessage("§c=-------REPORT-------=");
					}

					p.sendMessage(Main.PREFIX + "§aDu hast §e" + t.getName() + " §areportet. Vielen Dank!");

				}
			} else
				p.sendMessage(Main.PREFIX + "§cBitte nutze §e/report <Spieler> <Grund>");
		}
		cs.sendMessage(Main.PREFIX + "§cDu bist kein Spieler!");
		return false;
	}

}
