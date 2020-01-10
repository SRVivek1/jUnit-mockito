/**
 * 
 */
package com.rpsoft.junit.rules.chain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;

/**
 * @author vivek
 *
 */
public class TestRuleChainFunctionality {

	/**
	 * Rule Chain demonstration.
	 */
	@Rule
	public RuleChain ruleChain = RuleChain.outerRule(new LogAuditJUnitRule("Rule-1"))
			.around(new LogAuditJUnitRule("Rule-2")).around(new LogAuditJUnitRule("Rule-3"))
			.around(new LogAuditJUnitRule("Rule-4")).around(new LogAuditJUnitRule("Rule-5"));

	/**
	 * Message print test.
	 */
	@Test
	public void testHelloWorldPrint() {
		System.out.println("Hello World - RuleChain testing.");
	}
}
