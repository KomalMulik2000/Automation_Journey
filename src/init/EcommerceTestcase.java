package init;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.*;

public class EcommerceTestcase {

	public static WebDriver driver;
	public static Properties prop;
	public static Timeouts timeouts;
	
	public EcommerceTestcase(){
		// Properties 
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream("D:\\SeleniumTasks\\Task2\\Automation_Journey\\src\\init\\config.properties");
			prop.load(file);
			
		}catch(FileNotFoundException e){
			e.getStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		EcommerceTestcase testBase = new EcommerceTestcase(); 
		String browserName  = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			 System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
			 driver = new ChromeDriver();
		}
		
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 
		 // Store the Timeouts object
		 timeouts = driver.manage().timeouts();
		 timeouts.pageLoadTimeout(Duration.ofSeconds(utils.PAGE_LOAD_TIMEOUT));
		 timeouts.implicitlyWait(Duration.ofSeconds(utils.IMPLICIT_WAIT));
		 
		 driver.get(prop.getProperty("url"));
		 
		 homePage homePageObj = new homePage();
		 homePageObj.homePageElements();
		 homePageObj.searchProduct();
		 
		 productSearchPage searchPageObj = new productSearchPage();
		 searchPageObj.validateSearchPage();
		 searchPageObj.selectFirstProduct();
		 
		 productDetailView productDetailObj = new productDetailView();
		 productDetailObj.validateDetailsPage();
	}

}
