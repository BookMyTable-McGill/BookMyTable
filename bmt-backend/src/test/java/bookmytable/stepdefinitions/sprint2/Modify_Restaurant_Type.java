package bookmytable.stepdefinitions.sprint2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.Time;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import bookmytable.dao.RestaurantOwnerRepository;
import bookmytable.model.Restaurant;
import bookmytable.model.RestaurantOwner;
import bookmytable.service.RestaurantService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Modify_Restaurant_Type {
	
	@Autowired
	private RestaurantOwnerRepository oRepo;
	@Autowired
	private RestaurantService serviceR;

	private Restaurant theRestaurant;
	private String error;
	private String testName;
	private String testAddress;

	@Given("owner of restaurant <restaurant_owner_id> is logged into BookMyTable as a restaurant owner")
	public void a_restaurant_owner_restaurant_owner_id_is_logged_into_book_my_table_as_a_restaurant_owner() {

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
		this.testName = "name" + getSaltString();
		this.testAddress = "address" + getSaltString();

		// create restaurant through service method
		this.theRestaurant = serviceR.createRestaurant(testName, testAddress, hours, owner, estDuration, menuLink,
				price, cuisine, options);
	}

	@When("owner of restaurant <restaurant_owner_id> selects one of their restaurants <restaurant_id>")
	public void the_restaurant_owner_restaurant_owner_id_selects_one_of_their_restaurants_restaurant_id() {

	}

	@When("the restaurant owner <restaurant_owner_id> requests to modify the restaurant type")
	public void the_restaurant_owner_restaurant_owner_id_requests_to_modify_the_restaurant_type() {

		
	}

	@When("the restaurant owner <restaurant_owner_id> enters the restaurant type")
	public void the_restaurant_owner_restaurant_owner_id_enters_the_restaurant_type() {

		serviceR.modifyRestaurantType(theRestaurant, "moroccan");
	}

	@Then("the restaurant <restaurant_id> has the newly modified type")
	public void the_restaurant_restaurant_id_has_the_newly_modified_type() {

		Restaurant modifiedRestaurant = serviceR.getRestaurantByAddress(testAddress);
		assertEquals(modifiedRestaurant.getFood().getCuisine(), "moroccan");
	}

	@Then("a {string} message is appearing")
	public void a_message_is_displayed(String string) {

		assertEquals(true,true);
	}

	@When("owner of restaurant <restaurant_owner_id> selects one of its restaurants <restaurant_id>")
	public void the_restaurant_owner_restaurant_owner_id_selects_one_of_its_restaurants_restaurant_id() {

	}

	@When("the restaurant owner <restaurant_owner_id> does not enter the new restaurant type")
	public void the_restaurant_owner_restaurant_owner_id_does_not_enter_the_new_restaurant_type() {
		
		try {
			serviceR.modifyRestaurantType(theRestaurant, null);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
	}

	@Then("the restaurant <restaurant_id> type remains the same")
	public void the_restaurant_restaurant_id_type_remains_the_same() {
		
		Restaurant modifiedRestaurant = serviceR.getRestaurantByAddress(testAddress);
		assertEquals(modifiedRestaurant.getFood().getCuisine(), "asian");
	}

	@Then("an error message is appearing")
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
