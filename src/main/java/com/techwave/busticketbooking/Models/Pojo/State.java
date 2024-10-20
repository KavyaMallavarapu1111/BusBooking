package com.techwave.busticketbooking.Models.Pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@NamedQueries(value= {
	@NamedQuery(
		name="State.getByCountryName",
		query="select s from State s join  s.countryId c where c.countryName = ?1"
	)
})

@Entity
public class State {
	
	@Id
	@Column(length=10)
	private String stateId;
	@ManyToOne
	@JoinColumn(name="countryId")
	private Country countryId;
	@Column(length=30)
	private String stateName;
	public State() {
		super();
	}
	public State(String stateId, Country countryId, String stateName) {
		super();
		this.stateId = stateId;
		this.countryId = countryId;
		this.stateName = stateName;
	}
	public String getStateId() {
		return stateId;
	}
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	public Country getCountryId() {
		return countryId;
	}
	public void setCountryId(Country countryId) {
		this.countryId = countryId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
}
