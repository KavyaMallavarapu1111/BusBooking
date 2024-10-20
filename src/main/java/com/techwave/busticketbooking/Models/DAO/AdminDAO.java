package com.techwave.busticketbooking.Models.DAO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.busticketbooking.Models.Pojo.Login;
import com.techwave.busticketbooking.Models.Repositories.AdminRepository;

@Service
public class AdminDAO implements AdminDAOInterface{

	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public Login CheckAdminExists(String userId) {
		Optional<Login> l=adminRepository.findById(userId);
		if(!l.isPresent())
			return null;
		return l.get();
	}
}
