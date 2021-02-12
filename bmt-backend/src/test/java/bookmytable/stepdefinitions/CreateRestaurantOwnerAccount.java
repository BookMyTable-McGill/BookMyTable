package bookmytable.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateRestaurantOwnerAccount {
	@Given("a restaurant owner <restaurantOwner> is on the create restaurant owner account page")
	public void a_restaurant_owner_restaurant_owner_is_on_the_create_restaurant_owner_account_page() {
	    // Write code here that turns the phrase above into concrete actions
	}


	@When("a restaurant owner <restaurantOwner> inputs email <validEmail> and password <validPassword>")
	public void a_restaurant_owner_restaurant_owner_inputs_email_valid_email_and_password_valid_password() {
	    // Write code here that turns the phrase above into concrete actions
	}
	@When("restaurant owner <restaurantOwner> clicks to Create account")
	public void restaurant_owner_restaurant_owner_clicks_to_create_account() {
	    // Write code here that turns the phrase above into concrete actions
	}
	@Then("a restaurant owner with email <validEmail> and password <validPassword> is created")
	public void a_restaurant_owner_with_email_valid_email_and_password_valid_password_is_created() {
	    // Write code here that turns the phrase above into concrete actions
	}
	@Then("restaurant owner <restaurantOwner> is redirected to restaurant owner profile")
	public void restaurant_owner_restaurant_owner_is_redirected_to_restaurant_owner_profile() {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@When("a restaurant owner <restaurantOwner> inputs email <existingEmail> and password <validPassword>")
	public void a_restaurant_owner_restaurant_owner_inputs_email_existing_email_and_password_valid_password() {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@When("a restaurant owner <restaurantOwner> inputs email <validEmail> and password <invalidPassword>")
	public void a_restaurant_owner_restaurant_owner_inputs_email_valid_email_and_password_invalid_password() {
	    // Write code here that turns the phrase above into concrete actions
	}
}
