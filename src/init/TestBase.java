package init;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		// Properties 
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream("D:\\Git\\Automation_Journey\\src\\init\\config.properties");
			prop.load(file);
			
		}catch(FileNotFoundException e){
			e.getStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		TestBase testBase = new TestBase(); 
		String browserName  = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			 System.setProperty("webdriver.chrome.driver", "D:\\Git\\Automation_Journey\\src\\driver\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utils.PAGE_LOAD_TIMEOUT));
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(utils.IMPLICIT_WAIT));
		 
		 driver.get(prop.getProperty("url"));
	}
	
}
