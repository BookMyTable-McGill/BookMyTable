package bookmytable.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MakeAReservation {
	@Given("a customer <customer_id> is logged into BookMyTable as a customer")
	public void a_customer_customer_id_is_logged_into_book_my_table_as_a_customer() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Given("the customer <customer_id> is an unsuspended user")
	public void the_customer_customer_id_is_an_unsuspended_user() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("the customer <customer_id> selects the restaurant <restaurant_id> of their choice")
	public void the_customer_customer_id_selects_the_restaurant_restaurant_id_of_their_choice() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("the customer <customer_id>  enters an acceptable group size <group_size>")
	public void the_customer_customer_id_enters_an_acceptable_group_size_group_size() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("the customer <customer_id>  selects an available date and time <reservation_datetime>")
	public void the_customer_customer_id_selects_an_available_date_and_time_reservation_datetime() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("the customer <customer_id>  selects an available table <table_id> of their choice")
	public void the_customer_customer_id_selects_an_available_table_table_id_of_their_choice() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("the customer <customer_id>  should see a confirmation message")
	public void the_customer_customer_id_should_see_a_confirmation_message() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("a new reservation <reservation_id> is generated")
	public void a_new_reservation_reservation_id_is_generated(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
	}

	@When("the customer <customer_id>  fails to select an available reservation date and time <reservation_datetime>")
	public void the_customer_customer_id_fails_to_select_an_available_reservation_date_and_time_reservation_datetime() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("the customer <customer_id>  enter a group size <group_size> surpassing the maximum limit")
	public void the_customer_customer_id_enter_a_group_size_group_size_surpassing_the_maximum_limit() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("the customer <customer_id>  fails to enter a group size <group_size>")
	public void the_customer_customer_id_fails_to_enter_a_group_size_group_size() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("the customer <customer_id>  fails to select an available table <table_id> of my choice")
	public void the_customer_customer_id_fails_to_select_an_available_table_table_id_of_my_choice() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("the customer <customer_id>  selects a restaurant that is completely booked")
	public void the_customer_customer_id_selects_a_restaurant_that_is_completely_booked() {
		// Write code here that turns the phrase above into concrete actions
	}
	


}
