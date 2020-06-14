package com.maven.jenkins.TestNG;

import org.testng.annotations.Test;

//you can even include a single testmethod in multiple or more than 1 groups using (groups={"sanity","regression"})
public class LoginGroup {
	
	@Test(groups="sanity")
	public void TC_Login_01() {
		System.out.println("TC_Login_01 Executed");
	}
	
	@Test(groups="regression")
	public void TC_Login_02() {
		System.out.println("TC_Login_02 Executed");
	}
	
	@Test(groups= {"sanity","regression"})
	public void TC_Login_03() {
		System.out.println("TC_Login_03 Executed");
	}
	
	@Test
	public void TC_Login_04() {
		System.out.println("TC_Login_04 Executed");
	}

}



