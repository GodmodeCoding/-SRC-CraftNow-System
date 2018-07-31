package de.godmode.craftnow.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import coinsapi.api.CoinsAPI;
import de.godmode.craftnow.Main;

public class MoneyCommand implements CommandExecutor {

	private Main plugin;

	public MoneyCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {

		if (cs instanceof Player) {
			Player p = (Player) cs;

			// Money

			if (cmd.getName().equalsIgnoreCase("money") || cmd.getName().equalsIgnoreCase("craftcoins")
					|| cmd.getName().equalsIgnoreCase("coins")) {
				if (args.length == 0) {
					int coins = CoinsAPI.getCoins(p);
					p.sendMessage(Main.PREFIX + "§aDu hast §6" + coins + " §aCraftCoins.");
				} else if (args.length == 1) {
					Player t = Bukkit.getPlayer(args[0]);
					if (t != null) {
						int coins = CoinsAPI.getCoins(t);
						p.sendMessage(
								Main.PREFIX + "§aDer Spieler §6" + t.getDisplayName() + " §ahat §6" + coins + "§a.");
					} else
						p.sendMessage(Main.PREFIX + "§cDer Spieler ist nicht online!");
				}

				// Add Money

			} else if (cmd.getName().equalsIgnoreCase("addmoney") || cmd.getName().equalsIgnoreCase("addcraftcoins")
					|| cmd.getName().equalsIgnoreCase("addcoins")) {
				if (args.length == 2) {
					Player t = Bukkit.getPlayer(args[0]);
					if (t != null) {
						int addcoins = Integer.parseInt(args[1]);
						CoinsAPI.addCoins(t, addcoins);
						p.sendMessage(
								Main.PREFIX + "§aDu hast §r" + t.getDisplayName() + " §6" + addcoins + " §agegeben.");
						t.sendMessage(Main.PREFIX + "§aDu hast §6" + addcoins + " §avon §r" + t.getDisplayName()
								+ " §abekommen.");
					} else
						p.sendMessage(Main.PREFIX + "§cDer Spieler ist nicht online.");
				} else
					p.sendMessage(Main.PREFIX + "§cBitte nutze §e/addmoney <Spieler> <Menge>");
			}

			// set Money

			else if (cmd.getName().equalsIgnoreCase("setmoney") || cmd.getName().equalsIgnoreCase("setcraftcoins") || cmd.getName().equalsIgnoreCase("setcoins")) {
				if (args.length == 2) {
					Player t = Bukkit.getPlayer(args[0]);
					if (t != null) {
						int addcoins = Integer.parseInt(args[1]);
						CoinsAPI.addCoins(t, addcoins);
						p.sendMessage(
								Main.PREFIX + "§aDu hast den Kontostand von §r" + t.getDisplayName() + " §aauf §6" + addcoins + " §agesetzt.");
						t.sendMessage(Main.PREFIX + "§aDein Kontostand wurde von §r" + p.getDisplayName() + " §aauf §6" + addcoins + " §agesetzt.");
					} else
						p.sendMessage(Main.PREFIX + "§cDer Spieler ist nicht online.");
				} else
					p.sendMessage(Main.PREFIX + "§cBitte nutze §e/setmoney <Spieler> <Menge>");
			} 
			
			else if (cmd.getName().equalsIgnoreCase("removemoney") || cmd.getName().equalsIgnoreCase("removecraftcoins")
					|| cmd.getName().equalsIgnoreCase("removecoins")) {
				if (args.length == 2) {
					Player t = Bukkit.getPlayer(args[0]);
					if (t != null) {
						int addcoins = Integer.parseInt(args[1]);
						CoinsAPI.addCoins(t, addcoins);
						p.sendMessage(
								Main.PREFIX + "§aDu hast §r" + t.getDisplayName() + " §6" + addcoins + " §agel§scht.");
						t.sendMessage(Main.PREFIX + "§aDir wurden §6" + addcoins + " §avon §r" + t.getDisplayName()
								+ " §aentfernt.");
					} else
						p.sendMessage(Main.PREFIX + "§cDer Spieler ist nicht online.");
				} else
					p.sendMessage(Main.PREFIX + "§cBitte nutze §e/removemoney <Spieler> <Menge>");
			}
			
		}
		return false;
	}
}