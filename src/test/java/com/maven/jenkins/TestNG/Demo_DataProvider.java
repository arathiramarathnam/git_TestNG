package com.maven.jenkins.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;	

//100 data sets to be passed in a test case then we have data provider
//as supplying data for a test method. 
//The data provider name defaults to method name.
//The annotated method must return an new Object[][] where eachObject[] can be assigned the parameter list of the test method.
//The @Test method that wants to receive data from this DataProviderneeds to use a dataProvider name 
//equals to the name of this annotation.
public class Demo_DataProvider {
	
	@BeforeSuite
	public void dependencyTriggering() {
	BrowserUtility.launchBrowser("ch");
	}
			
	@AfterMethod
	public void settingURL() {
		if(BrowserUtility.driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).isDisplayed())
		{
			BrowserUtility.driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
			WebDriverWait wait = new WebDriverWait(BrowserUtility.driver, 30);
			wait.until(ExpectedConditions.visibilityOf(BrowserUtility.driver.findElement(By.id("email_field"))));
			System.out.println("Logout successful");
		}
	}
	
//    You must need to mention data provider method name in Test method
//data sets (values) needs to be parameterized here and since 3 data sets are passed, this test method will run 3 times
//how many ever data sets are passed in dataprovider, that many times, the test method will run.
	@Test(dataProvider="sUsernameandsPassword")
	public void checkLoginSuccessOrNot(String sUsername, String sPassword) throws Exception{
		System.out.println(sUsername+"\t"+sPassword);
		BrowserUtility.loginToBrowser(sUsername, sPassword);
		System.out.println("Login successful");
	}
	@AfterSuite
	public void tearDownDependencies() {
		BrowserUtility.quitBrowser();
	}
	
//   A data provider method with return type as 2D array: with rows and columns
// 3 data sets are passed here with 2 parameters: 
	@DataProvider(name="sUsernameandsPassword")
	public Object[][] getdatasUsernameAndsPassword()	{
		Object data[][]=new Object[3][3];
			return new Object[][] {{"admin123@gmail.com", "admin123"},{"admin@admin.com","admin"},{"a.gmail.com","a"}};
		
	}
}
			


