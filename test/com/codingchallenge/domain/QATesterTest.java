package com.codingchallenge.domain;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.codingchallenge.model.DaoInstanceFactory;
import com.codingchallenge.model.EmployeeDao;

public class QATesterTest {

	@Test
	public void testerIsAlsoAnEmployee() {
		assertTrue(Employee.class.isAssignableFrom(QATester.class));
	}

	@Test
	public void testerQAConstructorShouldCreateDeveloperRoleByDefault() {
		QATester tester1 = new QATester("Dave the tester");
		QATester tester2 = new QATester("Bobby the tester");
		QATester tester3 = new QATester("The bestes tester");

		assertEquals(Title.QA_TESTER, tester1.getTitle());
		assertEquals(Title.QA_TESTER, tester2.getTitle());
		assertEquals(Title.QA_TESTER, tester3.getTitle());
	}

	@Test
	public void calculatedAmountShouldBeTheSameAsAllocatedAmount() {
		QATester tester = new QATester("The bestes tester");

		assertEquals(500, tester.calculateMonthlyAllocatedAmount());
	}
	
	@Test
	public void calculatedAmountShouldBeTheSameAsMostCurrentAssignedAllocatedAmount() {
		QATester tester = new QATester("The bestes tester");
		assertEquals(500, tester.calculateMonthlyAllocatedAmount());
		
		tester.setAllocatedAmount(300);
		assertEquals(300, tester.calculateMonthlyAllocatedAmount());
	}

	@Test
	public void shouldUseDaoToGetAllocatedAmount(){
		EmployeeDao dao = mock(EmployeeDao.class);
		DaoInstanceFactory.set(dao);
		when(dao.getAllocationForTitle(Title.QA_TESTER)).thenReturn(1000);

		QATester tester = new QATester("James");
		
		assertEquals(1000, tester.getAllocatedAmount());
		DaoInstanceFactory.set(null);
	}

}
