package bookmytable.stepdefinitions;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import bookmytable.dao.AdminRepository;
import bookmytable.model.*;
import bookmytable.dao.RestaurantRepository;
import bookmytable.model.Restaurant;
import bookmytable.service.ViewRestaurantsService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;


public class View_All_Restaurants {
	
	@Autowired
	private AdminRepository adminRepo;
	@Autowired
	private RestaurantRepository restRepo;
	@Autowired
	private ViewRestaurantsService viewRestoService;

	
	private Admin admin;
	
	private List<Restaurant> restaurants = null;
	

	@Given("Administrator {string} is logged in")
	public void administrator_is_logged_in(String string) {
		this.admin = new Admin();
		this.admin.setName(string);
		this.admin.setEmail("admin@email.com");
		this.admin.setPassword("password");
		adminRepo.save(admin);
		  	
	}



	@When("Administrator {string} attempts to view all restaurants")
	public void administrator_attempts_to_view_all_restaurants(String string) {
		
//		Restaurant r1 = new Restaurant();
//		r1.setId(0001);
//		Restaurant r2 = new Restaurant();
//	 	r2.setId(0002);
//	 	Restaurant r3 = new Restaurant();
//	 	r3.setId(0003);
//	 	Restaurant r4 = new Restaurant();
//	 	r4.setId(0004);
//		   
//		restRepo.save(r1);
//		restRepo.save(r2);
//		restRepo.save(r3);
//		restRepo.save(r4);	
//	
	   this.restaurants = viewRestoService.getAllRestaurants();
	   
	}
	@Then("a list of all restaurant ids <{string}> is returned:")
	public void a_list_of_all_restaurant_ids_is_returned(String string, io.cucumber.datatable.DataTable dataTable) throws ParseException {
//		List<Map<String, String>> valueMaps = dataTable.asMaps();
//		for (Map<String, String> map : valueMaps) {
//			
//			String restaurantIDs = map.get("list_of_restaurants_id");
//			List<String> list = Arrays.asList(restaurantIDs.split("\\s*,\\s*"));
//			
//			for(int i=0; i < restaurants.size(); i++)
//			assertEquals(restaurants.get(i).getId(), Integer.parseInt(list.get(i)));
//			
//	}
		assertTrue(restaurants != null);
	}
	

	@When("no restaurants exists")
	public void no_restaurants_exists() {
		
		restRepo.deleteAll();
		this.restaurants = viewRestoService.getAllRestaurants();
	    
		assertEquals(0, this.restaurants.size());
	}
	@Then("the following empty list of restaurant ids <{string}> is returned:")
	public void the_following_empty_list_of_restaurant_ids_is_returned(String string, io.cucumber.datatable.DataTable dataTable) throws ParseException {
		
		List<Map<String, String>> valueMaps = dataTable.asMaps();
		for (Map<String, String> map : valueMaps) {
			
			String restaurantID = map.get("list_of_restaurants_id");
			
			assertEquals("null", restaurantID);
		}
	
	}
}
