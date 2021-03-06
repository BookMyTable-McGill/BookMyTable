package bookmytable.controller;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bookmytable.dao.RestaurantRepository;
import bookmytable.dto.FoodDTO;
import bookmytable.dto.RestaurantDTO;
import bookmytable.model.Food;
import bookmytable.model.Restaurant;
import bookmytable.model.RestaurantOwner;
import bookmytable.service.RestaurantOwnerLoginService;
import bookmytable.service.RestaurantService;

@CrossOrigin(origins = "*")
@RestController
public class RestaurantCreationController {
	
	@Autowired
	public RestaurantOwnerLoginService restaurantOwnerLoginService;
	
	@Autowired
	public RestaurantService restaurantService;
	
	@PostMapping(value = { "/restaurant/createRestaurant", "/restaurant/createRestaurant/" })
	public RestaurantDTO createRestaurant(@RequestParam(name = "name") String name, @RequestParam(name = "address") String address, 
									@RequestParam(name = "hours") String[] hours, @RequestParam(name = "owner") String restaurantOwnerEmail,
									@RequestParam(name = "estDuration") int estDuration, @RequestParam(name = "menuLink") String menuLink,
									@RequestParam(name = "price") int price, @RequestParam(name = "cuisine") String cuisine,
									@RequestParam(name = "options") String options) {
		
		Time[][] timeHours = new Time[7][2];
		int j = 0;
		int w = 0;
		for (int i = 0; i < hours.length; i++) {
			timeHours[w][j] = Time.valueOf(hours[i]);
			System.out.println(timeHours[w][j]);
			if (j == 0) {
				j = 1;
			}
			else {
				j = 0;
				w++;
			}
		}		
		
		RestaurantOwner restaurantOwner = restaurantOwnerLoginService.getRestaurantOwnerByEmail(restaurantOwnerEmail);
		Restaurant restaurant = restaurantService.createRestaurant(name, address, timeHours, restaurantOwner, estDuration, menuLink, price, cuisine, options);
		return Converters.convertToDto(restaurant);
		
	}
	
	@PostMapping(value = { "/restaurant/createFood", "/restaurant/createFood/"}) 
	public FoodDTO createFood(@RequestParam(name = "menuLink") String menuLink, @RequestParam(name = "price") int price,
								@RequestParam(name = "cuisine") String cuisine, @RequestParam(name = "options") String options, @RequestParam(name = "restaurantAddress") String restaurantAddress ) {
		
		Restaurant restaurant = restaurantService.getRestaurantByAddress(restaurantAddress);
		Food food = restaurantService.createFood(menuLink, price, cuisine, options, restaurant);
		return Converters.convertToDto(food);
		
	}
	
	@PostMapping(value = { "/restaurant/addTable", "/restaurant/addTable/"})
	public void addTableToMap(@RequestParam(name = "capacity") int capacity, @RequestParam(name = "tableNumber") int tableNumber,
							@RequestParam(name = "xCoordinate") int xCoordinate, @RequestParam(name = "yCoordinate") int yCoordinate,
							@RequestParam(name = "restaurantAddress") String restaurantAddress) {
		
		Restaurant restaurant = restaurantService.getRestaurantByAddress(restaurantAddress);
		restaurantService.addTableToMap(capacity, tableNumber, xCoordinate, yCoordinate, restaurant);
	}
	
	@GetMapping(value = { "/restaurants", "/restaurants/"})
	public List<RestaurantDTO> getAllRestaurants() {
		List<Restaurant> restaurants = restaurantService.getAllRestaurants();
		List<RestaurantDTO> restaurantDTOs = new ArrayList<RestaurantDTO>();
		for (Restaurant r : restaurants) {
			restaurantDTOs.add(Converters.convertToDto(r));
		}
		return restaurantDTOs;
	}
	
	@GetMapping(value = { "/restaurantByName", "/restaurantByName/"}) 
	public List<RestaurantDTO> getRestaurantByName(@RequestParam(name = "name") String name) {
		List<Restaurant> restaurants = restaurantService.getRestaurantsByName(name);
		List<RestaurantDTO> restaurantDTOs = new ArrayList<RestaurantDTO>();
		for (Restaurant r : restaurants) {
			restaurantDTOs.add(Converters.convertToDto(r));
		}
		return restaurantDTOs;
	}

	@GetMapping(value = { "/restaurantsByNameContains", "/restaurantsByNameContains/"})
	public List<RestaurantDTO> getRestaurantsByNameContains(@RequestParam(name = "nameFragment") String nameFragment) {
		List<Restaurant> restaurants = restaurantService.getRestaurantByNameContains(nameFragment);
		List<RestaurantDTO> restaurantDTOs = new ArrayList<RestaurantDTO>();
		for (Restaurant r : restaurants) {
			restaurantDTOs.add(Converters.convertToDto(r));
		}
		return restaurantDTOs;
	}
	
	@GetMapping(value = { "/restaurantByAddress", "/restaurantByAddress/" })
	public RestaurantDTO getRestaurantByAddress(@RequestParam(name = "address") String address) {
		Restaurant restaurant = restaurantService.getRestaurantByAddress(address);
		return Converters.convertToDto(restaurant);
	}
	
	@GetMapping(value = { "/restaurantsByAddressContains", "/restaurantsByAddressContains/"})
	public List<RestaurantDTO> getRestaurantsByAddressContains(@RequestParam(name = "addressFragment") String addressFragment) {
		List<Restaurant> restaurants = restaurantService.getRestaurantByAddressContains(addressFragment);
		List<RestaurantDTO> restaurantDTOs = new ArrayList<RestaurantDTO>();
		for (Restaurant r : restaurants) {
			restaurantDTOs.add(Converters.convertToDto(r));
		}
		return restaurantDTOs;
	}
	
	@PostMapping(value = { "/restaurant/modifyRestaurantMenu", "/restaurant/modifyRestaurantMenu/" })
	public RestaurantDTO modifyRestaurantMenu(@RequestParam(name = "menuLink") String menuLink, @RequestParam(name = "address") String address) {
		Restaurant restaurant = restaurantService.getRestaurantByAddress(address);
		restaurant = restaurantService.modifyRestaurantMenu(restaurant, menuLink);
		return Converters.convertToDto(restaurant);
	}
	
	@PostMapping(value = { "/restaurant/modifyRestaurantType", "/restaurant/modifyRestaurantType/" })
	public RestaurantDTO modifyRestaurantType(@RequestParam(name = "type") String type, @RequestParam(name = "address") String address) {
		Restaurant restaurant = restaurantService.getRestaurantByAddress(address);
		restaurant = restaurantService.modifyRestaurantType(restaurant, type);
		return Converters.convertToDto(restaurant);
	}
	
	@PostMapping(value = { "/restaurant/modifyRestaurantPrice", "/restaurant/modifyRestaurantPrice/" })
	public RestaurantDTO modifyRestaurantPrice(@RequestParam(name = "price") String price, @RequestParam(name = "address") String address) {
		Restaurant restaurant = restaurantService.getRestaurantByAddress(address);
		restaurant = restaurantService.modifyRestaurantPrice(restaurant, Integer.parseInt(price));
		return Converters.convertToDto(restaurant);
	}
	
	@PostMapping(value = { "/restaurant/modifyRestaurantFoodOption", "/restaurant/modifyRestaurantFoodOption/" })
	public RestaurantDTO modifyRestaurantFoodOption(@RequestParam(name = "foodOption") String foodOption, @RequestParam(name = "address") String address) {
		Restaurant restaurant = restaurantService.getRestaurantByAddress(address);
		restaurant = restaurantService.modifyRestaurantFoodOption(restaurant, foodOption);
		return Converters.convertToDto(restaurant);
	}
	
	@PostMapping(value = { "/restaurant/modifyRestaurantLocation", "/restaurant/modifyRestaurantLocation/" })
	public RestaurantDTO modifyRestaurantLocation(@RequestParam(name = "location") String location, @RequestParam(name = "address") String address) {
		Restaurant restaurant = restaurantService.getRestaurantByAddress(address);
		restaurant = restaurantService.modifyRestaurantLocation(restaurant, location);
		return Converters.convertToDto(restaurant);
	}
	

	
	
	
	

}
