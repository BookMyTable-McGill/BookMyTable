package bookmytable.stepdefinitions;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import bookmytable.model.Admin;
import bookmytable.model.Customer;
import bookmytable.model.RestaurantOwner;
import bookmytable.service.AdminLoginService;
import bookmytable.service.AdminRegistrationService;
import bookmytable.service.CustomerRegistrationService;
import bookmytable.service.RestaurantOwnerRegistrationService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class View_All_Users {
    
    @Autowired
    private AdminRegistrationService adminRegistrationService;
    @Autowired
    private AdminLoginService adminLoginService;
    @Autowired
    private CustomerRegistrationService customerRegistrationService;
    @Autowired
    private RestaurantOwnerRegistrationService restaurantOwnerRegistrationService;
    
    private List<Customer> customers;
    private List<RestaurantOwner> restaurantOwners;
    
    private String cName = "Billy Bob";
    private String cEmail = "billy@gmail.com";
    private String cPassword = "password";
    private String cPhoneNumber = "1234567890";
    
    private String rName = "Alex Alexander";
    private String rEmail = "alex@gmail.com";
    private String rPassword = "password";
    
    private Customer customer;
    private RestaurantOwner restaurantOwner;

	@Given("The administrator {string} is logged in")
	public void administrator_is_logged_in(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    String name = string;
	    String email = string + "@gmail.com";
	    String password = "password";
	    Admin admin = null;
	    try {
	      admin = adminRegistrationService.createAdmin(name, email, password);
	    } catch (IllegalArgumentException e) {
	      //If this account already exists, continue without any issue. If a separate problem happened,
	      //throw an exception
	      if (!e.getMessage().equals("An adminstrative account with this email already exists")) {
	        throw new IllegalArgumentException(e);
	      }
	    }
	    boolean loggedIn = adminLoginService.loginAdmin(admin, email, password);
	    assertTrue(loggedIn);
	}


	@When("Administrator {string} attempts to view all users")
	public void administrator_attempts_to_view_all_users(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //Create a customer and a restaurant owner
	    customer = customerRegistrationService.createCustomer(cName, cEmail, cPassword, cPhoneNumber);
	    restaurantOwner = restaurantOwnerRegistrationService.registerRestaurantOwner(rName, rPassword, rEmail);
	    customers = customerRegistrationService.getCustomers();
	    restaurantOwners = restaurantOwnerRegistrationService.getRestaurantOwners();
	    assertTrue(true);
	}
	@Then("a list of all Customer ids <{string}> and all  Restaurant Owner ids <{string}> is returned:")
	public void a_list_of_all_customer_ids_and_all_restaurant_owner_ids_is_returned(String string, String string2, io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.	  
	    assertTrue(customers != null);
	    assertTrue(restaurantOwners != null);
	    
	    assertTrue(customers.contains(customer));
	    assertTrue(restaurantOwners.contains(restaurantOwner));
	}

}
