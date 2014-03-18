package com.codingchallenge.domain;

import com.codingchallenge.model.DaoInstanceFactory;
import com.codingchallenge.model.EmployeeDao;

public class Developer extends Employee{

	private EmployeeDao dao = DaoInstanceFactory.getDao();
	
	public Developer(String name) {
		super(name, Title.DEVELOPER);
		setAllocatedAmount(dao.getAllocationForTitle(Title.DEVELOPER));
	}

	@Override
	public int calculateMonthlyAllocatedAmount() {
		return this.getAllocatedAmount();
	}
}
