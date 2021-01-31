package dto;

import java.util.Set;

public class CustomerDTO extends AccountTypeDTO {
  
  private String phoneNumber;
  private Set<ReservationDTO> reservations;
  private Set<RestaurantDTO> favoriteRestaurants;
  
  
  
  public CustomerDTO() {

  }  

  public CustomerDTO(String name, String email, String password, long id, String phoneNumber, Set<ReservationDTO> reservations, Set<RestaurantDTO> favoriteRestaurants) {
    super(name, email, password, id);
    this.phoneNumber = phoneNumber;
    this.reservations = reservations;
    this.favoriteRestaurants = favoriteRestaurants;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }
  
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
  
  public Set<ReservationDTO> getReservations() {
    return reservations;
  }
  
  public void setReservations(Set<ReservationDTO> reservations) {
    this.reservations = reservations;
  }
  
  public Set<RestaurantDTO> getFavoriteRestaurants() {
    return favoriteRestaurants;
  }
  
  public void setFavoriteRestaurants(Set<RestaurantDTO> favoriteRestaurants) {
    this.favoriteRestaurants = favoriteRestaurants;
  }
  
  
  
}
