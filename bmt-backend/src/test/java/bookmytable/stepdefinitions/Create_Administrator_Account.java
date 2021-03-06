package bookmytable.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;

import bookmytable.model.Admin;
import bookmytable.service.AdminRegistrationService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Create_Administrator_Account {
	
	@Autowired
	AdminRegistrationService adminRegistrationService = new AdminRegistrationService();
	
	String name = "Bob Rick";
	String email = "email12122@gmail.com";
	String password = "McgillUniversity";
	Admin createdAdmin;
	IllegalArgumentException error;
	String invalidPassword = "b";
	IllegalArgumentException passwordError;
	

	@Given("a person wishes to create an adminstrator account")
	public void a_person_wishes_to_create_an_adminstrator_account() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("the admin {string} inputs email {string} and password {string}")
	public void the_admin_inputs_email_and_password(String string, String string2, String string3) {
		try {
			createdAdmin = adminRegistrationService.createAdmin(name, email, password);
		} catch(IllegalArgumentException e) {
			error = e;
		}
	}	
	
	@When("the admin {string} clicks to Create account")
	public void the_admin_clicks_to_create_account(String string) {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@Then("an adminstrator account with email {string} and password {string} is created")
	public void an_adminstrator_account_with_email_and_password_is_created(String string, String string2) {
	    assertEquals(createdAdmin.getEmail(), email);
	    assertEquals(createdAdmin.getName(), name);
	    assertEquals(createdAdmin.getPassword(), password);
	}
	
	@Then("the admin {string}  is redirected to the administrator profile")
	public void the_admin_is_redirected_to_the_administrator_profile(String string) {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("a An account with this email already exists error message is issued")
	public void a_an_account_with_this_email_already_exists_error_message_is_issued() {
		boolean errorThrown = false;
		if(error != null) {
			errorThrown = true;
		}
		assertTrue(errorThrown);
	}
	
	@When("the admin {string} inputs email {string} and invalid password {string}")
	public void the_admin_inputs_email_and_invalid_password(String string, String string2, String string3) {
		try {
			createdAdmin = adminRegistrationService.createAdmin(name, email, invalidPassword);
		} catch(IllegalArgumentException e) {
			passwordError = e;
		}
	}
	
	@Then("a password is not valid error message is issued")
	public void a_password_is_not_valid_error_message_is_issued() {
		boolean errorThrown = false;
		if(passwordError != null) {
			errorThrown = true;
		}
		assertTrue(errorThrown);
	}




	
}
