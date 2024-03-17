package pages;

import org.openqa.selenium.By;

import init.EcommerceTestcase;

public class productDetailView extends EcommerceTestcase{
	
	By currentImg = By.xpath("//div[@class='CXW8mj _3nMexc']/img");
	By productDetails = By.xpath("//div[text()='Product Details']");
	By addToCartButton = By.xpath("//button[text()='Add to cart']");
	
	public void validateDetailsPage() {
		driver.navigate().refresh();
		
		String originalImgSrc = productSearchPage.productImg.getAttribute("src");
		String currentImgSrc =  driver.findElement(currentImg).getAttribute("src");
		
		if(originalImgSrc.equals(currentImgSrc)) {
			System.out.println("Larger Image is available on Product Detail Page");
		}else {
			System.out.println("Image sizes are same");
		}
		
		if(driver.findElement(productDetails).isDisplayed()){
			System.out.println("Product Details are available");
		}else {
			System.out.println("Product Details are not present");
		}
		
		if(driver.findElement(addToCartButton).isDisplayed()) {
			System.out.println("Add to Cart button is available");
		}else {
			System.out.println("Add to Cart button is available");
		}
		
	}
}
