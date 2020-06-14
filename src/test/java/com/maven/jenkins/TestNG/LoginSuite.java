package com.maven.jenkins.TestNG;

import org.testng.annotations.Test;

//How to generate a TestNG suite? 
//when there are 2 .java files or 2 class files and has to run multiple test methods in each class.
//select the class files>>> right-click + TestNG >> create TestNG class. You can select the methods you want to run in a single class.
//how to create a testng.xml file ---> select the class files>>>shift+right-click on .java files (class) ---> TestNG--->Convert to TestNG
//Generate testng.xml window: click finish. testng.xml file is created. rename testng.xml file. Edit .xml file to run
// testng.xml: source tab: name the suite name. within <test> </test> tag, place only one class file within classes tag.
//Select the testng.xml file>> right click>> run as > 1TestNG suite. Order in which class files in testng.xml are placed will be executed.
//TestNG report will have all test cases passed or failed and suite name reflected.
// Include and Exclude test methods in suite (testng.xml ) directly and start running required test methods in the suite:
//place <methods> </methods>tag within <class> </class> tag. 
//within <methods> tag, place <include name="" /> or <exclude name="" /> tags to place the test methods
//Note: Include for all TC_01,02,03,04 test methods, all 4 TC will be run
//Exclude TC_Login_03: only TC_Login_03 will not run, rest TC_01,02,04 will run.
//Include TC_Login_04: only TC_Login_04 will run, rest TC_01,02,03 will be excluded and not run.
//
//
public class LoginSuite {
	
	@Test
	public void TC_Login_01() {
		System.out.println("TC_Login_01 Executed");
	}
	
	@Test
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
	}

}



