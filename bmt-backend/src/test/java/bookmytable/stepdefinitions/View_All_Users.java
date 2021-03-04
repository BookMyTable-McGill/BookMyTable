package bookmytable.stepdefinitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class View_All_Users {

	/*
	@Given("Administrator {string} is logged in")
	public void administrator_is_logged_in(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}*/


	@When("Administrator {string} attempts to view all users")
	public void administrator_attempts_to_view_all_users(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("a list of all Customer ids <{string}> and all  Restaurant Owner ids <{string}> is returned:")
	public void a_list_of_all_customer_ids_and_all_restaurant_owner_ids_is_returned(String string, String string2, io.cucumber.datatable.DataTable dataTable) {
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
