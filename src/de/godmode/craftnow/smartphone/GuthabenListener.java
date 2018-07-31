package de.godmode.craftnow.smartphone;

import de.godmode.craftnow.Main;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GuthabenListener implements Listener {

    public void onInteract(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if (e.getInventory().getName().equalsIgnoreCase("§6Guthaben kaufen")) {
            try {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Guthaben §a10 CC")) {
                    p.sendMessage(Main.PREFIX + "§eDu hast nun 10 CraftCoins Guthaben bekommen!");
                    e.getView().close();
                    e.setCancelled(true);
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Guthaben §a20 CC")) {
                    p.sendMessage(Main.PREFIX + "§eDu hast nun 20 CraftCoins Guthaben bekommen!");
                    e.getView().close();
                    e.setCancelled(true);
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Guthaben §a50 CC")) {
                    p.sendMessage(Main.PREFIX + "§eDu hast nun 50 CraftCoins Guthaben bekommen!");
                    e.getView().close();
                    e.setCancelled(true);
                }
            } catch (Exception ex) {
            }
        }
    }


}
