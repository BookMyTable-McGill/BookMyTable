package bookmytable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import bookmytable.dto.RestaurantOwnerDTO;
import bookmytable.model.RestaurantOwner;
import bookmytable.service.RestaurantOwnerLoginService;
import bookmytable.dao.RestaurantOwnerRepository;


@CrossOrigin(origins = "*")
@RestController
public class RestaurantOwnerLoginController {
	
	@Autowired
	public RestaurantOwnerRepository restaurantOwnerRepository;

	@Autowired 
	public RestaurantOwnerLoginService restaurantOwnerLoginService;
	    
	@PostMapping(value = { "/restaurantOwner/login", "/restaurantOwner/login/" })
		public boolean loginRestaurantOwner(@RequestParam(name = "email") String email,
				@RequestParam(name = "password") String password) {
		RestaurantOwner restaurantOwner = restaurantOwnerRepository.findRestaurantOwnerByEmail(email);
			if (restaurantOwner != null) {
				return restaurantOwnerLoginService.loginRestaurantOwner(restaurantOwner, password);
			} else {
				return false;
			}
		}

	}
