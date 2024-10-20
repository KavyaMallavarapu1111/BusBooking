package com.techwave.busticketbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.techwave.busticketbooking.Models.BAO.AdminBAO;
import com.techwave.busticketbooking.Models.BAO.BusInfoBAO;
import com.techwave.busticketbooking.Models.BAO.CountryBAO;
import com.techwave.busticketbooking.Models.BAO.CustomerBAO;
import com.techwave.busticketbooking.Models.BAO.PassengerBAO;
import com.techwave.busticketbooking.Models.BAO.PlaceBAO;
import com.techwave.busticketbooking.Models.BAO.RouteInfoBAO;
import com.techwave.busticketbooking.Models.BAO.ScheduleInfoBAO;
import com.techwave.busticketbooking.Models.BAO.StateBAO;
import com.techwave.busticketbooking.Models.BAO.TicketHistoryBAO;

@SpringBootApplication
public class BusBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusBookingApplication.class, args);
	}
	
	@Bean
	public CustomerBAO customerBAO()
	{
		return new CustomerBAO();
	}
	
	@Bean
	public StateBAO stateBAO()
	{
		return new StateBAO();
	}
	
	@Bean
	public CountryBAO countryBAO()
	{
		return new CountryBAO();
	}
	
	@Bean
	public AdminBAO adminBAO()
	{
		return new AdminBAO();
	}
	
	@Bean
	public BusInfoBAO busBAO()
	{
		return new BusInfoBAO();
	}
	
	@Bean
	public RouteInfoBAO routeInfoBAO()
	{
		return new RouteInfoBAO();
	}
	
	@Bean
	public ScheduleInfoBAO scheduleInfoBAO()
	{
		return new ScheduleInfoBAO();
	}
	
	@Bean
	public TicketHistoryBAO ticketHistoryBAO()
	{
		return new TicketHistoryBAO();
	}
	
	@Bean
	public PassengerBAO passengerBAO()
	{
		return new PassengerBAO();
	}
	
	@Bean
	public PlaceBAO placeBAO()
	{
		return new PlaceBAO();
	}
}
