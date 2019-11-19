package ngewinnt;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Auflistung aller Farben mit den noetigen Informationen
 * 
 * @author Anton Kesy
 *
 */
public enum Color {
	RED(Strings.COLOR_RED_NAME.content, true, 'r'), BLUE(Strings.COLOR_BLUE_NAME.content, true, 'b'),
	GREEN(Strings.COLOR_GREEN_NAME.content, true, 'g'), ORANGE(Strings.COLOR_ORANGE_NAME.content, true, 'o');
	String name; // name der Farbe
	boolean free; // true ist frei
	char shortTerm; // Abkuerzung der Farbe

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
		getColorByIndex.put(1, BLUE);
		getColorByIndex.put(2, GREEN);
		return getColorByIndex(index);
	}

	/**
	 * setter von name
	 * 
	 * @param newName
	 * @return
	 */
	String getName() {
		return this.name;
	}

	/**
	 * getter von name
	 * 
	 * @param newName
	 */
	@SuppressWarnings("unused")
	private void setName(String newName) {
		this.name = newName;
	}

	/**
	 * getter von free
	 * 
	 * @return
	 */
	boolean getFree() {
		return this.free;
	}

	/**
	 * setter von free
	 * 
	 * @param newFree
	 */
	private void setFree(boolean newFree) {
		this.free = newFree;
	}

	/**
	 * getter von shortTerm
	 * 
	 * @return
	 */
	char getShortTerm() {
		return this.shortTerm;
	}

	/**
	 * setter von shortTerm
	 * 
	 * @param newshortTerm
	 */
	@SuppressWarnings("unused")
	private void setShortTerm(boolean newShortTerm) {
		this.free = newShortTerm;
	}

	/**
	 * setzt die Farbe benutzt
	 * 
	 * @param color
	 */
	void setColorUsed() {
		this.setFree(false);
	}

	/**
	 * Checked ob die Farbe frei ist
	 * 
	 * @return
	 */
	public boolean checkColorFree() {
		if (this.free) {
			return true;
		}
		return false;
	}

	/**
	 * Abfrage und Auswahl der Farbe
	 * 
	 * @param sc
	 * @return freie Farbe
	 */
	static Color chooseColor(Scanner sc) {
		System.out.println(Strings.CHOOSE_COLOR.content);
		Color colorOfChoice;
		switch (sc.next()) {
		case "r":
			System.out.println(Strings.YOU_PICKED.content + Strings.COLOR_RED_NAME.content);
			colorOfChoice = Color.RED;
			break;
		case "b":
			System.out.println(Strings.YOU_PICKED.content + Strings.COLOR_BLUE_NAME.content);
			colorOfChoice = Color.BLUE;
			break;
		case "g":
			System.out.println(Strings.YOU_PICKED.content + Strings.COLOR_GREEN_NAME.content);
			colorOfChoice = Color.GREEN;
			break;
		case "o":
			System.out.println(Strings.YOU_PICKED.content + Strings.COLOR_ORANGE_NAME.content);
			colorOfChoice = Color.ORANGE;
			break;
		default:
			System.out.println(Strings.UNKOWN_INPUT.content + "\n" + Strings.TRY_AGAIN.content);
			return chooseColor(sc);
		}
		if (colorOfChoice.checkColorFree()) {
			System.out.println(
					Strings.SUCCESSFULLY_PICKED.content + colorOfChoice.name + "(" + colorOfChoice.shortTerm + ")");
			return colorOfChoice;
		} else {
			System.out.println(Strings.NOT_FREE.content + "\n" + Strings.TRY_AGAIN.content);
			return chooseColor(sc);
		}
	}

}
