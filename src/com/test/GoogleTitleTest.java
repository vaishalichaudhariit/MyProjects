package com.test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTitleTest {
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
	
	@Test(priority=1) //2
	public void googleTitleTest()
	{
		String title= driver.getTitle();
		System.out.println("Google Title: " + title);
		assertEquals(title, "Googles","title is not matched");
	}
	

	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
