package com.techwave.busticketbooking.Models.BAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.techwave.busticketbooking.Models.DAO.PlaceDAOInterface;
import com.techwave.busticketbooking.Models.Pojo.Places;

public class PlaceBAO {
	
	@Autowired
	PlaceDAOInterface placeDAO;
	
	public List<Places> findByPlaceStartsWith(String placeName)
	{
		return placeDAO.findByPlaceStartsWith(placeName);
	}
}
