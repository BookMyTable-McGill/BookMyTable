package bookmytable.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateNewAdiministratorAccount {
	@When("the admin <administrator> inputs email <validEmail> and password <validPassword>")
	public void the_admin_administrator_inputs_email_valid_email_and_password_valid_password() {
	    // Write code here that turns the phrase above into concrete actions
	}


	@When("the admin <administrator> clicks to Create account")
	public void the_admin_administrator_clicks_to_create_account() {
	    // Write code here that turns the phrase above into concrete actions
	}
	@Then("an adminstrator account with email <validEmail> and password <validPassword> is created")
	public void an_adminstrator_account_with_email_valid_email_and_password_valid_password_is_created() {
	    // Write code here that turns the phrase above into concrete actions
	}
	@Then("the admin <administrator>  is redirected to the administrator profile")
	public void the_admin_administrator_is_redirected_to_the_administrator_profile() {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@When("the admin <administrator> inputs email <existingEmail> and password <validPassword>")
	public void the_admin_administrator_inputs_email_existing_email_and_password_valid_password() {
	    // Write code here that turns the phrase above into concrete actions
	}


	@Then("a {string} error message is issued")
	public void a_error_message_is_issued(String string) {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@When("the admin <administrator> inputs email <validEmail> and password <invalidPassword>")
	public void the_admin_administrator_inputs_email_valid_email_and_password_invalid_password() {
	    // Write code here that turns the phrase above into concrete actions
	}
}
