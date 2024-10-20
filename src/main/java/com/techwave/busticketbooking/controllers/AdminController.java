package com.techwave.busticketbooking.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.techwave.busticketbooking.Models.BAO.AdminBAO;
import com.techwave.busticketbooking.Models.BAO.BusInfoBAO;
import com.techwave.busticketbooking.Models.BAO.PlaceBAO;
import com.techwave.busticketbooking.Models.BAO.RouteInfoBAO;
import com.techwave.busticketbooking.Models.BAO.ScheduleInfoBAO;
import com.techwave.busticketbooking.Models.DAO.ScheduleInfoDAO;
import com.techwave.busticketbooking.Models.DAO.ScheduleInfoDAOInterface;
import com.techwave.busticketbooking.Models.Pojo.BusInfo;
import com.techwave.busticketbooking.Models.Pojo.Login;
import com.techwave.busticketbooking.Models.Pojo.Places;
import com.techwave.busticketbooking.Models.Pojo.RouteInfo;
import com.techwave.busticketbooking.Models.Pojo.ScheduleInfo;

@RestController
@CrossOrigin
public class AdminController {
	@Autowired
	AdminBAO adminBao;
	@Autowired
	BusInfoBAO busInfoBao;
	@Autowired
	RouteInfoBAO routeInfoBao;
	@Autowired
	ScheduleInfoBAO scheduleInfoBao;
	@Autowired
	PlaceBAO placeBao;
	
	@Autowired
	ScheduleInfoDAOInterface scheduleInfoInterface;
	@GetMapping("/checkadminexists/{userId}")
	public ResponseEntity<Object> CheckAdminExists(@PathVariable("userId") String userId) {
		Login l=adminBao.CheckAdminExists(userId);
		if(l!=null)
			return ResponseEntity.of(Optional.of(l));
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No user exists");
	}
	
	@PostMapping("/AddNewBus")
	public ResponseEntity<String> addNewBus(@RequestBody BusInfo B)
	{
		return ResponseEntity.of(Optional.of(busInfoBao.insert(B)));
	}
	
	@PostMapping("/AddNewRoute")
	public ResponseEntity<String> addNewRoute(@RequestBody RouteInfo R)
	{
		return ResponseEntity.of(Optional.of(routeInfoBao.insertRoute(R)));
	}
	
	@PostMapping("/AddNewSchedule")
	public ResponseEntity<String> addNewSchedule(@RequestBody ScheduleInfo S)
	{
		return ResponseEntity.of(Optional.of(scheduleInfoBao.insertSchedule(S)));
	}
	
	
	@GetMapping("/getBus/{busId}")
	public ResponseEntity<Object> getBus(@PathVariable("busId") String busId)
	{
		if(scheduleInfoInterface.findByBusId(busId)!=null)
			return ResponseEntity.of(Optional.of(scheduleInfoInterface.findByBusId(busId)));
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("BusId "+busId+" does not exists");
	}
	
	@GetMapping("/getRoute/{routeId}")
	public ResponseEntity<Object> getRoute(@PathVariable("routeId") String routeId)
	{
		if(scheduleInfoInterface.findByRouteId(routeId)!=null)
			return ResponseEntity.of(Optional.of(scheduleInfoInterface.findByRouteId(routeId)));
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("RouteId "+routeId+" does not exists");
	}
	
	@PutMapping("/updateSchedule")
	public void updateScheduleInfo(@RequestBody ScheduleInfo s)
	{
		scheduleInfoBao.updateSchedule(s);
	}
	
	
	@GetMapping("/LocationStart/{location}")
	public List<Places> findRouteInfoFromLocation(@PathVariable("location") String location)
	{
		return placeBao.findByPlaceStartsWith(location);
	}
}
