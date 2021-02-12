package bookmytable.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewMapOfReservations {
	@Given("restaurant owner <restaurant_owner> is logged into BookMyTable as a restaurant owner")
	public void restaurant_owner_restaurant_owner_is_logged_into_book_my_table_as_a_restaurant_owner() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Given("<restaurant_owner> owns <restaurant_id>")
	public void restaurant_owner_owns_restaurant_id() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Given("the following reservations are registered to the restaurant <restaurant_id>:")
	public void the_following_reservations_are_registered_to_the_restaurant_restaurant_id(
			io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
	}

	@When("<restaurant_owner> queries reservations with <reservation_datetime> ranging from {int}-{int}-{int} {int}:{int}:{int} to {int}-{int}-{int} {int}:{int}:{int} in <restaurant_id>")
	public void restaurant_owner_queries_reservations_with_reservation_datetime_ranging_from_to_in_restaurant_id(
			Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6, Integer int7,
			Integer int8, Integer int9, Integer int10, Integer int11, Integer int12) {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("the following list of all tables in <restaurant_id> is returned:")
	public void the_following_list_of_all_tables_in_restaurant_id_is_returned(
			io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
	}
}
