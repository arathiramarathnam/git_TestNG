package com.maven.jenkins.TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotSame;

import org.testng.annotations.Test;
//you have entered valid credentials on login screen, home screen should be displayed.
//test case fails based on the actual value or expected value fails.
public class TestNG_Assertion {
	
	@Test
	public void TC_Login_01() throws Exception {
		System.out.println("TC_Login_01 Executed");
//		assertEquals(true, true); (actual value, expected value)
		//assertEquals(true, false); 
//		assertEquals(false,true, "home screen is not displayed");
		assertNotSame("user", "admin");
	}
	
/*	@Test
	public void TC_Login_02() {
		System.out.println("TC_Login_02 Executed");
	}
	
	@Test
	public void TC_Login_03() {
		System.out.println("TC_Login_03 Executed");
	}
	
	@Test
	public void TC_Login_04() {
		System.out.println("TC_Login_04 Executed");
	}*/

}
