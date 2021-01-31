package dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import model.*;

public interface FoodRepository extends CrudRepository<Food, Long> {
    
  Food findFoodById(Long id);
  Food findFoodByMenuLink(String menuLink);
  Food findFoodByRestaurant(Restaurant restaurant);
  
  List<Food> findFoodByCuisine(String cuisine);
  List<Food> findFoodByOptions(String options);
  List<Food> findFoodByPriceBetween(int minPrice, int maxPrice);
  List<Food> findFoodByCuisineAndOptionsAndPriceBetween(String cuisine, String options, int minPrice, int maxPrice);
  
}
