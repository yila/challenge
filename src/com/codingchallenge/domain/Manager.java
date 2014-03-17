package com.codingchallenge.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.experimental.theories.internal.Assignments;

public class Manager extends Employee {
	private List<Employee> assignedEmployees = new ArrayList<Employee>();

	public Manager(String name, int allocatedAmount) {
		super(name, Title.MANAGER, allocatedAmount);
	}

	public void assignEmployee(Employee employee) {
		assignedEmployees.add(employee);
	}

	public List<Employee> getAssignedEmployees() {
		return assignedEmployees;
	}


}
