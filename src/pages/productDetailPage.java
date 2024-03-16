package pages;

import java.time.Duration;

import org.openqa.selenium.By;

import init.TestBase;
import init.utils;

public class productDetailPage extends TestBase {
	
	By addToCartButton = By.xpath("//button[text()='Add to cart']");
	public void addProductToCart() {
		timeouts.implicitlyWait(Duration.ofSeconds(utils.IMPLICIT_WAIT));
		selectSize();
		timeouts.implicitlyWait(Duration.ofSeconds(utils.IMPLICIT_WAIT));
		driver.findElement(addToCartButton).click();
	}
	
	By size = By.xpath("//a[text()='M']");
	public void selectSize() {
		driver.findElement(size).click();
		timeouts.implicitlyWait(Duration.ofSeconds(utils.IMPLICIT_WAIT));
	}
}
