package viergewinnt;

import java.util.HashMap;
import java.util.Map;

/**
 * Auflistung aller Farben mit den noetigen Informationen
 * 
 * @author Anton Kesy
 *
 */
public enum Color {
	RED(Strings.COLOR_RED_NAME.content, true), BLUE(Strings.COLOR_RED_NAME.content, true);
	String name;
	boolean free;

	/**
	 * Konstruktor
	 * 
	 * @param name
	 */
	Color(String name, boolean availability) {
		this.name = name;
		this.free = availability;
	}

	/**
	 * Ruft Objekte und Attribute per Index auf (noch keine Verwendung)
	 * 
	 * @param index
	 * @return enum Objekt
	 */
	public static Color getColorByIndex(int index) {
		Map<Integer, Color> getColorByIndex = new HashMap<>();
		getColorByIndex.put(0, RED);
		return getColorByIndex(index);
	}

}
