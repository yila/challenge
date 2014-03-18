package com.codingchallenge.domain;

import static org.junit.Assert.*;

import java.util.List;

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
	public void managerWithNoEmployeesAssignedShouldReturnAnEmptyList() {
		assertEquals(0, manager.getEmployeesAssigned().size());
	}

	@Test
	public void managerShouldBeAbleToAssignAnyEmployee() throws RuntimeException {
		Developer developer1 = new Developer("dev1", 850);
		Developer developer2 = new Developer("dev2", 900);
		TesterQA tester = new TesterQA("the Only tester", 200);

		manager.assignEmployee(developer1);
		manager.assignEmployee(developer2);
		manager.assignEmployee(tester);

		List<Employee> employeesAssigned = manager.getEmployeesAssigned();
		assertEquals(3, employeesAssigned.size());
		assertEquals(developer1, employeesAssigned.get(0));
		assertEquals(developer2, employeesAssigned.get(1));
		assertEquals(tester, employeesAssigned.get(2));
	}

	@Test
	public void aManagerCanHaveAnotherManagerUnderHimOrHer() throws RuntimeException {
		Developer developer1 = new Developer("dev1", 850);
		Developer developer2 = new Developer("dev2", 900);
		TesterQA tester = new TesterQA("the Only tester", 200);
		Manager manager2 = new Manager("manager2", 200);
		manager2.assignEmployee(developer1);
		manager2.assignEmployee(developer2);
		manager2.assignEmployee(tester);
		Developer developer3 = new Developer("dev3", 999);
		
		manager.assignEmployee(manager2);
		manager.assignEmployee(developer3);

		List<Employee> employeesAssigned = manager.getEmployeesAssigned();
		assertEquals(2, employeesAssigned.size());
		assertEquals(manager2, employeesAssigned.get(0));
		assertEquals(3, manager2.getEmployeesAssigned().size());
		assertEquals(developer3, employeesAssigned.get(1));
	}
	
	@Test(expected=RuntimeException.class)
	public void throwAnExceptionWhenManagerIsAssignedToHimselfOrHerself() throws RuntimeException{
			manager.assignEmployee(manager);
	}
	
	@Test
	public void messageWhenThrowingTheException(){
		try{
			manager.assignEmployee(manager);
		}catch(RuntimeException e){
			assertEquals("Cannot assign a manager to him/herself", e.getMessage());
		}
	}

}
