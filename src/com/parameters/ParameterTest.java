package com.parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

	
	/*
	 <?xml version="1.0" encoding="UTF-8"?>
		<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
		  
		<suite name="TestNG Session Test Automation Suite" verbose="1" >
		  <test name="Differnet testng Feature Test" >
		    <classes>
		       <class name="com.test.TestNGBasics" />
		       <class name="com.test.GoogleTest" />
		       <class name="com.test.GoogleTitleTest" />
		    </classes>
		  </test>
		 </suite>

	 */
	WebDriver driver;	
	
	@Test
	@Parameters({"url","emailID"})
	public void gmailLoginTest(String url, String emailID){
		System.setProperty("webdriver.chrome.driver","D:\\SeleniumWorkspace\\Talento_Automation\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		
		driver.findElement(By.xpath("//input[@name='identifier']")).clear();
		driver.findElement(By.xpath("//input[@name='identifier']")).sendKeys(emailID);
		driver.findElement(By.xpath("//div[@id='identifierNext']")).click();
		
						
	}
	
	
}
