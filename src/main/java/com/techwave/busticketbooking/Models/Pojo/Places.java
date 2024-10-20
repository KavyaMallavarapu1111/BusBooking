package com.techwave.busticketbooking.Models.Pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Places {
	@Id
	private String place;

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Places(String place) {
		super();
		this.place = place;
	}

	public Places() {
		super();
	}
	
}
