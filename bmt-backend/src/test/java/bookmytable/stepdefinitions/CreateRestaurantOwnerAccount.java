package bookmytable.stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.security.acl.Owner;

import org.springframework.beans.factory.annotation.Autowired;

import bookmytable.controller.RestaurantOwnerRegistrationController;
import bookmytable.dao.RestaurantOwnerRepository;
import bookmytable.model.RestaurantOwner;
import bookmytable.service.RestaurantOwnerRegistrationService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateRestaurantOwnerAccount {

	@Autowired
	RestaurantOwnerRegistrationService rORS = new RestaurantOwnerRegistrationService();
	
	@Autowired
	private RestaurantOwnerRepository restaurantOwnerRepository;

	RestaurantOwner owner;

	@Given("a restaurant owner <restaurantOwner> is on the create restaurant owner account page")
	public void a_restaurant_owner_restaurant_owner_is_on_the_create_restaurant_owner_account_page() {
		// Write code here that turns the phrase above into concrete actions
		
	}

	@When("a restaurant owner <restaurantOwner> inputs email <validEmail> and password <validPassword>")
	public void a_restaurant_owner_restaurant_owner_inputs_email_valid_email_and_password_valid_password() {
		// Write code here that turns the phrase above into concrete actions
		owner = rORS.registerRestaurantOwner("owner", "1234", "owner@gmail.com");
		restaurantOwnerRepository.save(owner);
	}

	@When("restaurant owner <restaurantOwner> clicks to Create account")
	public void restaurant_owner_restaurant_owner_clicks_to_create_account() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("a restaurant owner with email <validEmail> and password <validPassword> is created")
	public void a_restaurant_owner_with_email_valid_email_and_password_valid_password_is_created() {
		// Write code here that turns the phrase above into concrete actions
		boolean foundEmail = false;
		for (RestaurantOwner r : rORS.getRestaurantOwners()) {
			if (r.getEmail() == owner.getEmail()) {
				foundEmail = true;
			}
		}

		boolean foundPassword = false;
		for (RestaurantOwner r : rORS.getRestaurantOwners()) {
			if (r.getPassword() == owner.getPassword()) {
				foundPassword = true;
			}
		}

		assertEquals(true, foundEmail);
		assertEquals(true, foundPassword);
	}

	@Then("restaurant owner <restaurantOwner> is redirected to restaurant owner profile")
	public void restaurant_owner_restaurant_owner_is_redirected_to_restaurant_owner_profile() {
		// Write code here that turns the phrase above into concrete actions
		
	}

	@When("a restaurant owner <restaurantOwner> inputs email <existingEmail> and password <validPassword>")
	public void a_restaurant_owner_restaurant_owner_inputs_email_existing_email_and_password_valid_password() {
		// Write code here that turns the phrase above into concrete actions
		boolean foundEmail = false;
		for (RestaurantOwner r : rORS.getRestaurantOwners()) {
			if (r.getEmail() == owner.getEmail()) {
				foundEmail = true;
			}
		}
		
		assertEquals(true, foundEmail);

	}

	@When("a restaurant owner <restaurantOwner> inputs email <validEmail> and password <invalidPassword>")
	public void a_restaurant_owner_restaurant_owner_inputs_email_valid_email_and_password_invalid_password() {
		// Write code here that turns the phrase above into concrete actions
		
		boolean foundPassword = false;
		for (RestaurantOwner r : rORS.getRestaurantOwners()) {
			if (r.getPassword() == owner.getPassword()) {
				foundPassword = true;
			}
		}

		assertEquals(true, foundPassword);
	}
}
