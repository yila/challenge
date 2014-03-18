package com.codingchallenge.domain;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

public class Manager extends Employee {
	private List<Employee> employeesAssigned = new ArrayList<Employee>();

	public Manager(String name, int allocatedAmount) {
		super(name, Title.MANAGER, allocatedAmount);
	}

	public void assignEmployee(Employee employee) throws RuntimeException {
		if(employee == this){
			throw new RuntimeErrorException(new Error(), "A manager cannot assign him/herself to self");
		}
		employeesAssigned.add(employee);
	}

	public List<Employee> getEmployeesAssigned() {
		return employeesAssigned;
	}

	@Override
	public int calculateMonthlyAllocatedAmount() {
		int totalAllocatedAmount = this.getAllocatedAmount();
		for(Employee employee : employeesAssigned){
			totalAllocatedAmount += employee.calculateMonthlyAllocatedAmount();
		}
		return totalAllocatedAmount;
	}

}
