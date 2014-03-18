package com.codingchallenge.domain;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.codingchallenge.model.DaoInstanceFactory;
import com.codingchallenge.model.EmployeeDao;

public class TesterQATest {

	@Test
	public void testerIsAlsoAnEmployee() {
		assertTrue(Employee.class.isAssignableFrom(TesterQA.class));
	}

	@Test
	public void testerQAConstructorShouldCreateDeveloperRoleByDefault() {
		TesterQA tester1 = new TesterQA("Dave the tester");
		TesterQA tester2 = new TesterQA("Bobby the tester");
		TesterQA tester3 = new TesterQA("The bestes tester");

		assertEquals(Title.QA_TESTER, tester1.getTitle());
		assertEquals(Title.QA_TESTER, tester2.getTitle());
		assertEquals(Title.QA_TESTER, tester3.getTitle());
	}

	@Test
	public void calculatedAmountShouldBeTheSameAsAllocatedAmount() {
		TesterQA tester = new TesterQA("The bestes tester");

		assertEquals(500, tester.calculateMonthlyAllocatedAmount());
	}
	
	@Test
	public void calculatedAmountShouldBeTheSameAsMostCurrentAssignedAllocatedAmount() {
		TesterQA tester = new TesterQA("The bestes tester");
		assertEquals(500, tester.calculateMonthlyAllocatedAmount());
		
		tester.setAllocatedAmount(300);
		assertEquals(300, tester.calculateMonthlyAllocatedAmount());
	}

	@Test
	public void shouldUseDaoToGetAllocatedAmount(){
		EmployeeDao dao = mock(EmployeeDao.class);
		DaoInstanceFactory.set(dao);
		when(dao.getAllocationForTitle(Title.QA_TESTER)).thenReturn(1000);

		TesterQA tester = new TesterQA("James");
		
		assertEquals(1000, tester.getAllocatedAmount());
		DaoInstanceFactory.set(null);
	}

}
