package com.codingchallenge.domain;

public class Developer extends Employee{

	public Developer(String name, int allocatedAmount) {
		super(name, Title.DEVELOPER, allocatedAmount);
	}

	@Override
	public int calculateMonthlyAllocatedAmount() {
		return this.getAllocatedAmount();
	}
}
