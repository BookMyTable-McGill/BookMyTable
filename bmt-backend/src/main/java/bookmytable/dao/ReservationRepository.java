package bookmytable.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import bookmytable.model.*;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

  Reservation findReservationById(long id);
  
  List<Reservation> findReservationsByTable(Table table);
  List<Reservation> findReservationsByTableAndStartTime(Table table, Time startTime);
  List<Reservation> findReservationsByTableAndStartTimeBetween(Table table, Time minStartTime, Time maxStartTime);
  List<Reservation> findReservationsByTableAndDate(Table table, Date date);
  Reservation findReservationsByTableAndStartTimeAndDate(Table table, Time startTime, Date date);
  List<Reservation> findReservationsByTableAndStartTimeBetweenAndDate(Table table, Time minStartTime, Time maxStartTime, Date date);
  
  List<Reservation> findReservationsByRestaurant(Restaurant restaurant);
  List<Reservation> findReservationsByRestaurantAndStartTime(Restaurant restaurant, Time startTime);
  List<Reservation> findReservationsByRestaurantAndStartTimeBetween(Restaurant restaurant, Time minStartTime, Time maxStartTime);
  List<Reservation> findReservationsByRestaurantAndDate(Restaurant restaurant, Date date);
  List<Reservation> findReservationsByRestaurantAndStartTimeAndDate(Restaurant restaurant, Time startTime, Date date);
  List<Reservation> findReservationsByRestaurantAndStartTimeBetweenAndDate(Restaurant restaurant, Time minStartTime, Time maxStartTime, Date date);
  
  List<Reservation> findReservationsByTableAndGroupSize(Table table, int groupSize);
  List<Reservation> findReservationsByTableAndGroupSizeAndDate(Table table, int groupSize, Date date);
  List<Reservation> findReservationsByRestaurantAndGroupSize(Restaurant restaurant, int groupSize);
  List<Reservation> findReservationsByRestaurantAndGroupSizeAndDate(Restaurant restaurant, int groupSize, Date date);
}
