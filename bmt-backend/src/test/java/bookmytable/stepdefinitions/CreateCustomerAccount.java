package bookmytable.stepdefinitions;

import bookmytable.dao.CustomerRepository;
import bookmytable.model.Customer;
import bookmytable.service.CustomerRegistrationService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateCustomerAccount {

	private String error;
	private Customer customer;
	@Autowired
	CustomerRegistrationService service;

	@Given("a customer is on the account creation page")
	public void a_customer_is_on_the_account_creation_page(){

	}

	//Scenario: Create a new customer account (Normal Flow)

	@When("customer attempts to create a customer account with name {string} email {string} password {string} and phone number {string}")
	public void customer_attempts_to_create_a_customer_account_with_name_email_password_and_phone_number(String name, String email, String password, String number) {
		customer = service.createCustomer(name, email, password, number);
	}
	
	@Then("a new customer account with the customer's name email password and phone number is created")
	public void a_new_customer_account_with_the_customers_name_email_password_and_phone_number_is_created() {
	    Customer customer = service.getCustomerByEmail(this.customer.getEmail());
		assertEquals(customer.getName(), this.customer.getName());
	    assertEquals(customer.getEmail(), this.customer.getEmail());
		assertEquals(customer.getPassword(), this.customer.getPassword());
		assertEquals(customer.getPhoneNumber(), this.customer.getPhoneNumber());
	}

	@And("the customer is redirected to their account profile")
	public void the_customer_is_redirected_to_their_account_profile(){

	}

	//Create a new customer account with same email as existing account (Error Flow 1)

	@When("customer attempts to create a customer account with name {string} existing email {string} password {string} and phone number {string}")
	public void customer_attempts_to_create_a_customer_account_with_name_existing_email_password_and_phone_number(String name, String email, String password, String number) {
		try {
			service.createCustomer(name, email, password, number);
		}
		catch(IllegalArgumentException e) {
			error = e.getMessage();
		}
	}

	@Then("the error message 'An account with this email already exists' is displayed")
	public void the_error_message_an_account_with_this_emaiL_already_exists_is_displayed() {
		assertEquals( "An account with this email already exists", error);
	}

	//Create a new customer account with an invalid email (Error Flow 2)

	@When("customer attempts to create a customer account with name {string} invalid email {string} password {string} and phone number {string}")
	public void customer_attempts_to_create_a_customer_account_with_name_invalid_email_password_and_phone_number(String name, String email, String password, String number) {
		try {
			service.createCustomer(name, email, password, number);
		}
		catch(IllegalArgumentException e) {
			error = e.getMessage();
		}
	}

	@Then("the error message 'Invalid Email' is displayed")
	public void the_error_message_invalid_email_is_displayed() {
		assertEquals("Invalid Email", error);
	}

	//Create a new customer account with an invalid password (Error Flow 3)

	@When("customer attempts to create a customer account with name {string} email {string} invalid password {string} and phone number {string}")
	public void customer_attempts_to_create_a_customer_account_with_name_email_invalid_password_and_phone_number(String name, String email, String password, String number) {
		try {
			service.createCustomer(name, email, password, number);
		}
		catch(IllegalArgumentException e) {
			error = e.getMessage();
		}
	}

	@Then("the error message 'Invalid Password' is displayed")
	public void the_error_message_invalid_password_is_displayed() {
		assertEquals("Invalid Password", error);
	}

	//Create a new customer account with an invalid phone number (Error Flow 4)

	@When("customer attempts to create a customer account with name {string} email {string} password {string} and invalid phone number {string}")
	public void customer_attempts_to_create_a_customer_account_with_name_email_password_and_invalid_phone_number(String name, String email, String password, String number) {
		try {
			service.createCustomer(name, email, password, number);
		}
		catch(IllegalArgumentException e) {
			error = e.getMessage();
		}
	}

	@Then("the error message 'Invalid Phone Number' is displayed")
	public void the_error_message_invalid_phone_number_is_displayed() {
		assertEquals("Invalid Phone Number", error);
	}

	//Create a new customer account with missing information (Error Flow 5)

	@When("customer attempts to create a customer account with name {string} missing email {string} password {string} and phone number {string}")
	public void customer_attempts_to_create_a_customer_account_with_name_missing_email_password_and_phone_number(String name, String email, String password, String number) {
		try {
			service.createCustomer(name, email, password, number);
		}
		catch(IllegalArgumentException e) {
			error = e.getMessage();
		}
	}

	@Then("the error message 'Missing Information' is displayed")
	public void the_error_message_missing_information_is_displayed() {
		assertEquals("Missing Information", error);
	}
}
