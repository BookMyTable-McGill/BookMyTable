package bookmytable.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookmytable.dao.ReservationRepository;
import bookmytable.dao.RestaurantOwnerRepository;
import bookmytable.dao.RestaurantRepository;
import bookmytable.model.Customer;
import bookmytable.model.Reservation;
import bookmytable.model.Restaurant;
import bookmytable.model.RestaurantOwner;

@Service
public class RestaurantOwnerRegistrationService {

	@Autowired 
	private RestaurantOwnerRepository restaurantOwnerRepository;

	@Autowired
	private RestaurantRepository restaurantRepository;
	  
	@Transactional 
	public RestaurantOwner registerRestaurantOwner(String name, String password, String email) {
		String error = " ";
//		if(restaurantOwnerRepository.findRestaurantOwnerById(id) != null) {
//			error = "Restaurant Owner already exists.";
//			throw new IllegalArgumentException(error);
//		}else if(restaurantOwnerRepository.findRestaurantOwnerByEmail(email) != null) {
//			error = "This email is already used by another restaurant owner.";
//			throw new IllegalArgumentException(error);
//		}
		
		RestaurantOwner owner = new RestaurantOwner();
		owner.setEmail(email);
		//owner.setId(id);
		owner.setName(name);
		owner.setPassword(password);
		owner.setRestaurants(null);
		restaurantOwnerRepository.save(owner);
		return owner;
	}
	
	@Transactional
	public RestaurantOwner modifyRestaurantOwner(Long ownerID, String name, String email, String password) {
		RestaurantOwner owner = getRestaurantOwnerById(ownerID);  	
		
		  	name = name.trim();
		    email = email.trim();
		    password = password.trim();
		   
		    
		    if (name == null || name.compareTo("")==0
		        || email == null || email.compareTo("")==0
		        || password == null || password.compareTo("")==0) {
		      throw new IllegalArgumentException("Missing Information");
		    }
		    
		    if (!CustomerRegistrationService.validateEmail(email)) {
		      throw new IllegalArgumentException("Invalid Email");
		    }
		    
		    if (password.length() < 6) {
		      throw new IllegalArgumentException("Invalid Password");
		    }

		   
		    if(owner.getEmail().equalsIgnoreCase(email) == false) {
		    	RestaurantOwner emailCheck = restaurantOwnerRepository.findRestaurantOwnerByEmail(email);
		 	    if (emailCheck != null) {
		 	      throw new IllegalArgumentException("An account with this email already exists");
		 	    }
		 	    
		 	    owner.setEmail(email);
		 	    
		    }
		    
		    if(owner.getName().equalsIgnoreCase(name) == false) {
		    	owner.setName(name);
		    }
		    
		    if(owner.getPassword().equals(password) == false) {
		    	owner.setPassword(password);
		    }
		    
		    
		    
		    restaurantOwnerRepository.save(owner);
		    
		    return owner;
		    
	}
	
	@Transactional
	public RestaurantOwner deleteRestaurantOwner(long id) {
		if (id == 0) {
			throw new IllegalArgumentException("Id is empty");
		}

		RestaurantOwner restoOwner = restaurantOwnerRepository.findRestaurantOwnerById(id);

		if (restoOwner == null) {
			throw new IllegalArgumentException("No restaurant owner with this id was found");
		}

		Set<Restaurant> restaurants = restoOwner.getRestaurants();
		if (restaurants != null) {
			for (Restaurant r : restaurants) {
				restaurantRepository.delete(r);
			}
		}
		
		restoOwner.setRestaurants(null);

		restaurantOwnerRepository.delete(restoOwner);
		return restoOwner;
	}
	
	@Transactional
	  public RestaurantOwner getRestaurantOwnerById(long id) {
	    if (id == 0) {
	      throw new IllegalArgumentException("Id is empty");
	    }
	    
	    RestaurantOwner owner = restaurantOwnerRepository.findRestaurantOwnerById(id);
	    
	    if (owner == null) {
	      throw new IllegalArgumentException("No customer with this id was found");
	    }
	    
	    return owner;
	  }
	
	@Transactional
	public List<RestaurantOwner> getRestaurantOwners() {
	  return toList(restaurantOwnerRepository.findAll());
	}
	
	//Helper method to retrieve lists of objects
	  private <T> List<T> toList(Iterable<T> iterable) {
	      List<T> resultList = new ArrayList<T>();
	      for (T t : iterable) {
	          resultList.add(t);
	      }
	      return resultList;
	  }
	  
	  @Transactional
		public void deleteOwnRestaurantOwnerAccount(RestaurantOwner ro, String password) {
			if (ro == null) {
				throw new IllegalArgumentException("Restaurant Owner is null");
			}

			if (password == null) {
				throw new IllegalArgumentException("Restaurant Owner password was not provided");
			}

			if (!ro.getPassword().equals(password)) {
				throw new IllegalArgumentException("Incorrect password");
			}

			Set<Restaurant> restaurants = ro.getRestaurants();
			if (restaurants != null) {
				for (Restaurant restaurant : restaurants) {
					restaurantRepository.delete(restaurant);
				}
			}

			restaurantOwnerRepository.delete(ro);

		}
}
