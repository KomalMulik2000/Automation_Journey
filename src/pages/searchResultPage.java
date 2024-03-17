package pages;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.*; 

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import init.TestBase;
import init.utils;

public class searchResultPage extends TestBase {
	
	By products = By.xpath("//div[@class='_1xHGtK _373qXS']");
	By productName = By.xpath(".//a[@title]");
	By productPrice = By.xpath(".//a[@title]//following-sibling::a//div[@class='_30jeq3']");
	By brand = By.xpath(".//div[@class='_2WkVRV']");
	
	By nextPageLink = By.xpath("//a[span[text()='Next']]");
	
	public void storeData() {
		try(Workbook workbook = new XSSFWorkbook(); FileOutputStream fileOut = new FileOutputStream(prop.getProperty("excelPath"))){
			Sheet sheet = workbook.createSheet(prop.getProperty("dataSheet"));
			
			// Create Header Row
			Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Product Name");
            headerRow.createCell(1).setCellValue("Product Price");
            headerRow.createCell(2).setCellValue("Product Brand");
            
            int rowNum = 1;
          
            for(int page = 1; page <= 3; page++) {
            	driver.navigate().refresh();
            	timeouts.implicitlyWait(Duration.ofSeconds(utils.IMPLICIT_WAIT));
            	List<WebElement> allProducts = driver.findElements(products);
            	
            	for(WebElement product : allProducts) {
            		try {
            		  String productNameText = product.findElement(productName).getText();
            		  String productPriceText = product.findElement(productPrice).getText();
                      String productBrandText = product.findElement(brand).getText();
                      
                      Row dataRow = sheet.createRow(rowNum++);
                      dataRow.createCell(0).setCellValue(productNameText);
                      dataRow.createCell(1).setCellValue(productPriceText);
                      dataRow.createCell(2).setCellValue(productBrandText);
            		}catch(NoSuchElementException e) {
            			System.out.println("Element not found: "+ e.getMessage());
            		}
            	}
            	
            	if(page < 3) {
	            	driver.findElement(nextPageLink).click();
	            	timeouts.implicitlyWait(Duration.ofSeconds(utils.IMPLICIT_WAIT));
            	}
            }
            
			workbook.write(fileOut);
		}catch(IOException e) {
			System.out.println("File related issue: " + e.getMessage());
		}
	}
	
	
	// productName = //div[div[div[span[span[contains(text(), 'T-shirts')]]]]]/following-sibling::div//a[@title]
	// productPrice = //div[div[div[span[span[contains(text(), 'T-shirts')]]]]]/following-sibling::div//a[@title]/following-sibling::a//div[@class='_30jeq3']
	
	By firstPageLink = By.xpath("//a[text()='1']");
	
	public void goToFirstPage() {
		driver.findElement(firstPageLink).click();
		timeouts.implicitlyWait(Duration.ofSeconds(utils.IMPLICIT_WAIT));
	}
	
	By firstProductLink = By.xpath("(//div[@class='_1xHGtK _373qXS']//a[@title])[1]");
	public void selectFirstProduct() {
		driver.navigate().refresh();
		timeouts.implicitlyWait(Duration.ofSeconds(utils.IMPLICIT_WAIT));
		driver.findElement(firstProductLink).click();
		
	}
	
}
