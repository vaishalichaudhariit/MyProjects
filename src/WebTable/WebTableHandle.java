package WebTable;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.test.utility.Xls_Reader;

public class WebTableHandle {

	public static void main(String[] args) {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","D:\\SeleniumWorkspace\\Talento_Automation\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://money.rediff.com/gainers");
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("disable-infobars"); 
		
		String row = "//*[@id='leftcontainer']/table/tbody/tr";
		int rowCount = driver.findElements(By.xpath(row)).size();
		System.out.println("No. of row: " + rowCount);
		
		//Get the Current Price for the Accel Frontline
		String currentPrice = driver.findElement(By.xpath("//a[contains(text(),'Accel Frontline')]/parent::*/following-sibling::td[3]")).getText();
		System.out.println("Current Price for Accel Frontline: " + currentPrice);
		
		String firstPart = "//*[@id='leftcontainer']/table/tbody/tr[";
		String secondPart = "]/td[4]";
		String companyName = "]/td[1]";
		
		Xls_Reader reader = new Xls_Reader("D:\\SeleniumWorkspace\\TestNGProject\\src\\com\\testdata\\ebayLogin.xlsx");
		
		if(!reader.isSheetExist("TestData")){
			reader.addSheet("TestData");
			reader.addColumn("TestData", "Company");
			reader.addColumn("TestData", "Current Price (Rs)");
		}
	
		for(int i=1; i<rowCount; i++){
			
			//Extract Company Name from application and store in excel
			String finalCompany = firstPart+i+companyName;
			String companyNames = driver.findElement(By.xpath(finalCompany)).getText();
			reader.setCellData("TestData", "Company", i+1,companyNames );
			
			
			//Extract Current Price from application and store in excel
			String finalPart = firstPart+i+secondPart;
			String currentPrice1 = driver.findElement(By.xpath(finalPart)).getText();
			System.out.println("Company Names: " +companyNames + " Current Price (Rs): " +currentPrice1);
			reader.setCellData("TestData", "Current Price (Rs)", i+1,currentPrice1 );
		
		}

	}

}
