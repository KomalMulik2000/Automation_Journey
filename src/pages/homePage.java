package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import init.TestBase;
import init.utils;

public class homePage extends TestBase {

	By search_ip = By.xpath("//input[@title='Search for Products, Brands and More']");
	
	// Search Product - T-shirts
	public void searchProduct() {
		WebElement search = driver.findElement(search_ip);
		search.sendKeys("T-shirts");
		search.sendKeys(Keys.ENTER);
		timeouts.implicitlyWait(Duration.ofSeconds(utils.IMPLICIT_WAIT));
	}
	
}
