package bookmytable.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogInAsRestaurantOwner {
	@Given("RestaurantOwner <owner> is on the login page")
	public void restaurant_owner_owner_is_on_the_login_page() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Given("RestaurantOwner <owner> exists")
	public void restaurant_owner_owner_exists() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Given("RestaurantOwner <owner> is unsuspended")
	public void restaurant_owner_owner_is_unsuspended() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("RestaurantOwner <owner> inputs email <validEmailOwner> and password <validPasswordOwner>")
	public void restaurant_owner_owner_inputs_email_valid_email_owner_and_password_valid_password_owner() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("RestaurantOwner <owner> clicks to Log In")
	public void restaurant_owner_owner_clicks_to_log_in() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("RestaurantOwner <owner> is redirected to the RestaurantOwner profile")
	public void restaurant_owner_owner_is_redirected_to_the_restaurant_owner_profile() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("the following Reservation list is returned")
	public void the_following_reservation_list_is_returned(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
	}

	@Then("RestaurantOwner <owner> has the option to Create Restaurant")
	public void restaurant_owner_owner_has_the_option_to_create_restaurant() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("RestaurantOwner <owner> inputs email <validEmailOwner> and password <invalidPasswordOwner>")
	public void restaurant_owner_owner_inputs_email_valid_email_owner_and_password_invalid_password_owner() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("RestaurantOwner <owner> inputs email <validEmailOwner> and password <password>")
	public void restaurant_owner_owner_inputs_email_valid_email_owner_and_password_password() {
		// Write code here that turns the phrase above into concrete actions
	}

}
