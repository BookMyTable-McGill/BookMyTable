package controller;

import model.*;
import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import dao.*;
import dto.*;

public class Converters {
  
  @Autowired
  private static CustomerRepository customerRepository;
  @Autowired
  private static FoodRepository foodRepository;
  @Autowired
  private static ReservationRepository reservationRepository;
  @Autowired
  private static RestaurantOwnerRepository restaurantOwnerRepository;
  @Autowired
  private static RestaurantRepository restaurantRepository;
  @Autowired
  private static TableRepository tableRepository;
  
  /*
   * ========================== CUSTOMER CONVERTERS ==========================
   */
  
  public static CustomerDTO convertToDto(Customer c) {
    if (c == null) {
      throw new IllegalArgumentException("There is no such Customer");
    }
    
    String name = c.getName();
    String email = c.getEmail();
    String password = c.getPassword();
    String phoneNumber = c.getPhoneNumber();
    long id = c.getId();
    
    Set<Reservation> reservations = c.getReservations();
    Set<ReservationDTO> reservationDTOs = new HashSet<ReservationDTO>();
    if (reservations != null) {
      for (Reservation r : reservations) {
        reservationDTOs.add(convertWithoutCustomer(r));
      }
    }
    
    Set<Restaurant> favoriteRestaurants = c.getFavoriteRestaurants();
    Set<RestaurantDTO> favoriteRestaurantDTOs = new HashSet<RestaurantDTO>();
    if (favoriteRestaurants != null) {
      for (Restaurant r : favoriteRestaurants) {
        favoriteRestaurantDTOs.add(convertToDto(r));
      }
    }
    
    CustomerDTO cust = new CustomerDTO(name, email, password, id, phoneNumber, reservationDTOs, favoriteRestaurantDTOs);
    return cust;
  }
  
  private static CustomerDTO convertWithoutReservation(Customer c) {
    if (c == null) {
      throw new IllegalArgumentException("There is no such Customer");
    }
    
    String name = c.getName();
    String email = c.getEmail();
    String password = c.getPassword();
    String phoneNumber = c.getPhoneNumber();
    long id = c.getId();
    
    Set<Restaurant> favoriteRestaurants = c.getFavoriteRestaurants();
    Set<RestaurantDTO> favoriteRestaurantDTOs = new HashSet<RestaurantDTO>();
    if (favoriteRestaurants != null) {
      for (Restaurant r : favoriteRestaurants) {
        favoriteRestaurantDTOs.add(convertToDto(r));
      }
    }
    
    CustomerDTO cust = new CustomerDTO(name, email, password, id, phoneNumber, null, favoriteRestaurantDTOs);
    return cust;
  }
  
  /*
   * ========================== FOOD CONVERTERS ==========================
   */
  
  public static FoodDTO convertToDto(Food f) {
    if (f == null) {
      throw new IllegalArgumentException("There is no such Food");
    }
    
    String cuisine = f.getCuisine();
    String menuLink = f.getMenuLink();
    String options = f.getOptions();
    long id = f.getId();
    int price = f.getPrice();
    RestaurantDTO restaurant = convertWithoutFood(f.getRestaurant());
    
    FoodDTO foodDTO = new FoodDTO(id, menuLink, price, cuisine, options, restaurant);
    return foodDTO;    
  }
  
  private static FoodDTO convertWithoutRestaurant(Food f) {
    if (f == null) {
      throw new IllegalArgumentException("There is no such Food");
    }
    
    String cuisine = f.getCuisine();
    String menuLink = f.getMenuLink();
    String options = f.getOptions();
    long id = f.getId();
    int price = f.getPrice();
    
    FoodDTO foodDTO = new FoodDTO(id, menuLink, price, cuisine, options, null);
    return foodDTO; 
  }
  
  /*
   * ========================== RESERVATION CONVERTERS ==========================
   */
  
  public static ReservationDTO convertToDto(Reservation r) {
    if (r == null) {
      throw new IllegalArgumentException("There is no such Reservation");
    }
    
    long id = r.getId();
    int groupSize = r.getGroupSize();
    Time startTime = r.getStartTime();
    Time endTime = r.getEndTime();
    Date date = r.getDate();
    CustomerDTO customer = convertWithoutReservation(r.getCustomer());
    RestaurantDTO restaurant = convertWithoutReservation(r.getRestaurant());
    TableDTO table = convertWithoutReservation(r.getTable());
    
    ReservationDTO reservationDTO = new ReservationDTO(startTime, endTime, date, 
        groupSize, id, table, customer, restaurant);
    return reservationDTO;
  }
  
  private static ReservationDTO convertWithoutCustomer(Reservation r) {
    if (r == null) {
      throw new IllegalArgumentException("There is no such Reservation");
    }
    
    long id = r.getId();
    int groupSize = r.getGroupSize();
    Time startTime = r.getStartTime();
    Time endTime = r.getEndTime();
    Date date = r.getDate();
    RestaurantDTO restaurant = convertWithoutReservation(r.getRestaurant());
    TableDTO table = convertWithoutReservation(r.getTable());
    
    ReservationDTO reservationDTO = new ReservationDTO(startTime, endTime, date, 
        groupSize, id, table, null, restaurant);
    return reservationDTO;
  }
  
  private static ReservationDTO convertWithoutRestaurant(Reservation r) {
    if (r == null) {
      throw new IllegalArgumentException("There is no such Reservation");
    }
    
    long id = r.getId();
    int groupSize = r.getGroupSize();
    Time startTime = r.getStartTime();
    Time endTime = r.getEndTime();
    Date date = r.getDate();
    CustomerDTO customer = convertWithoutReservation(r.getCustomer());
    TableDTO table = convertWithoutReservation(r.getTable());
    
    ReservationDTO reservationDTO = new ReservationDTO(startTime, endTime, date, 
        groupSize, id, table, customer, null);
    return reservationDTO;
  }
  
  private static ReservationDTO convertWithoutTable(Reservation r) {
    if (r == null) {
      throw new IllegalArgumentException("There is no such Reservation");
    }
    
    long id = r.getId();
    int groupSize = r.getGroupSize();
    Time startTime = r.getStartTime();
    Time endTime = r.getEndTime();
    Date date = r.getDate();
    CustomerDTO customer = convertWithoutReservation(r.getCustomer());
    RestaurantDTO restaurant = convertWithoutReservation(r.getRestaurant());
    
    ReservationDTO reservationDTO = new ReservationDTO(startTime, endTime, date, 
        groupSize, id, null, customer, restaurant);
    return reservationDTO;
  }
  
  /*
   * ========================== RESTAURANT CONVERTERS ==========================
   */
  
  public static RestaurantDTO convertToDto(Restaurant r) {
    if (r == null) {
      throw new IllegalArgumentException("There is no such Restaurant");
    }
    
    String name = r.getName();
    String address = r.getAddress();
    boolean isBooked = r.isIsBooked();
    long id = r.getId();
    int[][] openingHours = r.getOpeningHours();
    int estimatedDuration = r.getEstimatedDuration();
    
    RestaurantOwnerDTO restaurantOwner = convertWithoutRestaurant(r.getRestaurantOwner());
    FoodDTO food = convertWithoutRestaurant(r.getFood());

    Set<Table> tables = r.getMap();
    Set<TableDTO> tableDTOs = new HashSet<TableDTO>();
    if (tables != null) {
      for (Table t : tables) {
        tableDTOs.add(convertWithoutRestaurant(t));
      }
    }
    
    Set<Reservation> reservations = r.getReservations();
    Set<ReservationDTO> reservationDTOs = new HashSet<ReservationDTO>();
    if (reservations != null) {
      for (Reservation res : reservations) {
        reservationDTOs.add(convertWithoutRestaurant(res));
      }
    }
    
    RestaurantDTO restaurantDTO = new RestaurantDTO(id, name, address, openingHours, isBooked, estimatedDuration,
        food, tableDTOs, reservationDTOs, restaurantOwner);
    return restaurantDTO;
  }
  
  private static RestaurantDTO convertWithoutFood(Restaurant r) {
    if (r == null) {
      throw new IllegalArgumentException("There is no such Restaurant");
    }
    
    String name = r.getName();
    String address = r.getAddress();
    boolean isBooked = r.isIsBooked();
    long id = r.getId();
    int[][] openingHours = r.getOpeningHours();
    int estimatedDuration = r.getEstimatedDuration();
    
    RestaurantOwnerDTO restaurantOwner = convertWithoutRestaurant(r.getRestaurantOwner());

    Set<Table> tables = r.getMap();
    Set<TableDTO> tableDTOs = new HashSet<TableDTO>();
    if (tables != null) {
      for (Table t : tables) {
        tableDTOs.add(convertWithoutRestaurant(t));
      }
    }
    
    Set<Reservation> reservations = r.getReservations();
    Set<ReservationDTO> reservationDTOs = new HashSet<ReservationDTO>();
    if (reservations != null) {
      for (Reservation res : reservations) {
        reservationDTOs.add(convertWithoutRestaurant(res));
      }
    }
    
    RestaurantDTO restaurantDTO = new RestaurantDTO(id, name, address, openingHours, isBooked, estimatedDuration,
        null, tableDTOs, reservationDTOs, restaurantOwner);
    return restaurantDTO;
  }  
  
  private static RestaurantDTO convertWithoutReservation(Restaurant r) {
    if (r == null) {
      throw new IllegalArgumentException("There is no such Restaurant");
    }
    
    String name = r.getName();
    String address = r.getAddress();
    boolean isBooked = r.isIsBooked();
    long id = r.getId();
    int[][] openingHours = r.getOpeningHours();
    int estimatedDuration = r.getEstimatedDuration();
    
    RestaurantOwnerDTO restaurantOwner = convertWithoutRestaurant(r.getRestaurantOwner());
    FoodDTO food = convertWithoutRestaurant(r.getFood());

    Set<Table> tables = r.getMap();
    Set<TableDTO> tableDTOs = new HashSet<TableDTO>();
    if (tables != null) {
      for (Table t : tables) {
        tableDTOs.add(convertWithoutRestaurant(t));
      }
    }
    
    RestaurantDTO restaurantDTO = new RestaurantDTO(id, name, address, openingHours, isBooked, estimatedDuration,
        food, tableDTOs, null, restaurantOwner);
    return restaurantDTO;
  }
  
  private static RestaurantDTO convertWithoutRestaurantOwner(Restaurant r) {
    if (r == null) {
      throw new IllegalArgumentException("There is no such Restaurant");
    }
    
    String name = r.getName();
    String address = r.getAddress();
    boolean isBooked = r.isIsBooked();
    long id = r.getId();
    int[][] openingHours = r.getOpeningHours();
    int estimatedDuration = r.getEstimatedDuration();
    
    FoodDTO food = convertWithoutRestaurant(r.getFood());

    Set<Table> tables = r.getMap();
    Set<TableDTO> tableDTOs = new HashSet<TableDTO>();
    if (tables != null) {
      for (Table t : tables) {
        tableDTOs.add(convertWithoutRestaurant(t));
      }
    }
    
    Set<Reservation> reservations = r.getReservations();
    Set<ReservationDTO> reservationDTOs = new HashSet<ReservationDTO>();
    if (reservations != null) {
      for (Reservation res : reservations) {
        reservationDTOs.add(convertWithoutRestaurant(res));
      }
    }
    
    RestaurantDTO restaurantDTO = new RestaurantDTO(id, name, address, openingHours, isBooked, estimatedDuration,
        food, tableDTOs, reservationDTOs, null);
    return restaurantDTO;
  }
  
  private static RestaurantDTO convertWithoutTable(Restaurant r) {
    if (r == null) {
      throw new IllegalArgumentException("There is no such Restaurant");
    }
    
    String name = r.getName();
    String address = r.getAddress();
    boolean isBooked = r.isIsBooked();
    long id = r.getId();
    int[][] openingHours = r.getOpeningHours();
    int estimatedDuration = r.getEstimatedDuration();
    
    RestaurantOwnerDTO restaurantOwner = convertWithoutRestaurant(r.getRestaurantOwner());
    FoodDTO food = convertWithoutRestaurant(r.getFood());
    
    Set<Reservation> reservations = r.getReservations();
    Set<ReservationDTO> reservationDTOs = new HashSet<ReservationDTO>();
    if (reservations != null) {
      for (Reservation res : reservations) {
        reservationDTOs.add(convertWithoutRestaurant(res));
      }
    }
    
    RestaurantDTO restaurantDTO = new RestaurantDTO(id, name, address, openingHours, isBooked, estimatedDuration,
        food, null, reservationDTOs, restaurantOwner);
    return restaurantDTO;
  }
  
  /*
   * ========================== RESTAURANTOWNER CONVERTERS ==========================
   */
  
  public static RestaurantOwnerDTO convertToDto(RestaurantOwner r) {
    if (r == null) {
      throw new IllegalArgumentException("There is no such RestaurantOwner");
    }
    String name = r.getName();
    String email = r.getEmail();
    String password = r.getPassword();
    long id = r.getId();
    
    Set<Restaurant> restaurants = r.getRestaurants();
    Set<RestaurantDTO> restaurantDTOs = new HashSet<RestaurantDTO>();
    if (restaurants != null) {
      for (Restaurant res : restaurants) {
        restaurantDTOs.add(convertWithoutRestaurantOwner(res));
      }
    }
    
    RestaurantOwnerDTO restaurantOwnerDTO = new RestaurantOwnerDTO(name, email, password, id, restaurantDTOs);
    return restaurantOwnerDTO;
  }
  
  private static RestaurantOwnerDTO convertWithoutRestaurant(RestaurantOwner r) {
    if (r == null) {
      throw new IllegalArgumentException("There is no such RestaurantOwner");
    }
    String name = r.getName();
    String email = r.getEmail();
    String password = r.getPassword();
    long id = r.getId();
    
    RestaurantOwnerDTO restaurantOwnerDTO = new RestaurantOwnerDTO(name, email, password, id, null);
    return restaurantOwnerDTO;
  }
  
  /*
   * ========================== TABLE CONVERTERS ==========================
   */
  
  public static TableDTO convertToDto(Table t) {
    if (t == null) {
      throw new IllegalArgumentException("There is no such Table");
    }
    
    int x = t.getX();
    int y = t.getY();
    int capacity = t.getCapacity();
    int tableNumber = t.getTableNumber();
    long id = t.getId();
    
    RestaurantDTO restaurant = convertWithoutTable(t.getRestaurant()); 
    
    Set<Reservation> reservations = t.getReservations();
    Set<ReservationDTO> reservationDTOs = new HashSet<ReservationDTO>();
    if (reservations != null) {
      for (Reservation res : reservations) {
        reservationDTOs.add(convertWithoutTable(res));
      }
    }    
    
    TableDTO tableDTO = new TableDTO(id, capacity, x, y, tableNumber, restaurant, reservationDTOs);
    return tableDTO;
  }
  
  private static TableDTO convertWithoutReservation(Table t) {
    if (t == null) {
      throw new IllegalArgumentException("There is no such Table");
    }
    
    int x = t.getX();
    int y = t.getY();
    int capacity = t.getCapacity();
    int tableNumber = t.getTableNumber();
    long id = t.getId();
    
    RestaurantDTO restaurant = convertWithoutTable(t.getRestaurant()); 
    
    TableDTO tableDTO = new TableDTO(id, capacity, x, y, tableNumber, restaurant, null);
    return tableDTO;
  }
  
  private static TableDTO convertWithoutRestaurant(Table t) {
    if (t == null) {
      throw new IllegalArgumentException("There is no such Table");
    }
    
    int x = t.getX();
    int y = t.getY();
    int capacity = t.getCapacity();
    int tableNumber = t.getTableNumber();
    long id = t.getId(); 
    
    Set<Reservation> reservations = t.getReservations();
    Set<ReservationDTO> reservationDTOs = new HashSet<ReservationDTO>();
    if (reservations != null) {
      for (Reservation res : reservations) {
        reservationDTOs.add(convertWithoutTable(res));
      }
    }    
    
    TableDTO tableDTO = new TableDTO(id, capacity, x, y, tableNumber, null, reservationDTOs);
    return tableDTO;
  }

}