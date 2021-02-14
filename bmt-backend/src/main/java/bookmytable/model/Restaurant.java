package bookmytable.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "restaurants")
public class Restaurant{
	  
private long id;

public void setId(long value) {
    this.id = value;
}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public long getId() {
    return this.id;
}
private String name;

public void setName(String value) {
    this.name = value;
}
public String getName() {
    return this.name;
}
private String address;

public void setAddress(String value) {
    this.address = value;
}
public String getAddress() {
    return this.address;
}

/**
 * Opening hours to have the following format:
 * S Open        M Open      T Open      W Open      T Open      F Open      S Open
 * S Close       M Close     T Close     W Close     T Close     F Close     S Close
 */
private int[][] openingHours;

public void setOpeningHours(int[][] value) {
    this.openingHours = value;
}
public int[][] getOpeningHours() {
    return this.openingHours;
}
private boolean isBooked;

public void setIsBooked(boolean value) {
    this.isBooked = value;
}
public boolean isIsBooked() {
    return this.isBooked;
}
private int estimatedDuration;

public void setEstimatedDuration(int value) {
    this.estimatedDuration = value;
}
public int getEstimatedDuration() {
    return this.estimatedDuration;
}
   private Food food;
   
   @OneToOne(mappedBy="restaurant" , cascade={CascadeType.ALL}, optional=true)
   public Food getFood() {
      return this.food;
   }
   
   public void setFood(Food food) {
      this.food = food;
   }
   
   private Set<RestaurantTable> map;
   
   @OneToMany(mappedBy="restaurant" , cascade={CascadeType.ALL})
   public Set<RestaurantTable> getMap() {
      return this.map;
   }
   
   public void setMap(Set<RestaurantTable> maps) {
      this.map = maps;
   }
   
   private Set<Reservation> reservations;
   
   @OneToMany(mappedBy="restaurant")
   public Set<Reservation> getReservations() {
     return this.reservations;
   }

   public void setReservations(Set<Reservation> reservations) {
     this.reservations = reservations;
   }
   
   private RestaurantOwner restaurantOwner;
   
   @ManyToOne(optional=true)
   public RestaurantOwner getRestaurantOwner() {
      return this.restaurantOwner;
   }
   
   public void setRestaurantOwner(RestaurantOwner restaurantOwner) {
      this.restaurantOwner = restaurantOwner;
   }
   
   }