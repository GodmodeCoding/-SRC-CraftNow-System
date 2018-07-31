package de.godmode.craftnow.commands;

import de.godmode.craftnow.Main;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {
	public boolean onCommand(CommandSender cs, Command cmd, String lable, String[] args) {
		Player p = (Player) cs;
		if (cmd.getName().equalsIgnoreCase("ping")) {
			if (args.length == 0) {
				FileConfiguration cfg = Main.getPlugin().getConfig();
				Location loc = p.getLocation();

				cfg.set("pingm", Double.valueOf(getPing(p)));

				p.sendMessage(Main.PREFIX + "§7Dein Ping betr§gt §a" + getPing(p) + "§7ms.");
			} else if (args.length == 1) {
				if (p.hasPermission("system.pingother") || p.hasPermission("system.*")) {
					Player target = Bukkit.getPlayer(args[0]);
					if (target != null) {
						FileConfiguration cfg = Main.getPlugin().getConfig();
						Location loc = p.getLocation();

						cfg.set("pingm", Double.valueOf(getPing(target)));

						p.sendMessage(Main.PREFIX + "§7Der Ping von " + target.getName() + " beträgt §a"
								+ getPing(target) + "§7ms.");
					} else
						p.sendMessage(Main.PREFIX + "§cDieser Spieler ist nicht online.");
				} else
					p.sendMessage(Main.PREFIX + "§cDazu hast du keine Rechte!");
			} else
				p.sendMessage(Main.PREFIX + "§cBitte nutze /ping | /ping <Spieler>");
		}
		return false;
	}

	public double getPing(Player p) {
		CraftPlayer pingc = (CraftPlayer) p;
		EntityPlayer pinge = pingc.getHandle();
		return pinge.ping;
	}
}