/**
 * 
 */
package com.rpsoft.junit.mockito.business.impl.mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.rpsoft.junit.mockito.business.impl.TodoBusinessImpl;
import com.rpsoft.junit.mockito.data.api.TodoService;

/**
 * @author vivek
 *
 */
public class TestTodoBusinessImplMock {

	private static TodoBusinessImpl todoBusinessImpl;
	private static TodoService todoServiceMock;

	@Before
	public void setup() {

		// Given - Setup
		todoServiceMock = mock(TodoService.class);

		given(todoServiceMock.retrieveTodos("Vivek"))
				.willReturn(Arrays.asList(new String[] { "Learn JS", "Angual JS", "Node JS", "Learn jUnit" }));

		given(todoServiceMock.retrieveTodos("JS Developer"))
				.willReturn(Arrays.asList(new String[] { "Learn JS", "Angual JS", "Node JS", "Learn jUnit" }));

		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(
				Arrays.asList(new String[] { "Learn Java", "Learn Spring boot", "Learn Spring MVC", "Learn jUnit" }));

		given(todoServiceMock.deleteTodos(anyString(), anyString())).willReturn(Boolean.TRUE);

		todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

	}

	/**
	 * Test BDD Style calling.
	 */
	@Test
	public void testRetrieveTodosRelatedToSpring_assertScenarios() {

		// Argument capture declaration
		final ArgumentCaptor<String> stringArgCaptor = ArgumentCaptor.forClass(String.class);

		// When - Action performed
		todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		todoBusinessImpl.retrieveTodos("JS Developer");
		todoBusinessImpl.retrieveTodos(".Net Developer");

		verify(todoServiceMock, times(3)).retrieveTodos(stringArgCaptor.capture());

		/*
		 * You can now use these argument values to assert and test your conditions.
		 */
		List<String> allArguments = stringArgCaptor.getAllValues();
		String lastArgument = stringArgCaptor.getValue();

		System.out.println("All Arguments : " + allArguments);
		System.out.println("Last Argument : " + lastArgument);
		
		
		// Then
		assertEquals(".Net Developer", lastArgument);
		assertEquals("JS Developer", allArguments.get(1));
		assertEquals("Dummy", allArguments.get(0));

	}
}
