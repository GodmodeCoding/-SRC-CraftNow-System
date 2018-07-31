package de.godmode.craftnow.utils;


import de.godmode.craftnow.commands.WerbungCommand;
import me.Tomekk.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class WerbungManager {

    public static void Timer() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {

                WerbungCommand.cfg.set(p.getUniqueId() + ".cooldown", "unused");

            }
        }, 0, 20*60);
    }

}
