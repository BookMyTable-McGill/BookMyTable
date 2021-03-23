package bookmytable.stepdefinitions;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

public class View_Restaurants_With_Least_Reservations {
	
	Restaurant restaurant1;
	Restaurant restaurant2;
	Restaurant restaurant3;
	Restaurant restaurant4;
	Restaurant restaurant5;
	Restaurant restaurant6;
	Restaurant restaurant7;
	Restaurant restaurant8;
	Restaurant restaurant9;
	Restaurant restaurant10;

	Customer customer;
		
	@Autowired
	RestaurantService restaurantService = new RestaurantService();
	
	@Autowired
	CustomerRegistrationService customerRegistrationService = new CustomerRegistrationService();
	
	@Autowired
	RestaurantOwnerRegistrationService restaurantOwnerRegistrationService = new RestaurantOwnerRegistrationService();

	@Autowired
	ReservationService reservationService = new ReservationService();
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	

	@Given("Customer {string} exists")
	public void customer_exists(String string) {

	}

	@Given("Customer {string} has email {string}, password {string}")
	public void customer_has_email_password(String string, String string2, String string3) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder word = new StringBuilder();
        Random rnd = new Random();
        while (word.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            word.append(chars.charAt(index));
        }
        String randomw = word.toString();
        
		if (customer != null) {
			customerRegistrationService.deleteCustomer(customer.getId());
		}
		customer = customerRegistrationService.createCustomer(string, randomw + "@mail.com", "123456", "111-111-1111");
	}

	@Given("Customer {string} is logged in")
	public void customer_is_logged_in(String string) {

	}

	@Given("there is at least {int} Restaurant in the system")
	public void there_is_at_least_restaurant_in_the_system(Integer int1) {
		for (Restaurant restaurant : restaurantService.getAllRestaurants()) {
			restaurantRepository.delete(restaurant);
		}
		
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

	@When("Customer {string} queries to view Restaurants with least Reservations")
	public void customer_queries_to_view_restaurants_with_least_reservations(String string) {

	}

	@When("there are at least {int} Restaurants in the System")
	public void there_are_at_least_restaurants_in_the_system(Integer int1) {

	}

	@Then("a list of the first {int} Restaurants with the least Reservations <{string}> is returned in ascending order:")
	public void a_list_of_the_first_restaurants_with_the_least_reservations_is_returned_in_ascending_order(Integer int1,
			String string, io.cucumber.datatable.DataTable dataTable) {
		List<Restaurant> restaurantsWithLeastReservations = restaurantService.getRestaurantsWithLeastReservations();
		assertEquals(10, restaurantsWithLeastReservations.size());
		assertEquals(1, restaurantsWithLeastReservations.get(0).getReservations().size());
		assertEquals(2, restaurantsWithLeastReservations.get(1).getReservations().size());
		assertEquals(3, restaurantsWithLeastReservations.get(2).getReservations().size());
		assertEquals(4, restaurantsWithLeastReservations.get(3).getReservations().size());
		assertEquals(5, restaurantsWithLeastReservations.get(4).getReservations().size());
		assertEquals(6, restaurantsWithLeastReservations.get(5).getReservations().size());
		assertEquals(7, restaurantsWithLeastReservations.get(6).getReservations().size());
		assertEquals(8, restaurantsWithLeastReservations.get(7).getReservations().size());
		assertEquals(9, restaurantsWithLeastReservations.get(8).getReservations().size());
		assertEquals(10, restaurantsWithLeastReservations.get(9).getReservations().size());
	}

	@When("there are less than {int} Restaurants in the system")
	public void there_are_less_than_restaurants_in_the_system(Integer int1) {
		for (Restaurant restaurant : restaurantService.getAllRestaurants()) {
			restaurantRepository.delete(restaurant);
		}
		
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
		
	}

	@Then("a list of all of the Restaurants <{string}> in the system is returned in ascending order based on Reservations:")
	public void a_list_of_all_of_the_restaurants_in_the_system_is_returned_in_ascending_order_based_on_reservations(
			String string, io.cucumber.datatable.DataTable dataTable) {
		List<Restaurant> restaurantsWithLeastReservations = restaurantService.getRestaurantsWithLeastReservations();
		assertEquals(8, restaurantsWithLeastReservations.size());
		assertEquals(3, restaurantsWithLeastReservations.get(0).getReservations().size());
		assertEquals(4, restaurantsWithLeastReservations.get(1).getReservations().size());
		assertEquals(5, restaurantsWithLeastReservations.get(2).getReservations().size());
		assertEquals(6, restaurantsWithLeastReservations.get(3).getReservations().size());
		assertEquals(7, restaurantsWithLeastReservations.get(4).getReservations().size());
		assertEquals(8, restaurantsWithLeastReservations.get(5).getReservations().size());
		assertEquals(9, restaurantsWithLeastReservations.get(6).getReservations().size());
		assertEquals(10, restaurantsWithLeastReservations.get(7).getReservations().size());
	}

}
