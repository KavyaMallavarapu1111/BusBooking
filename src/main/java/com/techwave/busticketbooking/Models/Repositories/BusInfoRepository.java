package com.techwave.busticketbooking.Models.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techwave.busticketbooking.Models.Pojo.BusInfo;

@Repository
public interface BusInfoRepository extends CrudRepository<BusInfo, String>{
	
}
