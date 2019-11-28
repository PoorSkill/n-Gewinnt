package ngewinnt;

import java.util.Scanner;

import ngewinnt.exceptions.NotFreeException;
import ngewinnt.exceptions.NumberOutOfRangeException;
import ngewinnt.exceptions.UnknownInputException;

/**
 * Spiel
 * 
 * @author Anton Kesy
 *
 */
public class Game {
	private static int defaultEmptyLines = 3; // Game Konsolen abstand fuer die Befragung TODO: Einstellungen Klasse?
	private static int maxAmountOfPlays = (Gamefield.getFieldMax() * Gamefield.getFieldMax()) / 2; // maximale Anzahl
																									// von Zuegen
	private static int points4win = 4; // Punkteanzahl die benoetigt wird, um zu gewinnen
	private Player player[]; // reduntantes Array von den Spielern (speatere Anwedung bei Speicherung der
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
			try {
				game.query(sc);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (game.yesNoQuestion(sc, Strings.RUN_CHECK_QUESTION));
		sc.close();
	}

	/**
	 * Abfrage/Ablauf des Spiels/Haupt-Output in die Konsole
	 * 
	 * @param sc
	 * @throws Exception
	 */
	void query(Scanner sc) throws Exception {
		changeRules(sc);
		// TODO: eine schoene Uebung zu Scanner und Kontruktoren
		emptyLines(defaultEmptyLines);
		Player player1 = new Player(chooseName(sc, null), Color.chooseColor(sc));
		emptyLines(defaultEmptyLines);
		Player player2 = set2cndPlayer(sc, player1);
		// TODO: Optimierung (Gamefield copy)
		player1.setOpponent(player2);
		player2.setOpponent(player1);
		// Startet Spielablauf
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
	 * @throws Exception
	 */
	void play(Player player1, Player player2, Scanner sc) throws Exception {
		while (!player1.getWon() || !player2.getWon() || !player1.isMaxPlays() || !player2.isMaxPlays()) {
			player1.printOwnField();
			player1.setStone(sc, player2);
			if (player1.getWon() || player1.isMaxPlays()) {
				player1.printOwnField();
				break;
			}
			player2.printOwnField();
			player2.setStone(sc, player1);
			if (player2.getWon() || player2.isMaxPlays()) {
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
	 * setter von points4win
	 * 
	 * Aendert die Anzahl von Punkten die man braucht um zu gewinnen und ueberprueft
	 * ihre legalitaet
	 * 
	 * @param sc
	 * @throws Exception
	 * 
	 */
	private void changePoints4Win(Scanner sc) throws Exception {
		emptyLines(defaultEmptyLines);
		System.out.println(Strings.HOW_MANY_POINTS.getContent());
		try {
			int input = inputAmountInt(sc);
			if (input > Gamefield.getFieldMax()) {
				System.out.println(Strings.NUMBER_CANT_BE_HIGHER_THAN_GAMEFIELD_SIZE.getContent());
				throw new NumberOutOfRangeException();
			} else if (input <= 1) {
				System.out.println(Strings.NUMBER_NEEDS_TO_BE_HIGHER.getContent());
				throw new NumberOutOfRangeException();
			}
			Game.points4win = input;
		} catch (NumberOutOfRangeException e) {
			System.out.println(Strings.TRY_AGAIN.getContent());
			changePoints4Win(sc);
		}

	}

	/**
	 * Scanner Abfrage und Auswahl der gewuenschten Regeln TODO
	 * 
	 * @param sc
	 * @throws Exception
	 */
	private void changeRules(Scanner sc) throws Exception {
		emptyLines(defaultEmptyLines);
		if (yesNoQuestion(sc, Strings.WANNA_CHANGE_RULES)) {
			System.out.println(Strings.CHANGE_RULES_START.getContent());
			try {
				String input = sc.next().toLowerCase();
				switch (input) {
				case "1": // Punktzahl aendern
					System.out.println(Strings.YOU_PICKED.getContent());
					changePoints4Win(sc);
					changeRules(sc);
					break;
				case "2": // Spieleranzahl aendern
					System.out.println(Strings.YOU_PICKED.getContent());
					// TODO: wenn langeweile, mehr wie einen Spieler hinzufuegen
					changeRules(sc);
					break;
				case "3": // Sprache aendern
					System.out.println(Strings.YOU_PICKED.getContent());
					// TODO: wenn langeweile, mehr wie einen Sprache hinzufuegen
					changeRules(sc);
					break;
				case "e": // verlassen
					System.out.println(Strings.YOU_PICKED.getContent());
					break;
				default:
					throw new UnknownInputException();
				}

			} catch (UnknownInputException e) {
				System.out.println(Strings.UNKOWN_INPUT.getContent() + "\n" + Strings.TRY_AGAIN.getContent());
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
		System.out.println(Strings.PLEASE_INSERT_NAME.getContent());
		try {
			String freeName = sc.next();
			for (int i = 0; i <= Strings.getUsedNames().length - 1; ++i) {
				if (freeName.equals(Strings.getUsedNames()[i])) {
					throw new NotFreeException();
				}
			}
			System.out.println(Strings.SUCCESSFULLY_PICKED.getContent() + freeName);
			for (int i = 0; i <= Strings.getUsedNames().length; ++i) {
				if (freeName.equals("platzhalter0") || freeName.equals("platzhalter1")) {
					Strings.getUsedNames()[i] = freeName;
				}
			}
			return freeName;
		} catch (NotFreeException e) {
			System.out.println(Strings.NOT_FREE.getContent() + "\n" + Strings.TRY_AGAIN.getContent());
			return chooseName(sc);
		}
	}

	/**
	 * Faule aber funktionale Abfrage des Namens
	 * 
	 * @param sc
	 * @return
	 */
	String chooseName(Scanner sc, Player player1) {
		emptyLines(defaultEmptyLines);
		System.out.println(Strings.PLEASE_INSERT_NAME.getContent());
		try {
			String freeName = sc.next();
			if (player1 != null) {
				if (freeName.equals(player1.getName()) || freeName.equals("Bot")) {
					throw new NotFreeException();
				}
			} else {
				if (freeName.equals("Bot")) {
					throw new NotFreeException();
				}
			}
			System.out.println(Strings.SUCCESSFULLY_PICKED.getContent() + freeName);
			return freeName;
		} catch (NotFreeException e) {
			System.out.println(Strings.NOT_FREE.getContent() + "\n" + Strings.TRY_AGAIN.getContent());
			return chooseName(sc, player1);

		}
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
		System.out.println(question.getContent());
		String input = sc.next().toLowerCase();
		for (int i = 0; i <= Strings.getPossibleAnswersOfYes().length - 1; i++) {
			if (input.equals(Strings.getPossibleAnswersOfYes()[i])) {
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
		Strings.getUsedNames()[2] = "platzhalter0";
		Strings.getUsedNames()[3] = "platzhalter1";
		// schlechte variante
		player1.getColor().setFree(true);
		player2.getColor().setFree(true);

	}

	/**
	 * @return the defaultEmptyLines
	 */
	public static int getDefaultEmptyLines() {
		return Game.defaultEmptyLines;
	}

	/**
	 * @param defaultEmptyLines the defaultEmptyLines to set
	 */
	public static void setDefaultEmptyLines(int defaultEmptyLines) {
		Game.defaultEmptyLines = defaultEmptyLines;
	}

	/**
	 * @return the maxAmountOfPlays
	 */
	public static int getMaxAmountOfPlays() {
		return Game.maxAmountOfPlays;
	}

	/**
	 * @param maxAmountOfPlays the maxAmountOfPlays to set
	 */
	public static void setMaxAmountOfPlays(int maxAmountOfPlays) {
		Game.maxAmountOfPlays = maxAmountOfPlays;
	}

	/**
	 * @return the points4win
	 */
	public static int getPoints4win() {
		return Game.points4win;
	}

	/**
	 * @param points4win the points4win to set
	 */
	public static void setPoints4win(int points4win) {
		Game.points4win = points4win;
	}

	/**
	 * @return the player
	 */
	public Player[] getPlayer() {
		return this.player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player[] player) {
		this.player = player;
	}

}
