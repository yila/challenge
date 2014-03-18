package com.codingchallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.codingchallenge.domain.Employee;

public class Department {
	private DeptName deptName;
	private List<Employee> employees = new ArrayList<Employee>();

	public Department(DeptName deptName) {
		setDepartmentName(deptName);
	}

	public void addEmployees(Employee... employeesToAdd) {
		employees.addAll(Arrays.asList(employeesToAdd));
	}

	public int calculateMonthlyAllocatedExpense() {
		int monthlyAllocatedExpense = 0;
		for(Employee employee : employees){
			monthlyAllocatedExpense += employee.calculateMonthlyAllocatedAmount();
		}
		return monthlyAllocatedExpense;
	}

	public String getDeptName() {
		return deptName.getName();
	}

	public void setDepartmentName(DeptName deptName) {
		this.deptName = deptName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}
}
