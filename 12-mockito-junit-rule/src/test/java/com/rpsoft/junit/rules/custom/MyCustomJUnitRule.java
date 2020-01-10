package com.rpsoft.junit.rules.custom;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * My Custom jUnit rule.
 * 
 * @author vivek
 *
 */
public class MyCustomJUnitRule implements TestRule {

	@Override
	public Statement apply(Statement base, Description description) {

		return new Statement() {

			@Override
			public void evaluate() throws Throwable {

				// Do before execution activity
				System.out.println("Before test : " + description);

				try {
					base.evaluate();
				} finally {

					// Do after execution activity
					System.out.println("After test : " + description);
				}
			}
		};
	}
}
