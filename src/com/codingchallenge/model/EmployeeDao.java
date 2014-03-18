package com.codingchallenge.model;

import java.util.HashMap;
import java.util.Map;

import com.codingchallenge.domain.Title;

public class EmployeeDao {
	
	Map<Title, Integer> titleToAllocationMap;;
	
	public EmployeeDao() {
		titleToAllocationMap = new HashMap<Title, Integer>();
		titleToAllocationMap.put(Title.DEVELOPER, 1000);
		titleToAllocationMap.put(Title.QA_TESTER, 500);
		titleToAllocationMap.put(Title.MANAGER, 300);
	}
	
	public int getAllocationForTitle(Title title){
		return titleToAllocationMap.get(title);
	}

}
