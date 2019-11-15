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
	RED(Strings.COLOR_RED_NAME.content, true, 'r'), BLUE(Strings.COLOR_RED_NAME.content, true, 'b');
	String name;
	boolean free;
	char shortTerm;

	/**
	 * Konstruktor
	 * 
	 * @param name
	 */
	Color(String name, boolean availability, char shortTerm) {
		this.name = name;
		this.free = availability;
		this.shortTerm = shortTerm;
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
