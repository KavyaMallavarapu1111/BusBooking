package com.techwave.busticketbooking.Models.DAO;

import java.util.Collection;
import java.util.List;

import com.techwave.busticketbooking.Models.Pojo.Passenger;
import com.techwave.busticketbooking.Models.Pojo.PassengerEmbeddable;

public interface PassengerDAOInterface {
	void insertPassenger(Passenger P);
	List<Passenger> getByTransactionIdAndStatus(String transactionId);
	String updatePassenger(String transactionId,String passengerId);
}
