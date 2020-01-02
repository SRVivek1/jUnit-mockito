package com.rpsoft.junit.app;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringUtilsTest {

	private StringUtils stringUtils;

	@BeforeClass
	public static void beforeClassSetup() {
		System.out.println("Executing : Before class method.");
	}
	
	@AfterClass
	public static void afterClassSetup() {
		System.out.println("Executing : After class method.");
	}

	
	@Before
	public void setup() {
		System.out.println("Executing : setup method.");

		stringUtils = new StringUtils();
	}

	@After
	public void teardown() {
		System.out.println("Executing : teardown method.");
	}

	@Test
	public void test1() {
		System.out.println("Executing : Test 1");
		assertEquals("BC", stringUtils.truncateAinFristTwoCharacters("AABC"));
	}

	@Test
	public void test2() {
		System.out.println("Executing : Test 2");
		assertTrue(stringUtils.areFirstAndLastTwoCharsTheSame("CAdCA"));
	}
}
