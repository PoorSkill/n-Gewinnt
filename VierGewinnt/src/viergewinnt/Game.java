package viergewinnt;

import java.util.Scanner;

/**
 * Spiel
 * 
 * @author Anton Kesy
 *
 */
public class Game {
	Player player[];

	/**
	 * Main startet Scanner und solange runCheck true, läuft das Progamm in Schleife
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Game game = new Game();
		do {
			game.query(sc);
		} while (game.runCheck(sc));
		sc.close();
		/*
		 * redundant, aber moegliche Erweiterung: System.exit(0);
		 */
	}

	/**
	 * Ueberprueft ob das Programm weiter laufen soll
	 * 
	 * @param sc
	 * @return true, falls es weiterlaufen soll
	 */
	public boolean runCheck(Scanner sc) {
		String[] possibleAnswersOfYes = { "y", "1", "yes", "true", "ja", "weiter", "ye", "ya" };
		System.out.println(Strings.RUN_CHECK_QUESTION.content);
		String input = sc.nextLine().toLowerCase();
		for (int i = 0; i <= possibleAnswersOfYes.length - 1; i++) {
			if (input.equals(possibleAnswersOfYes[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Abfrage/Ablauf des Spiels/Haupt-Output in die Konsole
	 * 
	 * @param sc
	 */
	void query(Scanner sc) {
		// TODO: eine schoene Uebung zu Scanner und Kontruktoren

		// test
		Gamefield gamefieldTest = new Gamefield(true);
		Player testPlayer = new Player();
		testPlayer.printOwnField();
	}

	/**
	 * Abfrage ob Einzel- oder Mehrerspieler
	 * 
	 * @param sc
	 * @return
	 */
	Player singlePlayer(Scanner sc) {
		// TODO: abfrage und ausfuellung des Kontruktors
		Player player2 = null;
		return player2;
	}

	/**
	 * Eigentlicher Spielablauf: einzelne eingaben und aktionen/Zuege der Spieler
	 * und gewonnen Ueberpruefung
	 * 
	 * @param player1
	 * @param player2
	 * @param sc
	 */
	void play(Player player1, Player player2, Scanner sc) {
		// TODO: einfacher aufruf der Methoden der Klasse Player

	}

	/**
	 * printed leere Linien
	 * 
	 * @param count
	 * 
	 */
	public static void emptyLines(int count) {
		// TODO: 2min Aufgabe Kontrollstruktur
		for (int i = 0; i <= count; ++i) {
			System.out.println(" ");
		}
	}

	public static void spacer(int amount) {
		for (int i = 0; i <= amount; ++i) {
			System.out.print(" ");
		}
	}

}
