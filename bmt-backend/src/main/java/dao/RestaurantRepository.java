package dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import model.*;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
  
  Restaurant findRestaurantById(long id);
  List<Restaurant> findRestaurantsByName(String name);  //Assumed that multiple restaurants can have the same name
  Restaurant findRestaurantByAddress(String address);
  List<Restaurant> findRestaurantsByAdressContains(String addressSnippet);

}
