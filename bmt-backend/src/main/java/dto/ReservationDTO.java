package dto;

import java.sql.Date;
import java.sql.Time;

public class ReservationDTO {
  
  private Time startTime;
  private Time endTime;
  private Date date;
  private int groupSize;
  private long id;
  private TableDTO table;
  private CustomerDTO customer;
  private RestaurantDTO restaurant;
  
  public ReservationDTO() {
    
  }
  
  public ReservationDTO(Time startTime, Time endTime, Date date, int groupSize, long id, TableDTO table,
      CustomerDTO customer, RestaurantDTO restaurant) {
    super();
    this.startTime = startTime;
    this.endTime = endTime;
    this.date = date;
    this.groupSize = groupSize;
    this.id = id;
    this.table = table;
    this.customer = customer;
    this.restaurant = restaurant;
  }
  
  public Time getStartTime() {
    return startTime;
  }
  
  public void setStartTime(Time startTime) {
    this.startTime = startTime;
  }
  
  public Time getEndTime() {
    return endTime;
  }
  
  public void setEndTime(Time endTime) {
    this.endTime = endTime;
  }
  
  public Date getDate() {
    return date;
  }
  
  public void setDate(Date date) {
    this.date = date;
  }
  
  public int getGroupSize() {
    return groupSize;
  }
  
  public void setGroupSize(int groupSize) {
    this.groupSize = groupSize;
  }
  
  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public TableDTO getTable() {
    return table;
  }
  
  public void setTable(TableDTO table) {
    this.table = table;
  }
  
  public CustomerDTO getCustomer() {
    return customer;
  }
  
  public void setCustomer(CustomerDTO customer) {
    this.customer = customer;
  }
  
  public RestaurantDTO getRestaurant() {
    return restaurant;
  }
  
  public void setRestaurant(RestaurantDTO restaurant) {
    this.restaurant = restaurant;
  }
  
  

}
