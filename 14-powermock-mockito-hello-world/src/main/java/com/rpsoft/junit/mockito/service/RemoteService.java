/**
 * 
 */
package com.rpsoft.junit.mockito.service;

import java.util.List;

/**
 * @author vivek
 *
 */
public interface RemoteService {

	/**
	 * Retrieve stats.
	 * 
	 * @return
	 */
	public List<Integer> retrieveAllStats();
}
