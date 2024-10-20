package com.techwave.busticketbooking.Models.BAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.techwave.busticketbooking.Models.DAO.RouteInfoDAOInterface;
import com.techwave.busticketbooking.Models.Pojo.RouteInfo;

public class RouteInfoBAO {
	
	@Autowired
	RouteInfoDAOInterface routeDao;
	
	public String insertRoute(RouteInfo R) {
		return routeDao.insertRoute(R);
	}
	
}
