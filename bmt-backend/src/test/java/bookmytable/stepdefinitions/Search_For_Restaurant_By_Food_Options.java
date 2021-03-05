package bookmytable.stepdefinitions;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Time;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import bookmytable.dao.RestaurantOwnerRepository;
import bookmytable.dao.RestaurantRepository;
import bookmytable.model.Restaurant;
import bookmytable.model.RestaurantOwner;
import bookmytable.service.RestaurantService;
import bookmytable.service.SearchingSerivce;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search_For_Restaurant_By_Food_Options {

	
	@Autowired
	private RestaurantService restaurantService;

	@Autowired
	private SearchingSerivce searchingS;
	
	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private RestaurantOwnerRepository restaurantOwnerRepository;

	RestaurantOwner restaurantOwner1;
	RestaurantOwner restaurantOwner2;
	Restaurant restaurant1;
	Restaurant restaurant2;
	List<Restaurant> rest;
	Boolean exception;

	@Given("the following Restaurants exist")
	public void the_following_restaurants_exist(io.cucumber.datatable.DataTable dataTable) {
		
		RestaurantOwner owner1 = new RestaurantOwner();
		restaurantOwnerRepository.save(owner1);
		
		//creating restaurant 1
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
		String cuisine = "asian";
		String options = "vegan";
		String testName1 = "gdoggygih5h111" + getSaltString();
		String testAddress1 = "97484g6655986111" + getSaltString();

		restaurant1 = restaurantService.createRestaurant(testName1, testAddress1, hours, owner1, estDuration, menuLink,
				price, cuisine, options);
	
		
		// creating restaurant 2
		
		RestaurantOwner owner2 = new RestaurantOwner();
		restaurantOwnerRepository.save(owner2);
		
		//creating restaurant 1
		Time[][] hours2 = new Time[7][2];
		Time time3 = Time.valueOf("6:45:20");
		Time time4 = Time.valueOf("7:45:20");
		for (int i = 0; i < hours2.length; i++) {
			for (int j = 0; j < hours2[i].length; j++) {
				if (j == 0) {
					hours2[i][j] = time3;
				} else {
					hours2[i][j] = time4;
				}
			}
		}
		int estDuration2 = 180;
		String menuLink2 = "aLink";
		int price2 = 3;
		String cuisine2 = "canadian";
		String options2 = "gluten-free";
		String testName2 = "o65iugy5rtufijh111" + getSaltString();
		String testAddress2 = "47335g5662370111" + getSaltString();

		restaurant2 = restaurantService.createRestaurant(testName2, testAddress2, hours2, owner2, estDuration2, menuLink2,
				price2, cuisine2, options2);
	
		
	}

	@When("Customer <customer_name> searches for the price <search_options>")
	public void customer_customer_name_searches_for_the_price_search_options() {
	}

	@Then("the restaurant info for Restaurants with <restaurant_price> equal to <search_options> will be displayed")
	public void the_restaurant_info_for_restaurants_with_restaurant_price_equal_to_search_options_will_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		//try {
			rest = searchingS.getRestaurantsByOptions("vegan");
		//}catch(IllegalArgumentException e) {
	//		exception = true;
	//	}
		
		boolean found = false;
		
		for(Restaurant r : rest) {
			if(r.getFood().getOptions() == "vegan") {
				found = true;
				assertTrue(found);
			}
		}
	}

	@Given("the Customer has not selected any food options")
	public void the_customer_has_not_selected_any_food_options() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("the Customer attempts to search by food options")
	public void the_customer_attempts_to_search_by_food_options() {
		// Write code here that turns the phrase above into concrete actions
	}

	/*
	 * @Then("all restaurants will be returned") public void
	 * all_restaurants_will_be_returned() { // Write code here that turns the phrase
	 * above into concrete actions throw new io.cucumber.java.PendingException(); }
	 */
	@Then("the Customer will be notified that no options filter was applied")
	public void the_customer_will_be_notified_that_no_options_filter_was_applied() {
		// Write code here that turns the phrase above into concrete actions
		//assertTrue(exception);
	}

	@When("Customer <customer_name> searches for the option Lactose-Free")
	public void customer_customer_name_searches_for_the_option_lactose_free() {
		// Write code here that turns the phrase above into concrete actions
		
	}

	@Then("The the Customer will be notified that no restaurants fall under their desired food options")
	public void the_the_customer_will_be_notified_that_no_restaurants_fall_under_their_desired_food_options() {
		// Write code here that turns the phrase above into concrete actions
		//for(Restaurant r : rest) {
		for(Restaurant r: restaurantRepository.findAll()) {
			assertNotEquals("lactose-free", r.getFood().getOptions());

		}
		//}
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
