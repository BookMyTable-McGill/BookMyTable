package bookmytable.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import bookmytable.model.*;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
  
  Restaurant findRestaurantById(long id);
  List<Restaurant> findRestaurantsByNameIgnoreCase(String name);  //Assumed that multiple restaurants can have the same name
  List<Restaurant> findRestaurantsByNameContainsIgnoreCase(String nameFragment);
  Restaurant findRestaurantByAddress(String address);
  List<Restaurant> findRestaurantsByAddressContains(String addressFragment);

  //This needs to be tested to ensure it really works
  List<Restaurant> findRestaurantsByNameContainsAndPriceBetweenAndCuisineAndOptionsAllIgnoreCase(
      String name, int minPrice, int maxPrice, String cuisine, String options);
}
