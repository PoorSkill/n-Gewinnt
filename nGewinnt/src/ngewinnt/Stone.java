package ngewinnt;

/**
 * Spielstein
 * 
 * @author Anton Kesy
 *
 */
public class Stone {
	private int xPos, yPos; // Postitionen des Steines auf dem Spielbrett
	private Color color; // Farbe des Steines

	/**
	 * Standart Konstruktor
	 */
	Stone() {
	}

	/**
	 * Konstruktor Stone setzten vom Spielfeld
	 * 
	 * @param xPos
	 * @param yPos
	 * @param color
	 */
	Stone(int xPos, int yPos, Color color) {
		setXPos(xPos);
		setYPos(yPos);
		setColor(color);
	}

	/**
	 * Konstruktor Stone setzten vom Spieler
	 * 
	 * @param xPos
	 * @param yPos
	 * @param color
	 */
	Stone(int xPos, Color color) {
		setXPos(xPos);
		setYPos(0);
		setColor(color);
	}

	/**
	 * getter von xPos
	 * 
	 * @return xPos des Objektes
	 */
	int getXPos() {
		return this.xPos;
	}

	/**
	 * setter von xPos
	 * 
	 * @param newXPos
	 */
	void setXPos(int newXPos) {
		this.xPos = newXPos;
	}

	/**
	 * getter von yPos
	 * 
	 * @return yPos des Objektes
	 */
	int getYPos() {
		return this.yPos;
	}

	/**
	 * setter von yPos
	 * 
	 * @param newYPos
	 */

	void setYPos(int newYPos) {
		this.yPos = newYPos;
	}

	/**
	 * getter von color
	 * 
	 * @return color des Objektes
	 */
	Color getColor() {
		return this.color;
	}

	/**
	 * setter von color
	 * 
	 * @param newColor
	 */
	void setColor(Color newColor) {
		this.color = newColor;
	}

}
