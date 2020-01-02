/**
 * 
 */
package com.rpsoft.junit.mockito.data.api;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * Stub for TodoService.
 * 
 * @author vivek
 *
 */
public class TodoServiceStub implements TodoService {

	@Override
	public List<String> retrieveTodos(String user) {

		return Arrays.asList(new String[] { 
				"Learn Java", 
				"Learn Spring boot", 
				"Learn Spring MVC", 
				"Learn jUnit" });
	}

}
