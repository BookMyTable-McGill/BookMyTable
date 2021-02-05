package dto;

import java.util.Set;

public class RestaurantOwnerDTO extends AccountTypeDTO {

  private Set<RestaurantDTO> restaurants;
  
  public RestaurantOwnerDTO() {
    
  }

  public RestaurantOwnerDTO(String name, String email, String password, long id, Set<RestaurantDTO> restaurants) {
    super(name, email, password, id);
    this.restaurants = restaurants;
  }

  public Set<RestaurantDTO> getRestaurants() {
    return restaurants;
  }

  public void setRestaurants(Set<RestaurantDTO> restaurants) {
    this.restaurants = restaurants;
  }
  
}
