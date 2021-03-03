package bookmytable.stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search_For_Restaurant_By_Type {

	/*
	@Given("the following Restaurants exist")
	public void the_following_restaurants_exist(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    throw new io.cucumber.java.PendingException();
	}*/



	@When("Customer <customer_name> searches for the type <search_type>")
	public void customer_customer_name_searches_for_the_type_search_type() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the restaurant info for Restaurants with <restaurant_type> equal to <search_type> will be displayed")
	public void the_restaurant_info_for_restaurants_with_restaurant_type_equal_to_search_type_will_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Given("the Customer has not selected a price")
	public void the_customer_has_not_selected_a_price() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}



	@When("the Customer attempts to search by price")
	public void the_customer_attempts_to_search_by_price() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}/*
	@Then("all restaurants will be returned")
	public void all_restaurants_will_be_returned() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}*/
	@Then("the Customer will be notified that no price filter was applied")
	public void the_customer_will_be_notified_that_no_price_filter_was_applied() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


	@When("Customer <customer_name> searches for the type Chinese")
	public void customer_customer_name_searches_for_the_type_chinese() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the Customer will be notified that no restaurants fall under their desired type")
	public void the_customer_will_be_notified_that_no_restaurants_fall_under_their_desired_type() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	
	
}
