package com.codingchallenge.domain;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

import com.codingchallenge.model.DaoInstanceFactory;
import com.codingchallenge.model.EmployeeDao;

public class ManagerTest {
	Manager manager = new Manager("dude");

	@Test
	public void managerTitleShouldBeManager() {
		assertEquals(Title.MANAGER, manager.getTitle());
	}

	@Test
	public void managerWithNoEmployeesAssignedShouldReturnAnEmptyList() {
		assertEquals(0, manager.getEmployeesAssigned().size());
	}

	@Test
	public void managersDefaultAllocationAmountShouldBe300(){
		assertEquals(300, manager.getAllocatedAmount());
	}
	
	@Test
	public void managerShouldBeAbleToAssignAnyEmployee() throws RuntimeException {
		Developer developer1 = new Developer("dev1");
		Developer developer2 = new Developer("dev2");
		TesterQA tester = new TesterQA("the Only tester");

		manager.assignEmployees(developer1, developer2, tester);

		List<Employee> employeesAssigned = manager.getEmployeesAssigned();
		assertEquals(3, employeesAssigned.size());
		assertEquals(developer1, employeesAssigned.get(0));
		assertEquals(developer2, employeesAssigned.get(1));
		assertEquals(tester, employeesAssigned.get(2));
	}

	@Test
	public void aManagerCanHaveAnotherManagerUnderHimOrHer() throws RuntimeException {
		Developer developer1 = new Developer("dev1");
		Developer developer2 = new Developer("dev2");
		TesterQA tester = new TesterQA("the Only tester");
		Manager manager2 = new Manager("manager2");
		manager2.assignEmployees(developer1, developer2, tester);
		Developer developer3 = new Developer("dev3");
		
		manager.assignEmployees(manager2, developer3);

		List<Employee> employeesAssigned = manager.getEmployeesAssigned();
		assertEquals(2, employeesAssigned.size());
		assertEquals(manager2, employeesAssigned.get(0));
		assertEquals(3, manager2.getEmployeesAssigned().size());
		assertEquals(developer3, employeesAssigned.get(1));
	}
	
	@Test public void monthlyAllocatedAmountShouldBeTheTotalOfAllTheAmountsOfSubordinatesPlusSelf(){
		Developer developer1 = new Developer("dev1");
		Developer developer2 = new Developer("dev2");
		TesterQA tester = new TesterQA("the Only tester");
		Manager manager2 = new Manager("manager2");
		manager2.assignEmployees(developer1, developer2, tester);
		Developer developer3 = new Developer("dev3");
		
		manager.assignEmployees(manager2, developer3);
		
		assertEquals(4100, manager.calculateMonthlyAllocatedAmount());

	}
	
	@Test public void flixibleEnoughToAddMultipleManagers(){
		Developer developer1 = new Developer("dev1");
		Developer developer2 = new Developer("dev2");
		TesterQA tester1 = new TesterQA("the Only tester");
		Manager manager1 = new Manager("manager2");
		manager1.assignEmployees(developer1, developer2, tester1);
		
		Developer developer3 = new Developer("dev1");
		TesterQA tester2 = new TesterQA("the Only tester");
		Manager manager2 = new Manager("manager2");
		manager2.assignEmployees(developer3, tester2);

		manager.assignEmployees(manager1, manager2);
		
		assertEquals(4900, manager.calculateMonthlyAllocatedAmount());
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
	@Test
	public void shouldUseDaoToGetAllocatedAmount(){
		EmployeeDao dao = mock(EmployeeDao.class);
		DaoInstanceFactory.set(dao);
		when(dao.getAllocationForTitle(Title.MANAGER)).thenReturn(2000);

		Manager manager = new Manager("James");
		
		assertEquals(2000, manager.getAllocatedAmount());
		DaoInstanceFactory.set(null);
	}
	
	@Test
	public void SCENARIO_FROM_REQUIREMENTS(){
		Developer developer = new Developer("dev1");
		TesterQA tester = new TesterQA("the Only tester");
		Manager managerB = new Manager("Manager B");
		managerB.assignEmployees(developer, tester);
		
		manager.assignEmployees(managerB);
		
		assertEquals(2100, manager.calculateMonthlyAllocatedAmount());
	}

}
