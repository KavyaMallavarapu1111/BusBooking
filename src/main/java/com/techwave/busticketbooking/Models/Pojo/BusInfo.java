package com.techwave.busticketbooking.Models.Pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

/*@NamedQueries(value= {
		@NamedQuery(
			name="State.getByBusId",
			query="select b from BusInfo b where b.busId=?1"
		)
	})*/
@Entity
public class BusInfo {
	@Id
	@Column(length=25)
	private String busId;
	@Column(length=25)
	private String busName;
	@Column(length=25)
	private String type;
	private int capacity;
	public BusInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BusInfo(String busId, String busName, String type, int capacity) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.type = type;
		this.capacity = capacity;
	}
	public String getBusId() {
		return busId;
	}
	public void setBusId(String busId) {
		this.busId = busId;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
}
