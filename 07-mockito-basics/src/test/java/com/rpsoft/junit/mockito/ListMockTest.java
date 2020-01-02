package com.rpsoft.junit.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class ListMockTest {

	private static List<String> listMock = null;

	@SuppressWarnings("unchecked")
	@Before
	public void setup() {
		listMock = mock(List.class);
	}

	@After
	public void tearUp() {
		listMock = null;
	}

	/**
	 * Mock size() method of list with default mocking behavior.
	 */
	@Test
	public void testListSizeMethod_defaultMock() {
		assertEquals(0, listMock.size());
	}

	@Test
	public void testListSizeMethod_customMocked() {

		// Mock size method to return value/values.
		when(listMock.size()).thenReturn(2);

		assertEquals(2, listMock.size());
	}

	@Test
	public void testListSizeMethod_customMocked_multipleValues() {

		// Mock size method to return value/values.
		when(listMock.size()).thenReturn(2).thenReturn(3).thenReturn(4);

		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
		assertEquals(4, listMock.size());
	}

	@Test
	public void testListSizeMethod_customMocked_multipleValues_vararg() {

		// Mock size method to return value/values.
		when(listMock.size()).thenReturn(1, 2, 3, 4, 5, 6);

		assertEquals(1, listMock.size());
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
		assertEquals(4, listMock.size());
		assertEquals(5, listMock.size());
		assertEquals(6, listMock.size());
	}

	/**
	 * 
	 */
	@Test
	public void testListGetMethod_customMocked() {

		// Mock get method to return value/values.
		when(listMock.get(1)).thenReturn("Index-1");

		assertEquals("Index-1", listMock.get(1));
	}

	/**
	 * Passing call to actual implementation.
	 */
	@Test
	@Ignore // As we are stubbing interface. Ignore test of real method call.
	public void testListConcreateMethod_callingRealMethod() {

		// No mocking, Pass call to real method.
		when(listMock.add(anyObject())).thenCallRealMethod();

		listMock.parallelStream();
	}

	/**
	 * When mocking a method with more than one argument, we need to provide either
	 * argument matchers or constants. Meaning we cannot use combination of argument
	 * matcher and constants.
	 * 
	 */
	@Test(expected = RuntimeException.class)
	public void testListAddMethod_argumentMatcherLimitation() {

		when(listMock.subList(anyInt(), anyInt())).thenThrow(new RuntimeException("Expected exception"));
		
		listMock.subList(0, 1);
	}
}
