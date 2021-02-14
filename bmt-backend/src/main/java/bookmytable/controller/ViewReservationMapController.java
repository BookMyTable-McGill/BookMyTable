package bookmytable.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import bookmytable.dao.RestaurantRepository;
import bookmytable.dto.TableDTO;
import bookmytable.model.RestaurantTable;
import bookmytable.service.ViewReservationMapService;

@CrossOrigin(origins = "*")
@RestController
public class ViewReservationMapController {
	
	@Autowired
	private ViewReservationMapService viewReservationMapService;
	private RestaurantRepository restaurantRepository;
	
	@GetMapping("/getReservedTables/{restaurantId}/{reservationDate}/{reservationTime}")
	public List<TableDTO> getTablesReservedByStartTime(@PathVariable("restaurantId") long restaurantId, @PathVariable("reservationDate") Date reservationDate, @PathVariable("reservationTime") Time reservationTime) {
		List<RestaurantTable> reservedTables = viewReservationMapService.getTablesReservedByStartTime(restaurantRepository.findRestaurantById(restaurantId), reservationTime, reservationDate);
		List<TableDTO> reservedTablesDTO = new ArrayList<>();
		reservedTables.forEach(rt -> reservedTablesDTO.add(Converters.convertToDto(rt)));
		return reservedTablesDTO;
	}
}
