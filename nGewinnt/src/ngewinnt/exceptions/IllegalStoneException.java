/**
 * 
 */
package ngewinnt.exceptions;

/**
 * @author Poor
 *
 */
public class IllegalStoneException extends Exception {

	/**
	 * generated Serial
	 */
	private static final long serialVersionUID = 1968194982089281089L;

	/*
	 * Standart Konstruktor
	 */
	public IllegalStoneException() {
	}

	/**
	 * Konstruktor leitet @param message zu super
	 * 
	 * @param message
	 */
	public IllegalStoneException(String message) {
		super(message);
	}
}
