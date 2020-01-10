/**
 * 
 */
package com.rpsoft.junit.rules.chain;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * @author vivek
 *
 */
public class LogAuditJUnitRule implements TestRule {

	private String ruleName;

	/**
	 * Constructor.
	 * 
	 * @param ruleName
	 */
	public LogAuditJUnitRule(String ruleName) {

		this.ruleName = ruleName;
	}

	@Override
	public Statement apply(Statement base, Description description) {

		return new Statement() {

			@Override
			public void evaluate() throws Throwable {

				ruleStartLogger();

				try {
					base.evaluate();
				} finally {
					ruleExitLogger();
				}
			}
		};
	}

	/**
	 * Logs audit message when rule execution starts.
	 */
	private void ruleStartLogger() {
		System.out.println("Starting : " + ruleName);
	}

	/**
	 * Logs audit message when rule execution ends.
	 */
	private void ruleExitLogger() {
		System.out.println("Finished : " + ruleName);
	}
}
