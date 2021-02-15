package bookmytable.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import bookmytable.dao.CustomerRepository;
import bookmytable.dao.ReservationRepository;
import bookmytable.model.Customer;
import bookmytable.model.Reservation;

@Service
public class CustomerRegistrationService {
  
  @Autowired
  private CustomerRepository customerRepository;
  
  @Autowired
  private ReservationRepository reservationRepository;
  
  @Transactional
  public Customer createCustomer(String name, String email, String password, String phoneNumber) {
    name = name.trim();
    email = email.trim();
    password = password.trim();
    phoneNumber = phoneNumber.trim();
    
    if (name == null || name.compareTo("")==0
        || email == null || email.compareTo("")==0
        || password == null || password.compareTo("")==0
        || phoneNumber == null || phoneNumber.compareTo("")==0) {
      throw new IllegalArgumentException("Missing Information");
    }
    
    if (!validateEmail(email)) {
      throw new IllegalArgumentException("Invalid Email");
    }
    
    Customer emailCheck = customerRepository.findCustomerByEmail(email);
    if (emailCheck != null) {
      throw new IllegalArgumentException("An account with this email already exists");
    }
    
    if (password.length() < 6) {
      throw new IllegalArgumentException("Invalid Password");
    }

    if (!validatePhoneNumber(phoneNumber)) {
      throw new IllegalArgumentException("Invalid Phone Number");
    }
    
    Customer customer = new Customer();
    customer.setName(name);
    customer.setEmail(email);
    customer.setPassword(password);
    customer.setPhoneNumber(phoneNumber);
    customer.setFavoriteRestaurants(null);
    customer.setReservations(null);
    customerRepository.save(customer);
    
    return customer;
  }
  
  @Transactional
  public List<Customer> getCustomers() {
    return toList(customerRepository.findAll());
  }
  
  @Transactional
  public List<Customer> getCustomersByName(String name) {
    if (name == null || name == "") {
      throw new IllegalArgumentException("Name is empty");
    }
    
    List<Customer> customers = customerRepository.findCustomersByName(name);
    
    if (customers == null || customers.size() == 0) {
      throw new IllegalArgumentException("No customer with this name was found");
    }
    
    return customers;
  }
  
  @Transactional
  public Customer getCustomerById(long id) {
    if (id == 0) {
      throw new IllegalArgumentException("Id is empty");
    }
    
    Customer customer = customerRepository.findCustomerById(id);
    
    if (customer == null) {
      throw new IllegalArgumentException("No customer with this id was found");
    }
    
    return customer;
  }
  
  @Transactional
  public Customer getCustomerByEmail(String email) {
    if (email == null || email == "") {
      throw new IllegalArgumentException("Email is empty");
    }
    
    Customer customer = customerRepository.findCustomerByEmail(email);
    
    if (customer == null) {
      throw new IllegalArgumentException("No customer with this email was found");
    }
    
    return customer;
  }
  
  @Transactional
  public Customer getCustomerByPhoneNumber(String phoneNumber) {
    if (phoneNumber == null || phoneNumber == "") {
      throw new IllegalArgumentException("Email is empty");
    }
    
    Customer customer = customerRepository.findCustomerByPhoneNumber(phoneNumber);
    
    if (customer == null) {
      throw new IllegalArgumentException("No customer with this phone number was found");
    }
    
    return customer;
  }
  
  @Transactional
  public Customer deleteCustomer(long id) {
    if (id == 0) {
      throw new IllegalArgumentException("Id is empty");
    }
    
    Customer customer = customerRepository.findCustomerById(id);
    
    if (customer == null) {
      throw new IllegalArgumentException("No customer with this id was found");
    }
    
    customer.setFavoriteRestaurants(null);
    
    Set<Reservation> reservations = customer.getReservations();
    if (reservations != null) {
      for (Reservation r : reservations) {
        reservationRepository.delete(r);
      }
    }
    
    customerRepository.delete(customer);
    return customer;
  }
  
  private boolean validateEmail(String email) {
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
            + "A-Z]{2,7}$";
    Pattern pattern = Pattern.compile(emailRegex);
    return pattern.matcher(email).matches();
  }

  private boolean validatePhoneNumber(String phoneNumber) {
    String phoneNumberRegex = "(?:\\d{3}-){2}\\d{4}";
    Pattern pattern = Pattern.compile(phoneNumberRegex);
    return pattern.matcher(phoneNumber).matches();
  }
  
//Helper method to retrieve lists of objects
  private <T> List<T> toList(Iterable<T> iterable) {
      List<T> resultList = new ArrayList<T>();
      for (T t : iterable) {
          resultList.add(t);
      }
      return resultList;
  }
  
}
