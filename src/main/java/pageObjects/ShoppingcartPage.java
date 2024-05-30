package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Constants;
import Utility.ElementUtilis;

public class ShoppingcartPage {
	
	WebDriver driver;
	Actions action;
	private ElementUtilis elementutilis;
	
	public ShoppingcartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementutilis = new ElementUtilis(driver);
		}
	
	@FindBy(xpath="//a[text()='ck one shock for him Deodorant']/../../following-sibling::div//a[@title='Add to Cart']")
	private WebElement lnkAddToCart;
	
	@FindBy(xpath="//a[text()='ck one shock for him Deodorant']/../../following-sibling::div//a[@title='Add to Cart']/following-sibling::div/div")
	private WebElement productPrice;
	
	@FindBy(xpath="//div[@class='subcategories']/../a[contains(text(),'Fragrance')]")
	private WebElement lnkFragrance;
	
public void clickFragrance() {
		
		elementutilis.clickonElement(lnkFragrance,Constants.EXPLICIT_WAIT_TIME);
	}
public String getProductPrice() {
	
String	price=elementutilis.gettingthetext(productPrice,Constants.EXPLICIT_WAIT_TIME);
return price;
}
public void clickAddToCart() {
	
	elementutilis.clickonElement(lnkAddToCart,Constants.EXPLICIT_WAIT_TIME);
}
public void clickAddToCart(String productName) {
	 

	  WebElement element = driver.findElement(By.xpath("//a[text()='"+productName+"']/../../following-sibling::div//a[@title='Add to Cart']"));
	  elementutilis.clickonElement(element,Constants.EXPLICIT_WAIT_TIME);
}
	
	
}
