package bookmytable.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@Entity
public class RestaurantTable{
  private long id;

  public void setId(long value) {
      this.id = value;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public long getId() {
      return this.id;
  }
  
   private int capacity;

public void setCapacity(int value) {
    this.capacity = value;
}
public int getCapacity() {
    return this.capacity;
}
private int x;

public void setX(int value) {
    this.x = value;
}
public int getX() {
    return this.x;
}
private int y;

public void setY(int value) {
    this.y = value;
}
public int getY() {
    return this.y;
}
private int tableNumber;

public void setTableNumber(int value) {
    this.tableNumber = value;
}
public int getTableNumber() {
    return this.tableNumber;
}
   private Restaurant restaurant;
   
   @ManyToOne(optional=false)
   public Restaurant getRestaurant() {
      return this.restaurant;
   }
   
   public void setRestaurant(Restaurant restaurant) {
      this.restaurant = restaurant;
   }
   
   private Set<Reservation> reservations;
   
   @OneToMany(mappedBy="table" , cascade={CascadeType.ALL})
   public Set<Reservation> getReservations() {
      return this.reservations;
   }
   
   public void setReservations(Set<Reservation> reservationss) {
      this.reservations = reservationss;
   }
   
   }
