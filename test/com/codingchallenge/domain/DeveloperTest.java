package com.codingchallenge.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeveloperTest {

	@Test
	public void developerIsAlsoAnEmployee() {
		assertTrue(Employee.class.isAssignableFrom(Developer.class));
	}
	
	@Test
	public void developerConstructorShouldCreateDeveloperRoleByDefault(){
		Developer developer = new Developer("James", 1000);
		
		assertEquals("James", developer.getName());
		assertEquals(Title.DEVELOPER, developer.getTitle());
		assertEquals(1000, developer.getAllocatedAmount());
	}
	
	@Test
	public void shouldBeAbleToChangeName(){
		Developer developer = new Developer("James", 1000);
		
		developer.setName("Jane Doe");
		
		assertEquals("Jane Doe", developer.getName());
		assertEquals(Title.DEVELOPER, developer.getTitle());
		assertEquals(1000, developer.getAllocatedAmount());
	}
	
	@Test
	public void shouldBeAbleToChangeAllocatedAmount(){
		Developer developer = new Developer("James", 1000);
		
		developer.setAllocatedAmount(300);
		
		assertEquals("James", developer.getName());
		assertEquals(Title.DEVELOPER, developer.getTitle());
		assertEquals(300, developer.getAllocatedAmount());
	}
	
}
