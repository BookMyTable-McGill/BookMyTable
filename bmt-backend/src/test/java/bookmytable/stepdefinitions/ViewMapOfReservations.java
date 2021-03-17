package bookmytable.stepdefinitions;

import bookmytable.dao.CustomerRepository;
import bookmytable.dao.ReservationRepository;
import bookmytable.dao.RestaurantOwnerRepository;
import bookmytable.dao.RestaurantRepository;
import bookmytable.model.*;
import bookmytable.service.CustomerRegistrationService;
import bookmytable.service.ReservationService;
import bookmytable.service.RestaurantService;
import bookmytable.service.ViewReservationMapService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ViewMapOfReservations {

	@Autowired
	private ViewReservationMapService serviceVR;
	@Autowired
	private RestaurantService serviceR;
	@Autowired
	private RestaurantRepository rRepo;
	@Autowired
	private CustomerRepository cRepo;
	@Autowired
	private ReservationRepository resvRepo;
	@Autowired
	private RestaurantOwnerRepository oRepo;
	@Autowired
	private ReservationService serviceRes;
	@Autowired
	private CustomerRegistrationService serviceC;


	private RestaurantOwner owner;
	private Restaurant restaurant;
	private Set<Restaurant> restaurants = new HashSet<>();
	private String[] customerEmails = {"john12345@gmail.com", "pizzaman@hotmail.com"};
	private String customerPassword = "password123";
	private String customerPhoneNumber = "123-456-7890";
	private List<Reservation> reservations = null;

	@Given("restaurant owner <restaurant_owner> is logged into BookMyTable as a restaurant owner")
	public void restaurant_owner_restaurant_owner_is_logged_into_book_my_table_as_a_restaurant_owner() {
		owner = new RestaurantOwner();
		owner.setName("test");
		owner.setEmail("test@gmail.com");
		owner.setPassword("testPassword");
		owner.setRestaurants(restaurants);
		oRepo.save(owner);
	}

	@Given("<restaurant_owner> owns <restaurant_id>")
	public void restaurant_owner_owns_restaurant_id() {
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
		String cuisine = "italian";
		String options = "pizzatime";
		String testName = "pizzeria";
		String testAddress = "testAddress";
		this.restaurant = serviceR.createRestaurant(testName, testAddress, hours, owner, estDuration, menuLink, price, cuisine, options);
		restaurants.add(restaurant);
		owner.setRestaurants(restaurants);
		oRepo.save(owner);
	}

	@Given("the following reservations are registered to the restaurant <restaurant_id>:")
	public void the_following_reservations_are_registered_to_the_restaurant_restaurant_id(
			io.cucumber.datatable.DataTable dataTable) throws ParseException {
		List<Map<String, String>> valueMaps = dataTable.asMaps();
		int i =0;
		for (Map<String, String> map : valueMaps) {
			java.util.Date res_date = new SimpleDateFormat("yyyy-MM-dd").parse(map.get("reservation_date"));
			Date dateFormat = new Date(res_date.getTime());
			DateFormat formatter = new SimpleDateFormat("kk:mm:ss");
			Time time = new Time(formatter.parse(map.get("reservation_time")).getTime());
			Integer res_ID = Integer.decode(map.get("reservation_id"));
			Integer table_ID = Integer.decode(map.get("table_id"));
			int x_coord = Integer.parseInt(map.get("table_coordinates").substring(0,1));
			int y_coord = Integer.parseInt(map.get("table_coordinates").substring(2,3));
			RestaurantTable table = serviceR.addTableToMap(5, table_ID, x_coord, y_coord, restaurant);

			Customer customer = serviceC.createCustomer(map.get("customer_name"), customerEmails[i], customerPassword, customerPhoneNumber);
			serviceRes.makeReservation(time, dateFormat, 1, table, customer, restaurant);
			i++;
		}
	}

	@When("<restaurant_owner> queries reservations with <reservation_datetime> ranging from {int}-{int}-{int} {int}:{int}:{int} to {int}-{int}-{int} {int}:{int}:{int} in <restaurant_id>")
	public void restaurant_owner_queries_reservations_with_reservation_datetime_ranging_from_to_in_restaurant_id(
			Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6, Integer int7,
			Integer int8, Integer int9, Integer int10, Integer int11, Integer int12) {
		Date startDate = new Date(int1-1900, int2-1, int3);
		Time startTime = new Time(int4, int5, int6);
		Time endTime = new Time(int10, int11, int12);
		reservations = serviceRes.getReservationsByRestaurantAndStartTimeBetweenAndDate(restaurant, startTime, endTime, startDate);
	}

	@Then("the following list of all tables in <restaurant_id> is returned:")
	public void the_following_list_of_all_tables_in_restaurant_id_is_returned(
			io.cucumber.datatable.DataTable dataTable) throws ParseException {
		List<Map<String, String>> valueMaps = dataTable.asMaps();
		int i = 0;
		for (Map<String, String> map : valueMaps) {
//			assertEquals(reservations.get(i).getId(), Integer.parseInt(map.get("reservation_id")));
			assertEquals(reservations.get(i).getCustomer().getName(), map.get("customer_name"));
//			assertEquals(reservations.get(i).getTable().getId(), Integer.parseInt(map.get("table_id")));
			assertEquals(reservations.get(i).getTable().getCapacity(), Integer.parseInt(map.get("table_capacity")));
			assertEquals(reservations.get(i).getTable().getX(), Integer.parseInt(map.get("table_coordinates").substring(0,1)));
			assertEquals(reservations.get(i).getTable().getY(), Integer.parseInt(map.get("table_coordinates").substring(2,3)));
			i++;
		}
	}
}
