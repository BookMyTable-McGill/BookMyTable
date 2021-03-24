package bookmytable.service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookmytable.dao.FoodRepository;
import bookmytable.dao.RestaurantOwnerRepository;
import bookmytable.dao.RestaurantRepository;
import bookmytable.dao.TableRepository;
import bookmytable.model.Admin;
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
	@Autowired
	RestaurantOwnerRepository ownerRepository;

	private Food food;

	@Transactional
	public Restaurant createRestaurant(String name, String address, Time[][] hours, RestaurantOwner owner,
			int estDuration, String menuLink, int price, String cuisine, String options) {

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
			if (r.getName().equals(name) && r.getAddress().equals(address)) {
				throw new IllegalArgumentException(
						"A restaurant with name " + name + " and address " + address + " already exists.");
			}
		}

		Restaurant restaurant = new Restaurant();
		Set<RestaurantTable> map = new HashSet<RestaurantTable>(); // Empty map

		// restaurant.setId(446223); //need to randomize
		// postgres declare this colum as unique id.
		restaurant.setAddress(address);
		restaurant.setName(name);
		restaurant.setOpeningHours(hours);
		restaurant.setEstimatedDuration(estDuration);

		restaurant.setRestaurantOwner(owner);
		restaurant.setMap(map); // setting empty map
		if (owner.getRestaurants() != null) {
			Set<Restaurant> ownerRestaurants = owner.getRestaurants();
			ownerRestaurants.add(restaurant);
		} else {
			Set<Restaurant> newRestaurants = new HashSet<Restaurant>();
			newRestaurants.add(restaurant);
			owner.setRestaurants(newRestaurants);
		}

		restaurant.setIsBooked(false);

		Set<Reservation> restaurantReservations = new HashSet<Reservation>();
		restaurant.setReservations(restaurantReservations);

		ownerRepository.save(owner);
		restaurantRepository.save(restaurant);
		// getRestaurantByAddress(restaurant.getAddress()).setFood(createFood(menuLink,
		// price,cuisine,options,restaurant));
		restaurant.setFood(createFood(menuLink, price, cuisine, options, restaurant));
		// food.setRestaurant(restaurant);

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
		// food.setId(2); //need to randomize
		// food.setRestaurant(restaurant);

		foodRepository.save(food);
		this.food = food;

		return food;
	}

	@Transactional
	public RestaurantTable addTableToMap(int capacity, int tableNumber, int xCoordinate, int yCoordinate,
			Restaurant restaurant) {

		RestaurantTable restaurantTable = new RestaurantTable();
		restaurantTable.setCapacity(capacity);
		restaurantTable.setTableNumber(tableNumber);
		restaurantTable.setX(xCoordinate);
		restaurantTable.setY(yCoordinate);
		restaurantTable.setRestaurant(restaurant);
		tableRepository.save(restaurantTable);
		restaurant.getMap().add(restaurantTable);
		return restaurantTable;
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

	@Transactional
	public Restaurant modifyRestaurantMenu(Restaurant aRestaurant, String newMenuLink) {

		if (aRestaurant == null) {

			throw new IllegalArgumentException("Restaurant is null");
		}

		if (newMenuLink == null) {

			throw new IllegalArgumentException("newMenuLink is null");
		}

		Food aFood = aRestaurant.getFood();
		aFood.setMenuLink(newMenuLink);
		foodRepository.save(aFood);

		return aRestaurant;

	}

	@Transactional
	public Restaurant modifyRestaurantName(Restaurant aRestaurant, String newName) {

		if (aRestaurant == null) {

			throw new IllegalArgumentException("Restaurant is null");
		}

		if (newName == null) {

			throw new IllegalArgumentException("newName is null");
		}

		aRestaurant.setName(newName);
		restaurantRepository.save(aRestaurant);

		return aRestaurant;
	}

	@Transactional
	public Restaurant modifyRestaurantType(Restaurant aRestaurant, String newType) {

		if (aRestaurant == null) {

			throw new IllegalArgumentException("Restaurant is null");
		}

		if (newType == null) {

			throw new IllegalArgumentException("newType is null");
		}

		Food aFood = aRestaurant.getFood();
		aFood.setCuisine(newType);
		foodRepository.save(aFood);

		return aRestaurant;
	}

	@Transactional
	public Restaurant modifyRestaurantPrice(Restaurant aRestaurant, int newPrice) {

		if (aRestaurant == null) {

			throw new IllegalArgumentException("Restaurant is null");
		}

		if (newPrice <= 0)
			throw new IllegalArgumentException("You cannot enter a negative or zero price");

		if (newPrice > 3)
			throw new IllegalArgumentException("You cannot enter a price value higher than 3");

		Food aFood = aRestaurant.getFood();
		aFood.setPrice(newPrice);
		foodRepository.save(aFood);

		return aRestaurant;

	}

	@Transactional
	public Restaurant modifyRestaurantFoodOption(Restaurant aRestaurant, String newFoodOption) {

		if (aRestaurant == null) {

			throw new IllegalArgumentException("Restaurant is null");
		}

		if (newFoodOption == null) {

			throw new IllegalArgumentException("newFoodOption is null");
		}

		Food aFood = aRestaurant.getFood();
		aFood.setOptions(newFoodOption);
		foodRepository.save(aFood);

		return aRestaurant;

	}

	@Transactional
	public Restaurant modifyRestaurantLocation(Restaurant aRestaurant, String newLocation) {

		if (aRestaurant == null) {

			throw new IllegalArgumentException("Restaurant is null");
		}

		if (newLocation == null) {

			throw new IllegalArgumentException("location is null");
		}

		aRestaurant.setAddress(newLocation);
		restaurantRepository.save(aRestaurant);

		return aRestaurant;

	}

	@Transactional
	public Restaurant modifyRestaurantHours(Restaurant aRestaurant, Time[][] newTime) {

		if (aRestaurant == null) {

			throw new IllegalArgumentException("Restaurant is null");
		}

		if (newTime == null) {

			throw new IllegalArgumentException("Hours is null");
		}

		aRestaurant.setOpeningHours(newTime);
		restaurantRepository.save(aRestaurant);

		return aRestaurant;
	}

	@Transactional
	public Restaurant AddPhoto(Restaurant restaurant, String photoLink) {

		if (restaurant == null) {
			throw new IllegalArgumentException("Restaurant doesn't exist");
		}

		if (photoLink.isBlank() || photoLink.isEmpty()) {
			throw new IllegalArgumentException("No link was provided");
		}

		if (restaurant.getPhotos() == null) {
			String[] photos = new String[1];
			photos[0] = photoLink;
			restaurant.setPhotos(photos);
		} else {
			String[] photos = restaurant.getPhotos();
			String[] newPhotos = new String[photos.length + 1];
			System.arraycopy(photos, 0, newPhotos, 0, photos.length);
			newPhotos[newPhotos.length - 1] = photoLink;
			restaurant.setPhotos(newPhotos);
		}
		restaurantRepository.save(restaurant);

		return restaurant;
	}

	@Transactional
	public Restaurant AddPhotos(Restaurant restaurant, String[] photos) {
		if (restaurant == null) {
			throw new IllegalArgumentException("Restaurant doesn't exist");
		}

		if (photos == null) {
			throw new IllegalArgumentException("No links were provided");
		}

		if (restaurant.getPhotos() == null) {
			restaurant.setPhotos(photos);
		} else {
			String[] savedPhotos = restaurant.getPhotos();
			String[] newPhotos = new String[savedPhotos.length + photos.length];
			System.arraycopy(savedPhotos, 0, newPhotos, 0, savedPhotos.length);
			System.arraycopy(photos, 0, newPhotos, savedPhotos.length, photos.length);
			restaurant.setPhotos(newPhotos);
		}

		restaurantRepository.save(restaurant);

		return restaurant;
	}

	@Transactional
	public void deleteRestaurant(Restaurant restaurant, String ownerEmail, String ownerPassword) {
		if (restaurant == null) {
			throw new IllegalArgumentException("Restaurant doesn't exist");
		}

		if (ownerEmail == null) {
			throw new IllegalArgumentException("Owner email was not provided");
		}

		if (ownerPassword == null) {
			throw new IllegalArgumentException("Owner password was not provided");
		}

		RestaurantOwner restaurantOwner = ownerRepository.findRestaurantOwnerByEmail(ownerEmail);
		if (restaurantOwner == null) {
			throw new IllegalArgumentException("No RestaurantOwner account is associated to this email address");
		}

		if (!restaurantOwner.getPassword().equals(ownerPassword)) {
			throw new IllegalArgumentException("Incorrect password");
		}

		if (!restaurantOwner.getRestaurants().contains(restaurant)) {
			throw new IllegalArgumentException("This account is not the owner of the restaurant");
		}

		Food food = restaurant.getFood();
		foodRepository.delete(food);

		Set<RestaurantTable> tables = restaurant.getMap();
		for (RestaurantTable table : tables) {
			tableRepository.delete(table);
		}

		restaurantRepository.delete(restaurant);

	}

	@Transactional 
	public List<Restaurant> getRestaurantsWithLeastReservations() {
		List<Restaurant> restaurants = getAllRestaurants();
		
		// Sort (Bubble):
        int n = restaurants.size(); 
        for (int i = 0; i < n-1; i++)  {
            for (int j = 0; j < n-i-1; j++) { 
                if (restaurants.get(j).getReservations().size() > restaurants.get(j+1).getReservations().size()) 
                { 
                    // swap restaurants[j+1] and restaurants[j] 
                    Restaurant temp = restaurants.get(j); 
                    restaurants.set(j, restaurants.get(j+1));
                    restaurants.set(j+1, temp);
                } 
            }
        }
	
        // Get the first 10 (or less)
		return restaurants.subList(0, Math.min(10, restaurants.size()));

	}
	
	
	@Transactional
	public List<Restaurant> getFeaturedRestaurants(){
		
		List<Restaurant> featuredRestaurants = getAllRestaurants();
		
		
		//bubble sort
		  int n = featuredRestaurants.size(); 
	        for (int i = 0; i < n-1; i++)  {
	            for (int j = 0; j < n-i-1; j++) { 
	                if (featuredRestaurants.get(j).getReservations().size() < featuredRestaurants.get(j+1).getReservations().size()) 
	                { 
	                    // swap restaurants[j+1] and restaurants[j] 
	                    Restaurant temp = featuredRestaurants.get(j); 
	                    featuredRestaurants.set(j, featuredRestaurants.get(j+1));
	                    featuredRestaurants.set(j+1, temp);
	                } 
	            }
	        }
		
	        // Get the first 10 (or less)
			return featuredRestaurants.subList(0, Math.min(10, featuredRestaurants.size()));

		
		
		
	}

}
