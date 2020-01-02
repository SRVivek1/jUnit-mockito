/**
 * 
 */
package com.rpsoft.junit.mockito;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author vivek
 *
 */
public class ArrayListMockTest {

	@Test
	public void testAddMethod_verifyNumberOfTimesMethodIsCalled() {

		// Given
		//@SuppressWarnings("unchecked")
		ArrayList<String> arrayListMock = mock(ArrayList.class);
		
		// When
		arrayListMock.add("Once");
		arrayListMock.add("Twice");
		arrayListMock.add("Twice");
		
		// Then
		
		// At least Once
		verify(arrayListMock, atLeastOnce()).add(anyString());
		
		// Exactly 2 times
		verify(arrayListMock, times(2)).add("Twice");
		
		
		// Exactly 1 time - times(1) is default check hence times(1) is skipped.
		verify(arrayListMock).add("Once");
	}
	
	
	
	
}
