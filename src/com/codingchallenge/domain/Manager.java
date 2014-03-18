package com.codingchallenge.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.management.RuntimeErrorException;

import com.codingchallenge.model.DaoInstanceFactory;
import com.codingchallenge.model.EmployeeDao;

public class Manager extends Employee {
	private EmployeeDao dao = DaoInstanceFactory.getDao();
	private List<Employee> employeesAssigned = new ArrayList<Employee>();

	public Manager(String name) {
		super(name, Title.MANAGER);
		setAllocatedAmount(dao.getAllocationForTitle(Title.MANAGER));
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
