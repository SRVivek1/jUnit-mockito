/**
 * 
 */
package com.rpsoft.junit.rules;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.isA;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestName;
import org.junit.rules.Timeout;
import org.junit.rules.Verifier;

/**
 * @author vivek
 *
 */
public class TestJUnitPredefinedRules {

	/**
	 * This rule helps get the name of currently executing test case.
	 */
	@Rule
	public TestName testName = new TestName();

	/**
	 * This rule helps in creating temporary folders and files.
	 */
	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();

	/**
	 * This rule helps verify that particular test case throws an expected exception
	 * or not.
	 */
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	/**
	 * The Timeout Rule applies the same timeout to all test methods in a class.
	 */
	@Rule
	public Timeout timeout = new Timeout(5, TimeUnit.SECONDS);

	/**
	 * The ErrorCollector rule allows execution of a test to continue after the
	 * first problem is found.
	 */
	@Rule
	public ErrorCollector errorCollector = new ErrorCollector();

	/**
	 * Verifier is a base class for Rules like ErrorCollector, which can
	 * turn otherwise passing test methods into failing tests if a verification check
	 * is failed.
	 */
	@Rule
	public Verifier verifier = new Verifier() {

		@Override
		protected void verify() throws Throwable {
			System.out.println("Verifier#Verify : " + testName.getMethodName());
		};
	};

	/**
	 * This is implementation of ExternalResource rule.
	 */
	@Rule
	public DatabaseResoureRule databaseResource = new DatabaseResoureRule();
	
	@Test
	public void testPrintHelloWorld_positiveTest() throws IOException, InterruptedException {

		// TestName Rule
		System.out.println("Executing : " + testName.getMethodName());

		// TemporaryFolder Rule
		System.out.println("Temp Folder Path : " + temporaryFolder.getRoot().getPath());

		// Creates a new temporary file.
		temporaryFolder.newFile();
		temporaryFolder.newFile("temp_file_1.txt");

		// Creates a new folder.
		temporaryFolder.newFolder();

		// Creates folder hierarchy
		temporaryFolder.newFolder("x", "xy", "xyz");

		// Sleep current thread
		// TimeUnit.SECONDS.sleep(40);
	}

	@Test
	public void testPrintHelloWorld_negativeTest() {

		// TestName rule
		System.out.println("Executing : " + testName.getMethodName());

		// ExpectedException - expected exception check
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectCause(isA(NullPointerException.class));
		expectedException.expectMessage("Invalid Argument");

		throw new IllegalArgumentException("Invalid Argument, cannot be empty or null.", new NullPointerException());
	}

	/**
	 * Timeout rule tester.
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testTimeOutRule() throws InterruptedException {

		// Sleep will cause this method to take more than 10 seconds and therefore it
		// will terminated by Timeout rule.
		TimeUnit.SECONDS.sleep(10);
	}

	/**
	 * Test the functionality of ErrorCollector rule.
	 */
	@Test
	public void testErrorCollectorRule() {

		// First error occurred, instead of throwing it add in error collector.
		errorCollector.addError(new IllegalArgumentException("Invalid argument, cannot be nullor empty."));

		// Another exception identified.
		errorCollector.addError(new AssertionError("X must be identical to Y."));

		// Another check
		errorCollector.checkThat("Something went wrong, failure.", containsString("success"));

		// and so on till end of method.
		// Errors will be printed once the method execution completes.
	}
	
}
