package com.maven.jenkins.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtility {

	public static WebDriver driver = null;
	
	
	public static void launchBrowser(String sBrowser){
		
		if(sBrowser.startsWith("ch")) {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\Users\arath\eclipse\com.qa.Selenium.web.browser\chromedriver.exe");
		driver = new ChromeDriver();
		}
				
		else {
			System.out.println("You have not given browser type correctly");
		}
		
		driver.manage().window().maximize(); 
//		driver.get("https://qa-tekarch.firebaseapp.com/"); 
		
	}

	public static void quitBrowser(){
		driver.quit();
	}
	
	public static void waitForPageElementToVisible(WebElement eleToWait) {// passing formal parameter in method for explicit wait
		WebDriverWait wait = new WebDriverWait(BrowserUtility.driver, 30);
		wait.until(ExpectedConditions.visibilityOf(eleToWait));
		
	}

	public static void loginToBrowser(String sUsername, String sPassword) throws Exception {
		driver.get("https://qa-tekarch.firebaseapp.com/"); 
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email_field"))));
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Web login')]")).getText());
		driver.findElement(By.id("email_field")).sendKeys(sUsername);
		Thread.sleep(2000);
		driver.findElement(By.id("password_field")).sendKeys(sPassword);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"))));
		Thread.sleep(1000);
	}
}