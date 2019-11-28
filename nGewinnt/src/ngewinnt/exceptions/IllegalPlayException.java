/**
 * 
 */
package ngewinnt.exceptions;

/**
 * @author Poor
 *
 */
public class IllegalPlayException extends Exception {

	/**
	 * generated Serial
	 */
	private static final long serialVersionUID = -15227958226960118L;

	/**
	 * Standart Konstruktor
	 */
	public IllegalPlayException() {
	}

	/**
	 * Konstruktor leitet @param message zu super
	 * 
	 * @param message
	 */
	public IllegalPlayException(String message) {
		super(message);
	}
}
