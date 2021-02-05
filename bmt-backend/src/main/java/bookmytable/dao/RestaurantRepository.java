package bookmytable.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import bookmytable.model.*;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
  
  Restaurant findRestaurantById(long id);
  List<Restaurant> findRestaurantsByName(String name);  //Assumed that multiple restaurants can have the same name
  List<Restaurant> findRestaurantsByNameContains(String nameFragment);
  Restaurant findRestaurantByAddress(String address);
  List<Restaurant> findRestaurantsByAddressContains(String addressFragment);

}
