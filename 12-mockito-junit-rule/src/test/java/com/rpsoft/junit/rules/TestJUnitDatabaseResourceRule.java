/**
 * 
 */
package com.rpsoft.junit.rules;

import org.junit.ClassRule;
import org.junit.Test;

/**
 * @author vivek
 *
 */
public class TestJUnitDatabaseResourceRule {

	@ClassRule
	public static DatabaseResoureRule databaseResoure = new DatabaseResoureRule();
	
	@Test
	public void testInsertRecord() {
		System.out.println("Employee record added");
		
	}
	
	@Test
	public void testUpdateRecord() {
		System.out.println("Employee record updated");
		
	}
	
	@Test
	public void testDeleteRecord() {
		System.out.println("Employee record deleted");
		
	}
}
