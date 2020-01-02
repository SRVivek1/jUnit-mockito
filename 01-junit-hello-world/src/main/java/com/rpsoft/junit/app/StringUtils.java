package com.rpsoft.junit.app;

/**
 * Hello world!
 *
 */
public class StringUtils {

	/**
	 * Remove fist 2 leading 'A' characters.
	 * 
	 * e.g : AACD => CD, ACD => CD, CDEF => CDEF, CDAA => CDAA.
	 * 
	 * @param source
	 * @return
	 */
	public String truncateAinFristTwoCharacters(final String source) {

		if (source.length() <= 2)
			return source.replaceAll("A", "");

		return source.substring(0, 2).replaceAll("A", "").concat(source.substring(2));
	}

	/**
	 * check if first and last 2 character in provided string are same.
	 * 
	 * Condition: 1. false if length is less than 2. 2. true if length is exactly 2.
	 * 3. Run test for other scenario.
	 * 
	 * e.g: A => false, AB => true, ABCD => false, ABAB => true.
	 * 
	 * @param source
	 * @return
	 */
	public boolean areFirstAndLastTwoCharsTheSame(final String source) {

		final int length = source.length();

		if (length <= 1) {
			return false;
		}

		if (length == 2) {
			return true;
		}

		String first2Chars = source.substring(0, 2);
		String last2Chars = source.substring(length - 2);

		return first2Chars.equals(last2Chars);
	}
}
