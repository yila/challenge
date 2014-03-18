package com.codingchallenge.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.codingchallenge.domain.Title;

public class EmployeeDaoTest {

	@Test
	public void mimimalTest() {
		EmployeeDao dao = new EmployeeDao();
		assertEquals(1000, dao.getAllocationForTitle(Title.DEVELOPER));
		assertEquals(500, dao.getAllocationForTitle(Title.QA_TESTER));
		assertEquals(300, dao.getAllocationForTitle(Title.MANAGER));
	}

}
