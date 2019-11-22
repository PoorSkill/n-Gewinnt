/**
 * 
 */
package ngewinnt;

/**
 * @author Poor
 *
 */
public class NumberOutOfRange extends Exception {

	/**
	 * generated Serial
	 */
	private static final long serialVersionUID = -8413144491688097921L;

	/*
	 * Standart Konstruktor
	 */
	NumberOutOfRange() {
	}

	NumberOutOfRange(String message) {
		super(message);
	}

	/**
	 * gibt Info aus (redundant)
	 */
	void printInfo() {
		System.out.println(Strings.EXCEPTION_NUMBER_OUT_OF_RANGE.content);
	}
}
