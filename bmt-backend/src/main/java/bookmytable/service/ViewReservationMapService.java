package bookmytable.service;

import bookmytable.dao.ReservationRepository;
import bookmytable.model.Reservation;
import bookmytable.model.Restaurant;
import bookmytable.model.RestaurantTable;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ViewReservationMapService {
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Transactional
	public List<RestaurantTable> getTablesReservedByStartTime(Restaurant restaurant, Time startTime, Date date) {
		List<Reservation> reservations = reservationRepository.findReservationsByRestaurantAndStartTimeAndDate(restaurant, startTime, date);
		
		List<RestaurantTable> tablesReserved = new ArrayList<>();
		for (Reservation r : reservations) {
			tablesReserved.add(r.getTable());
		}
		return tablesReserved;
	}
	
}
