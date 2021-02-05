package bookmytable.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import bookmytable.model.*;

public interface TableRepository extends CrudRepository<Table, Long> {
  
  Table findTableById(long id);
  
  List<Table> findTablesByRestaurant(Restaurant restaurant);
  Table findTableByRestaurantAndXAndY(Restaurant restaurant, int x, int y);
  List<Table> findTablesByRestaurantAndCapacity(Restaurant restaurant, int capacity);

}
