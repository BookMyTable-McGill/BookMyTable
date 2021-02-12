package bookmytable.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateCustomerAccount {
	@When("customer {string} attempts to create a customer account")
	public void customer_attempts_to_create_a_customer_account(String string) {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("the customer inputs email {string}")
	public void the_customer_inputs_email(String string) {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@When("the customer inputs password {string}")
	public void the_customer_inputs_password(String string) {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@When("the customer inputs address {string}")
	public void the_customer_inputs_address(String string) {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@When("the customer selects the Create Account button")
	public void the_customer_selects_the_create_account_button() {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@Then("a new customer account with email {string}, password {string}, customer name {string}, address {string} is created")
	public void a_new_customer_account_with_email_password_customer_name_address_is_created(String string, String string2, String string3, String string4) {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@Then("customer <cust_name> is redirected to their account profile")
	public void customer_cust_name_is_redirected_to_their_account_profile(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	}
	
	@When("customer <cust_name> attempts to create a customer account")
	public void customer_cust_name_attempts_to_create_a_customer_account() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("the customer inputs email <existing_email>")
	public void the_customer_inputs_email_existing_email() {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@When("the customer inputs password <password>")
	public void the_customer_inputs_password_password() {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@When("the customer inputs address <cust_address>")
	public void the_customer_inputs_address_cust_address() {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@Then("the error message {string} is displayed")
	public void the_error_message_is_displayed(String string) {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@When("the customer inputs email <invalid_email>")
	public void the_customer_inputs_email_invalid_email() {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@When("the customer inputs email <cust_email>")
	public void the_customer_inputs_email_cust_email() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("the customer inputs password <invalid_password>")
	public void the_customer_inputs_password_invalid_password() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("the customer inputs address <invalid_address>")
	public void the_customer_inputs_address_invalid_address() {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@When("the customer does not input one or multiple of the required information")
	public void the_customer_does_not_input_one_or_multiple_of_the_required_information() {
	    // Write code here that turns the phrase above into concrete actions
	}
	
}
