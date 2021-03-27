package bookmytable.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bookmytable.dao.RestaurantOwnerRepository;
import bookmytable.dto.CustomerDTO;
import bookmytable.dto.RestaurantOwnerDTO;
import bookmytable.model.Customer;
import bookmytable.model.RestaurantOwner;
import bookmytable.service.RestaurantOwnerRegistrationService;

@CrossOrigin(origins = "*")
@RestController
public class RestaurantOwnerRegistrationController {

	@Autowired
	public RestaurantOwnerRepository restaurantOwnerRepository;

	@Autowired
	public RestaurantOwnerRegistrationService restaurantOwnerRegistrationService;

	@PostMapping(value = { "/restaurantOwner/register", "/restaurantOwner/register/" })
	public RestaurantOwnerDTO registerRestaurantOwner(@RequestParam(name = "name") String name,
			@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
		RestaurantOwner restaurantOwner = restaurantOwnerRepository.findRestaurantOwnerByEmail(email);
		long id = 1234;
		if (restaurantOwner == null) {
			RestaurantOwner owner = restaurantOwnerRegistrationService.registerRestaurantOwner(name, password, email);
			return Converters.convertToDto(owner);
		} else {
			return null;
		}
	}
	
	 @PostMapping(value= {"/restaurantOwner/edit-info","restaurantOwners/edit-info/"})
	  public RestaurantOwnerDTO modifyOwnerInfo(@RequestParam(name="owner") long owner, @RequestParam(name="name") String name,
			  @RequestParam(name="email") String email, @RequestParam(name="password") String password) {
		  RestaurantOwner findOwner = restaurantOwnerRepository.findRestaurantOwnerByEmail(email);
		  if (findOwner == null) {
			  return null;
		  }
		  else {
				  
		  RestaurantOwner modifiedOwner= restaurantOwnerRegistrationService.modifyRestaurantOwner(owner, name, email, password);
		  return Converters.convertToDto(modifiedOwner);
		  }
	  }
	
	@GetMapping(value = {"/restaurantOwners", "/restaurantOwners/"})
	public List<RestaurantOwnerDTO> getAllRestaurantOwners() {
	    List<RestaurantOwner> restaurantOwners = restaurantOwnerRegistrationService.getRestaurantOwners();
	    List<RestaurantOwnerDTO> restaurantOwnerDTOs = new ArrayList<RestaurantOwnerDTO>();
	    for (RestaurantOwner r : restaurantOwners) {
	      restaurantOwnerDTOs.add(Converters.convertToDto(r));
	    }
	    return restaurantOwnerDTOs;
	}
	
	 @DeleteMapping(value = {"/restaurantOwner/delete", "/restaurantOwner/delete/"})
	 public RestaurantOwnerDTO deleteRestaurantOwner(@RequestParam(name = "ID") long id) {
	    RestaurantOwner restaurantOwner = restaurantOwnerRegistrationService.deleteRestaurantOwner(id);
	    return Converters.convertToDto(restaurantOwner);
	 }
	 

	 @DeleteMapping(value = {"/restaurantOwner/deleteOwnAccount", "/restaurantOwner/deleteOwnAccount/"})
	 public void deleteOwnRestaurantOwnerAccount(@RequestParam(name = "ID") long id, @RequestParam(name="password") String password) {
	    RestaurantOwner restaurantOwner = restaurantOwnerRepository.findRestaurantOwnerById(id);
	    restaurantOwnerRegistrationService.deleteOwnRestaurantOwnerAccount(restaurantOwner, password);
	 }
	 
	 

}
