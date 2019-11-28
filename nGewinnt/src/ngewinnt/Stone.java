package ngewinnt;

/**
 * Spielstein
 * 
 * @author Anton Kesy
 *
 */
public class Stone {
	private int xPos, yPos;
	private Color color;

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
		this.xPos = xPos;
		this.yPos = yPos;
		this.color = color;
	}

	/**
	 * Konstruktor Stone setzten vom Spieler
	 * 
	 * @param xPos
	 * @param yPos
	 * @param color
	 */
	Stone(int xPos, Color color) {
		this.xPos = xPos;
		this.yPos = 0;
		this.color = color;
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
	@SuppressWarnings("unused")
	private void setXPos(int newXPos) {
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
	@SuppressWarnings("unused")
	private void setYPos(int newYPos) {
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
	@SuppressWarnings("unused")
	private void setColor(Color newColor) {
		this.color = newColor;
	}

}
