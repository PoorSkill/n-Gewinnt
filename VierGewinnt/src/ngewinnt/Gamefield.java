package ngewinnt;

/**
 * Spielfeld
 * 
 * @author Anton Kesy
 *
 */
public class Gamefield {
	static int defaultEmptyLines = 1; // Standart Abstand fuer Ausgabe des Spieles in der Konsole
	static int defaultSpacer = 1; // Standart Abstand fuer Ausgabe des Spieles in der Konsole
	static int fieldMax = 10; // Groesse des Spielfeldes
	char field[][]; // Das Spielfeld
	Stone[] stones; // Die Steine des Spieles

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
	boolean checkLegalStone(Stone stone, Player player) {
		for (int i = fieldMax - 1; i >= 0; --i) {
			if (this.field[stone.xPos][i] == '-') {
				registerStone(stone, i, player);
				return true;
			}
		}
		System.out.println("Besetzt!");
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
		this.field[stone.xPos][yPos] = stone.color.shortTerm;
		++player.plays;
		System.out.println("Stein korrekt gesetzt");
		if (checkWin(stone.xPos, yPos, player)) {
			System.out.println("WIR HABEN EINEN GEWINNER\nSpieler " + player.name + " gewinnt!");
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
			if (i < Game.points4win - 1) {
				break;
			}
			pointsCount = 0;
			for (int j = 0; j < Game.points4win; ++j) {
				if (field[xPos][i] != '-' && field[xPos][i] == field[xPos][i - j]) {
					++pointsCount;
					if (pointsCount >= Game.points4win) {
						System.out.println(player.name + Strings.PLAYER_GOT_POINTS.content + pointsCount);
						player.won = true;
						char posCharXPos0 = (char) ('A' - 1 + (i - Gamefield.fieldMax) * (-1));
						System.out.println(posCharXPos0 + "-" + (Gamefield.fieldMax - i) + " bis " + posCharXPos0 + "-"
								+ (Gamefield.fieldMax - i + Game.points4win - 1));
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
			if (i < Game.points4win - 1) {
				break;
			}
			for (int j = 0; j < Game.points4win; ++j) {
				if (field[i][yPos] != '-' && field[i][yPos] == field[i - j][yPos]) {
					++pointsCount;
					if (pointsCount >= Game.points4win) {
						System.out.println(player.name + Strings.PLAYER_GOT_POINTS.content + pointsCount);
						player.won = true;
						char posCharXPos0 = (char) ('A' - 1 + (j) - 2);
						char posCharXPos1 = (char) ('A' - 1 + ((j + Game.points4win)) - 2);
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

}
