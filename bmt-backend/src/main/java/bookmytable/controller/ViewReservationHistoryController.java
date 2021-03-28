package bookmytable.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bookmytable.dao.CustomerRepository;
import bookmytable.dto.ReservationDTO;
import bookmytable.model.Customer;
import bookmytable.model.Reservation;
import bookmytable.service.ReservationService;

@CrossOrigin(origins = "*")
@RestController
public class ViewReservationHistoryController {

	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping(value = {"/getReservationHistory", "/getReservationHistory/"})
	public List<ReservationDTO> getReservationHistory(@RequestParam("customerID") long customerID) {
		
		Customer customer = customerRepository.findCustomerById(customerID);
		
		List<Reservation> reservations = reservationService.getReservationsByCustomer(customer);
		
		List<ReservationDTO> reservationDTOs = new ArrayList<ReservationDTO>();
		
		for(Reservation r : reservations) {
			reservationDTOs.add(Converters.convertToDto(r));
		}
		
		return reservationDTOs;
		
	}
	
}
