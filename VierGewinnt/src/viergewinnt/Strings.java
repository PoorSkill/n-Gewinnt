package viergewinnt;

import java.util.HashMap;
import java.util.Map;

/**
 * Ansammlung aller Strings zur einfachen Wartung/Bearbeitung und export in XML
 * 
 * @author Anton Kesy
 *
 */
public enum Strings {
	RULES("Spielregeln:"), SETUP_PLAYER_NAME("Bitte Name eingeben: \n");
	String content;

	/**
	 * Konstruktor
	 * 
	 * @param content
	 */
	Strings(String content) {
		this.content = content;
	}

	/**
	 * Ruft Objekte und Attribute per Index auf (noch keine Verwendung)
	 * 
	 * @param index
	 * @return enum Objekt
	 */
	public static Strings getStringByIndex(int index) {
		Map<Integer, Strings> getStringByIndex = new HashMap<>();
		getStringByIndex.put(0, RULES);
		getStringByIndex.put(1, SETUP_PLAYER_NAME);
		return getStringByIndex.get(index);
	}
}
