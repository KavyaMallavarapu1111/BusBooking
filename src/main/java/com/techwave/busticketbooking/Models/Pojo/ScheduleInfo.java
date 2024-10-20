package com.techwave.busticketbooking.Models.Pojo;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@NamedQueries(value= {
		@NamedQuery(
			name="ScheduleInfo.countByBusIdDOJ",
			query="select count(s) from ScheduleInfo s where s.busId.busId = ?1 and s.dateOfJourney=?2"
		),
		@NamedQuery(
				name="ScheduleInfo.getByRouteId",
				query="select s from ScheduleInfo s where s.routeId.routeId=?1 and s.dateOfJourney=?2 and s.availableSeats>=?3"
		)
})


@Table(name="ScheduleInfo")
@Entity
public class ScheduleInfo {
	@Id
	@Column(length=25)
	private String sId;
	private LocalTime scheduleTime;
	@ManyToOne
	@JoinColumn(name="routeId")
	private RouteInfo routeId;
	@ManyToOne
	@JoinColumn(name="busId")
	private BusInfo busId;
	private LocalDate dateOfJourney;
	private Double cost;
	private Integer availableSeats;
	public ScheduleInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getsId() {
		return sId;
	}
	public void setsId(String sId) {
		this.sId = sId;
	}
	public LocalTime getScheduleTime() {
		return scheduleTime;
	}
	public void setScheduleTime(LocalTime scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	public RouteInfo getRouteId() {
		return routeId;
	}
	public void setRouteId(RouteInfo routeId) {
		this.routeId = routeId;
	}
	public BusInfo getBusId() {
		return busId;
	}
	public void setBusId(BusInfo busId) {
		this.busId = busId;
	}
	public LocalDate getDateOfJourney() {
		return dateOfJourney;
	}
	public void setDateOfJourney(LocalDate dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Integer getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}
	public ScheduleInfo(String sId, LocalTime scheduleTime, RouteInfo routeId, BusInfo busId, LocalDate dateOfJourney,
			Double cost, Integer availableSeats) {
		super();
		this.sId = sId;
		this.scheduleTime = scheduleTime;
		this.routeId = routeId;
		this.busId = busId;
		this.dateOfJourney = dateOfJourney;
		this.cost = cost;
		this.availableSeats = availableSeats;
	}
	@Override
	public String toString() {
		return "ScheduleInfo [sId=" + sId + ", scheduleTime=" + scheduleTime + ", routeId=" + routeId + ", busId="
				+ busId + ", dateOfJourney=" + dateOfJourney + ", cost=" + cost + ", availableSeats=" + availableSeats
				+ "]";
	}
	
}
