package bookmytable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bookmytable.dto.*;
import bookmytable.model.*;
import bookmytable.service.*;

@CrossOrigin(origins = "*")
@RestController
public class BookMyTableController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	
	/**
	 * Creates a Restaurant
	 * @param rDTO The restaurant to be created
	 * @return The restaurant created converted to DTO
	 */
	@PostMapping(value = { "/restaurant/create", "/restaurant/create/"})
	private RestaurantDTO createRestaurant(@RequestBody RestaurantDTO rDTO) {
		
		
		return rDTO;
		
	}
}