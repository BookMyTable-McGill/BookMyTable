package bookmytable.stepdefinitions;

import bookmytable.controller.CustomerRegistrationController;
import bookmytable.model.Customer;
import bookmytable.service.CustomerRegistrationService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CreateCustomerAccount {

	private Customer customer = null;
	private String cust_name;
	private String cust_email;
	private String cust_password;
	private String cust_phone_number;
	CustomerRegistrationService service = new CustomerRegistrationService();

	@Given("customer {string} with email {string} and number {string} wishes to create a customer account with password {string}")
	public void customerWithEmailAndAddressWishesToCreateACustomerAccount(String cust_name, String cust_email, String cust_phone_number, String cust_password){

	}

	//Scenario: Create a new customer account (Normal Flow)

	@When("customer attempts to create a customer account with name {string} email {string} password {string} and phone number {string}")
	public void customer_attempts_to_create_a_customer_account_with_name_email_password_and_phone_number(String name, String email, String password, String number) {
		cust_name = name;
		cust_email = email;
		cust_password = password;
		cust_phone_number = number;
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

	//Create a new customer account with same email as existing account (Error Flow 1)

	@Then("the error message 'Account with this email already exists' is displayed")
	public void the_error_message_an_account_with_this_emaiL_already_exists_is_displayed() {
		String error = null;
		try {
			service.createCustomer(cust_name, cust_email, cust_password, cust_phone_number);
		}
		catch(IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals( "An account with this email already exists", error);
	}

	//Create a new customer account with an invalid email (Error Flow 2)

	@Then("the error message 'Invalid Email' is displayed")
	public void the_error_message_invalid_email_is_displayed() {
		String error = null;
		try {
			service.createCustomer(cust_name, cust_email, cust_password, cust_phone_number);
		}
		catch(IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Invalid Email", error);
	}

	//Create a new customer account with an invalid password (Error Flow 3)

	@Then("the error message 'Invalid Password' is displayed")
	public void the_error_message_invalid_password_is_displayed() {
		String error = null;
		try {
			service.createCustomer(cust_name, cust_email, cust_password, cust_phone_number);
		}
		catch(IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Invalid Password", error);
	}

	//Create a new customer account with an invalid phone number (Error Flow 4)

	@Then("the error message 'Invalid Phone Number' is displayed")
	public void the_error_message_invalid_phone_number_is_displayed() {
		String error = null;
		try {
			service.createCustomer(cust_name, cust_email, cust_password, cust_phone_number);
		}
		catch(IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Invalid Phone Number", error);
	}

	//Create a new customer account with missing information (Error Flow 5)

	@Then("the error message 'Missing Information' is displayed")
	public void the_error_message_missing_information_is_displayed() {
		String error = null;
		try {
			service.createCustomer(cust_name, cust_email, cust_password, cust_phone_number);
		}
		catch(IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Missing Information", error);
	}
}
