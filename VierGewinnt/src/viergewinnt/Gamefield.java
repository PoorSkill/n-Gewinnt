package viergewinnt;

/**
 * Spielfeld
 * 
 * @author Anton Kesy
 *
 */
public class Gamefield {

	static int defaultEmptyLines = 1; // "
	static int defaultSpacer = 3;// "
	static int fieldMax = 10 - 1;
	static int maxAmountOfPlays = (fieldMax * fieldMax) / 2; // maximale Anzahl von Zuegen
	char field[][];
	Stone[] stones;

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
		// TODO: sehr aufwaendig und Kopfarbeit!
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
			System.out.println("WIR HABEN EINEN GEWINNER\nSpieler " + player.name + " gewinnt!"); // TODO: verschieben
																									// mit
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
		// TODO
		// XPos ueberpruefung
		byte pointsCount;
		for (int i = field.length - 1; i >= 0; --i) {
			if (i < Game.points4win) {
				break;
			}
			System.out.println("i amount ypos" + i);
			pointsCount = 1;
			for (int j = 1; j < Game.points4win; ++j) { // 1 -2 - 3 - 4
				if (field[xPos][i] != '-' && field[xPos][i] == field[xPos][i - j]) { // 1 -2 -3 - 4
					++pointsCount;// 1- 2 -3 4
					System.out.println("PointsCount" + pointsCount);
					if (pointsCount >= Game.points4win) {
						player.won = true;
						System.out.println("XPos:" + (xPos + 1) + " YPos: " + (9 - i) + " bis "
								+ ((9 - i) + (Game.points4win - 1)));
						return true;
					}
				}
			}
		}
		// TODO: YPos ueberpruefung (noch nicht fertig)
		for (int i = field.length - 1; i >= 1; --i) {
			System.out.println("i amount xpos" + i);
			pointsCount = 1;
			if (i < Game.points4win) {
				break;
			}
			for (int j = 1; j < Game.points4win; ++j) { // 1 -2 - 3 - 4
				if (field[i][yPos] != '-' && field[i][yPos] == field[i - j][yPos]) { // 1 -2 -3 - 4
					++pointsCount;// 1- 2 -3 4
					System.out.println("PointsCount" + pointsCount);
					if (pointsCount >= Game.points4win) {
						player.won = true;
						System.out.println("XPos:" + (xPos + 1) + " bis " + ((9 - i) + (Game.points4win - 1))
								+ " YPos: " + (yPos + 1));
						return true;

					}
				}
			}
		}
		return false;
	}

}
