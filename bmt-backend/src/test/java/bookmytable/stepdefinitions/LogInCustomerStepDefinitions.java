package bookmytable.stepdefinitions;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import bookmytable.model.Customer;
import bookmytable.service.CustomerLoginService;
import bookmytable.service.CustomerRegistrationService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LogInCustomerStepDefinitions {
	@Given("Customer <customer> is on the login page")
	public void customer_customer_is_on_the_login_page() {
		// Write code here that turns the phrase above into concrete actions
	}
	
	
	boolean loggedIn =  false;
	boolean exceptionCaught=false;
	
	@Autowired
	CustomerLoginService loginService = new CustomerLoginService();
	
	@Autowired
	CustomerRegistrationService registrationService = new CustomerRegistrationService();
	
	@Given("Customer <customer> exists")
	public void customer_customer_exists() {
		
	
	}

	@Given("Customer <customer> is unsuspended")
	public void customer_customer_is_unsuspended() {
	}

	@When("Customer <customer> inputs email <validEmail> and password <validPassword>")
	public void customer_customer_inputs_email_valid_email_and_password_valid_password() {
		
	}

	@When("Customer <customer> clicks to Log In")
	public void customer_customer_clicks_to_log_in() {
		Customer cust = registrationService.createCustomer("Teste test", "heoo1@hotmail.com", "test123", "123-456-7890");
		String validEmail = cust.getEmail();
		String validPassword = cust.getPassword();
		loggedIn = loginService.loginCustomer(cust, validEmail, validPassword);
	}
	
	@When("a different Customer <customer> clicks to Log In")
	public void a_different_customer_customer_clicks_to_log_in() {
		Customer cust = registrationService.createCustomer("Teste test", "hlo1@hotmail.com", "test123", "123-456-7890");
		String validEmail = cust.getEmail();
		String validPassword = cust.getPassword();
		loggedIn = loginService.loginCustomer(cust, validEmail, validPassword);
	}

	@Then("Customer <customer> is redirected to the customer profile")
	public void customer_customer_is_redirected_to_the_customer_profile() {
		assertEquals(loggedIn, true);
	}

	@Given("Customer <customer> is already logged in")
	public void customer_customer_is_already_logged_in() {
		loggedIn = true;
	}

	@When("Customer <customer> inputs email <invalidEmail>")
	public void customer_customer_inputs_email_invalid_email() {
		Customer cust = registrationService.createCustomer("Teste test", "helo2@hotmail.com", "test123", "123-456-7890");
		try{
			loggedIn = loginService.loginCustomer(cust, "hi", cust.getPassword());
		} catch(IllegalArgumentException e){
			exceptionCaught = true;
		}
	}

	@When("Customer <customer> inputs  password <validPassword>")
	public void customer_customer_inputs_password_valid_password() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("Customer <customer> will remain on the login page")
	public void customer_customer_will_remain_on_the_login_page() {
		assertEquals(exceptionCaught, true);
	}

	@When("Customer <customer> inputs email <validEmail>")
	public void customer_customer_inputs_email_valid_email() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("Customer <customer> inputs  password <invalidPassword>")
	public void customer_customer_inputs_password_invalid_password() {
		Customer cust = registrationService.createCustomer("Teste test", "helo3@hotmail.com", "test123", "123-456-7890");
		try{
			loggedIn = loginService.loginCustomer(cust, cust.getEmail(), "hi");
		}catch(IllegalArgumentException e){
			exceptionCaught = true;
		}
	}
}
