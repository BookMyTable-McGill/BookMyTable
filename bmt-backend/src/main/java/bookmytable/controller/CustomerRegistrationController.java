package bookmytable.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import bookmytable.dao.CustomerRepository;
import bookmytable.dto.CustomerDTO;
import bookmytable.model.Customer;
import bookmytable.service.CustomerRegistrationService;

@CrossOrigin(origins = "*")
@RestController
public class CustomerRegistrationController {
  
  @Autowired
  public CustomerRegistrationService customerRegistrationService;
  
  @Autowired
  public CustomerRepository customerRepository;
  
  @PostMapping(value = { "/customer/register", "/customer/register/" })
  public CustomerDTO registerCustomer(@RequestParam(name = "name") String name,
      @RequestParam(name = "email") String email, @RequestParam(name = "password") String password,
      @RequestParam(name = "phoneNumber") String phoneNumber) {
    
    Customer customer = customerRegistrationService.createCustomer(name, email, password, phoneNumber);
    return Converters.convertToDto(customer);
  }
  
  @PostMapping(value= {"/customer/edit-info","customer/edit-info/"})
  public CustomerDTO modifyCustomerInfo(@RequestParam(name="customer") Customer customer, @RequestParam(name="name") String name, 
		  @RequestParam(name="email") String email, @RequestParam(name="password") String password, @RequestParam(name="phoneNum") String phoneNum) {
	  
	  Customer cust= customerRegistrationService.modifyCustomer(customer, name, email, password, phoneNum);
	  return Converters.convertToDto(cust);
	  
  }
  
  @GetMapping(value = { "/customers", "/customers/"})
  public List<CustomerDTO> getAllCustomers() {
    List<Customer> customers = customerRegistrationService.getCustomers();
    List<CustomerDTO> customerDTOs = new ArrayList<CustomerDTO>();
    for (Customer c : customers) {
      customerDTOs.add(Converters.convertToDto(c));
    }
    return customerDTOs;
  }
  
  @GetMapping(value = { "/customers/name", "/customers/name/"})
  public List<CustomerDTO> getCustomersByName(@RequestParam(name = "name") String name) {
    List<Customer> customers = customerRegistrationService.getCustomersByName(name);
    List<CustomerDTO> customerDTOs = new ArrayList<CustomerDTO>();
    for (Customer c : customers) {
      customerDTOs.add(Converters.convertToDto(c));
    }
    return customerDTOs;
  }

  @GetMapping(value = { "/customer/email", "/customer/email/"})
  public CustomerDTO getCustomerByEmail(@RequestParam(name = "email") String email) {
    Customer customer = customerRegistrationService.getCustomerByEmail(email);
    return Converters.convertToDto(customer);
  }
  
  @GetMapping(value = { "/customer/phone/number", "/customer/phone/number/"})
  public CustomerDTO getCustomerByPhoneNumber(@RequestParam(name = "phoneNumber") String phoneNumber) {
    Customer customer = customerRegistrationService.getCustomerByPhoneNumber(phoneNumber);
    return Converters.convertToDto(customer);
  }
  
  @GetMapping(value = { "/customer/id", "/customer/id/"})
  public CustomerDTO getCustomerById(@RequestParam(name = "ID") long id) {
    Customer customer = customerRegistrationService.getCustomerById(id);
    return Converters.convertToDto(customer);
  }
  
  @DeleteMapping(value = {"/customer/delete", "/customer/delete/"})
  public CustomerDTO deleteCustomer(@RequestParam(name = "ID") long id) {
    Customer customer = customerRegistrationService.deleteCustomer(id);
    return Converters.convertToDto(customer);
  }
}
