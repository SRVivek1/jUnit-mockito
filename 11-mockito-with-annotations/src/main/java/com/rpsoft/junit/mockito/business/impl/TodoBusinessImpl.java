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
	public List<String> retrieveTodos(String user) {

		return todoService.retrieveTodos(user);
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

	/**
	 * Retrieve todos for the users related to provided topic.
	 * 
	 * @param user
	 * @param topic
	 * @return
	 */
	public List<String> retrieveTodosRelatedTopics(String user, String topic) {

		List<String> filteredTodos = new ArrayList<>();

		Stream<String> todosStream = todoService.retrieveTodos(user).stream();

		filteredTodos = todosStream.filter(todo -> todo.contains(topic)).collect(Collectors.toList());

		return filteredTodos;
	}

	/**
	 * Delete todos for the users related to provided topic.
	 * 
	 * @param user
	 * @param topic
	 * @return
	 */
	public Boolean deleteTodosRelatedTopics(String user, String topic) {

		List<String> todosList = todoService.retrieveTodos(user);

		Boolean succeed = false;

		for (String todo : todosList) {
			if (todo.contains(topic)) {
				todoService.deleteTodos(user, todo);
			}
		}

		return succeed;
	}
}
