package bookmytable.stepdefinitions.sprint3;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.sql.Time;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import bookmytable.dao.RestaurantRepository;
import bookmytable.dao.TableRepository;
import bookmytable.model.Customer;
import bookmytable.model.Reservation;
import bookmytable.model.Restaurant;
import bookmytable.model.RestaurantOwner;
import bookmytable.model.RestaurantTable;
import bookmytable.service.CustomerRegistrationService;
import bookmytable.service.ReservationService;
import bookmytable.service.RestaurantOwnerRegistrationService;
import bookmytable.service.RestaurantService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Modify_A_Reservation {

	@Autowired
	ReservationService reservationService = new ReservationService();
	
	@Autowired
	CustomerRegistrationService customerRegistrationService = new CustomerRegistrationService();
	
	
	@Autowired
	RestaurantService restaurantService = new RestaurantService();
	
	@Autowired
	private RestaurantRepository rRepository;
	
	@Autowired
	private TableRepository tRepo;
	
	@Autowired
	RestaurantOwnerRegistrationService restaurantOwnerService = new RestaurantOwnerRegistrationService();
	
	Customer cust;
	
	//Create a restaurant
	Time[][] hours = new Time[7][2];
	Time time1 = Time.valueOf("6:45:20");
	Time time2 = Time.valueOf("7:45:20");
			
			
	int estDuration = 180;
	String menuLink = "aLink";
	int price = 2;
	String cuisine = "asian";
	String options = "vegan";
	String testName = "name";
	String testAddress = "address";
	
	
	RestaurantOwner owner;
	
	
			//create restaurant through service method
	Restaurant theRestaurant ;
				
			//Create table
	RestaurantTable table;
	RestaurantTable table2;
	
	
//	table.setCapacity(4);
//	table.setTableNumber(1);
//	table.setX(2);
//	table.setY(4);
//	table.setRestaurant(theRestaurant);
	
	Time startTime = new Time(8,30,0);
	Date date = new Date(10,05,2021);
	int groupSize = 4;
	
	Reservation reservation;
	
	
	@Given("a customer <customer_id> is logged into BookMyTable as a customer1")
	public void a_customer_customer_id_is_logged_into_BookMyTable_as_a_customer1() {
		
	}
	
	@Given("a customer has already made a reservation")
	public void a_customer_has_already_made_a_reservation() {
			
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
		
		
	}

	@When("the customer <customer_id> requests to modify the date of the reservation")
	public void the_customer_customer_id_requests_to_modify_the_date_of_the_reservation() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
	}

	@When("the customer <customer_id> selects a new date for the reservation")
	public void the_customer_customer_id_selects_a_new_date_for_the_reservation() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		cust = customerRegistrationService.createCustomer("Tester test", "a@reservation.com", "test123", "123-456-7890");
		owner = restaurantOwnerService.registerRestaurantOwner("Restaurant OWner", "test12345", "restoowner@owner.ca");
		theRestaurant = restaurantService.createRestaurant( testName+getSaltString(), testAddress+getSaltString(), hours, owner, estDuration, menuLink, price, cuisine, options);
		table = new RestaurantTable();
		table2 = new RestaurantTable();
		table.setCapacity(4);
		table.setTableNumber(1);
		table.setX(2);
		table.setY(4);
		table2.setCapacity(3);
		table2.setTableNumber(2);
		table2.setX(4);
		table2.setY(6);
		 
		 
		table.setRestaurant(theRestaurant);
		table2.setRestaurant(theRestaurant);
		tRepo.save(table);
		tRepo.save(table2);
		
		reservation = reservationService.makeReservation(startTime, date, groupSize, table, cust, theRestaurant);
		
		Date newDate = new Date(11,05,2021);
		reservationService.modifyReservation(reservation.getId(), startTime, newDate, groupSize, table, cust, theRestaurant);
		date =newDate;
	}

	@Then("the reservation <reservation_id> has the newly modified date")
	public void the_reservation_reservation_id_has_the_newly_modified_date() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		System.out.println("RESERVATION NUMBER IS "+ reservation.getId());
		Reservation res = reservationService.getReservationById(reservation.getId());
		assertEquals(res.getDate(), new Date(11,05,2021));
		
	}

	@When("the customer <customer_id> does not select any date for the reservation")
	public void the_customer_customer_id_does_not_select_any_date_for_the_reservation() {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
		//System.out.println("RESERVATION NUMBER IS "+ reservation.getId());
		
		cust = customerRegistrationService.createCustomer("Tester test", "b@reservation.com", "test123", "123-456-7890");
		owner = restaurantOwnerService.registerRestaurantOwner("Restaurant OWner", "test12345", "1restoowner@owner.ca");
		theRestaurant = restaurantService.createRestaurant( "mane"+getSaltString(), "12"+getSaltString(), hours, owner, estDuration, menuLink, price, cuisine, options);
		table = new RestaurantTable();
		table2 = new RestaurantTable();
		table.setCapacity(4);
		table.setTableNumber(1);
		table.setX(2);
		table.setY(4);
		table2.setCapacity(3);
		table2.setTableNumber(2);
		table2.setX(4);
		table2.setY(6);
		 
		 
		table.setRestaurant(theRestaurant);
		table2.setRestaurant(theRestaurant);
		tRepo.save(table);
		tRepo.save(table2);
		
		reservation = reservationService.makeReservation(startTime, date, groupSize, table, cust, theRestaurant);
		
		//System.out.println(res.getId());
		//System.out.println(startTime);
		//System.out.println(date);
		//System.out.println(groupSize);
		//System.out.println(table);
		//System.out.println(cust.getName());
		//System.out.println(theRestaurant.getName());
		reservationService.modifyReservation(reservation.getId(), startTime, date, groupSize, table, cust, theRestaurant);
	}

	@Then("the reservation <reservation_id> has the previously set date")
	public void the_reservation_reservation_id_has_the_previously_set_date() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		Reservation res = reservationService.getReservationById(reservation.getId());
		assertEquals(res.getDate(), date);
	}

	@Then("{string} message appears")
	public void message_appears(String string) {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
	}

	@When("the customer <customer_id> requests to modify the time of the reservation")
	public void the_customer_customer_id_requests_to_modify_the_time_of_the_reservation() {
		// Write code here that turns the phrase above into concrete actions
	//	throw new io.cucumber.java.PendingException();
		
		
	}

	@When("the customer <customer_id> selects a new time for the reservation")
	public void the_customer_customer_id_selects_a_new_time_for_the_reservation() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		cust = customerRegistrationService.createCustomer("Tester test", "bc@reservation.com", "test123", "123-456-7890");
		owner = restaurantOwnerService.registerRestaurantOwner("Restaurant OWner", "test12345", "12restoowner@owner.ca");
		theRestaurant = restaurantService.createRestaurant( "m1ane"+getSaltString(), "112"+getSaltString(), hours, owner, estDuration, menuLink, price, cuisine, options);
		table = new RestaurantTable();
		table2 = new RestaurantTable();
		table.setCapacity(4);
		table.setTableNumber(1);
		table.setX(2);
		table.setY(4);
		table2.setCapacity(3);
		table2.setTableNumber(2);
		table2.setX(4);
		table2.setY(6);
		 
		 
		table.setRestaurant(theRestaurant);
		table2.setRestaurant(theRestaurant);
		tRepo.save(table);
		tRepo.save(table2);
		
		reservation = reservationService.makeReservation(startTime, date, groupSize, table, cust, theRestaurant);
		
		Time newTime = new Time(8,00,0);
		reservationService.modifyReservation(reservation.getId(), newTime, date, groupSize, table, cust, theRestaurant);
		startTime =newTime;
	}

	@Then("the reservation <reservation_id> has the newly modified time")
	public void the_reservation_reservation_id_has_the_newly_modified_time() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		Reservation res = reservationService.getReservationById(reservation.getId());
		assertEquals(res.getStartTime(), new Time(8,00,0));
		
	}

	@When("the customer <customer_id> does not select any time for the reservation")
	public void the_customer_customer_id_does_not_select_any_time_for_the_reservation() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		cust = customerRegistrationService.createCustomer("Tester test", "bcg@reservation.com", "test123", "123-456-7890");
		owner = restaurantOwnerService.registerRestaurantOwner("Restaurant OWner", "test12345", "12grestoowner@owner.ca");
		theRestaurant = restaurantService.createRestaurant( "mg1ane"+getSaltString(), "11g2"+getSaltString(), hours, owner, estDuration, menuLink, price, cuisine, options);
		table = new RestaurantTable();
		table2 = new RestaurantTable();
		table.setCapacity(4);
		table.setTableNumber(1);
		table.setX(2);
		table.setY(4);
		table2.setCapacity(3);
		table2.setTableNumber(2);
		table2.setX(4);
		table2.setY(6);
		 
		 
		table.setRestaurant(theRestaurant);
		table2.setRestaurant(theRestaurant);
		tRepo.save(table);
		tRepo.save(table2);
		
		reservation = reservationService.makeReservation(startTime, date, groupSize, table, cust, theRestaurant);
		reservationService.modifyReservation(reservation.getId(), startTime, date, groupSize, table, cust, theRestaurant);

	}

	@Then("the reservation <reservation_id> has the previously set time")
	public void the_reservation_reservation_id_has_the_previously_set_time() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		Reservation res = reservationService.getReservationById(reservation.getId());
		assertEquals(res.getStartTime(), startTime);
	}

	@When("the customer <customer_id> requests to modify the group size of the reservation")
	public void the_customer_customer_id_requests_to_modify_the_group_size_of_the_reservation() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
	}

	@When("the customer <customer_id> selects a new group size for the reservation")
	public void the_customer_customer_id_selects_a_new_group_size_for_the_reservation() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		cust = customerRegistrationService.createCustomer("Tester test", "bcqg@reservation.com", "test123", "123-456-7890");
		owner = restaurantOwnerService.registerRestaurantOwner("Restaurant OWner", "test12345", "12gqrestoowner@owner.ca");
		theRestaurant = restaurantService.createRestaurant( "qmg1ane"+getSaltString(), "11qg2"+getSaltString(), hours, owner, estDuration, menuLink, price, cuisine, options);
		table = new RestaurantTable();
		table2 = new RestaurantTable();
		table.setCapacity(4);
		table.setTableNumber(1);
		table.setX(2);
		table.setY(4);
		table2.setCapacity(3);
		table2.setTableNumber(2);
		table2.setX(4);
		table2.setY(6);
		 
		 
		table.setRestaurant(theRestaurant);
		table2.setRestaurant(theRestaurant);
		tRepo.save(table);
		tRepo.save(table2);
		
		reservation = reservationService.makeReservation(startTime, date, groupSize, table, cust, theRestaurant);
		int newGroupSize = 3;
		reservationService.modifyReservation(reservation.getId(), startTime, date, newGroupSize, table, cust, theRestaurant);
		groupSize =newGroupSize;
	}
	
	@When("the customer <customer_id> selects a new group size and new table for the reservation1")
	public void the_customer_customer_id_selects_a_new_group_size_and_new_table_for_the_reservation1() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		cust = customerRegistrationService.createCustomer("Tester test", "bcqg5@reservation.com", "test123", "123-456-7890");
		owner = restaurantOwnerService.registerRestaurantOwner("Restaurant OWner", "test12345", "12gq5restoowner@owner.ca");
		theRestaurant = restaurantService.createRestaurant( "qmg51ane"+getSaltString(), "11q5g2"+getSaltString(), hours, owner, estDuration, menuLink, price, cuisine, options);
		table = new RestaurantTable();
		table2 = new RestaurantTable();
		table.setCapacity(4);
		table.setTableNumber(1);
		table.setX(2);
		table.setY(4);
		table2.setCapacity(3);
		table2.setTableNumber(2);
		table2.setX(4);
		table2.setY(6);
		 
		 
		table.setRestaurant(theRestaurant);
		table2.setRestaurant(theRestaurant);
		tRepo.save(table);
		tRepo.save(table2);
		
		reservation = reservationService.makeReservation(startTime, date, groupSize, table, cust, theRestaurant);
		int newGroupSize = 3;
		reservationService.modifyReservation(reservation.getId(), startTime, date, newGroupSize, table, cust, theRestaurant);
		groupSize =newGroupSize;
	}

	@When("the customer <customer_id> selects a new table for the reservation")
	public void the_customer_customer_id_selects_a_new_table_for_the_reservation() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		
		cust = customerRegistrationService.createCustomer("Tester test", "bcq3g@reservation.com", "test123", "123-456-7890");
		owner = restaurantOwnerService.registerRestaurantOwner("Restaurant OWner", "test12345", "12gq3restoowner@owner.ca");
		theRestaurant = restaurantService.createRestaurant( "qmg13ane"+getSaltString(), "113qg2"+getSaltString(), hours, owner, estDuration, menuLink, price, cuisine, options);
		table = new RestaurantTable();
		table2 = new RestaurantTable();
		table.setCapacity(4);
		table.setTableNumber(1);
		table.setX(2);
		table.setY(4);
		table2.setCapacity(3);
		table2.setTableNumber(2);
		table2.setX(4);
		table2.setY(6);
		 
		 
		table.setRestaurant(theRestaurant);
		table2.setRestaurant(theRestaurant);
		tRepo.save(table);
		tRepo.save(table2);
		
		groupSize=3;
		reservation = reservationService.makeReservation(startTime, date, groupSize, table, cust, theRestaurant);
		
		reservationService.modifyReservation(reservation.getId(), startTime, date, groupSize, table2, cust, theRestaurant);

	}
	@When("the customer <customer_id> selects a new table for the reservation1")
	public void the_customer_customer_id_selects_a_new_table_for_the_reservation1() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		
		cust = customerRegistrationService.createCustomer("Tester test", "becq3g@reservation.com", "test123", "123-456-7890");
		owner = restaurantOwnerService.registerRestaurantOwner("Restaurant OWner", "test12345", "12gq3erestoowner@owner.ca");
		theRestaurant = restaurantService.createRestaurant( "qmge13ane"+getSaltString(), "113qge2"+getSaltString(), hours, owner, estDuration, menuLink, price, cuisine, options);
		table = new RestaurantTable();
		table2 = new RestaurantTable();
		table.setCapacity(4);
		table.setTableNumber(1);
		table.setX(2);
		table.setY(4);
		table2.setCapacity(3);
		table2.setTableNumber(2);
		table2.setX(4);
		table2.setY(6);
		 
		 
		table.setRestaurant(theRestaurant);
		table2.setRestaurant(theRestaurant);
		tRepo.save(table);
		tRepo.save(table2);
		
		groupSize=3;
		reservation = reservationService.makeReservation(startTime, date, groupSize, table, cust, theRestaurant);
		
		reservationService.modifyReservation(reservation.getId(), startTime, date, groupSize, table2, cust, theRestaurant);

	}

	@Then("the reservation <reservation_id> has the newly modified group size and table")
	public void the_reservation_reservation_id_has_the_newly_modified_group_size_and_table() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();

		Reservation res = reservationService.getReservationById(reservation.getId());
		assertEquals(res.getGroupSize(), 3);
		assertEquals(res.getTable().getCapacity(), table2.getCapacity());
	}
	@Then("the reservation <reservation_id> has the newly modified group size and table1")
	public void the_reservation_reservation_id_has_the_newly_modified_group_size_and_table1() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();

		Reservation res = reservationService.getReservationById(reservation.getId());
		assertEquals(res.getGroupSize(), 3);
		assertEquals(res.getTable().getCapacity(), table.getCapacity());
	}

	@When("the customer <customer_id> does not select a new group size for the reservation")
	public void the_customer_customer_id_does_not_select_a_new_group_size_for_the_reservation() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		cust = customerRegistrationService.createCustomer("Tester test", "bcq3ig@reservation.com", "test123", "123-456-7890");
		owner = restaurantOwnerService.registerRestaurantOwner("Restaurant OWner", "test12345", "12igq3restoowner@owner.ca");
		theRestaurant = restaurantService.createRestaurant( "iqmg13ane"+getSaltString(), "1i13qg2"+getSaltString(), hours, owner, estDuration, menuLink, price, cuisine, options);
		table = new RestaurantTable();
		table2 = new RestaurantTable();
		table.setCapacity(4);
		table.setTableNumber(1);
		table.setX(2);
		table.setY(4);
		table2.setCapacity(3);
		table2.setTableNumber(2);
		table2.setX(4);
		table2.setY(6);
		 
		 
		table.setRestaurant(theRestaurant);
		table2.setRestaurant(theRestaurant);
		tRepo.save(table);
		tRepo.save(table2);
		groupSize =2; 
		reservation = reservationService.makeReservation(startTime, date, groupSize, table2, cust, theRestaurant);
		
		reservationService.modifyReservation(reservation.getId(), startTime, date, groupSize, table2, cust, theRestaurant);

	}
	@When("the customer <customer_id> does not select a new group size for the reservation1")
	public void the_customer_customer_id_does_not_select_a_new_group_size_for_the_reservation1() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		cust = customerRegistrationService.createCustomer("Tester test", "bcqe3ig@reservation.com", "test123", "123-456-7890");
		owner = restaurantOwnerService.registerRestaurantOwner("Restaurant OWner", "test12345", "12igqe3restoowner@owner.ca");
		theRestaurant = restaurantService.createRestaurant( "iqmg1e3ane"+getSaltString(), "1ie13qg2"+getSaltString(), hours, owner, estDuration, menuLink, price, cuisine, options);
		table = new RestaurantTable();
		table2 = new RestaurantTable();
		table.setCapacity(4);
		table.setTableNumber(1);
		table.setX(2);
		table.setY(4);
		table2.setCapacity(3);
		table2.setTableNumber(2);
		table2.setX(4);
		table2.setY(6);
		 
		 
		table.setRestaurant(theRestaurant);
		table2.setRestaurant(theRestaurant);
		tRepo.save(table);
		tRepo.save(table2);
		groupSize =2; 
		reservation = reservationService.makeReservation(startTime, date, groupSize, table2, cust, theRestaurant);
		
		reservationService.modifyReservation(reservation.getId(), startTime, date, groupSize, table2, cust, theRestaurant);

	}

	@Then("the reservation <reservation_id> has the previously set group size")
	public void the_reservation_reservation_id_has_the_previously_set_group_size() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		Reservation res = reservationService.getReservationById(reservation.getId());
		assertEquals(res.getGroupSize(), groupSize);
	}

	@When("the customer <customer_id> requests to modify the table of the reservation")
	public void the_customer_customer_id_requests_to_modify_the_table_of_the_reservation() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
	}

	@Then("the reservation <reservation_id> has the newly modified table")
	public void the_reservation_reservation_id_has_the_newly_modified_table() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		Reservation res = reservationService.getReservationById(reservation.getId());
		assertEquals(res.getTable().getCapacity(), table2.getCapacity());

		
	}

	@When("the customer <customer_id> does not select a new table for the reservation")
	public void the_customer_customer_id_does_not_select_a_new_table_for_the_reservation() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		cust = customerRegistrationService.createCustomer("Tester test", "bcqm3ig@reservation.com", "test123", "123-456-7890");
		owner = restaurantOwnerService.registerRestaurantOwner("Restaurant OWner", "test12345", "12igmq3restoowner@owner.ca");
		theRestaurant = restaurantService.createRestaurant( "imqmg13ane"+getSaltString(), "1i13mqg2"+getSaltString(), hours, owner, estDuration, menuLink, price, cuisine, options);
		table = new RestaurantTable();
		table2 = new RestaurantTable();
		table.setCapacity(4);
		table.setTableNumber(1);
		table.setX(2);
		table.setY(4);
		table2.setCapacity(3);
		table2.setTableNumber(2);
		table2.setX(4);
		table2.setY(6);
		 
		 
		table.setRestaurant(theRestaurant);
		table2.setRestaurant(theRestaurant);
		tRepo.save(table);
		tRepo.save(table2);
		groupSize=2;
		reservation = reservationService.makeReservation(startTime, date, groupSize, table2, cust, theRestaurant);
		
		reservationService.modifyReservation(reservation.getId(), startTime, date, groupSize, table2, cust, theRestaurant);

	}

	@Then("the reservation <reservation_id> has the previously set table")
	public void the_reservation_reservation_id_has_the_previously_set_table() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		Reservation res = reservationService.getReservationById(reservation.getId());
		assertEquals(res.getTable().getCapacity(), table2.getCapacity());

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
