package bookmytable.model;

import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@Entity
public class Customer extends AccountType{
   private String phoneNumber;

public void setPhoneNumber(String value) {
    this.phoneNumber = value;
}
public String getPhoneNumber() {
    return this.phoneNumber;
}
   private Set<Reservation> reservations;
   
   @OneToMany(mappedBy="customer" , cascade={CascadeType.ALL})
   public Set<Reservation> getReservations() {
      return this.reservations;
   }
   
   public void setReservations(Set<Reservation> reservationss) {
      this.reservations = reservationss;
   }
   
   private Set<Restaurant> favoriteRestaurants;
   
   @OneToMany
   public Set<Restaurant> getFavoriteRestaurants() {
      return this.favoriteRestaurants;
   }
   
   public void setFavoriteRestaurants(Set<Restaurant> favoriteRestaurantss) {
      this.favoriteRestaurants = favoriteRestaurantss;
   }
}