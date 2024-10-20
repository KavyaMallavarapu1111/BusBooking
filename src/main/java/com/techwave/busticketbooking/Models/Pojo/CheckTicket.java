package com.techwave.busticketbooking.Models.Pojo;

import java.time.LocalDate;

public class CheckTicket {
	private String customerId;
	private String fromLocation;
	private String toLocation;
	private LocalDate journeyDate;
	private Integer noOfTickets;
	public CheckTicket() {
		super();
	}
	
	public CheckTicket(String customerId, String fromLocation, String toLocation, LocalDate journeyDate,
			Integer noOfTickets) {
		super();
		this.customerId = customerId;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.journeyDate = journeyDate;
		this.noOfTickets = noOfTickets;
	}

	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	public LocalDate getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}
	public Integer getNoOfTickets() {
		return noOfTickets;
	}
	public void setNoOfTickets(Integer noOfTickets) {
		this.noOfTickets = noOfTickets;
	}
	
}
