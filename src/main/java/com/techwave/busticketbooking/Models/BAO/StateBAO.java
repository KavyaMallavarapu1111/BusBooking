package com.techwave.busticketbooking.Models.BAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.techwave.busticketbooking.Models.DAO.StateDAOInterface;
import com.techwave.busticketbooking.Models.Pojo.State;

public class StateBAO {
	
	@Autowired
	StateDAOInterface stateDao;
	
	public String[] getByCountryName(String countryId) {
		System.out.println(countryId);
		return stateDao.findStateNamesByCountryId(countryId);
	}
}
