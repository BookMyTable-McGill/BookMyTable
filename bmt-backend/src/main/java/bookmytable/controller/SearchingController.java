package bookmytable.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import bookmytable.dao.FoodRepository;
import bookmytable.dao.RestaurantRepository;
import bookmytable.dto.RestaurantDTO;
import bookmytable.dto.RestaurantOwnerDTO;
import bookmytable.model.Restaurant;
import bookmytable.service.SearchingSerivce;

@CrossOrigin(origins = "*")
@RestController
public class SearchingController {
  
  @Autowired
  SearchingSerivce searchingService;

  @Autowired
  RestaurantRepository restaurantRepository;
  
  @Autowired
  FoodRepository foodRepository;
  
  @GetMapping(value = {"/restaurants/price", "/restaurants/price/"})
  public List<RestaurantDTO> getRestaurantsByPrice(@RequestParam(name = "price") int price) {
    List<Restaurant> restaurants = searchingService.getRestaurantsByPrice(price);
    List<RestaurantDTO> restaurantDTOs = new ArrayList<RestaurantDTO>();
    for (Restaurant r : restaurants) {
      restaurantDTOs.add(Converters.convertToDto(r));
    }
    return restaurantDTOs;
  }
  
  @GetMapping(value = {"/restaurants/price/range", "/restaurants/price/range/"})
  public List<RestaurantDTO> getRestaurantsByPriceRange(@RequestParam(name = "minPrice") int minPrice,
      @RequestParam(name = "maxPrice") int maxPrice) {
    List<Restaurant> restaurants = searchingService.getRestaurantsByPriceRange(minPrice, maxPrice);
    List<RestaurantDTO> restaurantDTOs = new ArrayList<RestaurantDTO>();
    for (Restaurant r : restaurants) {
      restaurantDTOs.add(Converters.convertToDto(r));
    }
    return restaurantDTOs;
  }
  
  @GetMapping(value = {"/restaurants/cuisine", "/restaurants/cuisine/"})
  public List<RestaurantDTO> getRestaurantsByCuisine(@RequestParam(name = "cuisine") String cuisine) {
    List<Restaurant> restaurants = searchingService.getRestaurantsByCuisine(cuisine);
    List<RestaurantDTO> restaurantDTOs = new ArrayList<RestaurantDTO>();
    for (Restaurant r : restaurants) {
      restaurantDTOs.add(Converters.convertToDto(r));
    }
    return restaurantDTOs;
  }
  
  @GetMapping(value = {"/restaurants/options", "/restaurants/options/"})
  public List<RestaurantDTO> getRestaurantsByOptions(@RequestParam(name = "options") String options) {
    List<Restaurant> restaurants = searchingService.getRestaurantsByOptions(options);
    List<RestaurantDTO> restaurantDTOs = new ArrayList<RestaurantDTO>();
    for (Restaurant r : restaurants) {
      restaurantDTOs.add(Converters.convertToDto(r));
    }
    return restaurantDTOs;
  }
  
  @GetMapping(value = {"/restaurants/filtered", "/restaurants/filtered/"})
  public List<RestaurantDTO> getFilteredRestaurants(@RequestParam(name = "name") String name,
      @RequestParam(name = "minPrice") int minPrice, @RequestParam(name = "maxPrice") int maxPrice,
      @RequestParam(name = "cuisine") String cuisine, @RequestParam(name = "options") String options) {
    List<Restaurant> restaurants = searchingService.getRestaurantsByAllFilters(name, minPrice, maxPrice, cuisine, options);
    List<RestaurantDTO> restaurantDTOs = new ArrayList<RestaurantDTO>();
    for (Restaurant r : restaurants) {
      restaurantDTOs.add(Converters.convertToDto(r));
    }
    return restaurantDTOs;
  }
}
