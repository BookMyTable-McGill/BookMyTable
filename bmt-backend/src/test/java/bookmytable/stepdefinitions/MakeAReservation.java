package bookmytable.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.Date;
import java.sql.Time;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import bookmytable.dao.CustomerRepository;
import bookmytable.dao.ReservationRepository;
import bookmytable.dao.RestaurantOwnerRepository;
import bookmytable.dao.RestaurantRepository;
import bookmytable.dao.TableRepository;
import bookmytable.model.Customer;
import bookmytable.model.Reservation;
import bookmytable.model.Restaurant;
import bookmytable.model.RestaurantOwner;
import bookmytable.model.RestaurantTable;
import bookmytable.service.ReservationService;
import bookmytable.service.RestaurantService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MakeAReservation {
	@Autowired
	private RestaurantOwnerRepository oRepo;
	@Autowired
	private CustomerRepository cRepo;
	@Autowired
	private ReservationRepository rRepo;
	@Autowired
	private TableRepository tRepo;
	@Autowired
	private RestaurantRepository restRepo;
	@Autowired
	private RestaurantService serviceR;
	@Autowired
	private ReservationService serviceRsv;
	
	private Customer customer;
	private Restaurant theRestaurant;
	private RestaurantTable theTable;
	private String error;
	
	@Given("a customer <customer_id> is logged into BookMyTable as a customer")
	public void a_customer_customer_id_is_logged_into_book_my_table_as_a_customer() {
		this.customer = new Customer();
		customer.setName("test");
		customer.setEmail("test@gmail.com");
		customer.setPassword("testPassword");
		customer.setPhoneNumber("5143184677");
		cRepo.save(customer);
	}

	
	@Given("the customer <customer_id> is an unsuspended user")
	public void the_customer_customer_id_is_an_unsuspended_user() {
		// Write code here that turns the phrase above into concrete actions
		
	}

	@When("the customer <customer_id> selects the restaurant <restaurant_id> of their choice")
	public void the_customer_customer_id_selects_the_restaurant_restaurant_id_of_their_choice() {
		// Write code here that turns the phrase above into concrete actions
		//Create owner
		RestaurantOwner owner = new RestaurantOwner();
		
		oRepo.save(owner);
		
		
		//Create a restaurant
		int[][] hours = new int[4][2];
		int estDuration = 180;
		String menuLink = "aLink";
		int price = 2;
		String cuisine = "asian";
		String options = "vegan";
		String testName = "name"+getSaltString();
		String testAddress = "address"+getSaltString();
		
		//create restaurant through service method
		this.theRestaurant = serviceR.createRestaurant( testName, testAddress, hours, owner, estDuration, menuLink, price, cuisine, options);
		
		
		
		//Create table
		RestaurantTable table = new RestaurantTable();
		table.setCapacity(4);
		table.setTableNumber(1);
		table.setX(2);
		table.setY(4);
		table.setRestaurant(theRestaurant);
		this.theTable = table;
		tRepo.save(table);
		
		
	}
	
	@When("the customer <customer_id>  enters an acceptable group size <group_size>")
	public void the_customer_customer_id_enters_an_acceptable_group_size_group_size() {
		// Write code here that turns the phrase above into concrete actions
		Time startTime = new Time(8,30,0);
		Date date = new Date(10,05,2021);
		int groupSize = 4;
		long id = 123;
		
		
		Reservation aReservation = serviceRsv.makeReservation(startTime, date, groupSize, id, theTable,
                customer, theRestaurant);
		
	}

	@When("the customer <customer_id>  selects an available date and time <reservation_datetime>")
	public void the_customer_customer_id_selects_an_available_date_and_time_reservation_datetime() {
		//Done ABOVE
		
	}

	@When("the customer <customer_id>  selects an available table <table_id> of their choice")
	public void the_customer_customer_id_selects_an_available_table_table_id_of_their_choice() {
		//Done ABOVE
	}

	@Then("the customer <customer_id>  should see a confirmation message")
	public void the_customer_customer_id_should_see_a_confirmation_message() {
		
	}

	@Then("a new reservation <reservation_id> is generated")
	public void a_new_reservation_reservation_id_is_generated(io.cucumber.datatable.DataTable dataTable) {
		Reservation newReservation = rRepo.findReservationsByRestaurantAndGroupSize(theRestaurant, 4).get(0);
		Date date = new Date(10,05,2021);
				
		assertEquals(newReservation.getGroupSize(),4);
		assertEquals(newReservation.getDate(), date);
		
		rRepo.delete(newReservation);
		tRepo.delete(theTable);
		restRepo.delete(theRestaurant);
		
	}

	@When("the customer <customer_id>  fails to select an available reservation date and time <reservation_datetime>")
	public void the_customer_customer_id_fails_to_select_an_available_reservation_date_and_time_reservation_datetime() {
		// Write code here that turns the phrase above into concrete actions
		Time startTime = new Time(8,30,0);
		Time endTime = new Time(10,30,0);
		Date date = new Date(10,05,2021);
		int groupSize = 4;
		long id = 123;
		error=null;
		
		try {
			Reservation aReservation = serviceRsv.makeReservation(null, null, groupSize, id, theTable,
	                customer, theRestaurant);
		    } catch (IllegalArgumentException e) {
		      error = e.getMessage();
		    }
		
		//tRepo.delete(theTable);
		//restRepo.delete(theRestaurant);
		
	}
	
	@Then("an error message is issued")
	public void an_error_message_is_issued() {
	    // Write code here that turns the phrase above into concrete actions
	    assertNotEquals(null, error);
	   
		tRepo.delete(theTable);
		restRepo.delete(theRestaurant);
		
	}

	@When("the customer <customer_id>  enter a group size <group_size> surpassing the maximum limit")
	public void the_customer_customer_id_enter_a_group_size_group_size_surpassing_the_maximum_limit() {
		// Write code here that turns the phrase above into concrete actions
		Time startTime = new Time(8,30,0);
		Date date = new Date(10,05,2021);
		long id = 123;
		error = null;
		
		try {
			Reservation aReservation = serviceRsv.makeReservation(startTime, date, 6, id, theTable,
	                customer, theRestaurant);
		    } catch (IllegalArgumentException e) {
		      error = e.getMessage();
		    }
		//tRepo.delete(theTable);
		//restRepo.delete(theRestaurant);
	}


	@When("the customer <customer_id>  fails to enter a group size <group_size>")
	public void the_customer_customer_id_fails_to_enter_a_group_size_group_size() {
		// Write code here that turns the phrase above into concrete actions
		Time startTime = new Time(8,30,0);
		Date date = new Date(10,05,2021);
		long id = 123;
		error = null;
		
		try {
			Reservation aReservation = serviceRsv.makeReservation(startTime, date, -1, id, theTable,
	                customer, theRestaurant);
		    } catch (IllegalArgumentException e) {
		      error = e.getMessage();
		    }
		//tRepo.delete(theTable);
		//restRepo.delete(theRestaurant);
	}
	

	@When("the customer <customer_id>  fails to select an available table <table_id> of my choice")
	public void the_customer_customer_id_fails_to_select_an_available_table_table_id_of_my_choice() {
		// Write code here that turns the phrase above into concrete actions
		Time startTime = new Time(8,30,0);
		Date date = new Date(10,05,2021);
		long id = 123;
		int groupSize = 4;
		
		error = null;
		
		try {
			Reservation aReservation = serviceRsv.makeReservation(startTime, date, groupSize, id, null,
	                customer, theRestaurant);
		    } catch (IllegalArgumentException e) {
		      error = e.getMessage();
		    }
		//tRepo.delete(theTable);
		//restRepo.delete(theRestaurant);
	}

	@When("the customer <customer_id>  selects a restaurant that is completely booked")
	public void the_customer_customer_id_selects_a_restaurant_that_is_completely_booked() {
		// Write code here that turns the phrase above into concrete actions
		theRestaurant.setIsBooked(true);
		Time startTime = new Time(8,30,0);
		Date date = new Date(10,05,2021);
		int groupSize = 4;
		long id = 123;
		
		try {
		Reservation aReservation = serviceRsv.makeReservation(startTime, date, groupSize, id, null,
                customer, theRestaurant);
	}catch (IllegalArgumentException e) {
	      error = e.getMessage();
	    }
		
		//tRepo.delete(theTable);
		//restRepo.delete(theRestaurant);
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
