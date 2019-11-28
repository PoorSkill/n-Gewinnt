/**
 * 
 */
package ngewinnt.exceptions;

import ngewinnt.Strings;

/**
 * @author Poor
 *
 */
public class UnknownInputException extends Exception {

	/**
	 * generated Serial
	 */
	private static final long serialVersionUID = 8205300116077497489L;

	/**
	 * Standart-Konstruktor
	 */
	public UnknownInputException() {
	}

	/**
	 * Konstruktor leitet @param message zu super
	 * 
	 * @param message
	 */
	public UnknownInputException(String message) {
		super(message);
	}

	/**
	 * gibt Info aus (redundant)
	 */
	void printInfo() {
		System.out.println(Strings.EXCEPTION_UNKNOWN_INPUT.getContent());
	}
}
