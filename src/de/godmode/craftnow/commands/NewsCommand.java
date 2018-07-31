package de.godmode.craftnow.commands;

import de.godmode.craftnow.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NewsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        if(cs instanceof Player) {
            Player p = (Player)cs;
            if(p.hasPermission("news.member")) {
                if (args.length >= 1) {

                    String message = "";
                    for (int i = 0; i < args.length; i++) {
                        message += args[i] + " ";
                    }
                    Bukkit.broadcastMessage(" ");
                    Bukkit.broadcastMessage("§6§lNEWS §7| §l" + message);
                    Bukkit.broadcastMessage(" ");

                } else
                    p.sendMessage(Main.PREFIX + "§cBitte nutze §e/news <Nachricht>");
            } else
                p.sendMessage(Main.PREFIX + "§cDu bist leider kein News-Reporter!");
        } else
            cs.sendMessage(Main.PREFIX + "§cDu bist kein Spieler");
        return false;
    }
}
