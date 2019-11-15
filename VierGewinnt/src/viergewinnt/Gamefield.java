package viergewinnt;

/**
 * Spielfeld
 * 
 * @author Anton Kesy
 *
 */
public class Gamefield {
	static int defaultEmptyLines = 1;
	static int defaultSpacer = 3;
	static int fieldMax = 10 - 1;
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
	boolean checkLegalStone(Stone stone) {
		// TODO: sehr aufwaendig und Kopfarbeit!
		for (int i = fieldMax - 1; i >= 0; --i) {
			if (this.field[stone.xPos][i] == '-') {
				registerStone(stone, i);
				return true;
			}
		}
		System.out.println("Besetzt!");
		return false;
	}

	/**
	 * Setzt Stein
	 * 
	 * @param stone
	 *
	 */
	void registerStone(Stone stone, int yPos) {
		this.field[stone.xPos][yPos] = stone.color.shortTerm;
		System.out.println("Stein korrekt gesetzt");
	}

}
