package bookmytable.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookmytable.dao.CustomerRepository;
import bookmytable.dao.RestaurantRepository;
import bookmytable.model.Customer;
import bookmytable.model.Restaurant;

@Service
public class FavoriteRestaurantService {
  
  @Autowired
  CustomerRepository customerRepository;
  @Autowired
  RestaurantRepository restaurantRepository;
  
  @Transactional
  public Restaurant addRestaurantToFavorites(String customerEmail, long restoID) {
    if (customerEmail == null) {
      throw new IllegalArgumentException("customerEmail is null");
    }
    
    Customer customer = customerRepository.findCustomerByEmail(customerEmail);
    if (customer == null) {
      throw new IllegalArgumentException("No account with this email was found");
    }
    
    Restaurant restaurant = restaurantRepository.findRestaurantById(restoID);
    if (restaurant == null) {
      throw new IllegalArgumentException("No restaurant with this id was found");
    }
    
    Set<Restaurant> favorites = customer.getFavoriteRestaurants();
    if(favorites == null) {
    	favorites = new HashSet<Restaurant>();
    }
    favorites.add(restaurant);
    customer.setFavoriteRestaurants(favorites);
    customerRepository.save(customer);
    
    return restaurant;
  }
  
  @Transactional
  public Restaurant removeRestaurantFromFavorites(String customerEmail, long restoID) {
    if (customerEmail == null) {
      throw new IllegalArgumentException("customerEmail is null");
    }
    
    Customer customer = customerRepository.findCustomerByEmail(customerEmail);
    if (customer == null) {
      throw new IllegalArgumentException("No account with this email was found");
    }
    
    Restaurant restaurant = restaurantRepository.findRestaurantById(restoID);
    if (restaurant == null) {
      throw new IllegalArgumentException("No restaurant with this id was found");
    }
    
    Set<Restaurant> favorites = customer.getFavoriteRestaurants();
    favorites.remove(restaurant);
    customer.setFavoriteRestaurants(favorites);
    customerRepository.save(customer);
    
    return restaurant;
  }
  
  @Transactional
  public List<Restaurant> viewFavoriteRestaurants(String customerEmail) {
    if (customerEmail == null) {
      throw new IllegalArgumentException("customerEmail is null");
    }
    
    Customer customer = customerRepository.findCustomerByEmail(customerEmail);
    if (customer == null) {
      throw new IllegalArgumentException("No account with this email was found");
    }
    
    Set<Restaurant> favorites = customer.getFavoriteRestaurants();
    return toList(favorites);
  }
  
  private <T> List<T> toList(Iterable<T> iterable) {
    List<T> resultList = new ArrayList<T>();
    for (T t : iterable) {
        resultList.add(t);
    }
    return resultList;
}
}
