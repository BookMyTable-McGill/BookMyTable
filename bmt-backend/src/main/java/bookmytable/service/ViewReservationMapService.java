package bookmytable.service;

import bookmytable.dao.ReservationRepository;
import bookmytable.dao.RestaurantRepository;
import bookmytable.dao.TableRepository;
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
	@Autowired
	TableRepository tableRepository;
	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Transactional
	public List<RestaurantTable> getTablesReservedByStartTime(long restaurantId, Time startTime, Date date) {
		Restaurant resto = restaurantRepository.findRestaurantById(restaurantId);
		List<Reservation> reservations = reservationRepository.findReservationsByRestaurantAndStartTimeAndDate(resto, startTime, date);
		
		List<RestaurantTable> tablesReserved = new ArrayList<>();
		for (Reservation r : reservations) {
			tablesReserved.add(r.getTable());
		}
		return tablesReserved;
	}
	
	@Transactional
	public List<RestaurantTable> getTablesByRestaurant(long restaurantId) {
		Restaurant resto = restaurantRepository.findRestaurantById(restaurantId);
		return tableRepository.findTablesByRestaurant(resto);
	}
	
	@Transactional
	public RestaurantTable getTableByRestaurantAndTableNumber(long restaurantId, int tableNumber) {
		Restaurant restaurant = restaurantRepository.findRestaurantById(restaurantId);
		return tableRepository.findTableByRestaurantAndTableNumber(restaurant, tableNumber);
	}
}
