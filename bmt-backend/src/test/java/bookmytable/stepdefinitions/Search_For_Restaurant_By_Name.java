package bookmytable.stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.sql.Time;
import java.util.ArrayList;
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

public class Search_For_Restaurant_By_Name {
	
	
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
	Restaurant McDonalds;
	Restaurant Dominos;
	Restaurant Mikes;
	Restaurant My_Pizza;
	Restaurant Wendys;
	Restaurant Donalds_Pizza;
	List<Restaurant> rest;
	Boolean exception;

	@Given("Restaurant McDonalds exists")
	public void restaurant_mc_donalds_exists() {
		// Write code here that turns the phrase above into concrete actions
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
		String testName1 = "McDonalds";
		String testAddress1 = "973484g6655986111" + getSaltString();

		McDonalds = restaurantService.createRestaurant(testName1, testAddress1, hours, owner1, estDuration, menuLink,
				price, cuisine, options);
	
		restaurantRepository.save(McDonalds);
	}

	@When("Customer <customer_name> searches for the name McDonalds")
	public void customer_customer_name_searches_for_the_name_mc_donalds() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("the restaurant info for Restaurant McDonalds will be displayed")
	public void the_restaurant_info_for_restaurant_mc_donalds_will_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		//List<Restaurant> restaurants = toList(restaurantRepository.findAll());
		boolean found = false;
		for(Restaurant r: restaurantRepository.findAll()) {
			if(r.getFood().getPrice() == 2 && r.getFood().getOptions() == "vegan" && r.getFood().getCuisine() == "asian") {
				found = true;
				assertTrue(found);

			}
		}
	}

	@Given("Restaurant Dominos exists")
	public void restaurant_dominos_exists() {
		// Write code here that turns the phrase above into concrete actions
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
		String cuisine = "a";
		String options = "vegan";
		String testName1 = "Dominos";
		String testAddress1 = "973484g6655986111" + getSaltString();

		Dominos = restaurantService.createRestaurant(testName1, testAddress1, hours, owner1, estDuration, menuLink,
				price, cuisine, options);
	
		restaurantRepository.save(Dominos);	}

	@When("Customer <customer_name> searches for the name Dominos")
	public void customer_customer_name_searches_for_the_name_dominos() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("the restaurant info for Restaurant Dominos will be displayed")
	public void the_restaurant_info_for_restaurant_dominos_will_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		boolean found = false;
		for(Restaurant r: restaurantRepository.findAll()) {
			if(r.getFood().getPrice() == 2 && r.getFood().getOptions() == "vegan" && r.getFood().getCuisine() == "a") {
				found = true;
				assertTrue(found);

			}
		}
		}

	@Given("Restaurant Donalds pizza exists")
	public void restaurant_donalds_pizza_exists() {
		// Write code here that turns the phrase above into concrete actions
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
		String cuisine = "b";
		String options = "vegan";
		String testName1 = "Donalds pizza";
		String testAddress1 = "973484g6655986111" + getSaltString();

		Donalds_Pizza = restaurantService.createRestaurant(testName1, testAddress1, hours, owner1, estDuration, menuLink,
				price, cuisine, options);
	
		restaurantRepository.save(Donalds_Pizza);	}

	@When("Customer <customer_name> searches for the name Donalds pizza")
	public void customer_customer_name_searches_for_the_name_donalds_pizza() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("the restaurant info for Restaurant Donalds pizza will be displayed")
	public void the_restaurant_info_for_restaurant_donalds_pizza_will_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		boolean found = false;
		for(Restaurant r: restaurantRepository.findAll()) {
			if(r.getFood().getPrice() == 2 && r.getFood().getOptions() == "vegan" && r.getFood().getCuisine() == "b") {
				found = true;
				assertTrue(found);

			}
		}	}

	@Given("Restaurant Mikes exists")
	public void restaurant_mikes_exists() {
		// Write code here that turns the phrase above into concrete actions
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
		String cuisine = "c";
		String options = "vegan";
		String testName1 = "Mikes";
		String testAddress1 = "973484g6655986111" + getSaltString();

		Mikes = restaurantService.createRestaurant(testName1, testAddress1, hours, owner1, estDuration, menuLink,
				price, cuisine, options);
	
		restaurantRepository.save(Mikes);	
	}

	@When("Customer <customer_name> searches for the name Mikes")
	public void customer_customer_name_searches_for_the_name_mikes() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("the restaurant info for Restaurant Mikes will be displayed")
	public void the_restaurant_info_for_restaurant_mikes_will_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		boolean found = false;
		for(Restaurant r: restaurantRepository.findAll()) {
			if(r.getFood().getPrice() == 2 && r.getFood().getOptions() == "vegan" && r.getFood().getCuisine() == "c") {
				found = true;
				assertTrue(found);

			}
		}	
	}

	@Given("Restaurant My pizza place exists")
	public void restaurant_my_pizza_place_exists() {
		// Write code here that turns the phrase above into concrete actions
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
		String cuisine = "d";
		String options = "vegan";
		String testName1 = "My Pizza";
		String testAddress1 = "973484g6655986111" + getSaltString();

		My_Pizza = restaurantService.createRestaurant(testName1, testAddress1, hours, owner1, estDuration, menuLink,
				price, cuisine, options);
	
		restaurantRepository.save(My_Pizza);		}

	@When("Customer <customer_name> searches for the name My pizza place")
	public void customer_customer_name_searches_for_the_name_my_pizza_place() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("the restaurant info for Restaurant My pizza place will be displayed")
	public void the_restaurant_info_for_restaurant_my_pizza_place_will_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		boolean found = false;
		for(Restaurant r: restaurantRepository.findAll()) {
			if(r.getFood().getPrice() == 2 && r.getFood().getOptions() == "vegan" && r.getFood().getCuisine() == "d") {
				found = true;
				assertTrue(found);

			}
		}		}

	@Given("Restaurant Wendys exists")
	public void restaurant_wendys_exists() {
		// Write code here that turns the phrase above into concrete actions
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
		String cuisine = "e";
		String options = "vegan";
		String testName1 = "Wendys";
		String testAddress1 = "973484g6655986111" + getSaltString();

		Wendys = restaurantService.createRestaurant(testName1, testAddress1, hours, owner1, estDuration, menuLink,
				price, cuisine, options);
	
		restaurantRepository.save(Wendys);		}

	@When("Customer <customer_name> searches for the name Wendys")
	public void customer_customer_name_searches_for_the_name_wendys() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("the restaurant info for Restaurant Wendys will be displayed")
	public void the_restaurant_info_for_restaurant_wendys_will_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		boolean found = false;
		for(Restaurant r: restaurantRepository.findAll()) {
			if(r.getFood().getPrice() == 2 && r.getFood().getOptions() == "vegan" && r.getFood().getCuisine() == "e") {
				found = true;
				assertTrue(found);

			}
		}		}

	@When("Customer <customer_name> searches for the name Donald")
	public void customer_customer_name_searches_for_the_name_donald() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("the restaurant info for all Restaurants containing fragment Donald will be displayed")
	public void the_restaurant_info_for_all_restaurants_containing_fragment_donald_will_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		boolean found = false;
		for(Restaurant r: restaurantRepository.findAll()) {
			for(int i=0; i<r.getName().length(); i++) {
			if(r.getName().charAt(i) == 'D' && r.getName().charAt(i++) == 'o') {
				found = true;
				assertTrue(found);
				break;
			}
			}
		}			}

	@When("Customer <customer_name> searches for the name pizza")
	public void customer_customer_name_searches_for_the_name_pizza() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("the restaurant info for all Restaurants containing fragment pizza will be displayed")
	public void the_restaurant_info_for_all_restaurants_containing_fragment_pizza_will_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		boolean found = false;
		for(Restaurant r: restaurantRepository.findAll()) {
			for(int i=0; i<r.getName().length(); i++) {
			if(r.getName().charAt(i) == 'P' && r.getName().charAt(i++) == 'i') {
				found = true;
				assertTrue(found);
				break;
			}
			}
		}		}

	@When("Customer <customer_name> searches for the name Wen")
	public void customer_customer_name_searches_for_the_name_wen() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("the restaurant info for all Restaurants containing fragment Wen will be displayed")
	public void the_restaurant_info_for_all_restaurants_containing_fragment_wen_will_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		boolean found = false;
		for(Restaurant r: restaurantRepository.findAll()) {
			for(int i=0; i<r.getName().length(); i++) {
			if(r.getName().charAt(i) == 'W' && r.getName().charAt(i++) == 'e') {
				found = true;
				assertTrue(found);
				break;
			}
			}
		}		}

	@When("Customer <customer_name> searches for the name My")
	public void customer_customer_name_searches_for_the_name_my() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("the restaurant info for all Restaurants containing fragment My will be displayed")
	public void the_restaurant_info_for_all_restaurants_containing_fragment_my_will_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		boolean found = false;
		for(Restaurant r: restaurantRepository.findAll()) {
			for(int i=0; i<r.getName().length(); i++) {
			if(r.getName().charAt(i) == 'M' && r.getName().charAt(i++) == 'y') {
				found = true;
				assertTrue(found);
				break;
			}
			}
		}	
	}

	@When("Customer <customer_name> searches for the name <false_restaurant_name>")
	public void customer_customer_name_searches_for_the_name_false_restaurant_name() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("no corresponding restaurants will be found")
	public void no_corresponding_restaurants_will_be_found() {
		// Write code here that turns the phrase above into concrete actions
		boolean notFound = false;
		for(Restaurant r: restaurantRepository.findAll()) {
			for(int i=0; i<r.getName().length(); i++) {
			if(r.getName().charAt(i) != 't' && r.getName().charAt(i++) != 'i') {
				notFound = true;
				assertTrue(notFound);
				break;
			}
			}
		}	
	}

	@Then("the Customer will be notified that no such restaurant exists")
	public void the_customer_will_be_notified_that_no_such_restaurant_exists() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Given("Customer <customer_name> has not entered the name of a restaurant")
	public void customer_customer_name_has_not_entered_the_name_of_a_restaurant() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("Customer <customer_name> searches for a restaurant by name")
	public void customer_customer_name_searches_for_a_restaurant_by_name() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("no no restaurants will be returned")
	public void no_no_restaurants_will_be_returned() {
		// Write code here that turns the phrase above into concrete actions
		boolean found = false;
		for(Restaurant r: restaurantRepository.findAll()) {
			for(int i=0; i<r.getName().length(); i++) {
			if(r.getName().charAt(i) == ' ' && r.getName().charAt(i++) == ' ') {
				found = true;
				assertTrue(found);
				break;
			}
			}
		}		}

	@Then("the Customer will be prompted to enter a name")
	public void the_customer_will_be_prompted_to_enter_a_name() {
		// Write code here that turns the phrase above into concrete actions
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
	
	 private <T> List<T> toList(Iterable<T> iterable) {
		    List<T> resultList = new ArrayList<T>();
		    for (T t : iterable) {
		      resultList.add(t);
		    }
		    return resultList;
		  }

}
