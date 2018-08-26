package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	
	WebDriver driver;
	
	@BeforeMethod //1,4,7
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","D:\\SeleniumWorkspace\\Talento_Automation\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/");
		
	}
	
	//@Test annotation execute Test in any sequence. To avoid this use priority keyword
	
	@Test(priority=1,groups="Smoke") //2
	public void googleTitleTest()
	{
		String title= driver.getTitle();
		System.out.println("Google Title: " + title);
	}
	
	@Test(priority=2,groups="Smoke")//8
	public void googleLogoTest()
	{
		boolean b = driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
		if(b)
		System.out.println("Google Logo is available ");
	}
	
	@Test(priority=3,groups="Regression") //5
	public void mailLinkTest()
	{
		boolean b = driver.findElement(By.linkText("Gmail")).isDisplayed();
		if(b)
			System.out.println("Google mail link is available ");
	}
	
	//3,6,9
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
