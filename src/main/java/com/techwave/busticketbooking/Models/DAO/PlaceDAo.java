package com.techwave.busticketbooking.Models.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.busticketbooking.Models.Pojo.Places;
import com.techwave.busticketbooking.Models.Repositories.PlaceRepository;

@Service
public class PlaceDAo implements PlaceDAOInterface{

	@Autowired
	PlaceRepository placeRepository;
	
	@Override
	public List<Places> findByPlaceStartsWith(String placeName) {
		// TODO Auto-generated method stub
		return placeRepository.findByPlaceStartsWith(placeName);
	}

}
