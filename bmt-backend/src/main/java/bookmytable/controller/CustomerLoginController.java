package bookmytable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bookmytable.dto.CustomerDTO;
import bookmytable.model.Customer;
import bookmytable.service.CustomerLoginService;

@CrossOrigin(origins = "*")
@RestController
public class CustomerLoginController {

	@Autowired
	private CustomerLoginService customerLoginService;

	@PostMapping(value = { "/customer/login", "/customer/login/" })
	private CustomerDTO customerLogin(@RequestParam(name = "password") String password,
			@RequestParam(name = "email") String email) {
		Customer customer = customerLoginService.getCustomerByEmail(email);
		if (customer != null) {
			if (customer.getPassword().equals(password)) {
				return Converters.convertToDto(customer);
			} else {
				throw new IllegalArgumentException("Password entered is incorrect.");
			}
		} else {
			throw new IllegalArgumentException("Email entered is incorrect.");
		}
	}

	@PostMapping(value = { "/customer/logout", "/customer/logout/" })
	private CustomerDTO customerLogout(@RequestBody CustomerDTO cDto) {
		Customer customer = customerLoginService.getCustomerById(cDto.getId());
		if (customer == null) {
			throw new IllegalArgumentException("There is no such customer with id " + cDto.getId());
		} else {
			return Converters.convertToDto(customer);
		}
	}
}