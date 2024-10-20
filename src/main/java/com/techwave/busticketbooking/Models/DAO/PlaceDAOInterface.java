package com.techwave.busticketbooking.Models.DAO;

import java.util.List;

import com.techwave.busticketbooking.Models.Pojo.Places;

public interface PlaceDAOInterface {
	public List<Places> findByPlaceStartsWith(String placeName); 
}
