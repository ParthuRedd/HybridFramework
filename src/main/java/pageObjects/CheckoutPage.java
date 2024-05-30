package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Constants;
import Utility.ElementUtilis;

public class CheckoutPage {
	
	WebDriver driver;
	Actions action;
	private ElementUtilis elementutilis;
	
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementutilis = new ElementUtilis(driver);
		}
	
	@FindBy(xpath="//span[text()='Checkout']")
	private WebElement checkout;
	@FindBy(xpath="//button[@id='checkout_btn']")
	private WebElement btnConfirmOrder;
	@FindBy(xpath="//span[text()='Order Summary']/../following-sibling::table//a[text()='ck one shock for him Deodorant']/../following-sibling::td/b")
	private WebElement orderprice;
	
	public void clickCheckout() {
		
	
		elementutilis.clickonElement(checkout, Constants.EXPLICIT_WAIT_TIME);
	}
	
	public String getProductPrice() {
		
	String orderPrice=elementutilis.gettingthetext(orderprice,Constants.EXPLICIT_WAIT_TIME);
		return orderPrice;
	}
	
	
}
