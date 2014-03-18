package com.codingchallenge.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesterQATest {

	@Test
	public void testerIsAlsoAnEmployee() {
		assertTrue(Employee.class.isAssignableFrom(TesterQA.class));
	}
	
	@Test
	public void testerQAConstructorShouldCreateDeveloperRoleByDefault(){
		TesterQA tester1 = new TesterQA("Dave the tester", 89);
		TesterQA tester2 = new TesterQA("Bobby the tester", 45);
		TesterQA tester3 = new TesterQA("The bestes tester", 678);
		
		assertEquals(Title.QA_TESTER, tester1.getTitle());
		assertEquals(Title.QA_TESTER, tester2.getTitle());
		assertEquals(Title.QA_TESTER, tester3.getTitle());
	}
}
