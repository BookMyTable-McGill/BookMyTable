package bookmytable.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;

import bookmytable.model.Customer;
import bookmytable.service.CustomerRegistrationService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Modify_Account_Details {
	
@Autowired 
CustomerRegistrationService customerRegistrationService = new CustomerRegistrationService();


String newName;
String newEmail;
String newPassword;
String newPhone;
boolean exceptionCaught=false;


	@When("the customer <customer_id> queries to change his <name>")
	public void the_customer_customer_id_queries_to_change_his_username() {
		newName = "Big Test";
	   
	}


	@When("the customer <customer_id> queries to change his <email_address>")
	public void the_customer_customer_id_queries_to_change_his_email_address() {
	    newEmail = "b@testing.com";
	   // throw new io.cucumber.java.PendingException();
	}
	@When("the customer <customer_id> queries to change his <password>")
	public void the_customer_customer_id_queries_to_change_his_password() {
	   newPassword ="hihihi";
	    //throw new io.cucumber.java.PendingException();
	}
	@When("the customer <customer_id> queries to change his <phone_number>")
	public void the_customer_customer_id_queries_to_change_his_phone_number() {
		newPhone="111-111-1111";
		Customer cust = customerRegistrationService.createCustomer("Teste test", "a@testing.com", "test123", "123-456-7890");
		cust = customerRegistrationService.modifyCustomer(cust.getId(), newName, newEmail, newPassword, newPhone);
				
		// throw new io.cucumber.java.PendingException();
	}
	
	@When("the customer <customer_id> queries to only change his <name>")
	public void the_customer_customer_id_queries_to_only_change_his_username() {
		newName="new name";
		
		Customer cust = customerRegistrationService.createCustomer("Teste test", "z@testing.com", "test123", "123-456-7890");
	    customerRegistrationService.modifyCustomer(cust.getId(), newName, cust.getEmail(), cust.getPassword(), cust.getPhoneNumber());
		//throw new io.cucumber.java.PendingException();
	}

	@When("the customer <customer_id> queries to only change his <email_address>")
	public void the_customer_customer_id_queries_to_only_change_his_email_address() {
	    
		Customer cust = customerRegistrationService.createCustomer("Teste test", "x@testing.com", "test123", "123-456-7890");
	    customerRegistrationService.modifyCustomer(cust.getId(), cust.getName(), "tt@testing.com", cust.getPassword(), cust.getPhoneNumber());
		
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	@When("the customer <customer_id> queries to only change his <password>")
	public void the_customer_customer_id_queries_to_only_change_his_password() {
	    newPassword="newpassword";
		Customer cust = customerRegistrationService.createCustomer("Teste test", "v@testing.com", "test123", "123-456-7890");
	    customerRegistrationService.modifyCustomer(cust.getId(), cust.getName(), cust.getEmail(),newPassword, cust.getPhoneNumber());
		
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	@When("the customer <customer_id> queries to only change his <phone_number>")
	public void the_customer_customer_id_queries_to_only_change_his_phone_number() {
		newPhone="333-222-4444";
		Customer cust = customerRegistrationService.createCustomer("Teste test", "n@testing.com", "test123", "123-456-7890");
	    customerRegistrationService.modifyCustomer(cust.getId(), cust.getName(), cust.getEmail(),cust.getPassword(), newPhone);
		
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	
	
	@Then("the customer <customer_id>'s <name>, <email_address>, <password> and <phone_number> are modified Successfully.")
	public void the_customer_customer_id_s_name_email_address_password_and_phone_number_are_modified_successfully() {
	    Customer cust = customerRegistrationService.getCustomerByEmail(newEmail);
	    assertEquals(newName, cust.getName());
	    assertEquals(newPassword,cust.getPassword());
	    assertEquals(newPhone,cust.getPhoneNumber());
	    //throw new io.cucumber.java.PendingException();
	}
	

	

	@Then("the customer <customer_id>'s <name> is modified Successfully.")
	public void the_customer_customer_id_s_name_is_modified_successfully() {
		Customer cust1 = customerRegistrationService.getCustomerByEmail("z@testing.com");
		assertEquals(newName, cust1.getName());
    //throw new io.cucumber.java.PendingException();
	}
	



	@Then("the customer <customer_id>'s <email_address> is modified Successfully.")
	public void the_customer_customer_id_s_email_address_is_modified_successfully() {
	    
		
		assertNotNull(customerRegistrationService.getCustomerByEmail("tt@testing.com"));
		
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}



	@Then("the customer <customer_id>'s <password> is modified Successfully.")
	public void the_customer_customer_id_s_password_is_modified_successfully() {
		Customer cust1 = customerRegistrationService.getCustomerByEmail("v@testing.com");
		assertEquals(newPassword, cust1.getPassword());
	}
	
	



	@Then("the customer <customer_id>'s <phone_number> is modified Successfully.")
	public void the_customer_customer_id_s_phone_number_is_modified_successfully() {
	   
		Customer cust1 = customerRegistrationService.getCustomerByEmail("n@testing.com");
		assertEquals(newPhone, cust1.getPhoneNumber());
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	
	@When("the customer <customer_id> queries to change his <name>, <email_address>, <password> or <phone_number> to be empty")
	public void the_customer_customer_id_queries_to_change_his_name_email_address_password_or_phone_number_to_be_empty() {
	  
		Customer cust = customerRegistrationService.createCustomer("Teste test", "k@testing.com", "test123", "123-456-7890");
		
		try {
			 customerRegistrationService.modifyCustomer(cust.getId(), "","","", "");
		}
		catch(IllegalArgumentException e) {
			exceptionCaught=true;
		}
		
		// Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}



	@Then("the customer <customer_id>'s <name>, <email_address>, <password> and <phone_number> are not modified")
	public void the_customer_customer_id_s_name_email_address_password_and_phone_number_are_not_modified() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		assertTrue(exceptionCaught);
	}
	
	@Then("the initial customer's credentials are kept the same.")
	public void the_initial_customer_s_credentials_are_kept_the_same() {
	    Customer cust=customerRegistrationService.getCustomerByEmail("k@testing.com");
	    assertEquals("Teste test", cust.getName());
	    assertEquals("test123",cust.getPassword());
	    assertEquals("123-456-7890",cust.getPhoneNumber());
		
		// Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	}

