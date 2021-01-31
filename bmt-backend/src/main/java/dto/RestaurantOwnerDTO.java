package dto;

import java.util.Set;

public class RestaurantOwnerDTO {

  private Set<RestaurantDTO> restaurants;
  
  public RestaurantOwnerDTO() {
    
  }

  public RestaurantOwnerDTO(Set<RestaurantDTO> restaurants) {
    super();
    this.restaurants = restaurants;
  }

  public Set<RestaurantDTO> getRestaurants() {
    return restaurants;
  }

  public void setRestaurants(Set<RestaurantDTO> restaurants) {
    this.restaurants = restaurants;
  }
  
}
