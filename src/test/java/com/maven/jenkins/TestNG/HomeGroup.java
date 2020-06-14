package com.maven.jenkins.TestNG;

import org.testng.annotations.Test;

//How to mention groups for test methods? How to run a specific groups test methods? How to mention groups in suite?
//add (groups="sanity") to @test methods.
//create testng.xml for 2 class files: 
//In testng.xml: change suite name. below <test> tag, create <groups> </groups> tag , before <classes> </classes> tag starts
//within <groups></groups> tag, place <run> </run> tag
//within <run> </run>, place <include name="sanity"/> , <include name="regression"/> tags before each <class name= ""/>


public class HomeGroup {

	@Test(groups="sanity")
	public void TC_Home_01() {
		System.out.println("TC_Home_01 Executed");
	}
	
	@Test(groups="regression")
	public void TC_Home_02() {
		System.out.println("TC_Home_02 Executed");
	}

	
}
