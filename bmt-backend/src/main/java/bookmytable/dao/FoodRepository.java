package bookmytable.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import bookmytable.model.*;

public interface FoodRepository extends CrudRepository<Food, Long> {
    
  Food findFoodById(Long id);
  Food findFoodByMenuLink(String menuLink);
  Food findFoodByRestaurant(Restaurant restaurant);
  
  List<Food> findFoodByCuisineIgnoreCase(String cuisine);
  List<Food> findFoodByOptionsIgnoreCase(String options);
  List<Food> findFoodByPriceBetween(int minPrice, int maxPrice);
  List<Food> findFoodByPrice(int price);
  List<Food> findFoodByCuisineAndOptionsAndPriceBetweenAllIgnoreCase(String cuisine, String options, int minPrice, int maxPrice);
  
}
