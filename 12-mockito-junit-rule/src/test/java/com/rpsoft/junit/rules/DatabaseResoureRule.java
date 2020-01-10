/**
 * 
 */
package com.rpsoft.junit.rules;

import org.junit.rules.ExternalResource;

/**
 * @author vivek
 *
 */
public class DatabaseResoureRule extends ExternalResource {

	@Override
	protected void before() throws Throwable {

		// setup database connection
		System.out.println("*********Database connection initialized successfully.");
	};

	@Override
	protected void after() {

		// Release resources
		System.out.println("*********Database connection closed.");
	};
}
