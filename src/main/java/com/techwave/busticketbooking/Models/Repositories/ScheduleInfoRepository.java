package com.techwave.busticketbooking.Models.Repositories;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techwave.busticketbooking.Models.Pojo.ScheduleInfo;

@Repository
public interface ScheduleInfoRepository extends CrudRepository<ScheduleInfo, String>{
	@Query(name="ScheduleInfo.countByBusIdDOJ")
	Long countByBusIdAndDateOfJourney(String busId,LocalDate dateOfJourney);
	//@Query(name="ScheduleInfo.getByRouteId")
	//Collection<ScheduleInfo> findByRouteIdAndDateOfJourneyAndAvailableSeatsGreaterThanEqual(String routeId,LocalDate dateOfJourney,int noOftickets);
	Collection<ScheduleInfo> getByRouteId(String routeId,LocalDate dateOfJourney,int noOftickets);
}
