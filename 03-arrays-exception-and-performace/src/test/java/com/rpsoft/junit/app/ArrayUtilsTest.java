package com.rpsoft.junit.app;

import static org.junit.Assert.assertArrayEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */

public class ArrayUtilsTest {

	private ArrayUtils arrayUtils;

	@Before
	public void setup() {

		arrayUtils = new ArrayUtils();
	}

	@After
	public void destroy() {
		arrayUtils = null;
	}

	/**
	 * Test array data.
	 */
	@Test
	public void testSortArray_AscendingSort() {

		final Integer[] testData = new Integer[] { 12, 45, 5, 1 };
		final Integer[] expectedResult = new Integer[] { 1, 5, 12, 45 };

		// Sort array data
		arrayUtils.sortArray(testData);

		assertArrayEquals(expectedResult, testData);
	}

	/**
	 * Assertion error.
	 */
	@Test(expected = AssertionError.class)
	public void testSortArray_NegativeTest() {

		final Integer[] testData = new Integer[] { 12, 45, 5, 1 };
		final Integer[] expectedResult = new Integer[] { 12, 5, 1, 45 };

		// Sort array data
		arrayUtils.sortArray(testData);

		assertArrayEquals(expectedResult, testData);
	}

	/**
	 * Exception handling.
	 */
	@Test(expected = NullPointerException.class)
	public void testSortArray_NullPointerException() {

		final Integer[] testData = null;
		final Integer[] expectedResult = new Integer[] { 1, 5, 12, 45 };

		// Sort array data
		arrayUtils.sortArray(testData);

		assertArrayEquals(expectedResult, testData);
	}
	
	/**
	 * Exception handling.
	 */
	@Test(timeout = 60)
	public void testSortArray_1000k60msPerformanceTest() {

		final Integer[] testData = new Integer[1000000];

		// prepare data
		for (int i = 1000000, j = 0; i > 0; i--, j++) {
			testData[j] = i;
		}

		// Sort array data
		arrayUtils.sortArray(testData);
	}

}
