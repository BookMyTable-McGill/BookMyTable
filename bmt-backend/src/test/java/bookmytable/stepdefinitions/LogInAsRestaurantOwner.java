package bookmytable.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import bookmytable.dao.RestaurantOwnerRepository;
import bookmytable.model.Customer;
import bookmytable.model.Reservation;
import bookmytable.model.Restaurant;
import bookmytable.model.RestaurantOwner;
import bookmytable.service.RestaurantOwnerLoginService;
import bookmytable.service.RestaurantOwnerRegistrationService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogInAsRestaurantOwner {
	
	boolean loggedIn = false;
	boolean loggedIn2 = false;
	boolean exceptionCaught = false;
	
	@Autowired
	RestaurantOwnerRegistrationService rORS = new RestaurantOwnerRegistrationService();
	
	@Autowired
	RestaurantOwnerLoginService rOLS = new RestaurantOwnerLoginService();
	
	@Given("RestaurantOwner <owner> is on the login page")
	public void restaurant_owner_owner_is_on_the_login_page() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Given("RestaurantOwner <owner> exists")
	public void restaurant_owner_owner_exists() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Given("RestaurantOwner <owner> is unsuspended")
	public void restaurant_owner_owner_is_unsuspended() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("RestaurantOwner <owner> inputs email <validEmailOwner> and password <validPasswordOwner>")
	public void restaurant_owner_owner_inputs_email_valid_email_owner_and_password_valid_password_owner() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("RestaurantOwner <owner> clicks to Log In")
	public void restaurant_owner_owner_clicks_to_log_in() {
		// Write code here that turns the phrase above into concrete actions
		RestaurantOwner restOwner = rORS.registerRestaurantOwner("Thomas", "cat123", "thomas.alarcon@mail.mcgill.ca");
		//String validEmail = restOwner.getEmail();
		String validPassword = restOwner.getPassword();
		loggedIn = rOLS.loginRestaurantOwner(restOwner, validPassword);
	}
	
	@When("a different RestaurantOwner <owner> clicks to Log In")
	public void a_different_restaurant_owner_owner_clicks_to_log_in() {
		// Write code here that turns the phrase above into concrete actions
		RestaurantOwner restOwner = rORS.registerRestaurantOwner("Thomas", "cat123", "thomas@mcgill.ca");
		//String validEmail = restOwner.getEmail();
		String validPassword = restOwner.getPassword();
		loggedIn = rOLS.loginRestaurantOwner(restOwner, validPassword);
	}

	@Then("RestaurantOwner <owner> is redirected to the RestaurantOwner profile")
	public void restaurant_owner_owner_is_redirected_to_the_restaurant_owner_profile() {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(true, loggedIn);
	}

	@Then("RestaurantOwner <owner> has the option to Create Restaurant")
	public void restaurant_owner_owner_has_the_option_to_create_restaurant() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("RestaurantOwner <owner> inputs email <validEmailOwner> and password <invalidPasswordOwner>")
	public void restaurant_owner_owner_inputs_email_valid_email_owner_and_password_invalid_password_owner() {
		// Write code here that turns the phrase above into concrete actions
		RestaurantOwner restOwner = rORS.registerRestaurantOwner("Thomas", "cat123", "hello@yahoo.ca");
		//try{
			loggedIn2 = rOLS.loginRestaurantOwner(restOwner, "abcd1234");
		//}catch(IllegalArgumentException e){
			//exceptionCaught = true;
		//}
	}

	@When("RestaurantOwner <owner> inputs email <invalidEmailOwner> and password <validPasswordOwner>")
	public void restaurant_owner_owner_inputs_email_invalid_email_owner_and_password_valid_password_owner() {
		// Write code here that turns the phrase above into concrete actions
	}
	
	@Then("RestaurantOwner <owner> will remain on the login page")
	public void restaurant_owner_owner_customer_will_remain_on_the_login_page() {
		assertEquals(false, loggedIn2);
	}

}
