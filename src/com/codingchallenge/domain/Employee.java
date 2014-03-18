package com.codingchallenge.domain;


public abstract class Employee {

	private String name;
	private final Title title;
	private int allocatedAmount;

	public Employee(String name, Title title) {
		this.name = name;
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public Title getTitle() {
		return title;
	}

	public int getAllocatedAmount() {
		return allocatedAmount;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAllocatedAmount(int allocatedAmount) {
		this.allocatedAmount = allocatedAmount;
	}
	
	public abstract int calculateMonthlyAllocatedAmount();
}
