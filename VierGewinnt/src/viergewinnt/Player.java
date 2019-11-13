package viergewinnt;

import java.util.Scanner;

/**
 * Spieler
 * 
 * @author Anton Kesy
 *
 */
public class Player {
	String name;
	Gamefield ownGamefield, opponentsGamefield;
	Color color;
	boolean correctPlay, won, bot;

	/**
	 * Standart Konstruktor -> Bot
	 */
	Player() {
		Bot bot = new Bot();
		this.name = Strings.BOT_NAME.content;
		this.color = bot.checkFreeColor();
		this.ownGamefield = new Gamefield(true);
		this.opponentsGamefield = new Gamefield(false);
		this.correctPlay = true;
		this.won = false;
		this.bot = false;
	}

	/**
	 * Konstruktor bei manuellen Spielern
	 * 
	 * @param name
	 * @param color
	 */
	Player(String name, Color color) {
		this.name = name;
		this.color = color;
		this.ownGamefield = new Gamefield(true);
		this.opponentsGamefield = new Gamefield(false);
		this.correctPlay = true;
		this.won = false;
		this.bot = false;
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

	/**
	 * Setzen des Steines
	 * 
	 * @param sc
	 * @param player2
	 */
	void setStone(Scanner sc, Player player2) {
		// TODO: yap
	}
}
