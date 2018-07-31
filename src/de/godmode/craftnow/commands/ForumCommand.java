package de.godmode.craftnow.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.godmode.craftnow.Main;

public class ForumCommand implements CommandExecutor {

	private Main plugin;

	public ForumCommand(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("website") || cmd.getName().equalsIgnoreCase("web")) {
			cs.sendMessage(" ");
			cs.sendMessage(Main.PREFIX + "§eUnsere Website: §acraft-now.net");
			cs.sendMessage(" ");
		}

		if (cmd.getName().equalsIgnoreCase("forum")) {
			cs.sendMessage(" ");
			cs.sendMessage(Main.PREFIX + "§eUnser Forum: §acraft-now.net");
			cs.sendMessage(" ");
		}

		if (cmd.getName().equalsIgnoreCase("ts") || cmd.getName().equalsIgnoreCase("teamspeak")) {
			cs.sendMessage(" ");
			cs.sendMessage(Main.PREFIX + "§eUnser TeamSpeak: §acraft-now.net");
			cs.sendMessage(" ");
		}

		return false;
	}

}
