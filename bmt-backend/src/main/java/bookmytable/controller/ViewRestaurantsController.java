package bookmytable.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bookmytable.dto.RestaurantDTO;
import bookmytable.model.Restaurant;
import bookmytable.service.ViewRestaurantInfoService;
import bookmytable.service.ViewRestaurantsService;

@CrossOrigin(origins = "*")
@RestController
public class ViewRestaurantsController {

	@Autowired
	private ViewRestaurantsService viewRestaurantsService;

	@GetMapping(value = { "/getRestaurants", "/getRestaurants/" })
	public List<RestaurantDTO> getRestaurantByAddress(@RequestParam("address") String address) {
		List<Restaurant> restaurants = viewRestaurantsService.getAllRestaurants();
		List<RestaurantDTO> restaurantsDTO = new ArrayList<RestaurantDTO>();
		for (Restaurant r : restaurants) {
			restaurantsDTO.add(Converters.convertToDto(r));
		}
		return restaurantsDTO;
	}

}
