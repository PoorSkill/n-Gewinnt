/**
 * 
 */
package ngewinnt.exceptions;

/**
 * @author Poor
 *
 */
public class IllegalStone extends Exception {

	/**
	 * generated Serial
	 */
	private static final long serialVersionUID = 1968194982089281089L;

	/*
	 * Standart Konstruktor
	 */
	public IllegalStone() {
	}

	/**
	 * Konstruktor leitet @param message zu super
	 * 
	 * @param message
	 */
	IllegalStone(String message) {
		super(message);
	}
}
