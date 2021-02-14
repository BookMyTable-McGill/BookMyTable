package bookmytable.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookmytable.dao.RestaurantOwnerRepository;
import bookmytable.model.RestaurantOwner;

@Service
public class RestaurantOwnerRegistrationService {

	@Autowired 
	private RestaurantOwnerRepository restaurantOwnerRepository;

	
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
}
