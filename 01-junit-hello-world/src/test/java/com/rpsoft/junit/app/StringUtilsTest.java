package com.rpsoft.junit.app;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilsTest {

	StringUtils stringUtils = new StringUtils();

	/**
	 * Remove fist 2 leading 'A' characters in String having only 2 chars.
	 * 
	 * e.g : AA => ''.
	 * 
	 */
	@Test
	public void testTruncateAinFristTwoCharacters_AinFirst2CharsIn2CharString() {
		assertEquals("", stringUtils.truncateAinFristTwoCharacters("AA"));
	}

	/**
	 * Remove fist 2 leading 'A' characters in String.
	 * 
	 * e.g : AACD => CD, ACD => CD, CDEF => CDEF, CDAA => CDAA.
	 */
	@Test
	public void testTruncateAinFristTwoCharacters_AinFirst2Chars() throws Exception {
		assertEquals("CD", stringUtils.truncateAinFristTwoCharacters("AACD"));
	}

	// e.g: A => false, AB => true, ABCD => false, ABAB => true.
	@Test
	public void testAreFirstAndLastTwoCharsTheSame_OneCharacterString_false() throws Exception {
		assertFalse(stringUtils.areFirstAndLastTwoCharsTheSame("A"));
	}

	// e.g: AB => true, ABCD => false, ABAB => true.
	@Test
	public void testAreFirstAndLastTwoCharsTheSame_Exact2CharString_true() throws Exception {
		assertTrue(stringUtils.areFirstAndLastTwoCharsTheSame("AB"));
	}

	// e.g: ABCD => false, ABAB => true.
	@Test
	public void testAreFirstAndLastTwoCharsTheSame_NegativeTesting() throws Exception {
		assertFalse(stringUtils.areFirstAndLastTwoCharsTheSame("ABCD"));
	}

	// e.g: ABCD => false, ABAB => true.
	@Test
	public void testAreFirstAndLastTwoCharsTheSame_PositiveTesting() throws Exception {
		assertTrue(stringUtils.areFirstAndLastTwoCharsTheSame("ABAB"));
	}
}
