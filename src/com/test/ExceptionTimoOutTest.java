package com.test;

import org.testng.annotations.Test;

public class ExceptionTimoOutTest {

	@Test
	public void sampleTestCase(){
			System.out.println("Im ready to execute");
		}
	@Test(timeOut=1000) // specify time in milliseconds
	public void executetimeOut() throws InterruptedException{
		Thread.sleep(3000);
	}
	
	/*@Test(timeOut=20)
	public void infiniteLoopTest()
	{
		int i=1;
		while(i==1){
		System.out.println(i);
		}
	}*/
	
	@Test(expectedExceptions=NumberFormatException.class)
	public void test1()
	{
		String s = "100A";
		Integer.parseInt(s);
	}
}
