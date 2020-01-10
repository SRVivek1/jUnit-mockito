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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.hamcrest.collection.IsCollectionWithSize;
import org.hamcrest.core.IsCollectionContaining;
import org.hamcrest.core.IsNot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.rpsoft.junit.mockito.business.impl.TodoBusinessImpl;
import com.rpsoft.junit.mockito.data.api.TodoService;

/**
 * @author vivek
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TestTodoBusinessImplMock {

	/**
	 * Creating Mock for the service.
	 */
	@Mock
	private static TodoService todoServiceMock;

	/**
	 * Injecting mocked service in business bean.
	 */
	@InjectMocks
	private static TodoBusinessImpl todoBusinessImpl;

	/**
	 * Captor to captor arguments.
	 */
	@Captor
	ArgumentCaptor<String> stringArgCaptor;

	/**
	 * Test BDD Style calling.
	 */
	@Test
	public void testRetrieveTodosRelatedToSpring_assertScenarios() {

		// Given
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(
				Arrays.asList(new String[] { "Learn Java", "Learn Spring boot", "Learn Spring MVC", "Learn jUnit" }));

		given(todoServiceMock.retrieveTodos("JS Developer"))
				.willReturn(Arrays.asList(new String[] { "Learn JS", "Angual JS", "Node JS", "Learn jUnit" }));

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
	 * Non-BDD Style - Verify calls made to mock instance.
	 */
	@Test
	public void testRetrieveTodosRelatedTopics_verifyCallsOnMockInstance() {

		// When
		todoBusinessImpl.retrieveTodos("Other Devs");
		todoBusinessImpl.retrieveTodos("JS Devs");

		// Then
		verify(todoServiceMock).retrieveTodos("Other Devs");
		verify(todoServiceMock).retrieveTodos("JS Devs");

		// Using captor to capture arguments
		verify(todoServiceMock, atLeastOnce()).retrieveTodos(stringArgCaptor.capture());
		verify(todoServiceMock, times(2)).retrieveTodos(anyString());
		verify(todoServiceMock, atMost(3)).retrieveTodos(anyString());

		// Assert arguments.
		assertEquals("JS Devs", stringArgCaptor.getValue());
		assertThat(stringArgCaptor.getAllValues(), IsCollectionWithSize.hasSize(2));
		assertThat(stringArgCaptor.getAllValues(), IsCollectionContaining.hasItems("Other Devs", "JS Devs"));
	}

	/**
	 * BDD Style - Verify calls made to mock instance.
	 */
	@Test
	public void testRetrieveTodosRelatedTopics_bddStyleVerifyCallsOnMockInstance() {

		// When
		todoBusinessImpl.retrieveTodos("Other Devs");
		todoBusinessImpl.retrieveTodos("JS Devs");

		// Then
		then(todoServiceMock).should().retrieveTodos("Other Devs");
		then(todoServiceMock).should().retrieveTodos("JS Devs");

		then(todoServiceMock).should(atLeastOnce()).retrieveTodos(anyString());
		then(todoServiceMock).should(times(2)).retrieveTodos(anyString());
		then(todoServiceMock).should(atMost(3)).retrieveTodos(anyString());
	}

	/**
	 * Non-BDD Style - Verify calls made to mock instance.
	 */
	@Test
	public void testDeleteTodosRelatedTopics_verifyCallsOnMockInstance() {

		// Given
		given(todoServiceMock.retrieveTodos("Vivek"))
				.willReturn(Arrays.asList(new String[] { "Learn JS", "Angual JS", "Node JS", "Learn jUnit" }));

		// When
		todoBusinessImpl.deleteTodosRelatedTopics("Vivek", "JS");

		// Then
		// User Vivek had 3 courses of JS.... Hence there should be 3 delete calls
		verify(todoServiceMock, times(3)).deleteTodos(anyString(), anyString());
		verify(todoServiceMock, never()).deleteTodos("Vivek", "Learn jUnit");
	}

	/**
	 * BDD Style - Verify calls made to mock instance.
	 */
	@Test
	public void testDeleteTodosRelatedTopics_bddStyleVerifyCallsOnMockInstance() {

		// Given
		given(todoServiceMock.retrieveTodos("Vivek"))
				.willReturn(Arrays.asList(new String[] { "Learn JS", "Angual JS", "Node JS", "Learn jUnit" }));

		// When
		todoBusinessImpl.deleteTodosRelatedTopics("Vivek", "JS");

		// Then
		then(todoServiceMock).should(times(3)).deleteTodos(stringArgCaptor.capture(), stringArgCaptor.capture());
		then(todoServiceMock).should(never()).deleteTodos("Vivek", "Learn jUnit");
		
		System.out.println(stringArgCaptor.getAllValues());
	}

}
