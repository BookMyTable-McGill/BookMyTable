package bookmytable.stepdefinitions;


import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Random;
import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;

import bookmytable.dao.RestaurantRepository;
import bookmytable.model.Customer;
import bookmytable.model.Restaurant;
import bookmytable.model.RestaurantTable;
import bookmytable.service.CustomerRegistrationService;
import bookmytable.service.ReservationService;
import bookmytable.service.RestaurantOwnerRegistrationService;
import bookmytable.service.RestaurantService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class View_Featured_Restaurants {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private CustomerRegistrationService customerRegistrationService;
	
	@Autowired
	private RestaurantOwnerRegistrationService restaurantOwnerRegistrationService;

	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	private Customer customer;
	
	private Restaurant restaurant1;
	private Restaurant restaurant2;
	private Restaurant restaurant3;
	private Restaurant restaurant4;
	private Restaurant restaurant5;
	private Restaurant restaurant6;
	private Restaurant restaurant7;
	private Restaurant restaurant8;
	private Restaurant restaurant9;
	private Restaurant restaurant10;
	
	

	@Given("a Customer {string} exists")
	public void customer_exists(String string) {
	
	}

	@Given("a Customer {string} has email {string}, password {string}")
	public void customer_has_email_password(String string, String string2, String string3) {
		
		if (customer != null) {
			customerRegistrationService.deleteCustomer(customer.getId());
		}
		customer = customerRegistrationService.createCustomer(string, string2+"@mailxyz.com", string3, "222-222-222");
	}

	@Given("a Customer {string} is logged in")
	public void customer_is_logged_in(String string) {
		
	}

	@Given("there is at least {int} Restaurant in system")
	public void there_is_at_least_restaurant_in_the_system(Integer int1) {
		
		restaurantRepository.deleteAll();
		
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
		
	
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder word = new StringBuilder();
        Random rnd = new Random();
        while (word.length() < 13) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            word.append(chars.charAt(index));
        }
        String randomw = word.toString();
		
		restaurant1 = restaurantService.createRestaurant("restaurant1"+randomw, "restaurant1Adress"
				, hours, restaurantOwnerRegistrationService.registerRestaurantOwner("ownerName", "123456", randomw + "@mail.com"), 
				1, "link", 1, "cuisine", "options");
		RestaurantTable table1 = restaurantService.addTableToMap(4, 1, 1, 1, restaurant1);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-05"), 1, table1, customer, restaurant1);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-06"), 1, table1, customer, restaurant1);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-07"), 1, table1, customer, restaurant1);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-08"), 1, table1, customer, restaurant1);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-09"), 1, table1, customer, restaurant1);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-11"), 1, table1, customer, restaurant1);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-12"), 1, table1, customer, restaurant1);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-13"), 1, table1, customer, restaurant1);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-14"), 1, table1, customer, restaurant1);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-15"), 1, table1, customer, restaurant1);

        word = new StringBuilder();
        rnd = new Random();
        while (word.length() < 13) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            word.append(chars.charAt(index));
        }
        randomw = word.toString();
		
		restaurant2 = restaurantService.createRestaurant("restaurant2"+randomw, "restaurant2Adress"
				, hours, restaurantOwnerRegistrationService.registerRestaurantOwner("ownerName", "123456", randomw + "@mail.com"), 
				1, "link", 1, "cuisine", "options");
		RestaurantTable table2 = restaurantService.addTableToMap(4, 1, 1, 1, restaurant2);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-05"), 1, table1, customer, restaurant2);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-06"), 1, table1, customer, restaurant2);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-07"), 1, table1, customer, restaurant2);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-08"), 1, table1, customer, restaurant2);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-09"), 1, table1, customer, restaurant2);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-11"), 1, table1, customer, restaurant2);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-12"), 1, table1, customer, restaurant2);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-13"), 1, table1, customer, restaurant2);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-14"), 1, table1, customer, restaurant2);
 		
        word = new StringBuilder();
        rnd = new Random();
        while (word.length() < 13) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            word.append(chars.charAt(index));
        }
        randomw = word.toString();
        
		restaurant3 = restaurantService.createRestaurant("restaurant3"+randomw, "restaurant3Adress"
				, hours, restaurantOwnerRegistrationService.registerRestaurantOwner("ownerName", "123456", randomw + "@mail.com"), 
				1, "link", 1, "cuisine", "options");
		RestaurantTable table3 = restaurantService.addTableToMap(4, 1, 1, 1, restaurant1);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-05"), 1, table1, customer, restaurant3);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-06"), 1, table1, customer, restaurant3);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-07"), 1, table1, customer, restaurant3);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-08"), 1, table1, customer, restaurant3);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-09"), 1, table1, customer, restaurant3);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-11"), 1, table1, customer, restaurant3);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-12"), 1, table1, customer, restaurant3);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-13"), 1, table1, customer, restaurant3);
		
        word = new StringBuilder();
        rnd = new Random();
        while (word.length() < 13) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            word.append(chars.charAt(index));
        }
        randomw = word.toString();
        
		restaurant4 = restaurantService.createRestaurant("restaurant4"+randomw, "restaurant4Adress"
				, hours, restaurantOwnerRegistrationService.registerRestaurantOwner("ownerName", "123456", randomw + "@mail.com"), 
				1, "link", 1, "cuisine", "options");
		RestaurantTable table4 = restaurantService.addTableToMap(4, 1, 1, 1, restaurant4);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-05"), 1, table1, customer, restaurant4);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-06"), 1, table1, customer, restaurant4);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-07"), 1, table1, customer, restaurant4);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-08"), 1, table1, customer, restaurant4);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-09"), 1, table1, customer, restaurant4);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-11"), 1, table1, customer, restaurant4);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-12"), 1, table1, customer, restaurant4);
		
        word = new StringBuilder();
        rnd = new Random();
        while (word.length() < 13) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            word.append(chars.charAt(index));
        }
        randomw = word.toString();
        
		restaurant5 = restaurantService.createRestaurant("restaurant5"+randomw, "restaurant5Adress"
				, hours, restaurantOwnerRegistrationService.registerRestaurantOwner("ownerName", "123456", randomw + "@mail.com"), 
				1, "link", 1, "cuisine", "options");
		RestaurantTable table5 = restaurantService.addTableToMap(4, 1, 1, 1, restaurant5);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-05"), 1, table1, customer, restaurant5);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-06"), 1, table1, customer, restaurant5);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-07"), 1, table1, customer, restaurant5);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-08"), 1, table1, customer, restaurant5);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-11"), 1, table1, customer, restaurant5);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-12"), 1, table1, customer, restaurant5);
		
        word = new StringBuilder();
        rnd = new Random();
        while (word.length() < 13) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            word.append(chars.charAt(index));
        }
        randomw = word.toString();
        
		
		restaurant6 = restaurantService.createRestaurant("restaurant6"+randomw, "restaurant6Adress"
				, hours, restaurantOwnerRegistrationService.registerRestaurantOwner("ownerName", "123456", randomw + "@mail.com"), 
				1, "link", 1, "cuisine", "options");
		RestaurantTable table6 = restaurantService.addTableToMap(4, 1, 1, 1, restaurant6);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-05"), 1, table1, customer, restaurant6);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-06"), 1, table1, customer, restaurant6);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-07"), 1, table1, customer, restaurant6);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-08"), 1, table1, customer, restaurant6);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-11"), 1, table1, customer, restaurant6);
		
        word = new StringBuilder();
        rnd = new Random();
        while (word.length() < 13) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            word.append(chars.charAt(index));
        }
        randomw = word.toString();
        
		
		restaurant7 = restaurantService.createRestaurant("restaurant7"+randomw, "restaurant7Adress"
				, hours, restaurantOwnerRegistrationService.registerRestaurantOwner("ownerName", "123456", randomw + "@mail.com"), 
				1, "link", 1, "cuisine", "options");
		RestaurantTable table7 = restaurantService.addTableToMap(4, 1, 1, 1, restaurant7);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-05"), 1, table1, customer, restaurant7);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-06"), 1, table1, customer, restaurant7);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-07"), 1, table1, customer, restaurant7);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-08"), 1, table1, customer, restaurant7);
		
        word = new StringBuilder();
        rnd = new Random();
        while (word.length() < 13) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            word.append(chars.charAt(index));
        }
        randomw = word.toString();
        
		
		restaurant8 = restaurantService.createRestaurant("restaurant8"+randomw, "restaurant8Adress"
				, hours, restaurantOwnerRegistrationService.registerRestaurantOwner("ownerName", "123456", randomw + "@mail.com"), 
				1, "link", 1, "cuisine", "options");
		RestaurantTable table8 = restaurantService.addTableToMap(4, 1, 1, 1, restaurant8);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-05"), 1, table1, customer, restaurant8);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-06"), 1, table1, customer, restaurant8);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-08"), 1, table1, customer, restaurant8);
		
        word = new StringBuilder();
        rnd = new Random();
        while (word.length() < 13) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            word.append(chars.charAt(index));
        }
        randomw = word.toString();
        
		
		restaurant9 = restaurantService.createRestaurant("restaurant9"+randomw, "restaurant9Adress"
				, hours, restaurantOwnerRegistrationService.registerRestaurantOwner("ownerName", "123456", randomw + "@mail.com"), 
				1, "link", 1, "cuisine", "options");
		RestaurantTable table9 = restaurantService.addTableToMap(4, 1, 1, 1, restaurant9);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-05"), 1, table9, customer, restaurant9);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-06"), 1, table9, customer, restaurant9);
		
        word = new StringBuilder();
        rnd = new Random();
        while (word.length() < 13) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            word.append(chars.charAt(index));
        }
        randomw = word.toString();
        
		
		restaurant10 = restaurantService.createRestaurant("restaurant10"+randomw, "restaurant10Adress"
				, hours, restaurantOwnerRegistrationService.registerRestaurantOwner("ownerName", "123456", randomw + "@mail.com"), 
				1, "link", 1, "cuisine", "options");
		RestaurantTable table10 = restaurantService.addTableToMap(4, 1, 1, 1, restaurant10);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-05"), 1, table10, customer, restaurant10);
	}

	@When("Customer {string} queries to view Restaurants with most Reservations")
	public void customer_queries_to_view_restaurants_with_most_reservations(String string) {
		
	}

	@When("there are at least {int} Restaurants in System")
	public void there_are_at_least_restaurants_in_the_system(Integer int1) {
		
		List<Restaurant> restaurants = restaurantService.getAllRestaurants();
		boolean numRest = false;
		if(restaurants.size() >= 10)
			numRest = true;
		assertEquals(true, numRest);
	}

	@Then("a list of the first {int} Restaurants with the most Reservations <{string}> is returned in descending order:")
	public void a_list_of_the_first_restaurants_with_the_most_reservations_is_returned_in_descending_order(Integer int1,
			String string, io.cucumber.datatable.DataTable dataTable) {
		List<Restaurant> featuredRestaurants = restaurantService.getFeaturedRestaurants();
		assertEquals(10, featuredRestaurants.get(0).getReservations().size());
		assertEquals(9, featuredRestaurants.get(1).getReservations().size());
		assertEquals(8, featuredRestaurants.get(2).getReservations().size());
		assertEquals(7, featuredRestaurants.get(3).getReservations().size());
		assertEquals(6, featuredRestaurants.get(4).getReservations().size());
		assertEquals(5, featuredRestaurants.get(5).getReservations().size());
		assertEquals(4, featuredRestaurants.get(6).getReservations().size());
		assertEquals(3, featuredRestaurants.get(7).getReservations().size());
		assertEquals(2, featuredRestaurants.get(8).getReservations().size());
		assertEquals(1, featuredRestaurants.get(9).getReservations().size());
	}

	@When("there are less than {int} Restaurants in system")
	public void there_are_less_than_restaurants_in_the_system(Integer int1) {
	
		restaurantRepository.deleteAll();
		
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
		
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder word = new StringBuilder();
        Random rnd = new Random();
        while (word.length() < 13) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            word.append(chars.charAt(index));
        }
        String randomw = word.toString();
        
        
		restaurant1 = restaurantService.createRestaurant("restaurant1"+randomw, "restaurant1Adress"
				, hours, restaurantOwnerRegistrationService.registerRestaurantOwner("ownerName", "123456", randomw + "@mail.com"), 
				1, "link", 1, "cuisine", "options");
		RestaurantTable table1 = restaurantService.addTableToMap(4, 1, 1, 1, restaurant1);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-05"), 1, table1, customer, restaurant1);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-06"), 1, table1, customer, restaurant1);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-07"), 1, table1, customer, restaurant1);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-08"), 1, table1, customer, restaurant1);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-09"), 1, table1, customer, restaurant1);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-11"), 1, table1, customer, restaurant1);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-12"), 1, table1, customer, restaurant1);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-13"), 1, table1, customer, restaurant1);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-14"), 1, table1, customer, restaurant1);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-15"), 1, table1, customer, restaurant1);

        word = new StringBuilder();
        rnd = new Random();
        while (word.length() < 13) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            word.append(chars.charAt(index));
        }
        randomw = word.toString();
        
		
		
		restaurant2 = restaurantService.createRestaurant("restaurant2"+randomw, "restaurant2Adress"
				, hours, restaurantOwnerRegistrationService.registerRestaurantOwner("ownerName", "123456", randomw + "@mail.com"), 
				1, "link", 1, "cuisine", "options");
		RestaurantTable table2 = restaurantService.addTableToMap(4, 1, 1, 1, restaurant2);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-05"), 1, table1, customer, restaurant2);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-06"), 1, table1, customer, restaurant2);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-07"), 1, table1, customer, restaurant2);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-08"), 1, table1, customer, restaurant2);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-09"), 1, table1, customer, restaurant2);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-11"), 1, table1, customer, restaurant2);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-12"), 1, table1, customer, restaurant2);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-13"), 1, table1, customer, restaurant2);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-14"), 1, table1, customer, restaurant2);
 		
        word = new StringBuilder();
        rnd = new Random();
        while (word.length() < 13) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            word.append(chars.charAt(index));
        }
        randomw = word.toString();
        
		
		restaurant3 = restaurantService.createRestaurant("restaurant3"+randomw, "restaurant3Adress"
				, hours, restaurantOwnerRegistrationService.registerRestaurantOwner("ownerName", "123456", randomw + "@mail.com"), 
				1, "link", 1, "cuisine", "options");
		RestaurantTable table3 = restaurantService.addTableToMap(4, 1, 1, 1, restaurant1);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-05"), 1, table1, customer, restaurant3);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-06"), 1, table1, customer, restaurant3);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-07"), 1, table1, customer, restaurant3);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-08"), 1, table1, customer, restaurant3);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-09"), 1, table1, customer, restaurant3);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-11"), 1, table1, customer, restaurant3);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-12"), 1, table1, customer, restaurant3);
		reservationService.makeReservation(Time.valueOf("6:45:20"), Date.valueOf("2021-05-13"), 1, table1, customer, restaurant3);
	}

	@Then("a list of all of the Restaurants <{string}> in system is returned in descending order based on Reservations:")
	public void a_list_of_all_of_the_restaurants_in_the_system_is_returned_in_descending_order_based_on_reservations(
			String string, io.cucumber.datatable.DataTable dataTable) {
		List<Restaurant> featuredRestaurants = restaurantService.getFeaturedRestaurants();
		assertEquals(10, featuredRestaurants.get(0).getReservations().size());
		assertEquals(9, featuredRestaurants.get(1).getReservations().size());
		assertEquals(8, featuredRestaurants.get(2).getReservations().size());
	}

}
