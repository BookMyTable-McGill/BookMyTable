package bookmytable.dto;

import java.sql.Time;
import java.util.Set;

public class RestaurantDTO {
  
  private long id;
  private String name;
  private String address;
  private Time[][] openingHours;
  private boolean isBooked;
  private int estimatedDuration;
  private FoodDTO food;
  private Set<TableDTO> map;
  private Set<ReservationDTO> reservations;
  private RestaurantOwnerDTO restaurantOwner;
  private String[] photos;
  
  public RestaurantDTO() {
    
  }
  
  public RestaurantDTO(long id, String name, String address, Time[][] openingHours, boolean isBooked,
      int estimatedDuration, FoodDTO food, Set<TableDTO> map, Set<ReservationDTO> reservations,
      RestaurantOwnerDTO restaurantOwner) {
    super();
    this.id = id;
    this.name = name;
    this.address = address;
    this.openingHours = openingHours;
    this.isBooked = isBooked;
    this.estimatedDuration = estimatedDuration;
    this.food = food;
    this.map = map;
    this.reservations = reservations;
    this.restaurantOwner = restaurantOwner;
  }

  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getAddress() {
    return address;
  }
  
  public void setAddress(String address) {
    this.address = address;
  }
  
  public Time[][] getOpeningHours() {
    return openingHours;
  }
  
  public void setOpeningHours(Time[][] openingHours) {
    this.openingHours = openingHours;
  }
  
  public boolean isBooked() {
    return isBooked;
  }
  
  public void setBooked(boolean isBooked) {
    this.isBooked = isBooked;
  }
  
  public int getEstimatedDuration() {
    return estimatedDuration;
  }
  
  public void setEstimatedDuration(int estimatedDuration) {
    this.estimatedDuration = estimatedDuration;
  }
  
  public FoodDTO getFood() {
    return food;
  }
  
  public void setFood(FoodDTO food) {
    this.food = food;
  }
  
  public Set<TableDTO> getMap() {
    return map;
  }
  
  public void setMap(Set<TableDTO> map) {
    this.map = map;
  }
  
  public Set<ReservationDTO> getReservations() {
    return reservations;
  }
  
  public void setReservations(Set<ReservationDTO> reservations) {
    this.reservations = reservations;
  }
  
  public RestaurantOwnerDTO getRestaurantOwner() {
    return restaurantOwner;
  }
  
  public void setRestaurantOwner(RestaurantOwnerDTO restaurantOwner) {
    this.restaurantOwner = restaurantOwner;
  }

  public String[] getPhotos() {
	return photos;
  }
	
  public void setPhotos(String[] photos) {
	this.photos = photos;
  }
  
  

}
