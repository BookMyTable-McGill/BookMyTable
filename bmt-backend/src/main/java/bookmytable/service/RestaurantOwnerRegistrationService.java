package bookmytable.service;

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
	public RestaurantOwner registerRestaurantOwner(String name, String password, String email, long id) {
		String error = " ";
		if(restaurantOwnerRepository.findRestaurantOwnerById(id) != null) {
			error = "Restaurant Owner already exists.";
			throw new IllegalArgumentException(error);
		}else if(restaurantOwnerRepository.findRestaurantOwnerByEmail(email) != null) {
			error = "This email is already used by another restaurant owner.";
			throw new IllegalArgumentException(error);
		}
		
		RestaurantOwner owner = new RestaurantOwner();
		owner.setEmail(email);
		owner.setId(id);
		owner.setName(name);
		owner.setPassword(password);
		
		return owner;
	}
}
