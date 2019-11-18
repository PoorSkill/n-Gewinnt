package viergewinnt;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Bot fuer Einzelspieler
 * 
 * @author Anton Kesy
 *
 */
public class Bot {
	boolean active;
	Player player;

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
		// TODO: ez -> funktioniert noch nicht!!!
		Color freeColor;
		if (Color.BLUE.free) {
			freeColor = Color.BLUE;
		} else if (Color.RED.free) {
			freeColor = Color.RED;
		} else {
			freeColor = Color.GREEN;
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

	/**
	 * gibt zufaellige und moegliche xPos fuer den Stein zurueck
	 * 
	 * @return
	 */
	static int randomXPos() {
		int min = 0;
		int randomIntInRange = ThreadLocalRandom.current().nextInt(min, Gamefield.fieldMax + 1);
		if (randomIntInRange >= Gamefield.fieldMax + 1 || randomIntInRange <= 0) {
			return randomXPos();
		} else {
			return randomIntInRange;
		}
	}

	/*
	 * setzt den Stein
	 */
	static Stone setStone(Color color) {
		Stone stone = new Stone(randomXPos() - 1, color);
		return stone;
	}
}
