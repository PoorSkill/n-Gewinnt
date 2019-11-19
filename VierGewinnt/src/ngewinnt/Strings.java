package ngewinnt;

import java.util.ArrayList;
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
	COLOR_BLUE_NAME("blue"), COLOR_GREEN_NAME("green"), COLOR_ORANGE_NAME("orange"),
	RUN_CHECK_QUESTION("Soll das Programm wiederholt werden? (y/n)"), PLAYER_NAME_INTRO("Player "),
	NEXT_MOVE("Wo soll der Stein als naechstes gesetzt werden?"), SPACER("-"),
	NOT_A_COORDINATE("Nicht auf dem Koordinatensystem\nVersuche es erneut:"),
	SINGLEPLAYER_QUESTION("Einzelspieler? (y/n)"), PLEASE_INSERT_NAME("Bitte gebe deinen Namen ein:\n"),
	CHANGE_RULES_START(
			"Welche Regeln wollen sie aendern?\n(1):Punkteanzahl zum gewinnen\n(2):Spieler\n(3)Sprache\n\n(e):Verlassen der Einstellungen"),
	UNKOWN_INPUT("Unbekannter Eingang!"), TRY_AGAIN("Versuchen sie es erneut"), YOU_PICKED("Sie waehlten aus: "),
	HOW_MANY_POINTS("Wie viele Punkte wollen sie zum gewinnen benoetigen?"),
	NUMBER_CANT_BE_HIGHER_THAN_GAMEFIELD_SIZE("Punktzahl kann nicht groesser sein wie das Spielfeld"),
	WANNA_CHANGE_RULES("Wollen sie Regeln aendern?(y/n)"),
	CHOOSE_COLOR("Wahele eine Farbe aus!\n(b)lau,(r)ot,(g)ruen,(o)range"), NOT_FREE("Ihre Auswahl ist nicht frei!"),
	SUCCESSFULLY_PICKED("Erfolgfreich ausgewahlt: "), PLAYER_GOT_POINTS(" hat Punkte erzielt: "),
	NUMBER_NEEDS_TO_BE_HIGHER("Die Zahl muss groesser sein!");
	String content;

	static String[] possibleAnswersOfYes = { "y", "1", "yes", "true", "ja", "weiter", "ye", "ya" }; // Array fuer
	// moegliche
	// Antworten auf
	// "Ja"
	static String[] possibleAnswersOfNo = { "n", "0", "no", "false", "nein", "stop", "nah", "na" }; // Array fuer
	// moegliche
	// Antworten auf
	// "Nein"
	static String[] usedNames = { "Bot", "Guy", "platzhalter0", "platzhalter1" }; // Array aus besetzten Namen fuer den
																					// Spieler TODO: in Liste umwandeln

	static ArrayList<String> usedNamesList = new ArrayList<>(); // Namelist der nicht freien Spielernamen

	static String[] xCordsIdentifiers = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
			"P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" }; // xKoordinaten Identifizierer

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

	/**
	 * Fuegt neue Namen fuer der usedNamesList hinzu TODO: in Liste umwandeln
	 * 
	 * @param newName
	 */
	public static void addUsedName(String newName) {
		usedNamesList.add("Bot");
		usedNamesList.add("Guy");
		usedNamesList.add(newName);
	}

	/**
	 * Entfernt Namen aus usedNamesList TODO: in Liste umwandeln
	 * 
	 * @param removeName
	 */
	public void removeUsedName(String removeName) {
		usedNamesList.remove(removeName);
	}

}
