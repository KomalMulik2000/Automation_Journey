package init;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class utils extends EcommerceTestcase{

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 30;
	
	public static void switchToNewTab() {
		// Get the current window handle
		String currentWindowHandle = driver.getWindowHandle();

		// Get all window handles
		Set<String> allWindowHandles = driver.getWindowHandles();

		// Switch to the new tab
		for (String windowHandle : allWindowHandles) {
		    if (!windowHandle.equals(currentWindowHandle)) {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}
	}
	
	public static void takeScreenshot() {
		// Take a screenshot of the shopping cart page
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
        	timeouts.implicitlyWait(Duration.ofSeconds(utils.IMPLICIT_WAIT));
            // Save the screenshot to a specific location
            FileUtils.copyFile(screenshotFile, new File(prop.getProperty("snapshotPath")));
            System.out.println("Screenshot captured successfully.");
        } catch (Exception e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }

	}
	
	public static void scrollToTheElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	
}
