package bookmytable.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import bookmytable.dao.FoodRepository;
import bookmytable.dao.RestaurantRepository;
import bookmytable.model.Food;
import bookmytable.model.Restaurant;

@Service
public class SearchingSerivce {
    
  @Autowired
  RestaurantRepository restaurantRepository;
  @Autowired
  FoodRepository foodRepository;
  
  @Transactional
  public List<Restaurant> getRestaurantsByName(String name) {
    if (name == null) {
      throw new IllegalArgumentException("Please enter a restaurant name");
    }
    List<Restaurant> restaurants = restaurantRepository.findRestaurantsByNameIgnoreCase(name);
    return restaurants;
  }
  
  @Transactional
  public List<Restaurant> getRestaurantsByNameFragment(String nameFragment) {
    if (nameFragment == null) {
      throw new IllegalArgumentException("Please enter a restaurant name");
    }
    List<Restaurant> restaurants = restaurantRepository.findRestaurantsByNameContainsIgnoreCase(nameFragment);
    return restaurants;
  }
  
  @Transactional
  public List<Restaurant> getRestaurantsByPrice(int price) {
    if (price < 1 || price > 5) {
      throw new IllegalArgumentException("Please enter a valid price");
    }
    List<Food> foods = foodRepository.findFoodByPrice(price);
    List<Restaurant> restaurants = new ArrayList<Restaurant>();
    for (Food f : foods) {
      restaurants.add(f.getRestaurant());
    }
    return restaurants;
  }
  
  @Transactional
  public List<Restaurant> getRestaurantsByPriceRange(int minPrice, int maxPrice) {
    //TODO Tests need to make sure that between is inclusive; I can't find online whether it is
    if (minPrice < 1 || minPrice > 5 || maxPrice < 1 || maxPrice > 5) {
      throw new IllegalArgumentException("Please enter a valid price");
    }
    if (minPrice > maxPrice) {
      throw new IllegalArgumentException("Max price must be greater than min price");
    }
    List<Food> foods = foodRepository.findFoodByPriceBetween(minPrice, maxPrice);
    List<Restaurant> restaurants = new ArrayList<Restaurant>();
    for (Food f : foods) {
      restaurants.add(f.getRestaurant());
    }
    return restaurants;
  }
  
  @Transactional
  public List<Restaurant> getRestaurantsByCuisine(String cuisine) {
    if (cuisine == null) {
      throw new IllegalArgumentException("Please enter a cuisine type");
    }
    List<Food> foods = foodRepository.findFoodByCuisineIgnoreCase(cuisine);
    List<Restaurant> restaurants = new ArrayList<Restaurant>();
    for (Food f : foods) {
      restaurants.add(f.getRestaurant());
    }
    return restaurants;
  }
  
  @Transactional
  public List<Restaurant> getRestaurantsByOptions(String options) {
    if (options == null) {
      throw new IllegalArgumentException("Please enter desired food options");
    }
    List<Food> foods = foodRepository.findFoodByOptionsIgnoreCase(options);
    List<Restaurant> restaurants = new ArrayList<Restaurant>();
    for (Food f : foods) {
      restaurants.add(f.getRestaurant());
    }
    return restaurants;
  }
  
  /*
  @Transactional
  public List<Restaurant> getRestaurantsByAllFilters(String name, int minPrice, int maxPrice, String cuisine, String options) {
    if (name == null) {
      throw new IllegalArgumentException("Please enter resstaurant name");
    }
    if (minPrice < 1 || minPrice > 5 || maxPrice < 1 || maxPrice > 5) {
      throw new IllegalArgumentException("Please enter a valid price");
    }
    if (minPrice > maxPrice) {
      throw new IllegalArgumentException("Max price must be greater than min price");
    }
    if (cuisine == null) {
      throw new IllegalArgumentException("Please enter a cuisine type");
    }
    if (options == null) {
      throw new IllegalArgumentException("Please enter desired food options");
    }
    
    List<Restaurant> restaurants = restaurantRepository.findRestaurantsByNameContainsAndPriceBetweenAndCuisineAndOptionsAllIgnoreCase(name, minPrice, maxPrice, cuisine, options);
    return restaurants;
    
  }*/
}
