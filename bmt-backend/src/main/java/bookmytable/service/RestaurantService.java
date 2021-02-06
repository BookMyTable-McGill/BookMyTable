package bookmytable.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookmytable.dao.FoodRepository;
import bookmytable.dao.RestaurantRepository;
import bookmytable.dao.TableRepository;
import bookmytable.model.Food;
import bookmytable.model.Table;
import bookmytable.model.Reservation;
import bookmytable.model.Restaurant;
import bookmytable.model.RestaurantOwner;

@Service
public class RestaurantService {
	
	@Autowired
	RestaurantRepository restaurantRepository;
	FoodRepository foodRepository;
	TableRepository tableRepository;
	
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
		
		
		Restaurant restaurant = new Restaurant();
		Set<Table> map = new HashSet<Table>(); //Empty map
		
		restaurant.setAddress(address);
		restaurant.setName(name);
		restaurant.setOpeningHours(hours);
		restaurant.setEstimatedDuration(estDuration);
		restaurant.setFood(createFood(menuLink, price,cuisine,options));
		restaurant.setRestaurantOwner(owner);
		restaurant.setMap(map); //setting empty map
		
		Set<Restaurant> ownerRestaurants = owner.getRestaurants();
		ownerRestaurants.add(restaurant);
		owner.setRestaurants(ownerRestaurants);
		
		restaurant.setIsBooked(false);
		
		Set<Reservation> restaurantReservations = new HashSet<Reservation>();
		restaurant.setReservations(restaurantReservations);
		
		restaurantRepository.save(restaurant);
		
		return restaurant;
		
	}
	
	@Transactional
	public Food createFood(String menuLink, int price, String cuisine, String options) {
		
		Food food = new Food();
		food.setCuisine(cuisine);
		food.setMenuLink(menuLink);
		food.setOptions(options);
		food.setPrice(price);
		
		foodRepository.save(food);
		
		return food;
	}
	
	@Transactional
	public void addTabletoMap(int capacity, int tableNumber, int xCoordinate, int yCoordinate, Restaurant restaurant){
	  
	  Table table = new Table();
	  table.setCapacity(capacity);
	  table.setTableNumber(tableNumber);
	  table.setX(xCoordinate);
	  table.setY(yCoordinate);
	  table.setRestaurant(restaurant);
	  tableRepository.save(table);
	  restaurant.getMap().add(table);
	}
	
}
