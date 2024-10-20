package com.techwave.busticketbooking.Models.DAO;

import java.time.LocalDate;
import java.util.List;

import com.techwave.busticketbooking.Models.Pojo.BusInfo;
import com.techwave.busticketbooking.Models.Pojo.CheckTicket;
import com.techwave.busticketbooking.Models.Pojo.RouteInfo;
import com.techwave.busticketbooking.Models.Pojo.ScheduleInfo;

public interface ScheduleInfoDAOInterface {
	String insertSchedule(ScheduleInfo S);
	Long countByBusIdAndDateOfJourney(String busId,LocalDate dateOfJourney);
	BusInfo findByBusId(String busId);
	RouteInfo findByRouteId(String routeId);
	List<ScheduleInfo> findTheBuses(CheckTicket c);
	ScheduleInfo findById(String scheduleId,int noOfTickets);
	void updateSchedule(ScheduleInfo s);
}
