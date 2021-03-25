package bookmytable.service;


import bookmytable.dao.ReservationRepository;
import bookmytable.dao.RestaurantRepository;
import bookmytable.model.Customer;
import bookmytable.model.Food;
import bookmytable.model.Reservation;
import bookmytable.model.Restaurant;
import bookmytable.model.RestaurantTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Array;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
public class ViewRestaurantInfoService {
	
	// Integrate Yelp API??? //

    @Autowired
    RestaurantRepository restaurantRepository;
    
    @Transactional
    public Restaurant getRestaurantById(long id) {
        return restaurantRepository.findRestaurantById(id);
    }

    @Transactional
    public Restaurant getRestaurantByAddress(String address) {
        return restaurantRepository.findRestaurantByAddress(address);
    }
    
    @Transactional
    public Food getRestaurantMenu(Restaurant restaurant){
    	if(restaurant == null)
    	{
    		throw new IllegalArgumentException("Restaurant argument is null");
    	}
    	
		return restaurant.getFood();

    }

    private <T> List<T> toList(Iterable<T> iterable) {
        List<T> resultList = new ArrayList<T>();
        for (T t : iterable) {
            resultList.add(t);
        }
        return resultList;
    }

}
