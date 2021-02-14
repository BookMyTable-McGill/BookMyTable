package bookmytable.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bookmytable.dao.RestaurantRepository;
import bookmytable.dto.TableDTO;
import bookmytable.model.Restaurant;
import bookmytable.model.RestaurantTable;
import bookmytable.service.ViewReservationMapService;

@CrossOrigin(origins = "*")
@RestController
public class ViewReservationMapController {
	
	@Autowired
	private ViewReservationMapService viewReservationMapService;
	
	@GetMapping("/getReservedTables")
	public List<TableDTO> getTablesReservedByStartTime(@RequestParam("restaurantId") long restaurantId, @RequestParam("reservationDate") Date reservationDate, @RequestParam("reservationTime") Time reservationTime) {
		List<RestaurantTable> reservedTables = viewReservationMapService.getTablesReservedByStartTime(restaurantId, reservationTime, reservationDate);
		List<TableDTO> reservedTablesDTO = new ArrayList<>();
		reservedTables.forEach(rt -> reservedTablesDTO.add(Converters.convertToDto(rt)));
		return reservedTablesDTO;
	}
	
	@GetMapping("/getTables")
	public List<TableDTO> getTablesByRestaurant(@RequestParam("restaurantId") long restaurantId) {
		List<RestaurantTable> allTables = viewReservationMapService.getTablesByRestaurant(restaurantId);
		List<TableDTO> allTablesDTO = new ArrayList<>();
		allTables.forEach(t -> allTablesDTO.add(Converters.convertToDto(t)));
		return allTablesDTO;
	}
}
