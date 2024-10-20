package com.techwave.busticketbooking.Models.DAO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.busticketbooking.Models.Pojo.BusInfo;
import com.techwave.busticketbooking.Models.Repositories.BusInfoRepository;

@Service
public class BusInfoDAO implements BusInfoDAOInterface{

	@Autowired
	BusInfoRepository busRepository;
	
	@Override
	public String insert(BusInfo B) {
		// TODO Auto-generated method stub
		Optional<BusInfo> b=busRepository.findById(B.getBusId());
		if(!b.isPresent())
		{
			busRepository.save(B);
			return "Bus Added Successfully";
		}
		return "Bus already exists";
	}

}
