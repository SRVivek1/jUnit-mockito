/**
 * 
 */
package com.rpsoft.junit.rules.custom;

import org.junit.Rule;
import org.junit.Test;

/**
 * @author vivek
 *
 */
public class TestMyCustomJUnitRule {

	@Rule
	public MyCustomJUnitRule myCustomJUnitRule = new MyCustomJUnitRule();
	
	@Test
	public void testHelloWorldPrint() {
		System.out.println("Hello World - jUnit custom rules.");
	}
}
