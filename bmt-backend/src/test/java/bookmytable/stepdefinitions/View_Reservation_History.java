package bookmytable.stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
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
import bookmytable.service.CustomerRegistrationService;
import bookmytable.service.ReservationService;
import bookmytable.service.RestaurantService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class View_Reservation_History {

	@Autowired
	private CustomerRepository cRepo;
	
	@Autowired
	private TableRepository tRepo;
	
	@Autowired
	private ReservationRepository rRepo;
	
	@Autowired
	private RestaurantOwnerRepository oRepo;
	
	@Autowired
	private RestaurantRepository restRepo;
	
	@Autowired
	CustomerRegistrationService customerRegistrationService = new CustomerRegistrationService();
	
	@Autowired
	ReservationService reservationService = new ReservationService();
	
	@Autowired
	RestaurantService restaurantService = new RestaurantService();
	
	private Customer customer;
	private Customer newCustomer;
	private Restaurant theRestaurant;
	private RestaurantTable theTable;
	
	@Given("a customer is logged in")
	public void a_customer_is_logged_in() {
		//create customer
		this.customer = new Customer();
		customer.setName("test");
		customer.setEmail("test@gmail.com");
		customer.setPassword("testPassword");
		customer.setPhoneNumber("5143184677");
		cRepo.save(customer);
	}

	@Given("the customer has made at least one reservation through BookMyTable")
	public void the_customer_has_made_at_least_one_reservation_through_book_my_table() {
		//create owner
		RestaurantOwner owner = new RestaurantOwner();
		
		oRepo.save(owner);
		
		//Create a restaurant
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
		}		int estDuration = 180;
		String menuLink = "aLink";
		int price = 2;
		String cuisine = "asian";
		String options = "vegan";
		String testName = "name"+getSaltString();
		String testAddress = "address"+getSaltString();
		
		//create restaurant through service method
		this.theRestaurant = restaurantService.createRestaurant( testName, testAddress, hours, owner, estDuration, menuLink, price, cuisine, options);
		
		//Create table
		RestaurantTable table = new RestaurantTable();
		table.setCapacity(4);
		table.setTableNumber(1);
		table.setX(2);
		table.setY(4);
		table.setRestaurant(theRestaurant);
		this.theTable = table;
		tRepo.save(table);
		
		Time startTime = new Time(8,30,0);
		Date date = new Date(10,05,2021);
		int groupSize = 4;
		long id = 123;
		
		Reservation reservation = reservationService.makeReservation(startTime, date, groupSize, theTable, customer, theRestaurant);
	}

	@When("the customer selects to view their reservation history")
	public void the_customer_selects_to_view_their_reservation_history() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("the customer's reservation history will be displayed")
	public void the_customer_s_reservation_history_will_be_displayed() {
		List<Reservation> reservations = reservationService.getReservationsByCustomer(customer);
		
		assertEquals(reservations.size(), 1);
		cRepo.delete(customer);
		tRepo.delete(theTable);
		restRepo.delete(theRestaurant);
	}
	
	@Given("the customer has never used the system to make a reservation")
	public void the_customer_has_never_used_the_system_to_make_a_reservation() {
		this.newCustomer = new Customer();
		newCustomer.setName("test");
		newCustomer.setEmail("test@gmail.com");
		newCustomer.setPassword("testPassword");
		newCustomer.setPhoneNumber("5143184677");
		cRepo.save(newCustomer);
	}

	@When("the customer tries to view their reservation history")
	public void the_customer_tries_to_view_their_reservation_history() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("there will be an error message displayed")
	public void there_will_be_an_error_message_displayed() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("there will be no history for the customer to view")
	public void there_will_be_no_history_for_the_customer_to_view() {
		// Write code here that turns the phrase above into concrete actions
		List<Reservation> reservations = reservationService.getReservationsByCustomer(newCustomer);
		assertEquals(reservations.size(), 0);
		
		cRepo.delete(newCustomer);
		
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
