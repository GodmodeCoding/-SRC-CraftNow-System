package de.godmode.craftnow.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;

import de.godmode.craftnow.Main;

public class MySQL {

	public static String username;
	public static String password;
	public static String host;
	public static String port;
	public static String database;
	public static Connection con;

	public static void connect() {
		if (!isConnect()) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username,
						password);
				Bukkit.getConsoleSender().sendMessage(Main.PREFIX + "§aMySQL-Verbindung aufgebaut!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close() {
		if (isConnect()) {
			try {
				con.close();
				Bukkit.getConsoleSender().sendMessage(Main.PREFIX + "§cMySQL-Verbindung getrennt!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean isConnect() {
		return con != null;
	}

	// Spielername, UUID, Ende, Grund

	public static void createTable() {
		if (isConnect()) {
			try {
				con.createStatement().executeUpdate(
						"CREATE TABLE IF NOT EXISTS BannedPlayers (Spielername VARCHAR(100), UUID VARCHAR(100), Ende VARCHAR(100), Grund VARCHAR(100))");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void update(String qry) {
		if (isConnect()) {
			try {
				con.createStatement().executeUpdate(qry);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static ResultSet getResult(String qry) {
		if (isConnect()) {
			try {
				return con.createStatement().executeQuery(qry);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
