package viergewinnt;

/**
 * Spieler
 * 
 * @author Anton Kesy
 *
 */
public class Player {
	String name;
	Color color;
	boolean correctPlay, won, bot;

	/**
	 * Standart Konstruktor
	 */
	Player() {
	}

	/**
	 * getter von name
	 * 
	 * @return name des Objektes
	 */
	String getName() {
		return this.name;
	}

	/**
	 * setter von name
	 * 
	 * @param newName
	 */
	@SuppressWarnings("unused")
	private void setName(String newName) {
		this.name = newName;
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

	/**
	 * getter von correctPlay
	 * 
	 * @return correctPlay des Objektes
	 */
	boolean getCorrectPlay() {
		return this.correctPlay;
	}

	/**
	 * setter von correctPlay
	 * 
	 * @param newCorrectPlay
	 */
	@SuppressWarnings("unused")
	private void setCorrectPlay(boolean newCorrectPlay) {
		this.correctPlay = newCorrectPlay;
	}

	/**
	 * getter von won
	 * 
	 * @return won des Objektes
	 */
	boolean getWon() {
		return this.won;
	}

	/**
	 * setter von won
	 * 
	 * @param newWon
	 */
	@SuppressWarnings("unused")
	private void setWon(boolean newWon) {
		this.won = newWon;
	}

	/**
	 * getter von bot
	 * 
	 * @return bot des Objektes
	 */
	boolean getBot() {
		return this.bot;
	}

	/**
	 * setter von bot
	 * 
	 * @param newBot
	 */
	@SuppressWarnings("unused")
	private void setBot(boolean newBot) {
		this.bot = newBot;
	}
}
