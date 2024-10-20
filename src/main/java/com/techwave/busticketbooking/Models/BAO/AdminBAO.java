package com.techwave.busticketbooking.Models.BAO;

import org.springframework.beans.factory.annotation.Autowired;

import com.techwave.busticketbooking.Models.DAO.AdminDAOInterface;
import com.techwave.busticketbooking.Models.Pojo.Login;

public class AdminBAO {
	
	@Autowired
	AdminDAOInterface adminDao;
	
	public Login CheckAdminExists(String userId) {
		return adminDao.CheckAdminExists(userId);
	}
}
