package bookmytable.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import bookmytable.model.*;

public interface RestaurantOwnerRepository extends CrudRepository<RestaurantOwner, Long> {
  
  RestaurantOwner findRestaurantOwnerById(long id);
  RestaurantOwner findRestaurantOwnerByEmail(String email);
  List<RestaurantOwner> findRestaurantOwnersByName(String name);

}
