package bookmytable.dao;

import bookmytable.model.Reservation;
import bookmytable.model.Restaurant;
import bookmytable.model.RestaurantTable;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

  Reservation findReservationById(long id);
  
  List<Reservation> findReservationsByTable(RestaurantTable restaurantTable);
  List<Reservation> findReservationsByTableAndStartTime(RestaurantTable restaurantTable, Time startTime);
  List<Reservation> findReservationsByTableAndStartTimeBetween(RestaurantTable restaurantTable, Time minStartTime, Time maxStartTime);
  List<Reservation> findReservationsByTableAndDate(RestaurantTable restaurantTable, Date date);
  Reservation findReservationsByTableAndStartTimeAndDate(RestaurantTable restaurantTable, Time startTime, Date date);
  List<Reservation> findReservationsByTableAndStartTimeBetweenAndDate(RestaurantTable restaurantTable, Time minStartTime, Time maxStartTime, Date date);
  
  List<Reservation> findReservationsByRestaurant(Restaurant restaurant);
  List<Reservation> findReservationsByRestaurantAndStartTime(Restaurant restaurant, Time startTime);
  List<Reservation> findReservationsByRestaurantAndStartTimeBetween(Restaurant restaurant, Time minStartTime, Time maxStartTime);
  List<Reservation> findReservationsByRestaurantAndDate(Restaurant restaurant, Date date);
  List<Reservation> findReservationsByRestaurantAndStartTimeAndDate(Restaurant restaurant, Time startTime, Date date);
  List<Reservation> findReservationsByRestaurantAndStartTimeBetweenAndDate(Restaurant restaurant, Time minStartTime, Time maxStartTime, Date date);
  
  List<Reservation> findReservationsByTableAndGroupSize(RestaurantTable restaurantTable, int groupSize);
  List<Reservation> findReservationsByTableAndGroupSizeAndDate(RestaurantTable restaurantTable, int groupSize, Date date);
  List<Reservation> findReservationsByRestaurantAndGroupSize(Restaurant restaurant, int groupSize);
  List<Reservation> findReservationsByRestaurantAndGroupSizeAndDate(Restaurant restaurant, int groupSize, Date date);
}
