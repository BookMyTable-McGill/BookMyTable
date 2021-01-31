package dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import model.*;

public interface RestaurantOwnerRepository extends CrudRepository<RestaurantOwner, Long> {
  
  RestaurantOwner findRestaurantOwnerById(long id);
  RestaurantOwner findRestaurantOwnerByEmail(String email);
  RestaurantOwner findRestaurantOwnerByRestaurant(Restaurant restaurant);

}
