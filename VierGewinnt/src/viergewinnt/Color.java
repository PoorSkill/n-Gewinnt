package viergewinnt;

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

}
