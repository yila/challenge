package com.codingchallenge;

public enum DeptName {
	MARKETING("Marketing"), BILLING("Billing");
	
	private String name;
	private DeptName(String name){
		this.name = name;
	}
	
	public String getName(){ return name; }
}