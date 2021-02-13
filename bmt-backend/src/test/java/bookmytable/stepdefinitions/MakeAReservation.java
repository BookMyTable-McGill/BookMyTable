package bookmytable.stepdefinitions;

import bookmytable.dao.CustomerRepository;
import bookmytable.model.Customer;
import bookmytable.model.Restaurant;
import bookmytable.model.RestaurantOwner;
import bookmytable.service.RestaurantService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MakeAReservation {
	private Customer customer;
	private CustomerRepository cRepo;
	private RestaurantService serviceR;
	private MakeAReservation serviceRsv;
	
	
	@Given("a customer <customer_id> is logged into BookMyTable as a customer")
	public void a_customer_customer_id_is_logged_into_book_my_table_as_a_customer() {
		// Write code here that turns the phrase above into concrete actions
		this.customer = new Customer();
		customer.setName("test");
		customer.setEmail("test@gmail.com");
		customer.setPassword("testPassword");
		customer.setPhoneNumber("5143184677");
		cRepo.save(customer);
		
	}

	@Given("the customer <customer_id> is an unsuspended user")
	public void the_customer_customer_id_is_an_unsuspended_user() {
		// Write code here that turns the phrase above into concrete actions
		
	}

	@When("the customer <customer_id> selects the restaurant <restaurant_id> of their choice")
	public void the_customer_customer_id_selects_the_restaurant_restaurant_id_of_their_choice() {
		// Write code here that turns the phrase above into concrete actions
		//Create owner
		RestaurantOwner owner = new RestaurantOwner();
		
		
		//Create a restaurant
		int[][] hours = new int[4][2];
		int estDuration = 180;
		String menuLink = "aLink";
		int price = 20;
		String cuisine = "asian";
		String options = "vegan";
		String testName = "name";
		String testAddress = "address";
		
		//create restaurant through service method
		Restaurant theRestaurant = serviceR.createRestaurant( testName, testAddress, hours, owner, estDuration, menuLink, price, cuisine, options);
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
	
	@Then("an error message is issued")
	public void an_error_message_is_issued() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
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
