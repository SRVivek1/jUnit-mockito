/**
 * 
 */
package com.rpsoft.junit.mockito.business.impl.mock;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.hamcrest.core.IsNot;
import org.junit.BeforeClass;
import org.junit.Test;

import com.rpsoft.junit.mockito.business.impl.TodoBusinessImpl;
import com.rpsoft.junit.mockito.data.api.TodoService;

/**
 * @author vivek
 *
 */
public class TestTodoBusinessImplMock {

	private static TodoBusinessImpl todoBusinessImpl;
	private static TodoService todoServiceMock;

	@BeforeClass
	public static void setup() {

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

		// When - Action performed
		List<String> springTodosList = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		List<String> jsDeveloperTodosList = todoBusinessImpl.retrieveTodos("JS Developer");

		// Then - Verify expected result.
		assertThat(springTodosList.size(), is(2));
		assertThat(jsDeveloperTodosList.size(), is(4));

		assertThat(jsDeveloperTodosList, is(instanceOf(List.class)));
		assertThat(jsDeveloperTodosList, IsNot.not(LinkedList.class));

		assertThat(springTodosList.get(1), containsString("Spring"));
		assertThat(springTodosList.get(1), startsWith("Learn"));
		assertThat(springTodosList.get(0), allOf(startsWith("Learn"), containsString("Spring"), endsWith("boot")));

	}

	/**
	 * Verify calls made to mock instance.
	 */
	@Test
	public void testRetrieveTodosRelatedTopics_verifyCallsOnMockInstance() {

		// When
		todoBusinessImpl.retrieveTodos("Other Devs");
		todoBusinessImpl.retrieveTodos("JS Devs");

		todoBusinessImpl.deleteTodosRelatedTopics("Vivek", "JS");

		// Then
		verify(todoServiceMock).retrieveTodos("Other Devs");
		verify(todoServiceMock).retrieveTodos("JS Devs");

		verify(todoServiceMock, atLeastOnce()).retrieveTodos(anyString());
		verify(todoServiceMock, times(3)).retrieveTodos(anyString());
		verify(todoServiceMock, atMost(4)).retrieveTodos(anyString());

		
		// User Vivek had 3 courses of JS.... Hence there should be 3 delete calls
		verify(todoServiceMock, times(19)).deleteTodos("Vivek", "JS");
	}

}
