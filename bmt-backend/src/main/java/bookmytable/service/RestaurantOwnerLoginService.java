package bookmytable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import bookmytable.model.*;
import bookmytable.dao.*;

@Service 
public class RestaurantOwnerLoginService {

@Autowired 
private RestaurantOwnerRepository restaurantOwnerRepository;


@Transactional 
public boolean loginRestaurantOwner(RestaurantOwner owner, String password){
	
	String error = "";
  
    if(owner == null) {
    	
    	 error += "Restaurant Owner does not exist";
		return false;
    }

    else if(restaurantOwnerRepository.findRestaurantOwnerById(owner.getId()) == null){
    	error += "Restaurant Owner does not exist";
        return false;
    }
    
    else if(!restaurantOwnerRepository.findRestaurantOwnerById(owner.getId()).getPassword().equals(password)) {
    	error += "Username and Password do not match";
    	return false;
    }
		
    if(restaurantOwnerRepository.findRestaurantOwnerById(owner.getId()).getPassword().equals(password)) {
          //we may need a login toggle field for accounttype
          return true;
		
	}
    
    if (error.length() > 0) {
		throw new IllegalArgumentException(error);
	}

        return false;
}


   
}

