package ngewinnt;

import java.util.Scanner;

/**
 * Spieler
 * 
 * @author Anton Kesy
 *
 */
public class Player {
	private int plays; // Anzahl von Spielzuegen
	private Player opponent; // Gegenspieler des aktuellen Spielers
	private String name; // Name_Bezeichner des Spielers
	private Gamefield ownGamefield, opponentsGamefield; // eigene_gegnerische_Spielfeld
	private Color color; // Farbe der Steine des Spielers
	private boolean maxPlays, correctPlay, won, bot; // Maximale Anzahl von Spielzuegen bereits benutzt? / legaler Zug,
														// gewonnen oder bot,

	/**
	 * Standart Konstruktor -> Bot
	 */
	Player() {
		Bot bot = new Bot();
		setName(Strings.BOT_NAME.getContent());
		setColor(bot.checkFreeColor());
		setOwnGamefield(new Gamefield(true));
		setOpponentsGamefield(new Gamefield(false));
		setCorrectPlay(true);
		setWon(false);
		setBot(true);
		setPlays(0);
		setMaxPlays(false);
	}

	/**
	 * Konstruktor bei manuellen Spielern
	 * 
	 * @param name
	 * @param color
	 */
	Player(String name, Color color) {
		setName(name);
		setColor(color);
		color.setColorUsed();
		setOwnGamefield(new Gamefield(true));
		setOpponentsGamefield(new Gamefield(false));
		setCorrectPlay(true);
		setWon(false);
		setBot(false);
		setPlays(0);
		setMaxPlays(false);
	}

	/**
	 * setter von opponent (nicht geschuetzt!!)
	 * 
	 * @param opponentPlayer
	 */
	void setOpponent(Player opponentPlayer) {
		this.opponent = opponentPlayer;
	}

	/**
	 * getter von opponent
	 * 
	 * @return opponent des Objektes
	 */
	Player getOpponent() {
		return this.opponent;
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
	void setWon(boolean newWon) {
		this.won = newWon;
	}

	/**
	 * @return the maxPlays
	 */
	public boolean isMaxPlays() {
		return maxPlays;
	}

	/**
	 * @param maxPlays the maxPlays to set
	 */
	public void setMaxPlays(boolean maxPlays) {
		this.maxPlays = maxPlays;
	}

	/**
	 * @return the plays
	 */
	public int getPlays() {
		return plays;
	}

	/**
	 * @param plays the plays to set
	 */
	public void setPlays(int plays) {
		this.plays = plays;
	}

	/**
	 * @return the ownGamefield
	 */
	public Gamefield getOwnGamefield() {
		return ownGamefield;
	}

	/**
	 * @param ownGamefield the ownGamefield to set
	 */
	public void setOwnGamefield(Gamefield ownGamefield) {
		this.ownGamefield = ownGamefield;
	}

	/**
	 * @return the opponentsGamefield
	 */
	public Gamefield getOpponentsGamefield() {
		return opponentsGamefield;
	}

	/**
	 * @param opponentsGamefield the opponentsGamefield to set
	 */
	public void setOpponentsGamefield(Gamefield opponentsGamefield) {
		this.opponentsGamefield = opponentsGamefield;
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
	 * @return true, wenn gewonnen
	 * @throws Exception
	 */
	boolean setStone(Scanner sc, Player player2) throws Exception {
		if (this.plays >= Game.getMaxAmountOfPlays()) {
			System.out.println("Draw");
			this.maxPlays = true;
			return false;
		}
		if (this.bot) {
			if (ownGamefield.checkLegalStone(Bot.setStone(this.color), this)) {
				return true;
			} else {
				return setStone(sc, player2);
			}
		}
		System.out.println(Strings.NEXT_MOVE.getContent());
		Stone stone = new Stone(checkIntInRangeOfCord(sc, Gamefield.getFieldMax()) - 1, color);
		if (ownGamefield.checkLegalStone(stone, this)) {
			return true;
		} else {
			return setStone(sc, player2);

		}
	}

	/**
	 * Printed das eigene Feld in der Konsole (Grundrisse und field)
	 * 
	 */
	public void printOwnField() {
		this.ownGamefield = opponent.ownGamefield; // TODO: besser Version!
		System.out.println(Strings.PLAYER_NAME_INTRO.getContent() + this.name + ":");
		Game.emptyLines(Gamefield.getDefaultEmptyLines() * 3);
		Game.spacer(Gamefield.getDefaultSpacer());
		for (int l = 0; l <= Gamefield.getFieldMax() - 1; ++l) {
			System.out.print(Strings.getxCordsIdentifiers()[l]);
			Game.spacer(Gamefield.getDefaultSpacer());
		}
		Game.emptyLines(Gamefield.getDefaultEmptyLines() * 3);
		for (int i = 0; i < Gamefield.getFieldMax(); ++i) {
			System.out.print((i - Gamefield.getFieldMax()) * (-1));
			Game.spacer(Gamefield.getDefaultSpacer());
			for (int j = 0; j < Gamefield.getFieldMax(); ++j) {

				System.out.print(this.ownGamefield.getField()[j][i]);
				Game.spacer(Gamefield.getDefaultSpacer());
			}
			Game.emptyLines(Gamefield.getDefaultEmptyLines());
		}
		Game.emptyLines(Gamefield.getDefaultEmptyLines());
	}

	/**
	 * ueberprueft ob der eingegebene Wert, umgewandelt in ein int, auf dem Bereich
	 * des Spielfeldes ist
	 * 
	 * @param sc
	 * @param max
	 * @return
	 */
	int checkIntInRangeOfCord(Scanner sc, int max) {
		int input = inputAmountToCordInt(sc);
		if (input > max || input <= 0) {
			System.out.println(Strings.NOT_A_COORDINATE.getContent());
			return checkIntInRangeOfCord(sc, max);
		}
		return input;
	}

	/**
	 * Wenn input nicht int, ueberprueft ob input String mit char der Koordinate,
	 * umwandeln der Koordinaten in zahlen fuer das Spielfeld
	 * 
	 * @param input
	 * @return
	 */
	static int inputAmountToCordInt(Scanner input) {
		while (true) {
			try {
				return input.nextInt();
			} catch (java.util.InputMismatchException e) {
				String string2Int = input.nextLine().toLowerCase();
				if (string2Int.matches("[a-z]")) {
					char firstLetterOfString = string2Int.charAt(0);
					int cordOfChar = (int) firstLetterOfString - 97 + 1;
					return cordOfChar;
				}
				System.out.println("Wrong data type, try again!");
			}
		}
	}

}
