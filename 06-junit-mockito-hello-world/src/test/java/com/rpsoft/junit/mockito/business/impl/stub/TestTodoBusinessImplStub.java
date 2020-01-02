/**
 * 
 */
package com.rpsoft.junit.mockito.business.impl.stub;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.rpsoft.junit.mockito.business.impl.TodoBusinessImpl;
import com.rpsoft.junit.mockito.data.api.TodoService;
import com.rpsoft.junit.mockito.data.api.TodoServiceStub;

/**
 * @author vivek
 *
 */
public class TestTodoBusinessImplStub {

	TodoService todoServiceStub = new TodoServiceStub();
	TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);

	/**
	 * Test count of todos.
	 */
	@Test
	public void testRetrieveTodosRelatedToSpring_usingStub_contentSize() {

		List<String> springTodosList = todoBusinessImpl.retrieveTodosRelatedToSpring("user");

		// Assert size
		assertEquals(2, springTodosList.size());

	}
	
	/**
	 * Compare content of todos.
	 */
	@Test
	public void testRetrieveTodosRelatedToSpring_usingStub_contentMatching() {

		List<String> springTodosList = todoBusinessImpl.retrieveTodosRelatedToSpring("user");

		// Assert content
		String[] springTodos = new String[springTodosList.size()];
		springTodosList.toArray(springTodos);

		assertArrayEquals(new String[] { "Learn Spring boot", "Learn Spring MVC" }, springTodos);
	}

}
