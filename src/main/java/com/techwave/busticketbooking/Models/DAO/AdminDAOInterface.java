package com.techwave.busticketbooking.Models.DAO;

import com.techwave.busticketbooking.Models.Pojo.Login;

public interface AdminDAOInterface {
	Login CheckAdminExists(String userId);
}
