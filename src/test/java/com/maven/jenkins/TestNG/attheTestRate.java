package com.maven.jenkins.TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//same annotations are running in this script
// So far all were different annotations and we get to know which annotation will execute first
//When you have multiple SAME annotations for more than one methods. If annotations don't have any priority specified, 
//order in which it will be executed depending on Numbers(second),alphabets(Capital case letter first,Small case letter last): 
//A1Test1, A2Test1, a1Test1,aTest1, test1
//@BeforeSuite annotation: order of execution uppercase letter first, number second, lowercase letter last: B2suite, b1suite
//@BeforeMethod will run every time once before each @test annotation
//Likewise @AfterMethod will run every time once after each @test annotation
//Ideally you should not have any method without annotations. No main method in TestNG report
// In case if you have it.. how you will call it is using  annotations methods.
	

public class attheTestRate {
	
	
	@BeforeSuite
	public void b1suite() {
		System.out.println("b1suite @BeforeSuite");
	}
	
	@BeforeSuite
	public void B2suite() {
		System.out.println("B2suite @BeforeSuite");
	}
	
	@BeforeClass
	public void bclass() {
		System.out.println("bclass @BeforeClass");
	}
	
	@BeforeTest
	public void b1test() {
		System.out.println("b1test @BeforeTest");
	}
	

	@BeforeTest
	public void b2test() {
		System.out.println("b2test @BeforeTest");
	}
	
	@BeforeMethod
	public void bmethod() {
		System.out.println("bmethod @BeforeMethod");
	}
	
	@Test
	public void test1() {
		System.out.println("@test1");
	}
	@Test
	public void aTest1() {
		System.out.println("@aTest1");
	}
	@Test
	public void a1Test1() {
		System.out.println("@a1Test1");
	}
	@Test
	public void A1Test1() {
		System.out.println("@A1Test1");
	}
	@Test
	public void A2Test1() {
		System.out.println("@A2Test1");
	}
	
	@AfterMethod
	public void amethod() {
		System.out.println("amethod @AfterMethod");
	}

}
