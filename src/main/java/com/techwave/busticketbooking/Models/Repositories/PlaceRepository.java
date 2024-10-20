package com.techwave.busticketbooking.Models.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techwave.busticketbooking.Models.Pojo.Places;

@Repository
public interface PlaceRepository extends CrudRepository<Places, String>{

	List<Places> findByPlaceStartsWith(String placeName);
}
