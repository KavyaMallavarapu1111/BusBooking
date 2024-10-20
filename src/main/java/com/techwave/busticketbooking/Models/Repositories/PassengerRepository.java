package com.techwave.busticketbooking.Models.Repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.techwave.busticketbooking.Models.Pojo.Passenger;
import com.techwave.busticketbooking.Models.Pojo.PassengerEmbeddable;

@Repository
public interface PassengerRepository extends CrudRepository<Passenger, PassengerEmbeddable>{
	//Collection<Passenger> getByTransactionIdAndStatus(String transactionId);
	
	//List<Passenger> findByPassengerKeyAndStatus(PassengerEmbeddable passengerKey, String status);
	
	@Query("SELECT p FROM Passenger p WHERE p.passengerKey.transactionId.transactionId = :transactionId AND p.status = 'Booked'")
    List<Passenger> findByTransactionIdAndStatusBooked(@Param("transactionId") String transactionId);
	Passenger updatePassenger(String transactionId,String passengerId);
}
