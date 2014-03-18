package com.codingchallenge.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.management.RuntimeErrorException;

public class Manager extends Employee {
	private List<Employee> employeesAssigned = new ArrayList<Employee>();

	public Manager(String name, int allocatedAmount) {
		super(name, Title.MANAGER, allocatedAmount);
	}

	public void assignEmployees(Employee... employeesToAssign) {
		for(Employee employee : employeesToAssign){
			if(employee == this){
				throw new RuntimeErrorException(new Error(), "A manager cannot assign him/herself to self");
			}
		}
		employeesAssigned.addAll(Arrays.asList(employeesToAssign));
	}

	@Override
	public int calculateMonthlyAllocatedAmount() {
		int totalAllocatedAmount = this.getAllocatedAmount();
		for(Employee employee : employeesAssigned){
			totalAllocatedAmount += employee.calculateMonthlyAllocatedAmount();
		}
		return totalAllocatedAmount;
	}

	public List<Employee> getEmployeesAssigned() {
		return employeesAssigned;
	}

}
