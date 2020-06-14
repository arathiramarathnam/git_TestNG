package com.maven.jenkins.TestNG;

import org.testng.annotations.Test;

//if TC_Login_01 testmethod is passed, then only I have to run TC_Login_02 
//add exception to 01: on running the java file: TC_Login_02 skipped as it depends on 01, TC_01 failed with exception, 03,04 passed
//After Login_01 is executed, Login_03,04 will not wait for any dependent test method. 
//But Login02 depends on 01, it will execute after 01 is executed successfully.
public class Login_dependsOnMethods {
	
	@Test
	public void TC_Login_01() throws Exception {//username and password field are isDisplayed or not
		System.out.println("TC_Login_01 Executed");
//		throw new Exception("Intentionally");
	}
	
	@Test(dependsOnMethods="TC_Login_01")
	public void TC_Login_02() {//if fields are displayed, pass the credentials for TC_Login02
		System.out.println("TC_Login_02 Executed");
	}
	
	@Test
	public void TC_Login_03() {
		System.out.println("TC_Login_03 Executed");
	}
	
	@Test
	public void TC_Login_04() {
		System.out.println("TC_Login_04 Executed");
	}

}



