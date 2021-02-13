package bookmytable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bookmytable.dao.RestaurantOwnerRepository;
import bookmytable.dto.RestaurantOwnerDTO;
import bookmytable.model.RestaurantOwner;
import bookmytable.service.RestaurantOwnerRegistrationService;

@CrossOrigin(origins = "*")
@RestController
public class RestaurantOwnerRegistrationController {

	@Autowired
	public RestaurantOwnerRepository restaurantOwnerRepository;

	@Autowired
	public RestaurantOwnerRegistrationService restaurantOwnerRegistrationService;

	@PostMapping(value = { "/restaurantOwner/register", "/restaurantOwner/register/" })
	public RestaurantOwnerDTO registerRestaurantOwner(@RequestParam(name = "name") String name,
			@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
		RestaurantOwner restaurantOwner = restaurantOwnerRepository.findRestaurantOwnerByEmail(email);
		long id = 1234;
		if (restaurantOwner == null) {
			RestaurantOwner owner = restaurantOwnerRegistrationService.registerRestaurantOwner(name, password, email,
					id);
			return Converters.convertToDto(owner);
		} else {
			return null;
		}
	}

}
