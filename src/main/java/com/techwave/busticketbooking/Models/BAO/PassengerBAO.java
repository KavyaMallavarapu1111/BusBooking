package com.techwave.busticketbooking.Models.BAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.techwave.busticketbooking.Models.DAO.PassengerDAOInterface;
import com.techwave.busticketbooking.Models.Pojo.Passenger;

public class PassengerBAO {
	
	@Autowired
	PassengerDAOInterface passengerDao;
	
	public void insertPassenger(Passenger P) {
		passengerDao.insertPassenger(P);
	}
	
	public List<Passenger> getByTransactionIdAndStatus(String transactionId) {
		return passengerDao.getByTransactionIdAndStatus(transactionId);
	}
	public String updatePassenger(String transactionId,String PassengerId) {
		return passengerDao.updatePassenger(transactionId, PassengerId);
	}
}
