package ngewinnt;

import java.util.Scanner;

/**
 * Spiel
 * 
 * @author Anton Kesy
 *
 */
public class Game {
	static int defaultEmptyLines = 3; // Game Konsolen abstand fuer die Befragung TODO: Einstellungen Klasse?
	static int maxAmountOfPlays = (Gamefield.fieldMax * Gamefield.fieldMax) / 2; // maximale Anzahl von Zuegen
	static int points4win = 4; // Punkteanzahl die benoetigt wird, um zu gewinnen
	Player player[]; // reduntantes Array von den Spielern (speatere Anwedung bei Speicherung der
						// Spielstaende)

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
		} while (game.yesNoQuestion(sc, Strings.RUN_CHECK_QUESTION));
		sc.close();
		/*
		 * redundant, aber moegliche Erweiterung: System.exit(0);
		 */
	}

	/**
	 * Abfrage/Ablauf des Spiels/Haupt-Output in die Konsole
	 * 
	 * @param sc
	 */
	void query(Scanner sc) {
		changeRules(sc);
		// TODO: eine schoene Uebung zu Scanner und Kontruktoren
		emptyLines(defaultEmptyLines);
		Player player1 = new Player(chooseName(sc, null), Color.chooseColor(sc));
		emptyLines(defaultEmptyLines);
		Player player2 = set2cndPlayer(sc, player1);
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
	Player set2cndPlayer(Scanner sc, Player player1) {
		Player player2;
		if (yesNoQuestion(sc, Strings.SINGLEPLAYER_QUESTION)) {
			player2 = new Player();

		} else {
			player2 = new Player(chooseName(sc, player1), Color.chooseColor(sc));
		}
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
		garbageCollect(player1, player2);
	}

	/**
	 * printed leere Linien
	 * 
	 * @param count
	 * 
	 */
	public static void emptyLines(int count) {
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
		for (int i = 1; i <= amount; ++i) {
			System.out.print("\t");
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
	 * setter von points4win
	 * 
	 * Aendert die Anzahl von Punkten die man braucht um zu gewinnen und ueberprueft
	 * ihre legalitaet
	 * 
	 * @param sc
	 * 
	 */
	private void changePoints4Win(Scanner sc) {
		emptyLines(defaultEmptyLines);
		System.out.println(Strings.HOW_MANY_POINTS.content);
		int input = inputAmountInt(sc);
		if (input > Gamefield.fieldMax) {
			System.out.println(Strings.NUMBER_CANT_BE_HIGHER_THAN_GAMEFIELD_SIZE.content);
			System.out.println(Strings.TRY_AGAIN.content);
			changePoints4Win(sc);
		} else if (input <= 1) {
			System.out.println(Strings.NUMBER_NEEDS_TO_BE_HIGHER.content);
			System.out.println(Strings.TRY_AGAIN.content);
			changePoints4Win(sc);
		}
		Game.points4win = input;
	}

	/**
	 * Scanner Abfrage und Auswahl der gewuenschten Regeln TODO
	 * 
	 * @param sc
	 */
	private void changeRules(Scanner sc) {
		emptyLines(defaultEmptyLines);
		if (yesNoQuestion(sc, Strings.WANNA_CHANGE_RULES)) {
			System.out.println(Strings.CHANGE_RULES_START.content);
			String input = sc.next().toLowerCase();
			switch (input) {
			case "1": // Punktzahl aendern
				System.out.println(Strings.YOU_PICKED.content);
				changePoints4Win(sc);
				changeRules(sc);
				break;
			case "2": // Spieleranzahl aendern
				System.out.println(Strings.YOU_PICKED.content);
				// TODO: wenn langeweile, mehr wie einen Spieler hinzufuegen
				changeRules(sc);
				break;
			case "3": // Sprache aendern
				System.out.println(Strings.YOU_PICKED.content);
				// TODO: wenn langeweile, mehr wie einen Sprache hinzufuegen
				changeRules(sc);
				break;
			case "e": // verlassen
				System.out.println(Strings.YOU_PICKED.content);
				break;
			default:
				System.out.println(Strings.UNKOWN_INPUT.content + "\n" + Strings.TRY_AGAIN.content);
				changeRules(sc);
			}
		}
	}

	/**
	 * Abfrage und Auswahl des Namens
	 * 
	 * @param sc
	 * @return freier Name
	 */
	String chooseName(Scanner sc) {
		emptyLines(defaultEmptyLines);
		System.out.println(Strings.PLEASE_INSERT_NAME.content);
		String freeName = sc.next();
		for (int i = 0; i <= Strings.usedNames.length - 1; ++i) {
			if (freeName.equals(Strings.usedNames[i])) {
				System.out.println(Strings.NOT_FREE.content + "\n" + Strings.TRY_AGAIN.content);
				return chooseName(sc);
			}
		}
		System.out.println(Strings.SUCCESSFULLY_PICKED.content + freeName);
		for (int i = 0; i <= Strings.usedNames.length - 1; ++i) {
			if (freeName.equals("platzhalter0") || freeName.equals("platzhalter1")) {
				Strings.usedNames[i] = freeName;
			}
		}
		return freeName;

	}

	/**
	 * Faule aber funktionale Abfrage des Namens (nicht wirklich gut) //nicht sehr
	 * schoen geschrieben => unnoetig kompliziert
	 * 
	 * @param sc
	 * @return
	 */
	String chooseName(Scanner sc, Player player1) {
		emptyLines(defaultEmptyLines);
		System.out.println(Strings.PLEASE_INSERT_NAME.content);
		String freeName = sc.next();
		if (player1 != null) { // nicht sehr schoen geschrieben => unnoetig kompliziert
			if (freeName.equals(player1.name) || freeName.equals("Bot")) {
				System.out.println(Strings.NOT_FREE.content + "\n" + Strings.TRY_AGAIN.content);
				return chooseName(sc);
			}
			// nicht sehr schoen geschrieben => unnoetig kompliziert
		} else {
			if (freeName.equals("Bot")) {
				System.out.println(Strings.NOT_FREE.content + "\n" + Strings.TRY_AGAIN.content);
				return chooseName(sc);
			}
		}
		System.out.println(Strings.SUCCESSFULLY_PICKED.content + freeName);
		return freeName;
	}

	/**
	 * Einfache Ja/Nein abfrage
	 * 
	 * @param sc
	 * @param question
	 * @return true:ja, false:no
	 */
	public boolean yesNoQuestion(Scanner sc, Strings question) {
		emptyLines(defaultEmptyLines);
		System.out.println(question.content);
		String input = sc.next().toLowerCase();
		for (int i = 0; i <= Strings.possibleAnswersOfYes.length - 1; i++) {
			if (input.equals(Strings.possibleAnswersOfYes[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Setzt die Spielernamen zurueck TODO: auf Liste umschreiben
	 * 
	 * @param player1
	 * @param player2
	 */
	void garbageCollect(Player player1, Player player2) {
		Strings.usedNames[2] = "platzhalter0";
		Strings.usedNames[3] = "platzhalter1";
		// schlechte variante
		player1.color.free = true;
		player2.color.free = true;
//		Strings str = new Strings("name");
//		Strings.removeUsedName(player1.name);
//		Strings.removeUsedName(player2.name);
	}

}
