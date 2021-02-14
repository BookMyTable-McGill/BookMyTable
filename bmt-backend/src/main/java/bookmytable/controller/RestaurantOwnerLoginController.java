package bookmytable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bookmytable.dto.RestaurantOwnerDTO;
import bookmytable.model.RestaurantOwner;
import bookmytable.service.RestaurantOwnerLoginService;
import bookmytable.dao.RestaurantOwnerRepository;


@CrossOrigin(origins = "*")
@RestController
public class RestaurantOwnerLoginController {
	
	@Autowired
	public RestaurantOwnerRepository restaurantOwnerRepository;

	@Autowired 
	public RestaurantOwnerLoginService restaurantOwnerLoginService;
	    
	@PostMapping(value = { "/restaurantOwner/login", "/restaurantOwner/login/" })
		public RestaurantOwnerDTO loginRestaurantOwner(@RequestParam(name = "email") String email,
				@RequestParam(name = "password") String password) {
		
		boolean loginCheck = false;
		RestaurantOwner restaurantOwner = restaurantOwnerRepository.findRestaurantOwnerByEmail(email);
			if (restaurantOwner != null) {
				loginCheck = restaurantOwnerLoginService.loginRestaurantOwner(restaurantOwner, password);
			} 
			
			if(loginCheck == true)
				return Converters.convertToDto(restaurantOwner);
			
			else
				return null;
		}
	
    @GetMapping(value = {"/getRestaurantOwner/Email", "/getRestaurantOwner/Email/"})
    public RestaurantOwnerDTO getRestaurantOwnerByEmail(@RequestParam("email") String email) {
    	RestaurantOwner restaurantOwner = restaurantOwnerLoginService.getRestaurantOwnerByEmail(email);
        return Converters.convertToDto(restaurantOwner);
    }
    
    @GetMapping(value = {"/getRestaurantOwner/ID", "/getRestaurantOwner/ID/"})
    public RestaurantOwnerDTO getRestaurantOwner(@RequestParam("ID") long ID) {
    	RestaurantOwner restaurantOwner = restaurantOwnerLoginService.getRestaurantOwnerByID(ID);
        return Converters.convertToDto(restaurantOwner);
    }
    
    
}
