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
		field = new char[Gamefield.fieldMax][Gamefield.fieldMax];
		stones = new Stone[Gamefield.fieldMax];
		if (own == true) {
			for (int i = 0; i < Gamefield.fieldMax; i++) {
				for (int j = 0; j < Gamefield.fieldMax; j++) {
					this.field[i][j] = '-';
				}
			}
		}
	}

	/**
	 * Kontrolliert ob Stein plaziert werden darf und setzt ihn
	 * 
	 * @param stone
	 * @return
	 */
	boolean registerStone(Stone stone) {
		// TODO: sehr aufwaendig und Kopfarbeit!
		return true;
	}

}
