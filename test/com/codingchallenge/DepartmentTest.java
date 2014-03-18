package com.codingchallenge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.codingchallenge.domain.Developer;
import com.codingchallenge.domain.Employee;
import com.codingchallenge.domain.Manager;
import com.codingchallenge.domain.TesterQA;

public class DepartmentTest {

	@Test
	public void departmentNameShouldComeFromTheEnum() {
		Department department = new Department(DeptName.MARKETING);
		
		assertEquals("Marketing", department.getDeptName());
	}
	
	@Test
	public void shouldBeAbleToModifyTheDepartmentName() {
		Department department = new Department(DeptName.MARKETING);
		
		department.setDepartmentName(DeptName.BILLING);
		
		assertEquals("Billing", department.getDeptName());
	}
	
	
	@Test
	public void shouldBeAbleToAssignASingleEmployeeDirectlyToADepartment() {
		Department department = new Department(DeptName.BILLING);
		Developer developer = new Developer("Jane Doe");
		
		department.addEmployees(developer);
		
		assertEquals(developer, department.getEmployees().get(0));
	}
	
	@Test
	public void shouldBeAbleToAddMultipleEmployeesAlltogetherToTheDepartment(){
		Department department = new Department(DeptName.MARKETING);
		Developer developer = new Developer("Jane Doe");
		TesterQA tester = new TesterQA("Shane the Best");
		Manager manager = new Manager("Marry");
		
		department.addEmployees(developer, tester, manager);
		
		List<Employee> employees = department.getEmployees();
		assertEquals(3, employees.size());
		assertEquals(developer, employees.get(0));
		assertEquals(tester, employees.get(1));
		assertEquals(manager, employees.get(2));
	}

	@Test
	public void shouldReturnAnEmptyListIfNoEmployeesHavBeenAdded(){
		Department department = new Department(DeptName.MARKETING);
		
		assertTrue(department.getEmployees().isEmpty());
	}
	
	@Test
	public void monthlyAllocatedExpenseShouldBeTheSumOfAllExpensesOfEmployeesInTheDepartment(){
		Department department = new Department(DeptName.MARKETING);
		Developer developer1 = new Developer("Jane Doe");
		TesterQA tester1 = new TesterQA("Shane the Best");
		Manager manager = new Manager("Marry");
		Developer developer2 = new Developer("Bob the Builder");
		TesterQA tester2 = new TesterQA("Judy the Tester");
		manager.assignEmployees(developer2, tester2);
		
		department.addEmployees(developer1, tester1, manager);
		
		assertEquals(3300, department.calculateMonthlyAllocatedExpense());
	}
}
