/**
 * 
 */
package ngewinnt.exceptions;

/**
 * @author Poor
 *
 */
public class IllegalPlay extends Exception {

	/**
	 * generated Serial
	 */
	private static final long serialVersionUID = -15227958226960118L;

	/**
	 * Standart Konstruktor
	 */
	IllegalPlay() {
	}

	/**
	 * Konstruktor leitet @param message zu super
	 * 
	 * @param message
	 */
	IllegalPlay(String message) {
		super(message);
	}
}
