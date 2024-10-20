package com.techwave.busticketbooking.Models.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.busticketbooking.Models.Pojo.RouteInfo;
import com.techwave.busticketbooking.Models.Repositories.RouteInfoRepository;

@Service
public class RouteInfoDAO implements RouteInfoDAOInterface{

	@Autowired
	RouteInfoRepository routeRepository;
	
	@Override
	public String insertRoute(RouteInfo R) {
		// TODO Auto-generated method stub
		Optional<RouteInfo> r=routeRepository.findById(R.getRouteId());
		if(!r.isPresent())
		{
			routeRepository.save(R);
			return "Route added successfully";
		}
		return "Route already exist";
	}

	@Override
	public String getByRouteId(String fromLocation, String toLocation) {
		// TODO Auto-generated method stub
		String routeId=routeRepository.getByRouteId(fromLocation, toLocation);
		return routeId;
	}
}
