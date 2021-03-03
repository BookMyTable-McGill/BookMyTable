package bookmytable.model;

import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@Entity
public class RestaurantOwner extends AccountType{
   private Set<Restaurant> restaurants;
   
   @OneToMany(mappedBy="restaurantOwner") //, cascade={CascadeType.ALL})
   public Set<Restaurant> getRestaurants() {
      return this.restaurants;
   }
   
   public void setRestaurants(Set<Restaurant> restaurants) {
      this.restaurants = restaurants;
   }
   
   }
