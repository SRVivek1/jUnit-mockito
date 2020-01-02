/**
 * 
 */
package com.rpsoft.junit.mockito.business.impl.mock;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.rpsoft.junit.mockito.business.impl.TodoBusinessImpl;
import com.rpsoft.junit.mockito.data.api.TodoService;

/**
 * @author vivek
 *
 */
public class TestTodoBusinessImplMock {

	private static TodoService todoServiceMock;
	private static TodoBusinessImpl todoBusinessImpl;

	@BeforeClass
	public static void commonSetup() {
		// Creating mock object.
		todoServiceMock = mock(TodoService.class);

		// Mocking data for methods.
		when(todoServiceMock.retrieveTodos(anyString())).thenReturn(
				Arrays.asList(new String[] { "Learn Java", "Learn Spring boot", "Learn Spring MVC", "Learn jUnit" }));

		// Mocking service for a specific input.
		when(todoServiceMock.retrieveTodos("Vivek"))
				.thenReturn(Arrays.asList(new String[] { "Learn JS", "Angual JS", "Node JS", "Learn jUnit" }));

		todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
	}

	/**
	 * Test count of todos.
	 */
	@Test
	public void testRetrieveTodosRelatedToSpring_usingStub_contentSize() {

		List<String> springTodosList = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		// Assert size
		assertEquals(2, springTodosList.size());

	}

	/**
	 * Compare content of todos.
	 */
	@Test
	public void testRetrieveTodosRelatedToSpring_usingMock_contentMatching() {

		List<String> springTodosList = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		// Assert content
		String[] springTodos = new String[springTodosList.size()];
		springTodosList.toArray(springTodos);

		assertArrayEquals(new String[] { "Learn Spring boot", "Learn Spring MVC" }, springTodos);
	}

	/**
	 * Compare content of todos.
	 */
	@Test
	public void testRetrieveTodosRelatedTopics_usingMock_contentMatching_userVivek() {

		List<String> springTodosList = todoBusinessImpl.retrieveTodosRelatedTopics("Vivek", "JS");

		// Assert content
		String[] springTodos = new String[springTodosList.size()];
		springTodosList.toArray(springTodos);

		assertArrayEquals(new String[] { "Learn JS", "Angual JS", "Node JS" }, springTodos);
	}

}
