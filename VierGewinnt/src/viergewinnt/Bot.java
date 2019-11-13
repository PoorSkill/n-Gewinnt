package viergewinnt;

/**
 * Bot fuer Einzelspieler
 * 
 * @author Anton Kesy
 *
 */
public class Bot {
	boolean active;

	/**
	 * Standart Konstruktor
	 */
	Bot() {

	}

	/**
	 * Waehlt die andere, freie, Farbe aus
	 * 
	 * @return freie Farbe
	 */
	Color checkFreeColor() {
		// TODO: ez
		Color freeColor;
		if (Color.BLUE.free) {
			freeColor = Color.BLUE;
		} else {
			freeColor = Color.RED;
		}
		return freeColor;
	}

	/**
	 * getter von active
	 * 
	 * @return active des Objektes
	 */
	boolean getActive() {
		return this.active;
	}

	/**
	 * setter von active
	 * 
	 * @param newActive
	 */
	@SuppressWarnings("unused")
	private void setActive(boolean newActive) {
		this.active = newActive;
	}
}
