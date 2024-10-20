package com.techwave.busticketbooking.Models.BAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.techwave.busticketbooking.Models.DAO.ScheduleInfoDAOInterface;
import com.techwave.busticketbooking.Models.Pojo.CheckTicket;
import com.techwave.busticketbooking.Models.Pojo.ScheduleInfo;

public class ScheduleInfoBAO {
	
	@Autowired
	ScheduleInfoDAOInterface scheduleInfoInterface;
	
	public String insertSchedule(ScheduleInfo S) 
	{
		return scheduleInfoInterface.insertSchedule(S);
	}
	
	public List<ScheduleInfo> findTheBuses(CheckTicket c)
	{
		return scheduleInfoInterface.findTheBuses(c);
	}
	
	public ScheduleInfo findById(String scheduleId,int noOfTickets) {
		return scheduleInfoInterface.findById(scheduleId,noOfTickets);
	}
	
	public void updateSchedule(ScheduleInfo s) {
		scheduleInfoInterface.updateSchedule(s);
	}
}
