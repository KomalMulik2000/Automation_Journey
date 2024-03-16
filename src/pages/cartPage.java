package pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import init.TestBase;
import init.utils;

public class cartPage extends TestBase {
    
	By placeOrderBtn = By.xpath("//span[text()='Place Order']");
	
    public void takeCartScreenshot(){
        
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(240));
    	wait.until(ExpectedConditions.presenceOfElementLocated(placeOrderBtn));
        utils.takeScreenshot();
    }
}