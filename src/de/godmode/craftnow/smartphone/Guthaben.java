package de.godmode.craftnow.smartphone;

import de.godmode.craftnow.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Guthaben implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {

        if (cs instanceof Player) {
            Player p = (Player) cs;
            if (args.length == 0) {

                Inventory inv = Bukkit.createInventory(null, 9, "§6Guthaben kaufen");

                ItemStack spawn = new ItemStack(Material.PAPER);
                ItemMeta spawnmeta = spawn.getItemMeta();
                spawnmeta.setDisplayName("§3Guthaben §a10 CC");
                boolean b = spawn.setItemMeta(spawnmeta);

                ItemStack spiel1 = new ItemStack(Material.PAPER);
                ItemMeta spiel1meta = spiel1.getItemMeta();
                spiel1meta.setDisplayName("§3Guthaben §a20 CC");
                spiel1.setItemMeta(spiel1meta);

                ItemStack spiel2 = new ItemStack(Material.PAPER);
                ItemMeta spiel2meta = spiel2.getItemMeta();
                spiel2meta.setDisplayName("§3Guthaben §a50 CC");
                spiel2.setItemMeta(spiel2meta);

                inv.setItem(4, spiel1);
                inv.setItem(0, spawn);
                inv.setItem(8, spiel2);

                p.openInventory(inv);


            } else
                p.sendMessage(Main.PREFIX + "§cBitte nutze §e/guthaben");

        } else
            cs.sendMessage(Main.PREFIX + "§cDu bist kein Spieler!");

        return false;
    }
}
