package com.techwave.busticketbooking.Models.Pojo;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
@Embeddable
public class PassengerEmbeddable  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(length=25)
	private String passengerId;
	@ManyToOne
	@JoinColumn(name="transactionId")
	private TicketHistory transactionId;
	public PassengerEmbeddable() {
		super();
	}
	public PassengerEmbeddable(String passengerId, TicketHistory transactionId) {
		super();
		this.passengerId = passengerId;
		this.transactionId = transactionId;
	}
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public TicketHistory getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(TicketHistory transactionId) {
		this.transactionId = transactionId;
	}
	
	
}
