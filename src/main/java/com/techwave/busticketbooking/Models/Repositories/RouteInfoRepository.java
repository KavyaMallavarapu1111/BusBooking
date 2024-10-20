package com.techwave.busticketbooking.Models.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techwave.busticketbooking.Models.Pojo.RouteInfo;

@Repository
public interface RouteInfoRepository extends CrudRepository<RouteInfo, String>{
	@Query(name="RouteInfo.getByRouteId")
	String getByRouteId(String fromLocation,String toLocation);
	
}
