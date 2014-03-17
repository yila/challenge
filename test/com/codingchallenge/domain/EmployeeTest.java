package com.codingchallenge.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void employeeShouldHaveANameTitleAndAllocatedAmountAtCreationTime() {
		Employee employee = new Employee("myname", Title.DEVELOPER, 100);

		assertEquals("myname", employee.getName());
		assertEquals(Title.DEVELOPER, employee.getTitle());
		assertEquals(100, employee.getAllocatedAmount());
	}

	@Test
	public void employeeShouldBeAbleToBeModifiable() {
		Employee employee = new Employee("myname", Title.DEVELOPER, 100);
		
		employee.setName("a different Name");
		employee.setTitle(Title.QA_TESTER);
		employee.setAllocatedAmount(40);

		assertEquals("a different Name", employee.getName());
		assertEquals(Title.QA_TESTER, employee.getTitle());
		assertEquals(40, employee.getAllocatedAmount());
	}
	
}
