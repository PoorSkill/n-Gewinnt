/**
 * 
 */
package ngewinnt;

/**
 * @author Poor
 *
 */
public class UnknownInput extends Exception {

	/**
	 * generated Serial
	 */
	private static final long serialVersionUID = 8205300116077497489L;

	/**
	 * Standart-Konstruktor
	 */
	UnknownInput() {
	}

	/**
	 * Konstruktor leitet @param message zu super
	 * 
	 * @param message
	 */
	UnknownInput(String message) {
		super(message);
	}

	/**
	 * gibt Info aus (redundant)
	 */
	void printInfo() {
		System.out.println(Strings.EXCEPTION_UNKNOWN_INPUT.content);
	}
}
