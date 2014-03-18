package com.codingchallenge.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.codingchallenge.model.DaoInstanceFactory;
import com.codingchallenge.model.EmployeeDao;

public class DeveloperTest {

	@Test
	public void developerIsAlsoAnEmployee() {
		assertTrue(Employee.class.isAssignableFrom(Developer.class));
	}
	
	@Test
	public void developerConstructorShouldCreateDeveloperRoleByDefault(){
		Developer developer = new Developer("James");
		
		assertEquals("James", developer.getName());
		assertEquals(Title.DEVELOPER, developer.getTitle());
		assertEquals(1000, developer.getAllocatedAmount());
	}
	
	@Test
	public void shouldUseDaoToGetAllocatedAmount(){
		EmployeeDao dao = mock(EmployeeDao.class);
		DaoInstanceFactory.set(dao);
		when(dao.getAllocationForTitle(Title.DEVELOPER)).thenReturn(10);

		Developer developer = new Developer("James");
		
		assertEquals(10, developer.getAllocatedAmount());
		DaoInstanceFactory.set(null);
	}
	
	@Test
	public void shouldBeAbleToChangeName(){
		Developer developer = new Developer("James");
		
		developer.setName("Jane Doe");
		
		assertEquals("Jane Doe", developer.getName());
		assertEquals(Title.DEVELOPER, developer.getTitle());
		assertEquals(1000, developer.getAllocatedAmount());
	}
	
	@Test
	public void shouldBeAbleToChangeAllocatedAmount(){
		Developer developer = new Developer("James");
		
		developer.setAllocatedAmount(300);
		
		assertEquals("James", developer.getName());
		assertEquals(Title.DEVELOPER, developer.getTitle());
		assertEquals(300, developer.getAllocatedAmount());
	}
	
	
	@Test public void calculatedMonthlyCostShouldBeTheSameAsAssignedCost(){
		Developer developer = new Developer("James");
		
		assertEquals(1000, developer.calculateMonthlyAllocatedAmount());
	}
	
	@Test public void calculatedMonthlyCostShouldBeTheSameAsTheMostRecentAssignedCost(){
		Developer developer = new Developer("James");
		assertEquals(1000, developer.calculateMonthlyAllocatedAmount());
		
		developer.setAllocatedAmount(200);
		assertEquals(200, developer.calculateMonthlyAllocatedAmount());
	}
}
