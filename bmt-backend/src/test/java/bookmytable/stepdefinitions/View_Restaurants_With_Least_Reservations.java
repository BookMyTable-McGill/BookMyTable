package bookmytable.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class View_Restaurants_With_Least_Reservations {

	@Given("Customer {string} exists")
	public void customer_exists(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("Customer {string} has email {string}, password {string}")
	public void customer_has_email_password(String string, String string2, String string3) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("Customer {string} is logged in")
	public void customer_is_logged_in(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("there is at least {int} Restaurant in the system")
	public void there_is_at_least_restaurant_in_the_system(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("Customer {string} queries to view Restaurants with least Reservations")
	public void customer_queries_to_view_restaurants_with_least_reservations(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("there are at least {int} Restaurants in the System")
	public void there_are_at_least_restaurants_in_the_system(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("a list of the first {int} Restaurants with the least Reservations <{string}> is returned in ascending order:")
	public void a_list_of_the_first_restaurants_with_the_least_reservations_is_returned_in_ascending_order(Integer int1,
			String string, io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		throw new io.cucumber.java.PendingException();
	}

	@When("there are less than {int} Restaurants in the system")
	public void there_are_less_than_restaurants_in_the_system(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("a list of all of the Restaurants <{string}> in the system is returned in ascending order based on Reservations:")
	public void a_list_of_all_of_the_restaurants_in_the_system_is_returned_in_ascending_order_based_on_reservations(
			String string, io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		throw new io.cucumber.java.PendingException();
	}

}
