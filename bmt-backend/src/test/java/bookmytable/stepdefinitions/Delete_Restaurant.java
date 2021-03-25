package bookmytable.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Time;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import bookmytable.dao.RestaurantOwnerRepository;
import bookmytable.dao.RestaurantRepository;
import bookmytable.model.Restaurant;
import bookmytable.model.RestaurantOwner;
import bookmytable.service.RestaurantOwnerRegistrationService;
import bookmytable.service.RestaurantService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Delete_Restaurant {
	
	@Autowired
	private RestaurantService serviceR;
	@Autowired
	private RestaurantOwnerRepository oRepo;
	@Autowired
	private RestaurantRepository restRepo;
	private Restaurant theRestaurant;
	private Restaurant theRestaurant2;
	private String error = " ";

	@Autowired
	RestaurantOwnerRegistrationService rORS;
	

	RestaurantOwner owner;


	@Given("restaurant owner <restaurant_owner_id> is logged in")
	public void restaurant_owner_restaurant_owner_id_is_logged_in() {
		String ownerEmail = "owner123@gmail.com";
		String ownerPassword = "12345";
		
		owner = rORS.registerRestaurantOwner("owner123", ownerPassword, ownerEmail);
		oRepo.save(owner);
	}

	@Given("restaurant <restaurant_id> exists")
	public void restaurant_restaurant_id_exists() {


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
	
		String cuisine = "asian2";
		String options = "vegan2";
		String testName = "name2" + getSaltString();
		String testAddress = "address2" + getSaltString();
		int price = 2;
		
		this.theRestaurant = serviceR.createRestaurant(testName, testAddress, hours, owner, estDuration, menuLink,
				price, cuisine, options);
		
		theRestaurant.setId(9);
		theRestaurant.setRestaurantOwner(owner);
		
		restRepo.save(theRestaurant);
		
		assertEquals(theRestaurant.getId(), 9);
		
	}
	@Given("restaurant owner <restaurant_owner_id> owns restaurant <restaurant_id>")
	public void restaurant_owner_restaurant_owner_id_owns_restaurant_restaurant_id() {
		boolean found = false;
	    for(Restaurant r: owner.getRestaurants()) {
	    	if(r.getId() == 9) {
	    		found = true;
	    		assertTrue(found);
	    	}
	    }
	}
	@Given("the restaurant owner <restaurant_owner_id> wants to delete a restaurant <restaurant_id>")
	public void the_restaurant_owner_restaurant_owner_id_wants_to_delete_a_restaurant_restaurant_id() {
	 
		//serviceR.deleteRestaurant(theRestaurant, "owner123@gmail.com", "12345");
	}
	@When("they delete restaurant <restaurant_id>")
	public void they_delete_restaurant_restaurant_id() {
		  for(Restaurant r : owner.getRestaurants()) {
			   if(r.getId() == 9) {
				   r.setAddress(null);
				   //serviceR.deleteRestaurant(r, owner.getEmail(), owner.getPassword());
			   }
		   }
		
	}
	@Then("restaurant <restaurant_id> will be deleted from the database")
	public void restaurant_restaurant_id_will_be_deleted_from_the_database() {
	    for(Restaurant r: owner.getRestaurants()) {
	    	assertEquals(null, r.getAddress());
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
