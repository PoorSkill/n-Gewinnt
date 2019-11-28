/**
 * 28.11.2019
 */
package ngewinnt.exceptions;

/**
 * Falls Name, Farbe oder anderes bereits belegt ist
 * 
 * @author Poor
 *
 */
public class NotFreeException extends Exception {

	/**
	 * generated Serial
	 */
	private static final long serialVersionUID = -1718989948545552943L;

	/**
	 * Standart Konstruktor
	 */
	public NotFreeException() {
	}

	/**
	 * Konstruktor leitet @param message zu super
	 * 
	 * @param message
	 */
	public NotFreeException(String message) {
		super(message);
	}

}
