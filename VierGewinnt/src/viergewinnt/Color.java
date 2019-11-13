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
	RED("red"), BLUE("blue");
	String name;

	/**
	 * Konstruktor
	 * 
	 * @param name
	 */
	Color(String name) {
		this.name = name;
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
