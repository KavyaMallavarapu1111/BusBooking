package com.techwave.busticketbooking.Models.BAO;

import org.springframework.beans.factory.annotation.Autowired;
import com.techwave.busticketbooking.Models.DAO.CustomerDAOInterface;
import com.techwave.busticketbooking.Models.Pojo.Customer;


public class CustomerBAO {
	
	@Autowired
	CustomerDAOInterface customerDao;
	
	public String insert(Customer C) {
		return customerDao.insert(C);
	}
	
	public Customer findById(String customerId) {
		return customerDao.findById(customerId);
	}
	
	public String updateByCustomer(Customer C) {
		return customerDao.updateByCustomer(C);
	}
}
