package com.techwave.busticketbooking.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techwave.busticketbooking.Models.BAO.CountryBAO;
import com.techwave.busticketbooking.Models.BAO.CustomerBAO;
import com.techwave.busticketbooking.Models.BAO.PassengerBAO;
import com.techwave.busticketbooking.Models.BAO.ScheduleInfoBAO;
import com.techwave.busticketbooking.Models.BAO.StateBAO;
import com.techwave.busticketbooking.Models.BAO.TicketHistoryBAO;
import com.techwave.busticketbooking.Models.Pojo.CheckTicket;
import com.techwave.busticketbooking.Models.Pojo.Country;
import com.techwave.busticketbooking.Models.Pojo.Customer;
import com.techwave.busticketbooking.Models.Pojo.Passenger;
import com.techwave.busticketbooking.Models.Pojo.ScheduleInfo;
import com.techwave.busticketbooking.Models.Pojo.TicketHistory;

@RestController
@CrossOrigin
public class CustomerController {
	
	@Autowired
	CustomerBAO customerBao;
	@Autowired
	StateBAO stateBao;
	@Autowired
	PassengerBAO passengerBao;
	@Autowired
	CountryBAO countryBao;
	@Autowired
	ScheduleInfoBAO scheduleInfoBao;
	@Autowired
	TicketHistoryBAO ticketHistoryBao;
	@PostMapping("/registercustomer")
	public ResponseEntity<String> registerCustomer(@RequestBody Customer C)
	{
		return ResponseEntity.of(Optional.of(customerBao.insert(C)));
	}
	
	@GetMapping("/countryID/{countryName}")
	public ResponseEntity<String[]> getByCountryId(@PathVariable("countryName") String countryName)
	{
		return ResponseEntity.of(Optional.of(stateBao.getByCountryName(countryName)));
	}
	
	@GetMapping("/getcountries")
	public ResponseEntity<List<Country>> getAllCountries()
	{
		return ResponseEntity.of(Optional.of(countryBao.getCountries()));
	}
	
	@GetMapping("/getbuses")
	public ResponseEntity<List<ScheduleInfo>> findTheBuses(@RequestParam("customerId") String customerId,@RequestParam("fromLocation") String fromLocation,
	        @RequestParam("toLocation") String toLocation,@RequestParam("journeyDate") LocalDate journeyDate,@RequestParam("noOfTickets") int noOfTickets)
	{
		CheckTicket c=new CheckTicket();
		c.setCustomerId(customerId);
		c.setFromLocation(fromLocation);
		c.setToLocation(toLocation);
		c.setNoOfTickets(noOfTickets);
		c.setJourneyDate(journeyDate);
		List<ScheduleInfo> schedules=scheduleInfoBao.findTheBuses(c);
		if(schedules!=null)
			return ResponseEntity.of(Optional.of(schedules));
		else
			return ResponseEntity.of(Optional.of(null));
	}
	
	@GetMapping("/getCustomerById/{customerId}")
	public ResponseEntity<Customer> findById(@PathVariable("customerId") String customerId)
	{
		return ResponseEntity.of(Optional.of(customerBao.findById(customerId)));
	}
	
	@GetMapping("/getScheduleById/{scheduleId}/{noOfTickets}")
	public ResponseEntity<ScheduleInfo> findByScheduleID(@PathVariable("scheduleId") String scheduleId,@PathVariable("noOfTickets") int noOfTickets)
	{
		return ResponseEntity.of(Optional.of(scheduleInfoBao.findById(scheduleId,noOfTickets)));
	}
	
	@PostMapping("/insertTicketHistory")
	public ResponseEntity<TicketHistory> insertTicketHistory(@RequestBody TicketHistory T)
	{
		ResponseEntity<TicketHistory> t= ResponseEntity.of(Optional.of(ticketHistoryBao.insertTicketHistory(T)));
		return t;
	}
	
	@PostMapping("/insertPassenger")
	public void insertPassenger(@RequestBody Passenger P)
	{
		passengerBao.insertPassenger(P);
	}
	
	@GetMapping("/ViewHistory")
	public ResponseEntity<List<TicketHistory>> viewHistory(@RequestParam("customerId") String customerId)
	{
		List<TicketHistory> list=ticketHistoryBao.findByCustomerId(customerId);
		if(list==null)
			return null;
		else
			return  ResponseEntity.of(Optional.of(list));
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<String> updateByCustomer(@RequestBody Customer C) {
		return ResponseEntity.of(Optional.of(customerBao.updateByCustomer(C)));
	}
	
	@GetMapping("/getbyticketid")
	public ResponseEntity<Object> getByTicketId(@RequestParam("ticketId") String ticketId,@RequestParam("customerId") String customerId)
	{
		TicketHistory t=ticketHistoryBao.getByTicketId(ticketId,customerId);
		if(t==null)
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No bookings on this ticketId "+ticketId);
		return ResponseEntity.of(Optional.of(t));
	}
	
	@GetMapping("/getByTicketIdCancelStatus")
	public ResponseEntity<List<TicketHistory>> getByTicketIdCancelStatus(@RequestParam("ticketId") String ticketId,@RequestParam("customerId") String customerId)
	{
		List<TicketHistory> list=ticketHistoryBao.getByTicketIdCancelStatus(ticketId, customerId);
		if(list!=null)
			return ResponseEntity.of(Optional.of(list));
		else
			return ResponseEntity.of(Optional.of(null));
	}
	
	@GetMapping("/getByTransactionIdAndStatus")
	public ResponseEntity<List<Passenger>> getByTransactionIdAndStatus(@RequestParam("transactionId") String transactionId)
	{
		List<Passenger> plist=passengerBao.getByTransactionIdAndStatus(transactionId);
		return ResponseEntity.of(Optional.of(plist));
	}
	
	@PutMapping("/updatePassenger/{transactionId}/{passengerId}") 
	public ResponseEntity<String> updatePassenger(@PathVariable("transactionId") String transactionId,@PathVariable("passengerId") String passengerId){  
		return ResponseEntity.of(Optional.of(passengerBao.updatePassenger(transactionId, passengerId)));
	}
	
	@GetMapping("/getByTransactionId/{transactionId}")
	public ResponseEntity<TicketHistory> getByTransactionId(@PathVariable("transactionId") String transactionId)
	{
		return ResponseEntity.of(Optional.of(ticketHistoryBao.getByTransactionId(transactionId)));
	}
	 
	
}
