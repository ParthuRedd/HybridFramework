package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Constants;
import Utility.ElementUtilis;

public class LandingPage {
	
	
		
		//Implementing Page Factory
		
		WebDriver driver;
		Actions action;
		private ElementUtilis elementutilis;
		
		public LandingPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
			elementutilis = new ElementUtilis(driver);
			}
		
		@FindBy(xpath ="//div[contains(text(),'Welcome')]")
		private WebElement lnkWelcomeUser;
	


		
		@FindBy(linkText="Login or register")
		private WebElement lnkRegister;
		
		
		public void clickRegister() {
			elementutilis.clickonElement(lnkRegister,Constants.EXPLICIT_WAIT_TIME);
			
		}
		
		
		public String getUserName() {
			String   name = elementutilis.gettingthetext(lnkWelcomeUser,Constants.EXPLICIT_WAIT_TIME);
			return name;
		}
		public String getTitle() {
			String title=elementutilis.title();
			return title;
		}
		
		
		

	}


