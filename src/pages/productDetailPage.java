package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import init.TestBase;
import init.utils;

public class productDetailPage extends TestBase {
	
	By addToCartButton = By.xpath("//button[text()='Add to cart']");
	public void addProductToCart() {
		driver.navigate().refresh();
		timeouts.implicitlyWait(Duration.ofSeconds(utils.IMPLICIT_WAIT));
		selectSize();
		timeouts.implicitlyWait(Duration.ofSeconds(utils.IMPLICIT_WAIT));
		WebElement addCart_btn = driver.findElement(addToCartButton);
		utils.scrollToTheElement(addCart_btn);
		timeouts.implicitlyWait(Duration.ofSeconds(utils.IMPLICIT_WAIT));
		addCart_btn.click();
	}
	
	By size = By.xpath("//a[text()='M']");
	public void selectSize() {
		
		WebElement sizeBtn = driver.findElement(size);
		utils.scrollToTheElement(sizeBtn);
		timeouts.implicitlyWait(Duration.ofSeconds(utils.IMPLICIT_WAIT));
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", sizeBtn);
		
	}
}
