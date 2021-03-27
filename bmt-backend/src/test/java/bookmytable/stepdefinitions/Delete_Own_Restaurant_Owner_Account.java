package bookmytable.stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.sql.Time;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import bookmytable.dao.RestaurantOwnerRepository;
import bookmytable.dao.RestaurantRepository;
import bookmytable.model.Restaurant;
import bookmytable.model.RestaurantOwner;
import bookmytable.service.RestaurantOwnerLoginService;
import bookmytable.service.RestaurantOwnerRegistrationService;
import bookmytable.service.RestaurantService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Delete_Own_Restaurant_Owner_Account {
	
	private boolean loggedIn = false;
	private RestaurantOwner restaurantOwner;
	private String password;
	private String deleteException;
	private String email;
	private Restaurant restaurant;
	
	
	
	@Autowired
	private RestaurantOwnerLoginService ROLService;
	
	@Autowired
	private RestaurantOwnerRegistrationService RORService;
	
	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	private RestaurantRepository repo;
	
	@Autowired
	private RestaurantOwnerRepository ROrepo;
	
	

	
	@Given("a restaurant owner is logged in")
	public void a_restaurant_owner_is_logged_in() {
		
		restaurantOwner = RORService.registerRestaurantOwner("newOwner", "password", "xyz00@email.com");
		restaurantOwner.setId(Long.valueOf(9999));
		ROrepo.save(restaurantOwner);
		email = restaurantOwner.getEmail();
		String name = "newName";
		String address = "address";
		Time[][] hours = new Time[7][2];
		Time time1 = Time.valueOf("6:45:20");
		Time time2 = Time.valueOf("7:45:20");
		for (int i = 0; i < hours.length; i++) {
			for (int j = 0; j < hours[i].length; j++) {
				if (j == 0) {
					hours[i][j] = time1;
				}
				else {
					hours[i][j] = time2;
				}
			}
		}
		int estDuration = 2;
		String menuLink = "menuLink";
		int price = 2;
		String cuisine = "cuisine";
		String options = "options";
	
		restaurant = restaurantService.createRestaurant(name, address, hours, restaurantOwner, estDuration, menuLink, price, cuisine, options);
		restaurant.setId(55);
		repo.save(restaurant);
	
		
	}

	@Given("they are on their modify restaurant owner account page")
	public void they_are_on_their_modify_restaurant_owner_account_page() {
		
	}

	@When("the restaurant owner inputs their password into the delete account field")
	public void the_restaurant_owner_inputs_their_password_into_the_delete_account_field() {
		password = restaurantOwner.getPassword();
	}

	@When("the restaurant owner selects to delete their account")
	public void the_restaurant_owner_selects_to_delete_their_account() {
		
	}

	@When("the restaurant owner inputs an incorrect password into the delete account field")
	public void the_restaurant_owner_inputs_an_incorrect_password_into_the_delete_account_field() {
		
		try {
			RORService.deleteOwnRestaurantOwnerAccount(restaurantOwner, "!password");
		} catch (IllegalArgumentException e) {
			deleteException = e.getLocalizedMessage();
		}
	}

	@Then("the restaurant owner's account will not be deleted")
	public void the_restaurant_owner_s_account_will_not_be_deleted() {
		
		boolean exists = false;
		RestaurantOwner ro = ROLService.getRestaurantOwnerByEmail(email);
		if(ro !=null)
			exists = true;
		
		assertEquals(true, exists);
		assertEquals("Incorrect password", deleteException);
		
		
	}

	@Then("the restaurant owner's restaurants will not  be deleted")
	public void the_restaurant_owner_s_restaurants_will_not_be_deleted() {
		
		Restaurant resto = restaurantService.getRestaurantById(55);
		
		assertEquals(resto.getName(), restaurant.getName());
		
	}

	@Then("the restaurant owner will still be able to log in to the restaurant booking system")
	public void the_restaurant_owner_will_still_be_able_to_log_in_to_the_restaurant_booking_system() {
		
		loggedIn = false;
		try {
			loggedIn = ROLService.loginRestaurantOwner(restaurantOwner, password);
		} catch (IllegalArgumentException e) {
			loggedIn = false;
		}
		assertEquals(true, loggedIn);
		
		
	}

}
