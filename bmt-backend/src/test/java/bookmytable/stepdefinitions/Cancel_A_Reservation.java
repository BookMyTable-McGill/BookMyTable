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

public class Cancel_A_Reservation {
	
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
	private Reservation theReservation;

	@Given("customer <customer_id> has already made a reservation <reservation_id>")
	public void a_customer_customer_id_has_already_made_a_reservation_reservation_id() {
		
		this.customer = new Customer();
		customer.setName("test");
		customer.setEmail("test@gmail.com");
		customer.setPassword("testPassword");
		customer.setPhoneNumber("5143184677");
		cRepo.save(customer);
		
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
		
		Time startTime = new Time(8,30,0);
		Date date = new Date(10,05,2021);
		int groupSize = 4;
		long id = 123;
		
		//MAKING A RESERVATION
		this.theReservation = serviceRsv.makeReservation(startTime, date, groupSize, theTable,
                customer, theRestaurant);
		
		
	}
	
	@Given("customer <customer_id> is logged into BookMyTable as a customer")
	public void customer_customer_id_is_logged_into_book_my_table_as_a_customer() {
	   //DONE ABOVE
	}

	@When("the customer <customer_id> requests to cancel the reservation")
	public void the_customer_customer_id_requests_to_cancel_the_reservation() {
		
		Date date = new Date(10,04,2021);
		serviceRsv.deleteReservation(theReservation, date);
		
	}

	@Then("the reservation <reservation_id> will be cancelled")
	public void the_reservation_reservation_id_will_be_cancelled() {
		Date date = new Date(10,05,2021);
		int noReservation = serviceRsv.findReservationsByRestaurantAndGroupSizeAndDate(theRestaurant, 4, date).size();
		
		assertEquals(noReservation, 0);
	}

	@When("the customer <customer_id> wants to cancel the reservation")
	public void the_customer_customer_id_wants_to_cancel_the_reservation() {
		Date date = new Date(11,05,2021);
		
		try {
			serviceRsv.deleteReservation(theReservation, date);
			
		}catch (IllegalArgumentException e) {
		      error = e.getMessage();
		    }
			
	}

	@When("the reservation <reservation_id> has already passed")
	public void the_reservation_reservation_id_has_already_passed() {
		//This step is performed above
	}

	@Then("the customer will not have the option to cancel the reservation")
	public void the_customer_will_not_have_the_option_to_cancel_the_reservation() {
		
		assertNotEquals(error, null);
		
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
