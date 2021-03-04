package bookmytable.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import bookmytable.dao.RestaurantOwnerRepository;
import bookmytable.model.Restaurant;
import bookmytable.model.RestaurantOwner;
import bookmytable.service.RestaurantService;
import bookmytable.service.SearchingSerivce;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search_For_Restaurant_By_Price {

	@Autowired
	private RestaurantService restaurantService;

	@Autowired
	private SearchingSerivce searchingS;

	@Autowired
	private RestaurantOwnerRepository restaurantOwnerRepository;

	RestaurantOwner restaurantOwner1;
	RestaurantOwner restaurantOwner2;
	Restaurant restaurant1;
	Restaurant restaurant2;
	List<Restaurant> rest;
	Boolean exception;
	Boolean returned;
	/*
	 * @Given("the following Restaurants exist") public void
	 * the_following_restaurants_exist(io.cucumber.datatable.DataTable dataTable) {
	 * // Write code here that turns the phrase above into concrete actions // For
	 * automatic transformation, change DataTable to one of // E, List<E>,
	 * List<List<E>>, List<Map<K,V>>, Map<K,V> or // Map<K, List<V>>. E,K,V must be
	 * a String, Integer, Float, // Double, Byte, Short, Long, BigInteger or
	 * BigDecimal. // // For other transformations you can register a DataTableType.
	 * throw new io.cucumber.java.PendingException(); }
	 */

	@When("Customer <customer_name> searches for the price <search_price>")
	public void customer_customer_name_searches_for_the_price_search_price() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("the restaurant info for Restaurants with <restaurant_price> equal to <search_price> will be displayed")
	public void the_restaurant_info_for_restaurants_with_restaurant_price_equal_to_search_price_will_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		// Write code here that turns the phrase above into concrete actions
		try {
			rest = searchingS.getRestaurantsByPrice(2);
		
		} catch (IllegalArgumentException e) {
			exception = true;
		}

		//returned = true;
		for (Restaurant r : rest) {
			assertEquals(2, r.getFood().getPrice());
		}
	}

	/*
	 * @Given("the Customer has not selected a price") public void
	 * the_customer_has_not_selected_a_price() { // Write code here that turns the
	 * phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 */

	/*
	 * @When("the Customer attempts to search by price") public void
	 * the_customer_attempts_to_search_by_price() { // Write code here that turns
	 * the phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 * 
	 */
	@Then("all restaurants will be returned")
	public void all_restaurants_will_be_returned() {
		// Write code here that turns the phrase above into concrete actions
		//assertTrue(returned); 
		//assertNotNull(rest);
	}

	/*
	 * @Then("the Customer will be notified that no price filter was applied")
	 * public void the_customer_will_be_notified_that_no_price_filter_was_applied()
	 * { // Write code here that turns the phrase above into concrete actions throw
	 * new io.cucumber.java.PendingException(); }
	 */

	@When("Customer <customer_name> searches for the price {int}")
	public void customer_customer_name_searches_for_the_price(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("the Customer will be notified that no restaurants fall under their desired price range")
	public void the_customer_will_be_notified_that_no_restaurants_fall_under_their_desired_price_range() {
		// Write code here that turns the phrase above into concrete actions
		for (Restaurant r : rest) {
			assertNotEquals(1, r.getFood().getPrice());
		}
	}

}