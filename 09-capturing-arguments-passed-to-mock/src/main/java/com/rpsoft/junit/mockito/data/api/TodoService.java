/**
 * 
 */
package com.rpsoft.junit.mockito.data.api;

import java.util.List;

/**
 * @author vivek
 *
 */
public interface TodoService {

	public List<String> retrieveTodos(String user);
	
	public Boolean deleteTodos(String user, String topic);
}
