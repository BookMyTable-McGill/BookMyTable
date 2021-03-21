package bookmytable.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

public class Add_Photo {

	@Autowired
	private RestaurantOwnerRepository rRepo;
	
	@Autowired
	private RestaurantService rServe;
	
	private RestaurantOwner owner;
	
	private String testName;
	
	private String testAddress;
	
	private Restaurant resto;
	
	@Given("a Restaurant Owner is logged in to BookMyTable as a restaurant owner")
	public void a_restaurant_owner_is_logged_in_to_book_my_table_as_a_restaurant_owner() {
		owner = new RestaurantOwner();
		rRepo.save(owner);
	}

	@When("the restaurant owner selects a restaurant")
	public void the_restaurant_owner_selects_a_restaurant() {
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
		String menuLink = "big link";
		int price = 2;
		String cuisine = "european";
		String options = "none";
		this.testName = "name" + getSaltString();
		this.testAddress = "randomAddress" + getSaltString();

		// create restaurant through service method
		this.resto = rServe.createRestaurant(testName, testAddress, hours, owner, estDuration, menuLink,
				price, cuisine, options);
	}

	@When("the restaurant owner requests to add a photo")
	public void the_restaurant_owner_requests_to_add_a_photo() {
	}

	@When("the restaurant owner provides a link to a photo")
	public void the_restaurant_owner_provides_a_link_to_a_photo() {
		this.resto = rServe.AddPhoto(resto, "http://thewowstyle.com/wp-content/uploads/2015/01/nature-images-wallpaper.jpg");
	}

	@When("the restaurant owner does not provides a link to a photo")
	public void the_restaurant_owner_does_not_provides_a_link_to_a_photo() {
	}

	@Then("the restaurant has a new link to a photo")
	public void the_restaurant_has_a_new_link_to_a_photo() {
		assertEquals(true, resto.getPhotos().length > 0);
	}
	
	@Then("a status message is displayed")
	public void a_status_message_is_displayed() {
		try {
			this.resto = rServe.AddPhoto(resto, "");
		}catch(IllegalArgumentException e) {
			assertEquals( "No link was provided",e.getMessage());
		}
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
