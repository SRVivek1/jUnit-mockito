/**
 * 
 */
package com.rpsoft.junit.mockito;

/**
 * @author vivek
 *
 */
public class Employee {

	private String name;
	private String employeeId;
	private Double salary;

	/**
	 * Default constructor.
	 */
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param employeeId
	 * @param salary
	 */
	public Employee(String name, String employeeId, Double salary) {
		this.name = name;
		this.employeeId = employeeId;
		this.salary = salary;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the salary
	 */
	public Double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Double salary) {
		this.salary = salary;
	}
}
