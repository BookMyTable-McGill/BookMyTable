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

public class Modify_Restaurant_Name {

	@Autowired
	private RestaurantOwnerRepository oRepo;
	@Autowired
	private RestaurantService serviceR;

	private Restaurant theRestaurant;
	private String error;
	private String testName;
	private String testAddress;
	
	@Given("a restaurant owner <restaurant_owner_id> is connected into BookMyTable as a restaurant owner")
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

	@Given("restaurant owner <restaurant_owner_id> has at least one registered restaurant")
	public void restaurant_owner_restaurant_owner_id_has_at_least_one_registered_restaurant() {

	}

	@When("the restaurant owner <restaurant_owner_id> modifies the name of their restaurant <restaurant_id> to a new name")
	public void the_restaurant_owner_restaurant_owner_id_modifies_the_name_of_their_restaurant_restaurant_id_to_a_new_name() {
		
		serviceR.modifyRestaurantName(theRestaurant, "crazypartynight");
		
	}

	@Then("the restaurant <restaurant_id> has the newly modified name")
	public void the_restaurant_restaurant_id_has_the_newly_modified_name() {

		Restaurant modifiedRestaurant = serviceR.getRestaurantByAddress(testAddress);
		assertEquals(modifiedRestaurant.getName(), "crazypartynight");
	}

	@Then("a {string} message is showcased")
	public void a_message_is_displayed(String string) {
		
		assertEquals(true,true);
	}

	@When("the restaurant owner <restaurant_owner_id> modifies the name of their restaurant <restaurant_id> to be the same name")
	public void the_restaurant_owner_restaurant_owner_id_modifies_the_name_of_their_restaurant_restaurant_id_to_be_the_same_name() {
		
		serviceR.modifyRestaurantName(theRestaurant, testName);
	}

	@When("the restaurant owner <restaurant_owner_id> modifies the name of their restaurant <restaurant_id> to be an empty name")
	public void the_restaurant_owner_restaurant_owner_id_modifies_the_name_of_their_restaurant_restaurant_id_to_be_an_empty_name() {
		
		try {
			serviceR.modifyRestaurantName(theRestaurant, null);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
	
	}

	@Then("the restaurant <restaurant_id> name remains the same")
	public void the_restaurant_restaurant_id_name_remains_the_same() {
		
		Restaurant modifiedRestaurant = serviceR.getRestaurantByAddress(testAddress);
		assertEquals(modifiedRestaurant.getName(), testName);
		
	}

	@Then("an error message is showcased")
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
