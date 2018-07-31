package de.godmode.craftnow.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import de.godmode.craftnow.Main;

public class TrashCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (cs instanceof Player) {
			Player p = (Player) cs;
			if (args.length == 0) {

				Inventory inv = Bukkit.createInventory(null, 9 * 3, "§l§6M§lleimer");
				p.openInventory(inv);
				p.sendMessage(Main.PREFIX + "§aM§lleimer erfolgreich ge§ffnet.");

			} else
				p.sendMessage(Main.PREFIX + "§cBitte benutze /trash!");

		}
		return false;
	}

}
