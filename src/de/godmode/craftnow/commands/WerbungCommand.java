package de.godmode.craftnow.commands;

import de.godmode.craftnow.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;

public class WerbungCommand implements CommandExecutor{


    public static File f = new File("plugins/CraftNow-System", "werbung.yml");
    public static YamlConfiguration cfg = new YamlConfiguration().loadConfiguration(f);


    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        if(cs instanceof Player) {
            Player p = (Player)cs;
            if(args.length == 0) {
                p.sendMessage(Main.PREFIX + "§eEinmal Werbung kostet 100 CraftCoins!");
                p.sendMessage(Main.PREFIX + "§eNutze dafür /werbung <DEINE WERBUNG!>");
            } else if(args.length >= 1) {

                    String message = "";
                    for (int i = 0; i < args.length; i++) {
                        message += args[i] + " ";
                    }
                    Bukkit.broadcastMessage(" ");
                    Bukkit.broadcastMessage("§d§lWERBUNG §7| §l" + message);
                    Bukkit.broadcastMessage(" ");
                    //SPIELER COINS ABZIEHEN!
                    cfg.set(p.getUniqueId() + ".cooldown", "used");

                }

        } else
            cs.sendMessage(Main.PREFIX + "§cDu bist kein Spieler");
        return false;
    }
}
