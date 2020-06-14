package com.maven.jenkins.TestNG;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//Though my test got failed or Error or exception. 
//It is still proceeding for next test case which means next @Test is going to run
//It is built to testing purpose
	

public class Login {
	
		public static WebDriver driver = null;
		static String currentURL= "https://qa-tekarch.firebaseapp.com/";
		
		@BeforeTest
		public static void launchBrowser() throws Exception{
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "C:\Users\arath\eclipse\com.qa.Selenium.web.browser\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize(); 
//			driver.get(currentURL); 
			System.out.println("launched the browser successfully");
			Thread.sleep(2000);
		}
		
		@BeforeMethod
		public static void settingURL() throws Exception {
//			launchBrowser();
			driver.get(currentURL); 
			Thread.sleep(3000);
			System.out.println("opens URL successfully");
			driver.findElement(By.id("email_field")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("password_field")).clear();
			Thread.sleep(1000);
			}
		

		public static void logoutApp() throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Logout')]"))));
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			if(logout.isDisplayed())
			{
				logout.click();
			}
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email_field"))));
			Thread.sleep(3000);
		}
			
		@Test(priority=1, enabled=true)
		public static void login_ValidCredentials() throws Exception {
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
			Thread.sleep(3000);
			logoutApp();
			}
		
		@Test(priority=2, enabled=true)
		public static void login_InValidCredentials() throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email_field"))));
			WebElement email= driver.findElement(By.id("email_field"));
			email.sendKeys("admin123@gmail.com");
			Thread.sleep(1000);
			WebElement password= driver.findElement(By.id("password_field"));
			password.sendKeys("admin3");
			Thread.sleep(1000);
			System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Web login')]")).getText());
			WebElement Login=driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]"));
			Login.click();
			Thread.sleep(3000);
			Alert alert2 = driver.switchTo().alert();
			System.out.println(alert2.getText());
			alert2.accept();
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[contains(text(),'Student Registration Form')]"))));
		}
		
		@Test(priority=3, enabled=true)
		public static void logoutBrowser() throws Exception {
			login_ValidCredentials();
			System.out.println("Logged out from application successfully");
		}
		
		@AfterTest
		public static void quitBrowser(){
			driver.quit();
			System.out.println("quits all the instances of the browser window successfully");
		}
		
		
	}


