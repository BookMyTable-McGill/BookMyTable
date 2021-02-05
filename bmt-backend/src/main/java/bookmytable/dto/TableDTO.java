package bookmytable.dto;

import java.util.Set;

public class TableDTO {

  private long id;
  private int capacity;
  private int x;
  private int y;
  private int tableNumber;
  private RestaurantDTO restaurant;
  private Set<ReservationDTO> reservations;
  
  public TableDTO() {
    
  }
  
  public TableDTO(long id, int capacity, int x, int y, int tableNumber, RestaurantDTO restaurant,
      Set<ReservationDTO> reservations) {
    super();
    this.id = id;
    this.capacity = capacity;
    this.x = x;
    this.y = y;
    this.tableNumber = tableNumber;
    this.restaurant = restaurant;
    this.reservations = reservations;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getTableNumber() {
    return tableNumber;
  }

  public void setTableNumber(int tableNumber) {
    this.tableNumber = tableNumber;
  }

  public RestaurantDTO getRestaurant() {
    return restaurant;
  }

  public void setRestaurant(RestaurantDTO restaurant) {
    this.restaurant = restaurant;
  }

  public Set<ReservationDTO> getReservations() {
    return reservations;
  }

  public void setReservations(Set<ReservationDTO> reservations) {
    this.reservations = reservations;
  }  
}
