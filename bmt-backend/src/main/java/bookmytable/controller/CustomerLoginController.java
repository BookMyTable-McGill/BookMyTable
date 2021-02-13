package bookmytable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bookmytable.dto.CustomerDTO;
import bookmytable.model.Customer;
import bookmytable.model.RestaurantOwner;
import bookmytable.service.CustomerLoginService;

@CrossOrigin(origins = "*")
@RestController
public class CustomerLoginController {

	@Autowired
	private CustomerLoginService customerLoginService;

	@PostMapping(value = { "/customer/login", "/customer/login/" })
	private boolean customerLogin(@RequestParam(name = "password") String password,
			@RequestParam(name = "email") String email) {
		Customer customer = customerLoginService.getCustomerByEmail(email);
		if (customer != null) {
			return CustomerLoginService.loginCustomer(customer, password, email);
		} else {
			return false;
		}
	}

}