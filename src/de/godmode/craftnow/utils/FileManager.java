package de.godmode.craftnow.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.godmode.craftnow.Main;
import de.godmode.craftnow.mysql.MySQL;
import net.md_5.bungee.api.ChatColor;

public class FileManager {

	public static File getMySQLFile() {
		return new File("plugins/CraftNow-System", "mysql.yml");
	}

	public static FileConfiguration getMySQLFileConfiguration() {
		return YamlConfiguration.loadConfiguration(getMySQLFile());
	}

	public static void setStandardMySQL() {
		FileConfiguration cfg = getMySQLFileConfiguration();
		cfg.options().copyDefaults(true);
		cfg.addDefault("host", "127.0.0.1");
		cfg.addDefault("port", "3306");
		cfg.addDefault("database", "craftnow");
		cfg.addDefault("user", "root");
		cfg.addDefault("password", "passwortistgeil");
		try {
			cfg.save(getMySQLFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readMySQL() {
		FileConfiguration cfg = getMySQLFileConfiguration();

		MySQL.host = cfg.getString("host");
		MySQL.port = cfg.getString("port");
		MySQL.database = cfg.getString("database");
		MySQL.username = cfg.getString("user");
		MySQL.password = cfg.getString("password");
	}

}
