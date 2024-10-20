package com.techwave.busticketbooking.Models.DAO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.busticketbooking.Models.Pojo.BusInfo;
import com.techwave.busticketbooking.Models.Pojo.CheckTicket;
import com.techwave.busticketbooking.Models.Pojo.RouteInfo;
import com.techwave.busticketbooking.Models.Pojo.ScheduleInfo;
import com.techwave.busticketbooking.Models.Repositories.BusInfoRepository;
import com.techwave.busticketbooking.Models.Repositories.RouteInfoRepository;
import com.techwave.busticketbooking.Models.Repositories.ScheduleInfoRepository;

@Service
public class ScheduleInfoDAO implements ScheduleInfoDAOInterface{
	
	@Autowired
	ScheduleInfoRepository scheduleInfoRepository;
	@Autowired
	BusInfoRepository busRepository;
	@Autowired
	RouteInfoRepository routeRepository;
	@Autowired
	RouteInfoDAOInterface routeDao;
	
	@Override
	public String insertSchedule(ScheduleInfo S) {
		System.out.println(S.getsId());
		System.out.println(S.getAvailableSeats());
		System.out.println(S.getCost());
		System.out.println(S.getBusId());
		System.out.println(S.getDateOfJourney());
		System.out.println(S.getRouteId());
		System.out.println(S.getScheduleTime());
		BusInfo B=busRepository.findById(S.getBusId().getBusId()).get();
		System.out.println(S);
		if(countByBusIdAndDateOfJourney(S.getBusId().getBusId(),S.getDateOfJourney()) != 0)
		{
			return "This bus is already scheduled";
		}
		else if(countByBusIdAndDateOfJourney(S.getBusId().getBusId(),S.getDateOfJourney()) == 0)
		{
			if(S.getAvailableSeats()>B.getCapacity())
				return "SeatsAvailability is greater than "+B.getCapacity();
			else
			{
				scheduleInfoRepository.save(S);
				return "Schedule added successfully";
			}
		}
		return null;
	}

	@Override
	public Long countByBusIdAndDateOfJourney(String busId,LocalDate dateOfJourney) {

		long s=scheduleInfoRepository.countByBusIdAndDateOfJourney(busId,dateOfJourney);
		return s;
	}

	@Override
	public BusInfo findByBusId(String busId) {
		// TODO Auto-generated method stub
		Optional<BusInfo> b=busRepository.findById(busId);
		if(!b.isPresent())
			return null;
		return b.get();
	}
	
	public RouteInfo findByRouteId(String routeId) {
		// TODO Auto-generated method stub
		Optional<RouteInfo> b=routeRepository.findById(routeId);
		if(!b.isPresent())
			return null;
		return b.get();
	}

	@Override
	public List<ScheduleInfo> findTheBuses(CheckTicket c) {
		// TODO Auto-generated method stub
		String routeId=routeDao.getByRouteId(c.getFromLocation(), c.getToLocation());
		Collection<ScheduleInfo> schedules=(Collection<ScheduleInfo>) scheduleInfoRepository.getByRouteId(routeId, c.getJourneyDate(), c.getNoOfTickets());
		List<ScheduleInfo> schedule=new ArrayList<>(schedules);
		//ScheduleInfo[] scheduleArray = schedule.toArray(new ScheduleInfo[0]);
		if(c.getJourneyDate().compareTo(LocalDate.now())==0)
		{
		LocalTime currentTime = LocalTime.now();
        schedule = schedule.stream()
                .filter(scheduleInfo -> scheduleInfo.getScheduleTime().isAfter(currentTime))
                .collect(Collectors.toList());
		}
		schedule = schedule.stream()
                .filter(scheduleInfo -> scheduleInfo.getAvailableSeats() >=c.getNoOfTickets())
                .collect(Collectors.toList());
		return schedule;
	}

	@Override
	public ScheduleInfo findById(String scheduleId,int noOfTickets) {
		// TODO Auto-generated method stub
		ScheduleInfo S=scheduleInfoRepository.findById(scheduleId).get();
		S.setAvailableSeats(S.getAvailableSeats()-noOfTickets);
		scheduleInfoRepository.save(S);
		return scheduleInfoRepository.findById(scheduleId).get();
	}

	@Override
	public void updateSchedule(ScheduleInfo s) {
		// TODO Auto-generated method stub
		scheduleInfoRepository.save(s);
	}

}
