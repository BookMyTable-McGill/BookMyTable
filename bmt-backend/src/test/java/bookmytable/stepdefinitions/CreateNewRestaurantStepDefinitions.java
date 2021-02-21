package bookmytable.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;

import bookmytable.model.Restaurant;
import bookmytable.model.RestaurantOwner;
import bookmytable.service.RestaurantOwnerRegistrationService;
import bookmytable.service.RestaurantService;

public class CreateNewRestaurantStepDefinitions {
	
	@Autowired
	RestaurantService restaurantService = new RestaurantService();
	
	@Autowired
	RestaurantOwnerRegistrationService restaurantOwnerRegistrationService = new RestaurantOwnerRegistrationService();
	
	RestaurantOwner restaurantOwner;
	Restaurant restaurant;
	Restaurant secondRestaurant;
	Boolean exception;
	
	@Given("a restaurant owner {string} wants to add a new restaurant to his account")
	public void a_restaurant_owner_wants_to_add_a_new_restaurant_to_his_account(String name) {
		restaurantOwner = restaurantOwnerRegistrationService.registerRestaurantOwner("Eric", "Password212", "ericpelle@gmail.com");
	}


	@When("creating a restaurant with name {string} and address {string}")
	public void creating_a_restaurant_with_name_and_address(String string, String string2) {
		String name = "name";
		String address = "address";
		Time[][] hours = new Time[7][2];
		Time time1 = Time.valueOf("6:45:20");
		Time time2 = Time.valueOf("7:45:20");
		for (int i = 0; i < hours.length; i++) {
			for (int j = 0; j < hours[i].length; j++) {
				if (j == 0) {
					hours[i][j] = time1;
				}
				else {
					hours[i][j] = time2;
				}
			}
		}
		int estDuration = 2;
		String menuLink = "menuLink";
		int price = 2;
		String cuisine = "cuisine";
		String options = "options";
		try {
			restaurant = restaurantService.createRestaurant(name, address, hours, restaurantOwner, estDuration, menuLink, price, cuisine, options);
		} catch (IllegalArgumentException e) {
			exception = true;
		}
	}
	
	@Then("a unique id {string} will be assigned to it")
	public void a_unique_id_will_be_assigned_to_it(String string) {
	    restaurant.setId(2);
	}
	
	@Then("a status message {string} will be displayed")
	public void a_status_message_will_be_displayed(String string) {
		boolean created = false;
		if(restaurant != null) {
			created = true;
		}
	    assertEquals(created, true);
	}
	
	@Then("reservations for that restaurant will be possible")
	public void reservations_for_that_restaurant_will_be_possible() {
	}
	

	@When("a restaurant with name {string} and address {string} already exists")
	public void a_restaurant_with_name_and_address_already_exists(String string1, String string2) {
		String name = "name";
		String address = "address";
		int[][] hours = new int[2][2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				hours[i][j] = 1;
			}
		}
		int estDuration = 2;
		String menuLink = "menuLink";
		int price = 2;
		String cuisine = "cuisine";
		String options = "options";
	}
	
	@Then("restaurant creation will fail")
	public void restaurant_creation_will_fail() {
	    assertTrue(exception);
	}
	
	@Then("a status message will be displayed")
	public void a_status_message_will_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	}
	

	
}