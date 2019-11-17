package viergewinnt;

import java.util.Scanner;

/**
 * Spiel
 * 
 * @author Anton Kesy
 *
 */
public class Game {
	static String[] possibleAnswersOfYes = { "y", "1", "yes", "true", "ja", "weiter", "ye", "ya" };
	static String[] possibleAnswersOfNo = { "n", "0", "no", "false", "nein", "stop", "nah", "na" };
	static int points4win = 4; // outsourcen

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
		emptyLines(3);
		System.out.println(Strings.RUN_CHECK_QUESTION.content);
		String input = sc.next().toLowerCase();
		for (int i = 0; i <= Game.possibleAnswersOfYes.length - 1; i++) {
			if (input.equals(Game.possibleAnswersOfYes[i])) {
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
		System.out.println(Strings.PLEASE_INSERT_NAME.content);
		Player player1 = new Player(sc.next(), Color.BLUE);
		Player player2 = set2cndPlayer(sc);
		// TODO: Optimierung (Gamefield copy)
		player1.setOpponent(player2);
		player2.setOpponent(player1);
		// verschieben in play
		this.play(player1, player2, sc);
	}

	/**
	 * Aussuchen des 2.Spielers
	 * 
	 * @param sc
	 * @return spieler2 (Bot oder manueller Spieler)
	 */
	Player set2cndPlayer(Scanner sc) {
		Player player2;
		if (singlePlayerQuestion(sc)) {
			player2 = new Player();

		} else {
			System.out.println(Strings.PLEASE_INSERT_NAME.content);
			player2 = new Player(sc.next(), Color.RED);
		}
		return player2;
	}

	/**
	 * Abfrage ob Einzel- oder Mehrerspieler
	 * 
	 * @param sc
	 * @return true, wenn ja - false, wenn nein
	 */
	boolean singlePlayerQuestion(Scanner sc) {
		// TODO: abfrage und ausfuellung des Kontruktors
		emptyLines(3);
		System.out.println(Strings.SINGLEPLAYER_QUESTION.content);
		String input = sc.next().toLowerCase();
		for (int i = 0; i <= Game.possibleAnswersOfYes.length - 1; i++) {
			if (input.equals(Game.possibleAnswersOfYes[i])) {
				return true;
			}
		}
		for (int i = 0; i <= Game.possibleAnswersOfYes.length - 1; i++) {
			if (input.equals(Game.possibleAnswersOfYes[i])) {
				return false;
			}
		}
		return false;
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
		while (player1.won == false || player2.won == false || player1.maxPlays == false || player2.maxPlays == false) {
			player1.printOwnField();
			player1.setStone(sc, player2);
			if (player1.won || player1.maxPlays == true) {
				player1.printOwnField();
				break;
			}
			player2.printOwnField();
			player2.setStone(sc, player1);
			if (player2.won || player2.maxPlays == true) {
				player2.printOwnField();
				break;
			}
		}
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

	/**
	 * printed Leerzeichen
	 * 
	 * @param amount
	 */
	public static void spacer(int amount) {
		for (int i = 0; i <= amount; ++i) {
			System.out.print(" ");
		}
	}

	/**
	 * Wenn input nicht int, wiederholt Eingabe
	 * 
	 * @param input
	 * @return
	 */
	static int inputAmountInt(Scanner input) {
		while (true) {
			try {
				return input.nextInt();
			} catch (java.util.InputMismatchException e) {
				System.out.println("Wrong data type, try again!");
				input.nextLine();
			}
		}
	}

}
