/**
 * 
 */
package com.rpsoft.junit.mockito.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.rpsoft.junit.mockito.data.api.TodoService;

/**
 * @author vivek
 *
 */
public class TodoBusinessImpl {

	private TodoService todoService;

	/**
	 * @param todoService
	 */
	public TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}

	/**
	 * Return Spring todos for the user.
	 * 
	 * @param user
	 * @return
	 */
	public List<String> retrieveTodosRelatedToSpring(String user) {

		return retrieveTodosRelatedTopics(user, "Spring");
	}

	public List<String> retrieveTodosRelatedTopics(String user, String topic) {

		List<String> filteredTodos = new ArrayList<>();

		Stream<String> todosStream = todoService.retrieveTodos(user).stream();

		filteredTodos = todosStream.filter(todo -> todo.contains(topic)).collect(Collectors.toList());

		return filteredTodos;
	}
}
