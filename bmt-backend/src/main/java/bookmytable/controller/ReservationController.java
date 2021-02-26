package bookmytable.controller;

import bookmytable.dao.CustomerRepository;
import bookmytable.dao.RestaurantRepository;
import bookmytable.dao.TableRepository;
import bookmytable.dto.ReservationDTO;
import bookmytable.model.Customer;
import bookmytable.model.Reservation;
import bookmytable.model.Restaurant;
import bookmytable.model.RestaurantTable;
import bookmytable.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.SQLData;
import java.sql.Time;
import java.text.SimpleDateFormat;

@CrossOrigin(origins = "*")
@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping(value = {"/reservation", "/reservation/"})
    public ReservationDTO makeReservation(@RequestParam("startTime") String startTime, @RequestParam("date") String date,@RequestParam("groupSize") int groupSize, 
    										@RequestParam("tableID") long tID, @RequestParam("customerID") long cID, @RequestParam("restaurantID") long rID) {
        RestaurantTable restaurantTable = tableRepository.findTableById(tID);
        Restaurant restaurant = restaurantRepository.findRestaurantById(rID);
        Customer customer = customerRepository.findCustomerById(cID);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Reservation reservation = reservationService.makeReservation(Time.valueOf(startTime), java.sql.Date.valueOf(date), groupSize, restaurantTable, customer,restaurant);

        return Converters.convertToDto(reservation);
    }

}
