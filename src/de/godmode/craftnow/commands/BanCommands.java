package de.godmode.craftnow.commands;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.godmode.craftnow.Main;
import de.godmode.craftnow.utils.BanManager;
import de.godmode.craftnow.utils.BanUnit;

public class BanCommands implements CommandExecutor {

	private Main plugin;

	public BanCommands(Main plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("system.admin") || p.hasPermission("system.*")) {

				if (cmd.getName().equalsIgnoreCase("ban")) {
					if (args.length >= 2) {

						String playername = args[0];
						if (BanManager.isBanned(getUUID(playername))) {
							p.sendMessage(Main.PREFIX + "§cDieser Spieler ist bereits gebannt!");
						}
						String reason = "";

						for (int i = 1; i < args.length; i++) {
							reason += args[i] + " ";
						}

						BanManager.ban(getUUID(playername), playername, reason, -1);
						p.sendMessage(Main.PREFIX + "§7Du hast §e" + playername + " §7f§r §e'" + reason
								+ "' §4PERMANENT §7gebannt.");

						return true;
					} else
						p.sendMessage(Main.PREFIX + "§cBitte nutze §e/ban <Spieler> <Grund>");
					return true;
				}

				if (cmd.getName().equalsIgnoreCase("tempban")) {
					if (args.length >= 4) {
						String playername = args[0];

						if (BanManager.isBanned(getUUID(playername))) {
							p.sendMessage(Main.PREFIX + "§cDieser Spieler ist bereits gebannt!");
						}

						int value;
						try {
							value = Integer.valueOf(args[1]);
						} catch (NumberFormatException e) {
							p.sendMessage(Main.PREFIX + "§cZahl muss eine Zahl sein :) ");
							return true;
						}

						String reason = "";
						for (int i = 3; i < args.length; i++) {
							reason += args[i] + " ";
						}

						String unitString = args[2];

						List<String> unitList = BanUnit.getUnitAsString();

						if (unitList.contains(unitString.toLowerCase())) {
							BanUnit unit = BanUnit.getUnit(unitString);
							int seconds = value * unit.getToSeccond();
							BanManager.ban(getUUID(playername), playername, reason, seconds);
							p.sendMessage(Main.PREFIX + "§7Du hast §e" + playername + " §7f§r §e" + value
									+ unit.getName() + " §7wegen §e" + reason + " §7gebannt.");
							return true;
						}
						p.sendMessage(Main.PREFIX + "§cDiese Einheit exestiert nicht!");
						p.sendMessage(Main.PREFIX
								+ "§eEinheiten: §aMinuten = m, Wochen = w, Sekunden = s, Tage = d, Stunden = h");

						return true;
					} else
						p.sendMessage(Main.PREFIX + "§cBitte nutze §e/tempban <Spieler> <Zahl> <Einheit> <Grund>");
				}

				if (cmd.getName().equalsIgnoreCase("check")) {
					if (args.length == 1) {
						if (args[0].equalsIgnoreCase("list")) {
							List<String> list = BanManager.getBannedPlayers();
							if (list.size() == 0) {
								p.sendMessage(Main.PREFIX + "§cDerzeit ist kein Spieler gebannt.");
							}
							p.sendMessage("§7---------- §6§lBan-Liste §7----------");
							for (String allBanned : BanManager.getBannedPlayers()) {
								p.sendMessage("§e" + allBanned + " §7(Grund: §c"
										+ BanManager.getReason(getUUID(allBanned)) + "§7)");
							}
						} else {
							String playername = args[0];
							p.sendMessage("§7---------- §6§lBan-Info §7----------");
							p.sendMessage("§eName: §r" + playername);
							p.sendMessage(
									"§eGebannt: §r" + (BanManager.isBanned(getUUID(playername)) ? "§aJa" : "§cNein"));
							if (BanManager.isBanned(getUUID(playername))) {
								p.sendMessage("§eGrund: §r" + BanManager.getReason(getUUID(playername)));
								p.sendMessage("§eVerbleibende Zeit: §r" + BanManager.getEnd(getUUID(playername)));
							}
						}
						return true;
					}
					p.sendMessage(Main.PREFIX + "§cBitte Nutze /check <Spieler / List>");
				}

				if (cmd.getName().equalsIgnoreCase("unban")) {
					if (args.length == 1) {
						String playername = args[0];
						if (BanManager.isBanned(getUUID(playername))) {
							BanManager.unban(getUUID(playername));
							p.sendMessage("§aDu hast §e" + playername + " §aentbannt.");
							return true;
						} else
							p.sendMessage(Main.PREFIX + "§cDer Spieler ist nicht gebannt.");
					} else
						p.sendMessage(Main.PREFIX + "§cBitte Nutze §e/unban <Spieler>");
				}
			}
		}
		return true;
	}

	@SuppressWarnings("deprecation")
	private String getUUID(String playername) {
		return Bukkit.getOfflinePlayer(playername).getUniqueId().toString();
	}

}
