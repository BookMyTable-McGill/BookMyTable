package bookmytable.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookmytable.dao.CustomerRepository;
import bookmytable.model.Customer;

@Service
public class CustomerLoginService {

	@Autowired
	private CustomerRepository customerRepository;

	@Transactional
	public boolean loginCustomer(Customer customer, String email, String password) {
		String error = "";
		
		if (customer == null) {
			error = "Customer does not exist.";
			throw new IllegalArgumentException(error);
			
		} else if (customerRepository.findCustomerById(customer.getId()) == null || customer.getId() == null) {
			error = "Customer does not exist.";
			throw new IllegalArgumentException(error);

		} else if (customer.getPassword().equals(password) == false) {
			error = "Customer password does not match input password.";
			throw new IllegalArgumentException(error);

		} else if (customer.getEmail().equals(email) == false) {
			error = "Customer email does not match input email.";
			throw new IllegalArgumentException(error);
			
		} else {
			// set login status of customer to true
			return true;
		}
	}

	@Transactional
	public Customer getCustomerByEmail(String email) {
		return customerRepository.findCustomerByEmail(email);
	}

	@Transactional
	public Customer getCustomerById(long id) {
		return customerRepository.findCustomerById(id);
	}
	
	@Transactional
	public Customer getCustomerByPhoneNumber(String phoneNumber) {
		return customerRepository.findCustomerByPhoneNumber(phoneNumber);
	}
	
	@Transactional
	public List<Customer> getCustomersByName(String name) {
		return toList(customerRepository.findCustomersByName(name));
	}
	
	 private <T> List<T> toList(Iterable<T> iterable) {
	        List<T> resultList = new ArrayList<T>();
	        for (T t : iterable) {
	            resultList.add(t);
	        }
	        return resultList;
	    }
}
