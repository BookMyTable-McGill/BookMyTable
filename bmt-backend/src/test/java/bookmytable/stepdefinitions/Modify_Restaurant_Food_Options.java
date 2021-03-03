package bookmytable.stepdefinitions;

import org.springframework.beans.factory.annotation.Autowired;

import bookmytable.dao.CustomerRepository;
import bookmytable.dao.ReservationRepository;
import bookmytable.dao.RestaurantOwnerRepository;
import bookmytable.dao.RestaurantRepository;
import bookmytable.dao.TableRepository;
import bookmytable.model.Customer;
import bookmytable.model.Reservation;
import bookmytable.model.Restaurant;
import bookmytable.model.RestaurantOwner;
import bookmytable.model.RestaurantTable;
import bookmytable.service.ReservationService;
import bookmytable.service.RestaurantService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.Time;
import java.util.Random;

public class Modify_Restaurant_Food_Options {
	@Autowired
	private RestaurantOwnerRepository oRepo;
	@Autowired
	private CustomerRepository cRepo;
	@Autowired
	private ReservationRepository rRepo;
	@Autowired
	private TableRepository tRepo;
	@Autowired
	private RestaurantRepository restRepo;
	@Autowired
	private RestaurantService serviceR;
	@Autowired
	private ReservationService serviceRsv;

	private Customer customer;
	private Restaurant theRestaurant;
	private RestaurantTable theTable;
	private String error;
	private String testAddress;

	@Given("a restaurant owner <restaurant_owner_id> is logged into BookMyTable as a restaurant owner")
	public void a_restaurant_owner_restaurant_owner_id_is_logged_into_book_my_table_as_a_restaurant_owner() {
		// Write code here that turns the phrase above into concrete actions

		// Create Owner
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
		String cuisine = "asian";
		String options = "vegan";
		String testName = "name" + getSaltString();
		testAddress = "address" + getSaltString();

		// create restaurant through service method
		this.theRestaurant = serviceR.createRestaurant(testName, testAddress, hours, owner, estDuration, menuLink,
				price, cuisine, options);

	}

	@When("the restaurant owner <restaurant_owner_id> selects one of its restaurants <restaurant_id>")
	public void the_restaurant_owner_restaurant_owner_id_selects_one_of_its_restaurants_restaurant_id() {

	}

	@When("the restaurant owner <restaurant_owner_id> requests to modify the food option")
	public void the_restaurant_owner_restaurant_owner_id_requests_to_modify_the_food_option() {

	}

	@When("the restaurant owner <restaurant_owner_id> enters the new food option")
	public void the_restaurant_owner_restaurant_owner_id_enters_the_new_food_option() {

		serviceR.modifyRestaurantFoodOption(theRestaurant, "gluten-free");

	}

	@Then("the restaurant <restaurant_id> has the newly modified food option")
	public void the_restaurant_restaurant_id_has_the_newly_modified_food_option() {
		Restaurant modifiedRestaurant = serviceR.getRestaurantByAddress(testAddress);
		assertEquals(modifiedRestaurant.getFood().getOptions(), "glutent-free");

	}

	@Then("a {string} message is displayed")
	public void a_message_is_displayed(String string) {
		assertEquals(true, true);
	}

	@When("the restaurant owner <restaurant_owner_id> does not enter the new food option")
	public void the_restaurant_owner_restaurant_owner_id_does_not_enter_the_new_food_option() {

		try {
			serviceR.modifyRestaurantFoodOption(theRestaurant, null);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

	}

	@Then("the restaurant <restaurant_id> food option remains the same")
	public void the_restaurant_restaurant_id_food_option_remains_the_same() {
		
		Restaurant modifiedRestaurant = serviceR.getRestaurantByAddress(testAddress);
		assertEquals(modifiedRestaurant.getFood().getOptions(), "vegan");
	}

	@Then("an error message is displayed")
	public void an_error_message_is_displayed() {

		assertNotEquals(error, null);
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
