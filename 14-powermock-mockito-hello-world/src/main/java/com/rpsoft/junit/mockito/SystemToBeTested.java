/**
 * 
 */
package com.rpsoft.junit.mockito;

import java.util.ArrayList;
import java.util.List;

import com.rpsoft.junit.mockito.service.RemoteService;
import com.rpsoft.junit.mockito.utility.UtilityService;

/**
 * @author vivek
 *
 */
public class SystemToBeTested {

	private RemoteService remoteService;

	/**
	 * Dafault constructor support.
	 */
	/*
	 * public SystemToBeTested() { // TODO Auto-generated constructor stub }
	 */

	/**
	 * @param remoteService
	 */
	public SystemToBeTested(RemoteService remoteService) {
		super();
		this.remoteService = remoteService;
	}

	/**
	 * A method using 'ArrayList' constructor inside method.
	 * 
	 * @return
	 */
	public int methodUsingAnArrayListConstructor() {
		final List<String> list = new ArrayList<>();
		return list.size();
	}

	/**
	 * A method making call to another class static method.
	 * 
	 * @return
	 */
	public long methodInternallyCallingStaticMethod() {

		final List<Integer> stats = remoteService.retrieveAllStats();

		long sum = calculateSumOfStats(stats);

		// Call to static method of a utility class.
		return UtilityService.staticMethodDemo(sum);
	}

	/**
	 * A private method calculating sum of stats.
	 * 
	 * @return
	 */
	private long calculateSumOfStats(List<Integer> stats) {

		if (stats == null || stats.isEmpty()) {
			stats = remoteService.retrieveAllStats();
		}

		int sum = 0;
		for (Integer stat : stats) {
			sum += stat;
		}

		return sum;
	}

	/**
	 * @return the remoteService
	 */
	public final RemoteService getRemoteService() {
		return remoteService;
	}

	/**
	 * @param remoteService the remoteService to set
	 */
	public final void setRemoteService(RemoteService remoteService) {
		this.remoteService = remoteService;
	}
}
