package bookmytable.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Time;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import bookmytable.dao.RestaurantOwnerRepository;
import bookmytable.dao.RestaurantRepository;
import bookmytable.model.Food;
import bookmytable.model.Restaurant;
import bookmytable.model.RestaurantOwner;
import bookmytable.service.RestaurantService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class View_Restaurant_Menu {

	@Autowired
	private RestaurantService serviceR;
	@Autowired
	private RestaurantOwnerRepository oRepo;
	@Autowired
	private RestaurantRepository restRepo;
	private Restaurant theRestaurant;
	private Restaurant theRestaurant2;
	private String error = " ";

//
//		@Given("a customer <customer_id> is logged into BookMyTable as a customer")
//		public void a_customer_customer_id_is_logged_into_book_my_table_as_a_customer() {
//		    // Write code here that turns the phrase above into concrete actions
//		  
//		}
//
//		@Given("the customer <customer_id> is an unsuspended user")
//		public void the_customer_customer_id_is_an_unsuspended_user() {
//		   
//		}




	@When("the customer <customer_id> queries to view the menu of a restaurant with name <restaurant_name>")
	public void the_customer_customer_id_queries_to_view_the_menu_of_a_restaurant_with_name_restaurant_name() {

	}

	@Then("the customer is redirected to the menu link to the restaurant <restaurant_name>")
	public void the_customer_is_redirected_to_the_menu_link_to_the_restaurant_restaurant_name() {

	}

	@Then("the list of foods available in the restaurant <restaurant_name> are shown.")
	public void the_list_of_foods_available_in_the_restaurant_restaurant_name_are_shown() {
		RestaurantOwner owner = new RestaurantOwner();

		oRepo.save(owner);

		// Create a restaurant
		Time[][] hours = new Time[7][2];
		Time time1 = Time.valueOf("6:45:20");
		Time time2 = Time.valueOf("7:45:20");
		for (int i = 0; i < hours.length; i++) {
			for (int j = 0; j < hours[i].length; j++) {
				if (j == 0) {
					hours[i][j] = time1;
				} else {
					hours[i][j] = time2;
				}
			}
		}
		int estDuration = 180;
		String menuLink = "aLink";
		int price = 2;
		String cuisine = "asian2";
		String options = "vegan2";
		String testName = "name2" + getSaltString();
		String testAddress = "address2" + getSaltString();

		this.theRestaurant = serviceR.createRestaurant(testName, testAddress, hours, owner, estDuration, menuLink,
				price, cuisine, options);
		
		restRepo.save(theRestaurant);
		
		assertEquals(theRestaurant.getFood().getMenuLink(), "aLink");
		
	}

	@When("the restaurant <restaurant_name> has  link to its menu")
	public void the_restaurant_restaurant_name_has_link_to_its_menu() {
		//assertNotNull(theRestaurant.getFood().getMenuLink());
	}

	@Then("the customer gets redirected to the wrong link.")
	public void the_customer_gets_redirected_to_the_wrong_link() {
		// Write code here that turns the phrase above into concrete actions
		
	}

	@When("the restaurant <restaurant_name> has no link to its menu")
	public void the_restaurant_restaurant_name_has_no_link_to_its_menu() {
		RestaurantOwner owner = new RestaurantOwner();

		oRepo.save(owner);

		// Create a restaurant
		Time[][] hours = new Time[7][2];
		Time time1 = Time.valueOf("6:45:20");
		Time time2 = Time.valueOf("7:45:20");
		for (int i = 0; i < hours.length; i++) {
			for (int j = 0; j < hours[i].length; j++) {
				if (j == 0) {
					hours[i][j] = time1;
				} else {
					hours[i][j] = time2;
				}
			}
		}
		int estDuration = 180;
		String menuLink = " ";
		int price = 2;
		String cuisine = "asian2";
		String options = "vegan2";
		String testName = "name2" + getSaltString();
		String testAddress = "address2" + getSaltString();

		try{
		this.theRestaurant2 = serviceR.createRestaurant(testName, testAddress, hours, owner, estDuration, menuLink,
				price, cuisine, options);
		}catch(Exception e) {
			error = "empty menu";
		}
		
		assertEquals(menuLink, " ");
		
		
	}

	@Then("the customer gets an error message.")
	public void the_customer_gets_an_error_message() {
		
		assertNotEquals(" ", error);
	}

	protected String getSaltString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 18) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}

}
