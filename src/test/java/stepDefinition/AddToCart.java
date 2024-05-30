package stepDefinition;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;

import baseClass.BaseClass;
import hooks.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.LandingPage;

import pageObjects.RegisterPage;
import pageObjects.ShoppingcartPage;
import pageObjects.CheckoutPage;
import Utility.ElementUtilis;



public class AddToCart extends BaseClass{
	public LandingPage LanPage;
	
	public RegisterPage RegisterPage;
	public ShoppingcartPage CartPage;
	public CheckoutPage CheckoutPage;
	
	public String userName;
	public String price;
	Logger logs = LogManager.getLogger(AddToCart.class.getName());
	
	
	@When("user click on register in landing page")
	public void user_click_on_register_in_landing_page(){	
		 LanPage= new LandingPage(driver);
		LanPage.clickRegister();
		logs.debug("User clicked on Register link");

	}
	
	@And("^create account by entering emil address personal details$")
	public void create_account_by_entering_emil_address_personal_details(DataTable table) {
		RegisterPage=new RegisterPage(driver);
		RegisterPage.clickContinue();
		
//		List<List<String>> data = table.asList(String.class); 
		userName= table.cell(1, 1);
		RegisterPage.setFirstName(userName);
		RegisterPage.setLastName(table.cell(2, 1));
		RegisterPage.setEmail(table.cell(3, 1));
		RegisterPage.setAddress(table.cell(4, 1));
		RegisterPage.setCity(table.cell(5, 1));
		
		RegisterPage.setZipCode(table.cell(7, 1));
		RegisterPage.setLoginId(table.cell(8, 1));
		RegisterPage.setPassword(table.cell(9, 1));
		RegisterPage.setConfirmPassword(table.cell(10, 1));
		RegisterPage.selectCountry(table.cell(11, 1));
		RegisterPage.selectReagion(table.cell(6, 1));
		RegisterPage.checkboxAccountFrmagree();
		logs.debug("User has given all personal details");
		
	}
	@And("click register")
	public void click_register(){	
		
		RegisterPage.clickContinue();
		logs.debug("User Registered successfully");

	}
	@Then("verify name and surname is displayed correct")
	public void verify_name_and_surname_is_displayed_correct() throws InterruptedException {
		
		
		String title = LanPage.getTitle();
		System.out.print(title);
		Thread.sleep(5000);
		Assert.assertEquals("Your Account Has Been Created!",title);
		if(LanPage.getUserName().contains(userName)) {
			Assert.assertTrue(true);
			logs.info("Correct Name is displayed");
		}
		else {
			Assert.assertTrue(false);
		}
		logs.info("Verified Name");
	}
	
	@And("add product to cart")
	public void add_product_to_cart() {
		CartPage = new ShoppingcartPage(driver);
		CartPage.clickFragrance();
		CartPage.clickAddToCart();
		price = CartPage.getProductPrice();
		logs.info("User added Item to cart");
	}
	
	@Then("user proceed to checkout")
	public void user_proceed_to_checkout() {
		 CheckoutPage = new CheckoutPage(driver);
		 CheckoutPage.clickCheckout();
		
		logs.debug("Proceed to checkout");
	}
	
	@And("verify on payment page is the product details are correct")
	public void verify_on_payment_page_is_the_product_details_are_correct() {
		String actualPrice=CheckoutPage.getProductPrice();
		Assert.assertEquals(actualPrice, price);
		logs.debug("verify Product details");
	}

	
	
}

