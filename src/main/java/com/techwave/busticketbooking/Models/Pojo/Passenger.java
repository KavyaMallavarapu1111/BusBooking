package com.techwave.busticketbooking.Models.Pojo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@NamedQueries(value= {
		/*
		 * @NamedQuery( name="Passenger.getByTransactionIdAndStatus",
		 * query="select p from Passenger p where p.passengerKey.transactionId.transactionId=?1 and status=?2"
		 * )
		 */
		@NamedQuery(name="Passenger.updatePassenger",
				query="select p from Passenger p where p.passengerKey.transactionId.transactionId=?1 and p.passengerKey.passengerId=?2"
				)
})

@Entity
public class Passenger {

	@EmbeddedId
	private PassengerEmbeddable passengerKey;
	@Column(length=25)
	private String passengerName;
	private int age;
	@Column(length=10)
	private String gender;
	@Column(length=25)
	private String status;
	private LocalDateTime transactionDate;
	public Passenger() {}
	
	public Passenger(PassengerEmbeddable passengerKey, String passengerName, int age, String gender, String status,
			LocalDateTime transactionDate) {
		super();
		this.passengerKey = passengerKey;
		this.passengerName = passengerName;
		this.age = age;
		this.gender = gender;
		this.status = status;
		this.transactionDate = transactionDate;
	}
	public PassengerEmbeddable getPassengerKey() {
		return passengerKey;
	}
	public void setPassengerKey(PassengerEmbeddable passengerKey) {
		this.passengerKey = passengerKey;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	
}