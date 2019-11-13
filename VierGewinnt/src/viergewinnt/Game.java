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
		while (game.runCheck(sc)) {
			game.query(sc);
		}
		sc.close();
		/*
		 * redundant, aber moegliche Erweiterung System.exit(0);
		 */
	}

	/**
	 * Ueberprueft ob das Programm weiter laufen soll
	 * 
	 * @param sc
	 * @return true, falls es weiterlaufen soll
	 */
	public boolean runCheck(Scanner sc) {
		String[] possibleAnswersOfYes = { "1", "yes", "true", "ja", "weiter", "ye", "ya" };
		System.out.println(Strings.RUN_CHECK_QUESTION.content);
		String input = sc.nextLine().toLowerCase();
		for (int i = 0; i <= possibleAnswersOfYes.length - 1; i++) {
			if (input.equals(possibleAnswersOfYes[i])) {
				return true;
			}

		}
		// Switch durch for-Schleife ersetzt
		/*
		 * switch (input) { case "yes": case "true": case "ja": case "weiter": case "1":
		 * return true; default:
		 */
		return false;
	}

	/**
	 * Abfrage/Ablauf des Spiels/Haupt-Output in die Konsole
	 * 
	 * @param sc
	 */
	void query(Scanner sc) {
		// TODO: eine schoene Uebung zu Scanner und Kontruktoren
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
	}

}
