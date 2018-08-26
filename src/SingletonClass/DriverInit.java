package SingletonClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInit {

	
		private static DriverInit instaceDriver = null;
		private WebDriver driver;
		
		private DriverInit(){
			
		}
		
		public WebDriver openBrowser(){
			System.setProperty("webdriver.chrome.driver","D:\\SeleniumWorkspace\\Talento_Automation\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			return driver;
		}
	
		public static DriverInit getInstance(){
			if (instaceDriver == null)
				instaceDriver = new DriverInit();
			return instaceDriver;
		}
}
