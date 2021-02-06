package bookmytable.controller;

import bookmytable.dao.CustomerRepository;
import bookmytable.dao.RestaurantRepository;
import bookmytable.dao.TableRepository;
import bookmytable.dto.RestaurantDTO;
import bookmytable.model.Customer;
import bookmytable.model.Reservation;
import bookmytable.model.Restaurant;
import bookmytable.model.Table;
import bookmytable.service.ViewRestaurantInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Time;

@CrossOrigin(origins = "*")
@RestController
public class ViewRestaurantInfoController {

    @Autowired
    private ViewRestaurantInfoService viewRestaurantInfoService;

    @Autowired
    private RestaurantRepository restaurantRepository;

    //????
    @PostMapping(value = {"/", "//"})
    public RestaurantDTO viewRestaurantInfo(@RequestParam("a") String a) {
    	///??///
    	Restaurant restaurant = viewRestaurantInfoService.getRestaurantByAddress(a);
        return Converters.convertToDto(restaurant);
    }
    
}
