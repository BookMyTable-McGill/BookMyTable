package bookmytable.stepdefinitions.sprint3;

import static org.junit.Assert.assertTrue;
import java.sql.Time;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import bookmytable.dao.CustomerRepository;
import bookmytable.dao.RestaurantRepository;
import bookmytable.model.Customer;
import bookmytable.model.Restaurant;
import bookmytable.model.RestaurantOwner;
import bookmytable.service.CustomerLoginService;
import bookmytable.service.CustomerRegistrationService;
import bookmytable.service.FavoriteRestaurantService;
import bookmytable.service.RestaurantOwnerRegistrationService;
import bookmytable.service.RestaurantService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Mark_Restaurant_As_Favorite {
  
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    CustomerRegistrationService customerRegistrationService;
    @Autowired
    CustomerLoginService customerLoginService;
    @Autowired
    RestaurantService restaurantService;
    @Autowired
    RestaurantOwnerRegistrationService restaurantOwnerRegistrationService;
    @Autowired
    FavoriteRestaurantService favoriteRestaurantService;
    
    private Customer customer;
    private Restaurant restaurant;
    private RestaurantOwner restaurantOwner;

	@Given("a Customer is logged in to BookMyTable as a Customer")
	public void a_customer_is_logged_in_to_book_my_table_as_a_customer() {
		String name = "Customer1";
		String email = "customer1@gmail.com";
		String password = "password";
		String phoneNumber = "514-111-2222";
		if (customerRepository.findCustomerByEmail(email) == null) {
          customer = customerRegistrationService.createCustomer(name, email, password, phoneNumber);
		}else {
			customer = customerRepository.findCustomerByEmail(email);
		}
		assertTrue(customerLoginService.loginCustomer(customer, customer.getEmail(), customer.getPassword()));
	}

	@When("the Customer marks a Restaurant as Favorite")
	public void the_customer_marks_a_restaurant_as_favorite() {
	  String ownerName = "Owner Name";
	  String email = "restoOwner@gmail.com";
	  String password = "password";
	  restaurantOwner = restaurantOwnerRegistrationService.getRestaurantOwnerByEmail(email);
	  if (restaurantOwner == null) {
	      restaurantOwner = restaurantOwnerRegistrationService.registerRestaurantOwner(ownerName, password, email); 
	  }
	  
	  String name = "TestoResto"+getSaltString();
	  String address = "123 Test Lane"+getSaltString();
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
      int estDuration = 1;
      String menuLink = "somerandommenulink";
      int price = 3;
      String cuisine = "Italian";
      String options = "None";
      
	  restaurant = restaurantService.createRestaurant(name, address, hours, restaurantOwner, estDuration, menuLink, price, cuisine, options);
	  favoriteRestaurantService.addRestaurantToFavorites(customer.getEmail(), restaurant.getId());
	}

	@Then("the restaurant shall be added to that customer's favorite list of Favorite Restaurants")
	public void the_restaurant_shall_be_added_to_that_customer_s_favorite_list_of_favorite_restaurants() {
	    assertTrue(favoriteRestaurantService.viewFavoriteRestaurants(customer.getEmail()).size() > 0);
	    favoriteRestaurantService.removeRestaurantFromFavorites(customer.getEmail(), restaurant.getId());
	}

	@Then("a message indicating that the restaurant has been added to that customer's list of Favorite Restaurants will appear")
	public void a_message_indicating_that_the_restaurant_has_been_added_to_that_customer_s_list_of_favorite_restaurants_will_appear() {

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
