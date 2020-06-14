package com.maven.jenkins.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*TestNG is an automation testing framework in which NG stands for "Next Generation". Inspired by Junit
.java file - 1st line of execution of code starts from main function -- traverse Sequentially 
TestNG for testing purpose only
TestNG approach you can play around with controls/execution -- by using Annotations without main method
you can get to know execution status by methods wise -- 
// public void method1(){
//}
// public void method2(){
//}
prioritize your test cases
run particular test case with different data's
Default Reporting format(TestNg)
create a Maven project
TestNG for exclipse
install TestNG plugin to your eclipse -- help --> Eclipse MarketPlace --> // To run .java file using testNg
import TestNG libraries, mvnrepository: testNG dependencies:6.14.3 version
.java file>> Run As>>TestNG Test
Right-click >> Maven>> Update Project >> test-output folder will be created under com.qa.TestNG maven project 
emailable-report.html >> right click >>open with web browser >> TestNG Report: testcase is passed or failed
Sequence of annotations for execution:
@BeforeSuite>>
	@BeforeTest>>
		@BeforeClass>>
			@BeforeMethod>>
					@test>> // (write your test cases here. @test will be only captured in report). rest all annotations are supportive.
			@AfterMethod>>
		@AfterClass>>
	@AfterTest>>
@AfterSuite
Note: Execution or control starts from @BeforeSuiteonly.
It is not mandatory to have all annotations written. Its your choice to use annotations for test case written. only @test is mandatory.
*/

public class Annotations {
	//TestNG supports Annotations
	
	@BeforeSuite
	public void bsuite() {
		System.out.println("suite1 @BeforeSuite");
	}
	@AfterSuite
	public void asuite() {
		System.out.println("suite2 @AfterSuite");
		
	}
	@BeforeClass
	public void bclass() {
		System.out.println("class1 @BeforeClass");
	}
	@AfterClass
	public void aclass() {
		System.out.println("class2 @AfterClass");
	}
	
	@BeforeTest
	public void btest() {
		System.out.println("test1 @BeforeTest");
	}
	@AfterTest
	public void atest() {
		System.out.println("test2 @AfterTest");
	}
	@Test
	public void test() {
		System.out.println("run testNG method");
	}
	@BeforeMethod
	public void bmethod() {
		System.out.println("method1 @BeforeMethod");
	}
	@AfterMethod
	public void amethod() {
		System.out.println("method2 @AfterMethod");
	}
	
}
