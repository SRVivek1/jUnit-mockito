package com.rpsoft.junit.app;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringUtilsParameterizedPositiveTest {

	private StringUtils stringUtils;

	/*
	 * Hold input from the condition array.
	 */
	private String actual;

	/*
	 * Hold expected result from the condition array.
	 */
	private String expected;

	/**
	 * @param input
	 * @param expected
	 */
	public StringUtilsParameterizedPositiveTest(String input, String expected) {
		this.actual = input;
		this.expected = expected;
	}

	@Parameters
	public static Collection<String[]> testConditionData() {

		// @formatter:off
		
		return Arrays.asList(
				new String[][] { 
					{ "AACD", "CD" }, 
					{ "ABF", "BF" }, 
					{ "NHGJ", "NHGJ" } 
				});
		
		// @formatter:on
	}

	@Before
	public void setUp() throws Exception {
		stringUtils = new StringUtils();
	}

	@After
	public void tearDown() throws Exception {
		stringUtils = null;
	}

	@Test
	public void testTruncateAinFristTwoCharacters_PositiveTesting() {

		assertEquals(expected, stringUtils.truncateAinFristTwoCharacters(actual));
	}

}
