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
		System.out.println(employee == this);
		if(employee == this){
			throw new RuntimeErrorException(new Error(), "Cannot assign a manager to him/herself");
		}
		employeesAssigned.add(employee);
	}

	public List<Employee> getEmployeesAssigned() {
		return employeesAssigned;
	}

}
