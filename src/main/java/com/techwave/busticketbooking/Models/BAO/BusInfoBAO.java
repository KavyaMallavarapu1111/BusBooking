package com.techwave.busticketbooking.Models.BAO;

import org.springframework.beans.factory.annotation.Autowired;

import com.techwave.busticketbooking.Models.DAO.BusInfoDAOInterface;
import com.techwave.busticketbooking.Models.Pojo.BusInfo;

public class BusInfoBAO {
	
	@Autowired
	BusInfoDAOInterface busDao;
	
	public String insert(BusInfo B) {
		return busDao.insert(B);
}
}