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
	RULES("Spielregeln:"), SETUP_PLAYER_NAME("Bitte Name eingeben: \n"), BOT_NAME("Bot"), COLOR_RED_NAME("red"),
	COLOR_BLUE_NAME("blue"), RUN_CHECK_QUESTION("Soll das Programm wiederholt werden? (y/n)"),
	PLAYER_NAME_INTRO("Player "), NEXT_MOVE("Wo soll der Stein als naechstes gesetzt werden?"),SPACER("-");
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
	 * setter von content
	 * 
	 * @return content des Objektes
	 */
	String getContent() {
		return this.content;
	}

	/**
	 * setter von content
	 * 
	 * @param newContent
	 */
	@SuppressWarnings("unused")
	private void setContent(String newContent) {
		this.content = newContent;
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
