package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;

import init.EcommerceTestcase;
import init.utils;

public class productSearchPage extends EcommerceTestcase{

	public static WebElement productImg;
	
	By searchresultText = By.xpath("//span[contains(text(), 'results for') and span[contains(text(), 'dress')]]");
	By products = By.xpath("//div[@class='_1xHGtK _373qXS']");
	By productName = By.xpath(".//a[@title]");
	By productPrice = By.xpath(".//a[@title]//following-sibling::a//div[@class='_30jeq3']");
	By fisrtProductImg = By.xpath("(//div[@class='_1xHGtK _373qXS']//img)[1]");
	
	
	//	Confirm that the search results page loads and displays items relevant to the search term.
	public void validateSearchPage() {
		if(driver.findElement(searchresultText).isDisplayed()) {
			System.out.println("Search Results are displayed");
		}else {
			System.out.println("Search Results are not displayed");
		}
		
	// Verify that each product listed has a product name and price displayed.
		validateProductListed();
		
		productImg = driver.findElement(fisrtProductImg);
	}
	
	public void validateProductListed() {
		List<WebElement> allProducts = driver.findElements(products);
		boolean flag = true;

		
		for (WebElement product : allProducts) {
			
		  String productNameText = product.findElement(productName).getText();
   		  String productPriceText = product.findElement(productPrice).getText();
   		  
   		  if(productNameText.isBlank() || productPriceText.isBlank()) { 
			  flag = false;
   		  }
			
		}
		
		if(flag == false) {
			System.out.println("For all products, Product name and Product Price not get listed");
		}else {
			System.out.println("For all products, Product name and Product Price get listed");
		}
	}
	
	By firstProductLink = By.xpath("(//div[@class='_1xHGtK _373qXS']//a[@title])[1]");
	public void selectFirstProduct() {
		driver.navigate().refresh();
		timeouts.implicitlyWait(Duration.ofSeconds(utils.IMPLICIT_WAIT));
		driver.findElement(firstProductLink).click();
		timeouts.implicitlyWait(Duration.ofSeconds(utils.IMPLICIT_WAIT));
	}
}
