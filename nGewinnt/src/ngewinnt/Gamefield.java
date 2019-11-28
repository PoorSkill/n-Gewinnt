package ngewinnt;

import java.util.Scanner;

import ngewinnt.exceptions.IllegalStoneException;

/**
 * Spielfeld
 * 
 * @author Anton Kesy
 *
 */
public class Gamefield {
	private static int defaultEmptyLines = 1; // Standart Abstand fuer Ausgabe des Spieles in der Konsole
	private static int defaultSpacer = 1; // Standart Abstand fuer Ausgabe des Spieles in der Konsole
	private static int fieldMax = 10; // Groesse des Spielfeldes
	private char field[][]; // Das Spielfeld
	private Stone[] stones; // Die Steine des Spieles

	/**
	 * Konstruktor fragt nach, welches Spielfeld gezeichnet werden soll und erstellt
	 * dieses
	 * 
	 * @param own
	 */
	Gamefield(boolean own) {
		this.field = new char[Gamefield.fieldMax][Gamefield.fieldMax];
		this.stones = new Stone[Gamefield.fieldMax];
		if (own == true) {
			for (int i = 0; i < Gamefield.fieldMax; i++) {
				for (int j = 0; j < Gamefield.fieldMax; j++) {
					this.field[i][j] = '-';
				}
			}
		}
	}

	/**
	 * Kontrolliert ob Stein plaziert werden darf und ruft register Stone oder gibt
	 * false zurueck
	 * 
	 * @param stone
	 * @return
	 */
	boolean checkLegalStone(Stone stone, Player player) throws Exception {
		try {
			for (int i = fieldMax - 1; i >= 0; --i) {
				if (this.field[stone.getXPos()][i] == '-') {
					registerStone(stone, i, player);
					return true;
				}
			}
			throw new IllegalStoneException();
		} catch (IllegalStoneException e) {
			System.out.println("Besetzt!");
		}
		return false;

	}

	/**
	 * Setzt Stein und ruft smart gewinn ueberpruefer auf
	 * 
	 * @param stone
	 * @return true, wenn gewonnen
	 *
	 */
	private boolean registerStone(Stone stone, int yPos, Player player) {
		this.field[stone.getXPos()][yPos] = stone.getColor().getShortTerm();
		player.setPlays(player.getPlays() + 1);
		System.out.println("Stein korrekt gesetzt");
		Game.emptyLines(defaultEmptyLines * 10);
		if (checkWin(stone.getXPos(), yPos, player)) {
			System.out.println("WIR HABEN EINEN GEWINNER\nSpieler " + player.getName() + " gewinnt!");
			return true;
		}
		return false;
	}

	/**
	 * Optimierte gewonnen ueberpruefung
	 * 
	 * @param yPos
	 * @return true, wenn gewonnen
	 */
	private boolean checkWin(int xPos, int yPos, Player player) {
		// yPos ueberpruefung (Senkrecht)

		byte pointsCount;
		for (int i = field.length - 1; i > 0; --i) {
			if (i < Game.getPoints4win() - 1) {
				break;
			}
			pointsCount = 0;
			for (int j = 0; j < Game.getPoints4win(); ++j) {
				if (field[xPos][i] != '-' && field[xPos][i] == field[xPos][i - j]) {
					++pointsCount;
					if (pointsCount >= Game.getPoints4win()) {
						System.out.println(player.getName() + Strings.PLAYER_GOT_POINTS.getContent() + pointsCount);
						player.setWon(true);
						char posCharXPos0 = (char) ('A' - 1 + (i - Gamefield.fieldMax) * (-1));
						System.out.println(posCharXPos0 + "-" + (Gamefield.fieldMax - i) + " bis " + posCharXPos0 + "-"
								+ (Gamefield.fieldMax - i + Game.getPoints4win() - 1));
						return true;
					}
				} else {
					pointsCount = 0;
				}
			}
		}
		// xPos ueberpruefung (Horizontal)
		for (int i = field.length - 1; i > 0; --i) {
			pointsCount = 0;
			if (i < Game.getPoints4win() - 1) {
				break;
			}
			for (int j = 0; j < Game.getPoints4win(); ++j) {
				if (field[i][yPos] != '-' && field[i][yPos] == field[i - j][yPos]) {
					++pointsCount;
					if (pointsCount >= Game.getPoints4win()) {
						System.out.println(player.getName() + Strings.PLAYER_GOT_POINTS.getContent() + pointsCount);
						player.setWon(true);
						char posCharXPos0 = (char) ('A' - 1 + (j) - 2);
						char posCharXPos1 = (char) ('A' - 1 + ((j + Game.getPoints4win())) - 2);
						System.out.println(posCharXPos0 + "-" + (yPos - Gamefield.fieldMax) * (-1) + " bis "
								+ posCharXPos1 + "-" + (yPos - Gamefield.fieldMax) * (-1));
						return true;
					}
				} else {
					pointsCount = 0;
				}
			}
		}
		return false;
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

	/**
	 * @return the defaultEmptyLines
	 */
	public static int getDefaultEmptyLines() {
		return defaultEmptyLines;
	}

	/**
	 * @param defaultEmptyLines the defaultEmptyLines to set
	 */
	public static void setDefaultEmptyLines(int defaultEmptyLines) {
		Gamefield.defaultEmptyLines = defaultEmptyLines;
	}

	/**
	 * @return the defaultSpacer
	 */
	public static int getDefaultSpacer() {
		return defaultSpacer;
	}

	/**
	 * @param defaultSpacer the defaultSpacer to set
	 */
	public static void setDefaultSpacer(int defaultSpacer) {
		Gamefield.defaultSpacer = defaultSpacer;
	}

	/**
	 * @return the fieldMax
	 */
	public static int getFieldMax() {
		return fieldMax;
	}

	/**
	 * @param fieldMax the fieldMax to set
	 */
	public static void setFieldMax(int fieldMax) {
		Gamefield.fieldMax = fieldMax;
	}

	/**
	 * @return the field
	 */
	public char[][] getField() {
		return field;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(char[][] field) {
		this.field = field;
	}

	/**
	 * @return the stones
	 */
	public Stone[] getStones() {
		return stones;
	}

	/**
	 * @param stones the stones to set
	 */
	public void setStones(Stone[] stones) {
		this.stones = stones;
	}

}
