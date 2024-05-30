package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Constants;
import Utility.ElementUtilis;

public class RegisterPage {

	WebDriver driver;
	Actions action;
	private ElementUtilis elementutilis;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementutilis = new ElementUtilis(driver);
	}
	
	@FindBy(xpath="//button[@title='Continue']")
	private WebElement btnContinue;
	
	@FindBy(name="firstname")
	private WebElement txtFirstName;
	
	
	
	@FindBy(name="email")
	private WebElement txtEmail;
	@FindBy(name="address_1")
	private WebElement txtAddress;
	@FindBy(name="city")
	private WebElement txtCity;
	@FindBy(name="postcode")
	private WebElement txtZipCode;
	@FindBy(name="lastname")
	private WebElement txtLastName;
	@FindBy(name="loginname")
	private WebElement txtLoginName;
	@FindBy(name="password")
	private WebElement txtPassword;
	@FindBy(name="confirm")
	private WebElement txtConfirmPassword;
	@FindBy(name="zone_id")
	private WebElement dropDownReagion;
	
	
	@FindBy(name="country_id")
	private WebElement dropDownCountry;
	@FindBy(id="AccountFrm_agree")
	private WebElement checkBoxAggree;
	
	
public void selectReagion(String reagion) {
		System.out.println(reagion);
		elementutilis.selectoptionindropdown(dropDownReagion, reagion);
	}
public void selectCountry(String country) {
	System.out.println(country);
	elementutilis.selectoptionindropdown(dropDownCountry, country);
}

public void checkboxAccountFrmagree() {
	
	elementutilis.clickonElement(checkBoxAggree,Constants.EXPLICIT_WAIT_TIME);
}
	public void setEmail(String emailAddress) {
		
		elementutilis.typetextIntoElement(txtEmail, emailAddress);
	}
	
	public void setFirstName(String firstName) {
		
		elementutilis.typetextIntoElement(txtFirstName, firstName);
	}
	
	public void setLastName(String lastname) {
		
		elementutilis.typetextIntoElement(txtLastName, lastname);
	}
	
	public void setAddress(String address) {
		
		elementutilis.typetextIntoElement(txtAddress, address);
	}
	
	public void setCity(String city) {
	
		elementutilis.typetextIntoElement(txtCity, city);
	}
	
	public void setZipCode(String zipCode) {
		
		elementutilis.typetextIntoElement(txtZipCode, zipCode);
	}
	
	public void setLoginId(String loginId) {
		
		elementutilis.typetextIntoElement(txtLoginName, loginId);
	}
	
	public void setPassword(String password) {//emailAddressoption.sendKeys(emailaddress);
		elementutilis.typetextIntoElement(txtPassword, password);
	}
	
public void clickContinue() {
		
		elementutilis.click(btnContinue);
	}
	
	
	public void setConfirmPassword(String confirmPassword) {
		
		elementutilis.typetextIntoElement(txtConfirmPassword, confirmPassword);
	}

	
	

}
