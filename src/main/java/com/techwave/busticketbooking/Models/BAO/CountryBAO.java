package com.techwave.busticketbooking.Models.BAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.techwave.busticketbooking.Models.DAO.CountryDAOInterface;
import com.techwave.busticketbooking.Models.Pojo.Country;

public class CountryBAO {
	
	@Autowired
	CountryDAOInterface countryDao;
	
	public List<Country> getCountries() {
		return countryDao.getCountries();
	}
}
