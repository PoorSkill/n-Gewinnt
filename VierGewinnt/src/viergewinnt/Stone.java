package viergewinnt;

/**
 * Spielstein
 * 
 * @author Anton Kesy
 *
 */
public class Stone {
	int xPos, yPos;
	Color color;

	/**
	 * Standart Konstruktor
	 */
	Stone() {
	}

	Stone(int xPos, int yPos, Color color) {
		this.xPos = xPos;
		this.yPos = yPos;
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

//	/**
//	 * Sucht den naechst moeglichen freien yPos Platz (momentan noch in
//	 * Gamefield.legalStone)
//	 * 
//	 * @param stone
//	 * @param xPos
//	 * @return
//	 */
//	int getFreeYPos(Stone stone, int xPos) {
////		return 0;
//	}
}
