package de.godmode.craftnow;

import de.godmode.craftnow.commands.*;
import de.godmode.craftnow.smartphone.Guthaben;
import de.godmode.craftnow.smartphone.GuthabenListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import de.godmode.craftnow.listeners.ChatListener;
import de.godmode.craftnow.listeners.GlobalMuteListener;
import de.godmode.craftnow.listeners.JoinListener;
import de.godmode.craftnow.listeners.LeaveListener;
import de.godmode.craftnow.listeners.PlayerLogin;
import de.godmode.craftnow.listeners.TabListener;
import de.godmode.craftnow.mysql.MySQL;
import de.godmode.craftnow.utils.FileManager;
import de.godmode.craftnow.utils.License;

public class Main extends JavaPlugin {

	public static Main instance;
	public static String PREFIX = "§c§lSystem §7| ";
	public static String msgprefix = "§a§lNachricht §7| ";
	public static String lizenzkey = "O551-6XJQ-SZQG-UGJJ";

	public static boolean wartung = false;
	
	@Override
	public void onEnable() {
		instance = this;
//        if(!new License(Main.lizenzkey, "http://godmode-coding.de/Lizenz/verify.php", this).register()) return;

		Bukkit.getConsoleSender().sendMessage(" ");
		Bukkit.getConsoleSender().sendMessage("§2CraftNow - System");
		Bukkit.getConsoleSender().sendMessage(Main.PREFIX + "§aAKTIVIERT");
		Bukkit.getConsoleSender().sendMessage(" ");

		registerCommands();
		registerEvents();

		FileManager.setStandardMySQL();
		FileManager.readMySQL();
		loadConfig();

		MySQL.connect();
		MySQL.createTable();


	}

	@Override
	public void onDisable() {

		Bukkit.getConsoleSender().sendMessage(" ");
		Bukkit.getConsoleSender().sendMessage("§2CraftNow - System");
		Bukkit.getConsoleSender().sendMessage(Main.PREFIX + "§cDEAKTIVIERT");
		Bukkit.getConsoleSender().sendMessage(" ");

		MySQL.close();

	}

	public static Main getPlugin() {
		return instance;

	}

	public void registerCommands() {
		BanCommands banCMD = new BanCommands(this);
		getCommand("ban").setExecutor(banCMD);
		getCommand("unban").setExecutor(banCMD);
		getCommand("tempban").setExecutor(banCMD);
		getCommand("check").setExecutor(banCMD);

		ForumCommand infoCMD = new ForumCommand(this);
		getCommand("ts").setExecutor(infoCMD);
		getCommand("teamspeak").setExecutor(infoCMD);
		getCommand("website").setExecutor(infoCMD);
		getCommand("forum").setExecutor(infoCMD);

		getCommand("heal").setExecutor(new HealCommand());
		getCommand("feed").setExecutor(new HealCommand());
		getCommand("ccp").setExecutor(new ClearChatPrivatCommand());
		getCommand("cc").setExecutor(new ClearChatCommand());
		getCommand("ping").setExecutor(new PingCommand());
		getCommand("globalmute").setExecutor(new GlobalMuteCommand());
		getCommand("report").setExecutor(new ReportCommand());
		getCommand("gm").setExecutor(new SimpleCommands());
//		getCommand("gamemode").setExecutor(new SimpleCommands());
		getCommand("tc").setExecutor(new TeamChatCommand());
		getCommand("invsee").setExecutor(new InvSeeCommand());
		getCommand("msg").setExecutor(new MessageCommand());
		getCommand("bc").setExecutor(new BroadcastCommand());
		getCommand("news").setExecutor(new NewsCommand());
		getCommand("werbung").setExecutor(new WerbungCommand());

	}

	public void registerEvents() {
		this.getServer().getPluginManager().registerEvents(new JoinListener(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerLogin(), this);
		this.getServer().getPluginManager().registerEvents(new ChatListener(), this);
		this.getServer().getPluginManager().registerEvents(new GlobalMuteListener(), this);
		this.getServer().getPluginManager().registerEvents(new TabListener(), this);
		this.getServer().getPluginManager().registerEvents(new LeaveListener(), this);
		this.getServer().getPluginManager().registerEvents(new GuthabenListener(), this);
	}

	public void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
}
