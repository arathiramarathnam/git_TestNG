package com.maven.jenkins.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo_Annotations {

	public static WebDriver driver = null;
	static String currentURL= "https://qa-tekarch.firebaseapp.com/";
	
	@BeforeMethod
	public static void launchBrowser() throws Exception{
		
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\Users\arath\eclipse\com.qa.Selenium.web.browser\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get(currentURL); 
		System.out.println("launched the browser and opens URL successfully");
		Thread.sleep(2000);
	}
	
	
	@Test
	public static void loginToBrowser() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email_field"))));
		WebElement email= driver.findElement(By.id("email_field"));
		email.sendKeys("admin123@gmail.com");
		Thread.sleep(1000);
		WebElement password= driver.findElement(By.id("password_field"));
		password.sendKeys("admin123");
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Web login')]")).getText());
		WebElement Login=driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]"));
		Login.click();
		System.out.println("Logged in successfully");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[contains(text(),'Student Registration Form')]"))));
		Thread.sleep(1000);
	}
	
	@AfterMethod
	public static void quitBrowser(){
		driver.quit();
		System.out.println("quits all the instances of the browser window successfully");
	}
	
	
}