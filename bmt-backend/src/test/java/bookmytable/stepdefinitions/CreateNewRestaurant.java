package bookmytable.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CreateNewRestaurant {
	@Given("a restaurant owner {string} wants to add a new restaurant to his account")
	public void a_restaurant_owner_wants_to_add_a_new_restaurant_to_his_account(String string) {
	    // Write code here that turns the phrase above into concrete actions
	  
	}


	@When("creating a restaurant with name {string} and address {string}")
	public void creating_a_restaurant_with_name_and_address(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@Then("a unique id {int} will be assigned to it")
	public void a_unique_id_will_be_assigned_to_it(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@Then("a status message {string} will be displayed")
	public void a_status_message_will_be_displayed(String string) {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@Then("reservations for that restaurant will be possible")
	public void reservations_for_that_restaurant_will_be_possible() {
	    // Write code here that turns the phrase above into concrete actions
	}
	

	@When("a restaurant with name {string} and address {string} already exists")
	public void a_restaurant_with_name_and_address_already_exists(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@Then("restaurant creation will fail")
	public void restaurant_creation_will_fail() {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@Then("a status message will be displayed")
	public void a_status_message_will_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	}
	

	
}
