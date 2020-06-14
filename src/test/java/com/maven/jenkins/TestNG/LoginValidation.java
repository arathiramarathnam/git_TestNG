package com.maven.jenkins.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

//Though my test got failed or Error or exception .It is still proceeding for next test case which means next @Test is going to run
//It is built to testing purpose

public class LoginValidation {
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
		@Test(priority=2)
		public void checkLoginSuccessOrNot_InvalidCredentials() throws Exception{
			System.out.println("Login unsuccessful");
			BrowserUtility.loginToBrowser("admin123@gmail.com", "admin3");
		}
		
		@Test(priority=1)
		public void checkLoginSuccessOrNot_ValidCredentials() throws Exception{
			BrowserUtility.loginToBrowser("admin123@gmail.com", "admin123");
			System.out.println("Login successful");
		}
		@AfterSuite
		public void tearDownDependencies() {
			BrowserUtility.quitBrowser();
		}

}
