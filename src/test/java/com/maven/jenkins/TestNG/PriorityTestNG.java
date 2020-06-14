package com.maven.jenkins.TestNG;

import org.testng.annotations.Test;

//When you have SAME annotations for more than one methods. and if you used priority to it.
//It works on priority. 
//Higher the priority(in terms of number: 1 is higher priority) then execution order starts from 1.
//When you have not given an priority to any of the method then Annotations by default it will assume the priority as 0
//0,1,10 (// -1,0,1,10)
//Priority can be used only for @Test annotations only :  
//we cannot prioritize the @BeforeSuite annotations and other annotations
//enabled is the tag which is used to block the execution of methods
//false: to not run @test, true: to run a test	

public class PriorityTestNG {
	
	
	@Test(priority=1)
	public void m1() {
		System.out.println("@Test M1");
	}
	
	@Test
	public void aM1() {
		System.out.println("@Test aM1");
	}
	
	@Test(priority=-1,enabled=true)
	public void a1M1() {
		System.out.println("@Test a1M1");
	}
	
	@Test(priority=10)
	public void A2M1() {
		System.out.println("@Test A2M1");
	}


}
