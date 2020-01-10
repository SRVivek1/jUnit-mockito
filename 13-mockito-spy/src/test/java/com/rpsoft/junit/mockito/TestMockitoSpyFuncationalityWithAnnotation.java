/**
 * 
 */
package com.rpsoft.junit.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * @author vivek
 *
 */
public class TestMockitoSpyFuncationalityWithAnnotation {

	// Mockito Rule to initialize mockito annotations.
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	// Creating SPY of ArrayList Object.
	@Spy
	final List<String> arrayListSpy = new ArrayList<>();
	
	
	
	@Test
	public void testArrayListMethods() {
		
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
