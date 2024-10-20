package com.techwave.busticketbooking.Models.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.busticketbooking.Models.Pojo.Country;
import com.techwave.busticketbooking.Models.Repositories.CountryRepository;

@Service
public class CountryDAO implements CountryDAOInterface{

	@Autowired
	CountryRepository countryRepository;

	@Override
	public List<Country> getCountries() {
		// TODO Auto-generated method stub
		return (List<Country>) countryRepository.findAll();
	}

		
	
	
}
