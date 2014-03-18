package com.codingchallenge.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DaoInstanceFactoryTest {

	@Test
	public void returnTheSameInstanceOfTheDaoThatWasSet(){
		EmployeeDao dao = new EmployeeDao();
		
		DaoInstanceFactory.set(dao);
		
		assertSame(dao, DaoInstanceFactory.getDao());
	}

	@Test
	public void aNewInstanceOfDaoShouldBeReturnedWhenThereIsNoneAvailable() {
		DaoInstanceFactory.set(null);
		
		assertNotNull(DaoInstanceFactory.getDao());
		assertTrue(DaoInstanceFactory.getDao() instanceof EmployeeDao);
	}

}
