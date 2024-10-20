package com.techwave.busticketbooking.Models.DAO;

import java.util.List;

import com.techwave.busticketbooking.Models.Pojo.RouteInfo;

public interface RouteInfoDAOInterface {
	String insertRoute(RouteInfo R);
	String getByRouteId(String fromLocation,String toLocation);
}
