/**
 * 
 */
package com.rpsoft.junit.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author vivek
 *
 */
public class TestMockitoSpyFuncationality {

	@SuppressWarnings("unchecked")
	@Test
	public void testArrayListMethods() {
		
		// Creating SPY of ArrayList Object.
		final List<String> arrayListSpy = spy(ArrayList.class);
		
		// Assert default size of ArrayList
		assertThat(arrayListSpy.size(), is(0));
		
		// Add data to ArrayList
		arrayListSpy.add("Index-0");

		// Verify call to add method
		verify(arrayListSpy).add("Index-0");
		
		// Now size with be incremented
		assertThat(arrayListSpy.size(), is(1));
		

	}
	
	
}
