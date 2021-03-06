package bookmytable.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookmytable.dao.RestaurantRepository;
import bookmytable.model.Restaurant;

@Service
public class ViewRestaurantsService {


    @Autowired
    RestaurantRepository restaurantRepository;
    
    @Transactional
    public List<Restaurant> getAllRestaurants(){
    	
    	return toList(restaurantRepository.findAll());
    	
    }
    

    private <T> List<T> toList(Iterable<T> iterable) {
        List<T> resultList = new ArrayList<T>();
        for (T t : iterable) {
            resultList.add(t);
        }
        return resultList;
    }

}
