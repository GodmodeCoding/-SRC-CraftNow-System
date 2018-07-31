package de.godmode.craftnow.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.craftbukkit.v1_8_R3.util.ShortConsoleLogFormatter;

public enum BanUnit {

	SECONDS("Sekunde(n)", 1, "s"), MINUTES("Minute(n)", 60, "m"), HOUR("Stunde(n)", 60 * 60, "h"), DAY("Tag(e)",
			24 * 60 * 60, "d"), WEEK("Woche(n)", 7 * 24 * 60 * 60, "w");

	private String name;
	private int toSeccond;
	private String shortcut;

	private BanUnit(String name, int toSeccond, String shortcut) {
		this.name = name;
		this.toSeccond = toSeccond;
		this.shortcut = shortcut;
	}

	public int getToSeccond() {
		return toSeccond;
	}

	public String getShortcut() {
		return shortcut;
	}

	public String getName() {
		return name;
	}

	public static List<String> getUnitAsString() {
		List<String> units = new ArrayList<String>();
		for (BanUnit unit : BanUnit.values()) {
			units.add(unit.getShortcut());
		}
		return units;
	}

	public static BanUnit getUnit(String unit) {
		for (BanUnit units : BanUnit.values()) {
			if (units.getShortcut().toLowerCase().equals(unit.toLowerCase()))
				;
			return units;
		}
		return null;
	}

}
