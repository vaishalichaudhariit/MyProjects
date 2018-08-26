package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {

	
	/*
	@BeforeSuite ----setup system property fro chrome
	@BeforeTest-----launch chrome Browser
	@BeforeClass-----login to App
	@BeforeMethod----Enter URL
	@Test-----Google Logo Test
	@AfterMethod-----logout from App
	@BeforeMethod----Enter URL
	@Test----Google Title Test
	@AfterMethod-----logout from App
	@BeforeMethod----Enter URL
	@Test-----Search Test
	@AfterMethod-----logout from App
	@AfterClass-----Close Browser
	@AfterTest----deleteAllCookies
	PASSED: googleLogoTest
	PASSED: googleTitleTest
	PASSED: searchTest
	*
	*/
	
	//pre conditions annotation ---starting with @Before 
	@BeforeSuite //1
	public void setUp()
	{
		System.out.println("@BeforeSuite ----setup system property fro chrome");
	}
	
	@BeforeTest//2
	public void launchBrowser()
	{
		System.out.println("@BeforeTest-----launch chrome Browser");
	}	
	
	
	@BeforeClass//3
	public void login()
	{
		System.out.println("@BeforeClass-----login to App");
	}
	
	
	@BeforeMethod//4
	public void enterURL()
	{
		System.out.println("@BeforeMethod----Enter URL");
	}
	
	//test cases - starting with @Test
	@Test//5
	public void googleTitleTest(){
		
		System.out.println("@Test----Google Title Test");
	}
	@Test//5
	public void searchTest(){
		
		System.out.println("@Test-----Search Test");
	}
	@Test//5
	public void googleLogoTest(){
		
		System.out.println("@Test-----Google Logo Test");
	}
	
	/*
	 * 
	 * @BeforeMethod
	 * @Test -1
	 * @AfterMethod
	 * 
	 * @BeforeMethod
	 * @Test -2
	 * @AfterMethod
	 * 
	 * @BeforeMethod
	 * @Test -2
	 * @AfterMethod
	 * 
	 * 
	 */
	
	
	/*
	 *  @BeforeSuite ----setup system property fro chrome
		@BeforeTest-----launch chrome Browser
		@BeforeClass-----login to App
		
		@BeforeMethod----Enter URL
		@Test-----Google Logo Test
		@AfterMethod-----logout from App
		
		@BeforeMethod----Enter URL
		@Test----Google Title Test
		@AfterMethod-----logout from App
		
		@BeforeMethod----Enter URL
		@Test-----Search Test
		@AfterMethod-----logout from App
		
		@AfterClass-----Close Browser
		@AfterTest----deleteAllCookies
		
		PASSED: googleLogoTest
		PASSED: googleTitleTest
		PASSED: searchTest
	*/
	
	//post condition ---starting with @After
	@AfterMethod//6
	public void logout()
	{
		System.out.println("@AfterMethod-----logout from App");
	}
	@AfterClass//7
	public void closeBrowser()
	{
		System.out.println("@AfterClass-----Close Browser");
	}
	@AfterTest//8
	public void deleteAllCookies()
	{
		System.out.println("@AfterTest----deleteAllCookies");
	}
		
	@AfterSuite//9 // Not executed
	public void generateReport()
	{
		System.out.println("@AfterSuite----Generate Report");
	}
	
	
}
