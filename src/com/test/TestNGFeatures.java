package com.test;

import org.testng.annotations.Test;

public class TestNGFeatures {
	
	@Test
	public void loginTest()
	{
		System.out.println("Login Test");
		//int i=9/0;
	}
	
	@Test(dependsOnMethods="loginTest")
	public void homePageTest()
	{
		System.out.println("Home Page Test");
	}
	
	@Test(dependsOnMethods="loginTest")
	public void searchPageTest()
	{
		System.out.println("Search Page Test");
	}
	
	@Test(dependsOnMethods="loginTest")
	public void regPageTest()
	{
		System.out.println("Register Page Test");
	}
	
}
