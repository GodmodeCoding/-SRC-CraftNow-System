package de.godmode.craftnow.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.godmode.craftnow.Main;

public class ClearChatPrivatCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (cs instanceof Player) {
			Player p = (Player) cs;
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
			p.sendMessage(Main.PREFIX + "§aDu hast deinen Privaten Chat geleert.");

		} else
			cs.sendMessage(Main.PREFIX + "§cDu bist kein Spieler.");
		return false;
	}

}
