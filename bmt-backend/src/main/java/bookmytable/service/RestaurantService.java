package bookmytable.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookmytable.dao.FoodRepository;
import bookmytable.dao.RestaurantRepository;
import bookmytable.dao.TableRepository;
import bookmytable.model.Food;
import bookmytable.model.RestaurantTable;
import bookmytable.model.Reservation;
import bookmytable.model.Restaurant;
import bookmytable.model.RestaurantOwner;

@Service
public class RestaurantService {
	
	@Autowired
	RestaurantRepository restaurantRepository;
	@Autowired
	FoodRepository foodRepository;
	@Autowired
	TableRepository tableRepository;
	
	private Food food;
	
	@Transactional
	public Restaurant createRestaurant( String name, String address, int[][] hours, RestaurantOwner owner, int estDuration, String menuLink, int price, String cuisine, String options) {
		
		if (price <= 0)
			throw new IllegalArgumentException("You cannot enter a negative or zero price");
		
		if (price > 3)
			throw new IllegalArgumentException("You cannot enter a price value higher than 3");
		
		if (price < 0)
			throw new IllegalArgumentException("You cannot enter a negative price");
		
		if (name == null)
			throw new IllegalArgumentException("You need to enter restaurant name");
		
		if (address == null)
			throw new IllegalArgumentException("You need to enter restaurant address");
		
		if (hours == null)
			throw new IllegalArgumentException("You need to enter restaurant opening hours");
		
		if (estDuration <= 0)
			throw new IllegalArgumentException("You need to enter a valid restaurant estimated stay duration");
		
		if (menuLink == null)
			throw new IllegalArgumentException("You need to add the restaurant menu");
		
		if (cuisine == null)
			throw new IllegalArgumentException("You need to specify the type of cuisine of the restaurant");
		
		if (options == null)
			throw new IllegalArgumentException("You need to enter specify the food options of the restaurant");
		
		List<Restaurant> restaurants = getAllRestaurants();
		for (Restaurant r : restaurants) {
			if(r.getName().equals(name) && r.getAddress().equals(address)) {
				throw new IllegalArgumentException("A restaurant with name " + name + " and address " + address + " already exists.");
			}
		}
		
		Restaurant restaurant = new Restaurant();
		Set<RestaurantTable> map = new HashSet<RestaurantTable>(); //Empty map
		
		//restaurant.setId(446223); //need to randomize
		//postgres declare this colum as unique id.
		restaurant.setAddress(address);
		restaurant.setName(name);
		restaurant.setOpeningHours(hours);
		restaurant.setEstimatedDuration(estDuration);
		
		restaurant.setRestaurantOwner(owner);
		restaurant.setMap(map); //setting empty map
		if(owner.getRestaurants() !=null) {
		Set<Restaurant> ownerRestaurants = owner.getRestaurants();
		ownerRestaurants.add(restaurant);
		}else {
			Set<Restaurant> newRestaurants = new HashSet<Restaurant>();
			newRestaurants.add(restaurant);
			owner.setRestaurants(newRestaurants);
		}
		
		
		restaurant.setIsBooked(false);
		
		Set<Reservation> restaurantReservations = new HashSet<Reservation>();
		restaurant.setReservations(restaurantReservations);
		
		restaurantRepository.save(restaurant);
		restaurant.setFood(createFood(menuLink, price,cuisine,options,restaurant));
		//food.setRestaurant(restaurant);
		
		return restaurant;
		
	}
	
	@Transactional
	public Food createFood(String menuLink, int price, String cuisine, String options, Restaurant aRestaurant) {
		
		Food food = new Food();
		food.setCuisine(cuisine);
		food.setMenuLink(menuLink);
		food.setOptions(options);
		food.setPrice(price);
		food.setRestaurant(aRestaurant);
		//food.setId(2); //need to randomize
		//food.setRestaurant(restaurant);
		
		
		foodRepository.save(food);
		this.food = food;
		
		return food;
	}
	
	@Transactional
	public void addTableToMap(int capacity, int tableNumber, int xCoordinate, int yCoordinate, Restaurant restaurant){
	  
	  RestaurantTable restaurantTable = new RestaurantTable();
	  restaurantTable.setCapacity(capacity);
	  restaurantTable.setTableNumber(tableNumber);
	  restaurantTable.setX(xCoordinate);
	  restaurantTable.setY(yCoordinate);
	  restaurantTable.setRestaurant(restaurant);
	  tableRepository.save(restaurantTable);
	  restaurant.getMap().add(restaurantTable);
	}
	
	@Transactional
	public Restaurant getRestaurantById(long id) {
		return restaurantRepository.findRestaurantById(id);
	}
	
	@Transactional 
	public List<Restaurant> getAllRestaurants() {
		return toList(restaurantRepository.findAll());
	}
	
	@Transactional
	public List<Restaurant> getRestaurantsByName(String name) {
		return restaurantRepository.findRestaurantsByNameIgnoreCase(name);
	}
	
	@Transactional
	public List<Restaurant> getRestaurantByNameContains(String nameFragment) {
		return restaurantRepository.findRestaurantsByNameContainsIgnoreCase(nameFragment);
	}
	
	@Transactional
	public Restaurant getRestaurantByAddress(String address) {
		return restaurantRepository.findRestaurantByAddress(address);
	}
	
	@Transactional
	public List<Restaurant> getRestaurantByAddressContains(String addressFragment) {
		return restaurantRepository.findRestaurantsByAddressContains(addressFragment);
	}
	
	private <T> List<T> toList(Iterable<T> iterable) {
        List<T> resultList = new ArrayList<T>();
        for (T t : iterable) {
            resultList.add(t);
        }
        return resultList;
    }
	
	
}
