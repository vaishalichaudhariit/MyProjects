package com.test.utility;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestUtil {
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFrom(){
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try{
			reader =new Xls_Reader("D:\\SeleniumWorkspace\\TestNGProject\\src\\com\\testdata\\ebayLogin.xlsx");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		for(int rowNum = 2; rowNum <=reader.getRowCount("RegTestData"); rowNum++){
			String firstname = reader.getCellData("RegTestData","Firstname",rowNum);
			String lastname = reader.getCellData("RegTestData","Lastname",rowNum);
			String emailid = reader.getCellData("RegTestData","Email",rowNum);
			String password = reader.getCellData("RegTestData","Password",rowNum);
			
			Object ob[] = {firstname,lastname,emailid,password};
			myData.add(ob);
		}
		return myData;
	}
	
	
		
		
		

}
