package com.codingchallenge.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class ManagerTest {
	Manager manager = new Manager("dude", 1000);

	@Test
	public void managerIsAlsoAnEmployee() {
		assertTrue(Employee.class.isAssignableFrom(Manager.class));
	}

	@Test
	public void managerTitleShouldBeManager() {
		assertEquals(Title.MANAGER, manager.getTitle());
	}

	@Test
	public void variousEmployeesCanBeAssignedToAManager() {
		Employee developer1 = new Employee("dev1", Title.DEVELOPER, 1000);
		Employee developer2 = new Employee("dev2", Title.DEVELOPER, 1000);
		Employee tester = new Employee("tester", Title.QA_TESTER, 1000);
		Employee Manager = new Employee("dev2", Title.DEVELOPER, 1000);

		manager.assignEmployee(developer1);

		assertEquals(developer1, manager.getAssignedEmployees().get(0));
	}

}
