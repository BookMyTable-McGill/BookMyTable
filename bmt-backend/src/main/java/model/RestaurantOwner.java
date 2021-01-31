package model;

import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@Entity
public class RestaurantOwner extends AccountType{
   private Set<Restaurant> restaurant;
   
   @OneToMany(mappedBy="restaurantOwner" , cascade={CascadeType.ALL})
   public Set<Restaurant> getRestaurant() {
      return this.restaurant;
   }
   
   public void setRestaurant(Set<Restaurant> restaurants) {
      this.restaurant = restaurants;
   }
   
   }
