package com.techwave.busticketbooking.Models.Pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@NamedQueries(value= {
		@NamedQuery(
				name="RouteInfo.getByRouteId",
				query="select r.routeId from RouteInfo r where r.fromLocation=?1 and r.toLocation=?2"
				)
})

@Entity
public class RouteInfo {
	@Id
	@Column(length=25)
	private String routeId;
	@Column(length=30)
	private String fromLocation;
	@Column(length=30)
	private String toLocation;
	public RouteInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RouteInfo(String routeId, String fromLocation, String toLocation) {
		super();
		this.routeId = routeId;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
	}
	public String getRouteId() {
		return routeId;
	}
	public void setRouteId(String routeId) {
		this.routeId = routeId;
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
}
