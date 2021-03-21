package bookmytable.stepdefinitions;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;

import bookmytable.model.Customer;
import bookmytable.service.CustomerLoginService;
import bookmytable.service.CustomerRegistrationService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Delete_Own_Customer_Account {

	boolean loggedIn = false;
	Customer cust;
	String password;
	String exception;
	String deleteException;

	@Autowired
	CustomerRegistrationService CRS = new CustomerRegistrationService();

	@Autowired
	CustomerLoginService CLS = new CustomerLoginService();

	@Given("customer is logged in")
	public void a_customer_is_logged_in() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Given("they are on their modify customer account page")
	public void they_are_on_their_modify_customer_account_page() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("the customer inputs their password into the delete account field")
	public void the_customer_inputs_their_password_into_the_delete_account_field() {
		// Write code here that turns the phrase above into concrete actions
		cust = CRS.createCustomer("Harry Potter", "hp7@hotmail.com", "owl123", "123-456-7890");
		password = cust.getPassword();
	}

	@When("the customer selects to delete their account")
	public void the_customer_selects_to_delete_their_account() {
		// Write code here that turns the phrase above into concrete actions
		try {
			CRS.deleteOwnCustomerAccount(cust, cust.getEmail(), password);
		} catch (IllegalArgumentException e) {
			deleteException = e.getLocalizedMessage();
		}
	}

	@Then("the customer's own account will be deleted")
	public void the_customer_s_own_account_will_be_deleted() {
		// Write code here that turns the phrase above into concrete actions
		try {
			CRS.getCustomerByEmail(cust.getEmail());
		} catch (IllegalArgumentException e) {
			exception = e.getLocalizedMessage();
		}
		assertEquals("No customer with this email was found", exception);
	}

	@Then("the customer will not be able to log in to their restaurant booking system account anymore")
	public void the_customer_will_not_be_able_to_log_in_to_their_restaurant_booking_system_account_anymore() {
		// Write code here that turns the phrase above into concrete actions
		try {
			CLS.loginCustomer(cust, cust.getEmail(), password);
		} catch (IllegalArgumentException e) {
			exception = e.getLocalizedMessage();
		}
		assertEquals("Customer does not exist.", exception);
	}

	@When("the customer inputs an incorrect password into the delete account field")
	public void the_customer_inputs_an_incorrect_password_into_the_delete_account_field() {
		// Write code here that turns the phrase above into concrete actions
		cust = CRS.createCustomer("Someone Else", "hi1@hotmail.com", "cat123", "123-123-1111");
		password = "abcd1234";
	}

	@Then("the customer's account will not be deleted")
	public void the_customer_s_account_will_not_be_deleted() {
		// Write code here that turns the phrase above into concrete actions
		exception = "not caught";
		try {
			CRS.getCustomerByEmail(cust.getEmail());
		} catch (IllegalArgumentException e) {
			exception = e.getLocalizedMessage();
		}
		assertEquals("not caught", exception);
	}

	@Then("the customer will still be able to log in to the restaurant booking system")
	public void the_customer_will_still_be_able_to_log_in_to_the_restaurant_booking_system() {
		// Write code here that turns the phrase above into concrete actions
		loggedIn = false;
		try {
			loggedIn = CLS.loginCustomer(cust, cust.getEmail(), cust.getPassword());
		} catch (IllegalArgumentException e) {
			loggedIn = false;
		}
		assertEquals(true, loggedIn);
	}

}
