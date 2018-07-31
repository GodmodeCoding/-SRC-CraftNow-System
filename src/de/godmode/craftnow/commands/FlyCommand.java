package de.godmode.craftnow.commands;

import de.godmode.craftnow.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        if(cs instanceof Player) {
            Player p = (Player)cs;
            if(p.hasPermission("system.fly") || p.hasPermission("system.*")) {
                    p.setFlying(true);
                    p.setAllowFlight(true);
                    p.sendMessage(Main.PREFIX + "§aDu kannst nun fliegen!");

            } else
                p.sendMessage(Main.PREFIX + "§cDazu hast du keine Rechte!");
        } else
            cs.sendMessage(Main.PREFIX + "§cDu bist kein Spieler!");
        return false;
    }
}
