/**
 * 
 */
package com.rpsoft.junit.mockito.utility;

/**
 * @author vivek
 *
 */
public class UtilityService {

	/**
	 * This static method does some business calculations here.
	 * 
	 * @return
	 */
	public static int staticMethodDemo(long value) {
		
		// Some business logic goes here.....

		throw new RuntimeException("Not doing anything, I must be stubbed/mocked.");
	}
}
