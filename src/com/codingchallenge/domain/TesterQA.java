package com.codingchallenge.domain;

import com.codingchallenge.model.DaoInstanceFactory;
import com.codingchallenge.model.EmployeeDao;


public class TesterQA extends Employee{

	private EmployeeDao dao = DaoInstanceFactory.getDao();
	
	public TesterQA(String name) {
		super(name, Title.QA_TESTER);
		setAllocatedAmount(dao.getAllocationForTitle(Title.QA_TESTER));
	}

	@Override
	public int calculateMonthlyAllocatedAmount() {
		return this.getAllocatedAmount();
	}

}
