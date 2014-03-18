package com.codingchallenge.domain;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class ManagerTest {
	Manager manager = new Manager("dude", 1000);

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

		manager.assignEmployees(developer1, developer2, tester);

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
		manager2.assignEmployees(developer1, developer2, tester);
		Developer developer3 = new Developer("dev3", 999);
		
		manager.assignEmployees(manager2, developer3);

		List<Employee> employeesAssigned = manager.getEmployeesAssigned();
		assertEquals(2, employeesAssigned.size());
		assertEquals(manager2, employeesAssigned.get(0));
		assertEquals(3, manager2.getEmployeesAssigned().size());
		assertEquals(developer3, employeesAssigned.get(1));
	}
	
	@Test public void monthlyAllocatedAmountShouldBeTheTotalOfAllTheAmountsOfSubordinatesPlusSelf(){
		Developer developer1 = new Developer("dev1", 850);
		Developer developer2 = new Developer("dev2", 900);
		TesterQA tester = new TesterQA("the Only tester", 200);
		Manager manager2 = new Manager("manager2", 200);
		manager2.assignEmployees(developer1, developer2, tester);
		Developer developer3 = new Developer("dev3", 999);
		
		manager.assignEmployees(manager2, developer3);
		
		assertEquals(4149, manager.calculateMonthlyAllocatedAmount());

	}
	
	@Test public void flixibleEnoughToAddMultipleManagers(){
		Developer developer1 = new Developer("dev1", 500);
		Developer developer2 = new Developer("dev2", 500);
		TesterQA tester1 = new TesterQA("the Only tester", 100);
		Manager manager1 = new Manager("manager2", 500);
		manager1.assignEmployees(developer1, developer2, tester1);
		
		Developer developer3 = new Developer("dev1", 500);
		TesterQA tester2 = new TesterQA("the Only tester", 100);
		Manager manager2 = new Manager("manager2", 500);
		manager2.assignEmployees(developer3, tester2);

		manager.assignEmployees(manager1, manager2);
		
		assertEquals(3700, manager.calculateMonthlyAllocatedAmount());
	}

	@Test(expected=RuntimeException.class)
	public void throwAnExceptionWhenManagerIsAssignedToHimselfOrHerself() throws RuntimeException{
			manager.assignEmployees(manager);
	}
	
	@Test
	public void messageWhenThrowingTheException(){
		try{
			manager.assignEmployees(manager);
			fail("Should throw an exception!!!");
		}catch(RuntimeException e){
			assertEquals("A manager cannot assign him/herself to self", e.getMessage());
		}
	}
}
