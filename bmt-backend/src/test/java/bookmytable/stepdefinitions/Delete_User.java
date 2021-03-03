package bookmytable.stepdefinitions;

import org.springframework.beans.factory.annotation.Autowired;

import bookmytable.model.Restaurant;
import bookmytable.model.Customer;
import bookmytable.model.RestaurantOwner;
import bookmytable.service.CustomerRegistrationService;
import bookmytable.service.RestaurantOwnerRegistrationService;
import bookmytable.service.RestaurantOwnerLoginService;
import bookmytable.service.CustomerLoginService;
import bookmytable.service.RestaurantService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.And;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;


public class Delete_User {
	
	@Autowired
	RestaurantService restaurantService = new RestaurantService();
	
	@Autowired
	CustomerRegistrationService customerRegistrationService = new CustomerRegistrationService();
	
	@Autowired
	RestaurantOwnerRegistrationService restaurantOwnerRegistrationService = new RestaurantOwnerRegistrationService();
	
	@Autowired
	RestaurantOwnerLoginService restaurantOwnerLoginService = new RestaurantOwnerLoginService();
	
	@Autowired
	CustomerLoginService customerLoginService = new CustomerLoginService();
		
	Customer customer;
	long customerID;
	String customerEmail;
	String customerPassword;;
	
	RestaurantOwner restaurantOwner;
	long restaurantOwnerID;
	String restaurantOwnerEmail;
	String restaurantOwnerPassword;
	Set<Restaurant> restaurants = new HashSet<Restaurant>(); 


	@Given("an administrator is logged in")
	public void an_administrator_is_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
	}


	@Given("they are viewing all the existing users")
	public void they_are_viewing_all_the_existing_users() {
	    // Write code here that turns the phrase above into concrete actions
	}
	@Given("the administrator wants to delete a customer account")
	public void the_administrator_wants_to_delete_a_customer_account() {
	    // Write code here that turns the phrase above into concrete actions
		
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder word = new StringBuilder();
        Random rnd = new Random();
        while (word.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            word.append(chars.charAt(index));
        }
        String randomw = word.toString();
        
		customer = customerRegistrationService.createCustomer(randomw, randomw + "@mail.com", randomw, "123-123-1234");
		customerID = customer.getId();
		customerEmail = customer.getEmail();
		customerPassword = customer.getPassword();
	}
	@When("they delete said customer account")
	public void they_delete_said_customer_account() {
	    // Write code here that turns the phrase above into concrete actions
		customerRegistrationService.deleteCustomer(customerID);
	}
	@Then("the customer's account will be deleted")
	public void the_customer_s_account_will_be_deleted() {
	    // Write code here that turns the phrase above into concrete actions
		String error = null;
		try {
			customerRegistrationService.getCustomerById(customerID);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("No customer with this id was found", error);
	}
	@Then("the customer will not be able to log in to the restaurant booking system anymore")
	public void the_customer_will_not_be_able_to_log_in_to_the_restaurant_booking_system_anymore() {
	    // Write code here that turns the phrase above into concrete actions	    
		String error = null;
		try {
			customerLoginService.loginCustomer(customer, customerEmail, customerPassword);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Customer does not exist.", error);
	}
	

	@Given("the administrator wants to delete a restaurant owner account")
	public void the_administrator_wants_to_delete_a_restaurant_owner_account() {
	    // Write code here that turns the phrase above into concrete actions
		
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder word = new StringBuilder();
        Random rnd = new Random();
        while (word.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            word.append(chars.charAt(index));
        }
        String randomw = word.toString();
        
		restaurantOwner =  restaurantOwnerRegistrationService.registerRestaurantOwner(randomw, randomw, randomw + "@mail.com");
		restaurantOwnerID = restaurantOwner.getId();
		restaurantOwnerEmail = restaurantOwner.getEmail();
		restaurantOwnerPassword = restaurantOwner.getPassword();
		Restaurant restaurant1 = new Restaurant();
		Restaurant restaurant2 = new Restaurant();
		Restaurant restaurant3 = new Restaurant();
		restaurant1.setRestaurantOwner(restaurantOwner);
		restaurant2.setRestaurantOwner(restaurantOwner);
		restaurant3.setRestaurantOwner(restaurantOwner);
		restaurants = restaurantOwner.getRestaurants();
	}
	@When("they delete said restaurant owner")
	public void they_delete_said_restaurant_owner() {
		restaurantOwnerRegistrationService.deleteRestaurantOwner(restaurantOwnerID);
	}
	@Then("the restaurant owner's account will be deleted")
	public void the_restaurant_owner_s_account_will_be_deleted() {
	    // Write code here that turns the phrase above into concrete actions
		assertNull(restaurantOwnerLoginService.getRestaurantOwnerByID(restaurantOwnerID));	
	}
	@Then("the restaurant owner's restaurants will be deleted")
	public void the_restaurant_owner_s_restaurants_will_be_deleted() {
	    // Write code here that turns the phrase above into concrete actions
		assertNull(restaurants);
	}
	@Then("the restaurant owner will not be able to log in to the restaurant booking system anymore")
	public void the_restaurant_owner_will_not_be_able_to_log_in_to_the_restaurant_booking_system_anymore() {
	    // Write code here that turns the phrase above into concrete actions
		String error = null;
		try {
			restaurantOwnerLoginService.loginRestaurantOwner(restaurantOwner, restaurantOwnerPassword);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Restaurant Owner does not exist", error);	
	}
	
}
