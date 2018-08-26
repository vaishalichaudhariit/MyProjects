package com.dataprovider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtil;

public class DataProvierTest {

		WebDriver driver;
		
		@BeforeMethod
		public void setUp(){
		System.setProperty("webdriver.chrome.driver","D:\\SeleniumWorkspace\\Talento_Automation\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://reg.ebay.in/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.in%2F");
		}
		
		/*@Test
		public void testing()
		{
			System.out.println("Testing data provider in TestNG");
		}*/
		
		@DataProvider
		public Iterator<Object[]> getTestData(){
			ArrayList<Object[]> testData = TestUtil.getDataFrom();
			return testData.iterator();
		}
		
		@Test(dataProvider="getTestData")
		public void ebayReg(String firstname, String lastname, String emailid, String password){
			
			driver.findElement(By.xpath("//input[@name='firstname']")).clear();
			driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstname);
			
			driver.findElement(By.xpath("//input[@name='lastname']")).clear();
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
			
			driver.findElement(By.xpath("//input[@name='email']")).clear();
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(emailid);
			
			driver.findElement(By.xpath("//input[@name='PASSWORD']")).clear();
			driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys(password);
		
		}
			
}
