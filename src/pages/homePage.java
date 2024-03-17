package pages;

import init.EcommerceTestcase;
import init.utils;

import java.time.Duration;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert; 

public class homePage extends EcommerceTestcase{
	
	By search_ip = By.xpath("//input[@title='Search for Products, Brands and More']");
	By cartBtn = By.xpath("//a[text()='Cart']");
	
	
	public void homePageElements() {
		// Assert that the website's title is correct.
		if(testTitleAssertion()) {
			System.out.println("Title Matched");
		}
		
		// Verify that the homepage has a visible 'search bar' and 'cart' element.
		if(driver.findElement(search_ip).isDisplayed()) {
			System.out.println("Search Bar is visible");
		}else {
			System.out.println("Search Bar is not visible");
		}
		
		if(driver.findElement(cartBtn).isDisplayed()) {
			System.out.println("Cart Button is visible");
		}else {
			System.out.println("Cart Button is not visible");
		}
		
		
	}
	
	private boolean checkVisibilityOfHomePageElements() {
		
		return false;
	}

	String title = driver.getTitle();
	String expTitle = prop.getProperty("flipkartTitle");
	
	
	public boolean testTitleAssertion() {
		Assert.assertEquals(title, expTitle);
		return true;
	}
	
	By thirdSearchOption = By.xpath("(//div[input[@value='dress']]/parent::div/following-sibling::ul/li//a)[3]");
	
	// Search Product - dress
	public void searchProduct() {
		WebElement search = driver.findElement(search_ip);
		search.sendKeys("dress");
		Actions actions = new Actions(driver);

    	 actions.moveToElement(search).build().perform();
    	 timeouts.implicitlyWait(Duration.ofSeconds(utils.IMPLICIT_WAIT));
 		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(240));
    	 wait.until(ExpectedConditions.presenceOfElementLocated(thirdSearchOption));
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("arguments[0].click();", driver.findElement(thirdSearchOption));
		 timeouts.implicitlyWait(Duration.ofSeconds(utils.IMPLICIT_WAIT));
	}

	
	
}
