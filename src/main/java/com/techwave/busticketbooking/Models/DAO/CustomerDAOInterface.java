package com.techwave.busticketbooking.Models.DAO;

import com.techwave.busticketbooking.Models.Pojo.Customer;

public interface CustomerDAOInterface {
	public String insert(Customer C);
	Customer findById(String customerId);
	String updateByCustomer(Customer C);
}
