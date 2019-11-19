package ngewinnt;

import java.util.Scanner;

/**
 * Spieler
 * 
 * @author Anton Kesy
 *
 */
public class Player {
	boolean maxPlays;
	int plays; // Anzahl von Spielzuegen
	Player opponent; // Gegenspieler des aktuellen Spielers
	String name; // Name_Bezeichner des Spielers
	Gamefield ownGamefield, opponentsGamefield; // eigene_gegnerische_Spielfeld
	Color color; // Farbe der Steine des Spielers
	boolean correctPlay, won, bot; // legaler Zug, gewonnen oder bot,

	// kann bei
	// höheren
	// sizeGamefield
	// helfen

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
		this.bot = true;
		this.plays = 0;
		this.maxPlays = false;
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
		color.setColorUsed();
		this.ownGamefield = new Gamefield(true);
		this.opponentsGamefield = new Gamefield(false);
		this.correctPlay = true;
		this.won = false;
		this.bot = false;
		this.plays = 0;
		this.maxPlays = false;
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
	 * @return true, wenn gewonnen
	 */
	boolean setStone(Scanner sc, Player player2) {
		if (this.plays >= Game.maxAmountOfPlays) {
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
		System.out.println(Strings.NEXT_MOVE.content);
		Stone stone = new Stone(checkIntInRangeOfCord(sc, Gamefield.fieldMax) - 1, color);
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
		System.out.println(Strings.PLAYER_NAME_INTRO.content + this.name + ":");
		Game.emptyLines(Gamefield.defaultEmptyLines * 3);
		Game.spacer(Gamefield.defaultSpacer);
		for (int l = 0; l <= Gamefield.fieldMax - 1; ++l) {
			System.out.print(Strings.xCordsIdentifiers[l]);
			Game.spacer(Gamefield.defaultSpacer);
		}
		Game.emptyLines(Gamefield.defaultEmptyLines * 3);
		for (int i = 0; i < Gamefield.fieldMax; ++i) {
			System.out.print((i - Gamefield.fieldMax) * (-1));
			Game.spacer(Gamefield.defaultSpacer);
			for (int j = 0; j < Gamefield.fieldMax; ++j) {

				System.out.print(this.ownGamefield.field[j][i]);
				Game.spacer(Gamefield.defaultSpacer);
			}
			Game.emptyLines(Gamefield.defaultEmptyLines);
		}
		Game.emptyLines(Gamefield.defaultEmptyLines);
	}

	int checkIntInRangeOfCord(Scanner sc, int max) {
		int input = Game.inputAmountToCordInt(sc);
		if (input > max || input <= 0) {
			System.out.println(Strings.NOT_A_COORDINATE.content);
			return checkIntInRangeOfCord(sc, max);
		}
		return input;
	}

	/**
	 * Methode ueberprueft auf korrekte eingabe (int und im Wertebereich)
	 * 
	 * @param input
	 * @return
	 */
	int inputAmountInt(Scanner input, int max) { // Wenn input nicht int oder zu grosser Wert wiederholt Eingabe
		// TODO
		while (true) {
			try {
				return input.nextInt();
			} catch (java.util.InputMismatchException e) {
				System.out.println("Wrong data type, try again!");
				input.nextLine();
			} /*
				 * catch (java.lang.ArrayIndexOutOfBoundsException c) {
				 * System.out.println(Strings.NOT_A_COORDINATE.content); input.hasNextLine(); //
				 * inputAmountInt(input, Gamefield.fieldMax);
				 * 
				 * }
				 */
		}
	}

}
