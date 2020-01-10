/**
 * 
 */
package com.rpsoft.junit.rules;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.Timeout;

/**
 * @author vivek
 *
 */
public class TestDisableOnDebugRule {

	/**
	 * This demonstrates use of Timeout rule with DisableOnDebug rule.
	 */
	@Rule
	public DisableOnDebug debugDisabledTimeout = new DisableOnDebug(Timeout.seconds(5));

	@Test
	public void testTimeOutWithDebug() throws InterruptedException {
		System.out.println("Started.");

		// Sleep for 10 secs.
		TimeUnit.SECONDS.sleep(10);

		System.out.println("Completed.");
	}
}
