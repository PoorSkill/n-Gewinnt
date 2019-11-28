package ngewinnt;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Bot fuer Einzelspieler TODO
 * 
 * @author Anton Kesy
 *
 */
public class Bot {
	private boolean active;

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
		Color freeColor;
		if (Color.BLUE.getFree()) {
			freeColor = Color.BLUE;
		} else if (Color.RED.getFree()) {
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
		int randomIntInRange = ThreadLocalRandom.current().nextInt(min, Gamefield.getFieldMax() + 1);
		if (randomIntInRange > Gamefield.getFieldMax() || randomIntInRange <= 0) {
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
