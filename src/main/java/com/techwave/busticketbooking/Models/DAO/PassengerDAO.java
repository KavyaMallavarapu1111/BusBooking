package com.techwave.busticketbooking.Models.DAO;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.busticketbooking.Models.Pojo.Passenger;
import com.techwave.busticketbooking.Models.Pojo.PassengerEmbeddable;
import com.techwave.busticketbooking.Models.Pojo.TicketHistory;
import com.techwave.busticketbooking.Models.Repositories.PassengerRepository;

@Service
public class PassengerDAO implements PassengerDAOInterface{
	@Autowired
	PassengerRepository passengerRepository;

	@Override
	public void insertPassenger(Passenger P) {
		// TODO Auto-generated method stub
		passengerRepository.save(P);
	}

	@Override
	public List<Passenger> getByTransactionIdAndStatus(String transactionId) {
		// TODO Auto-generated method stub
//		Collection<Passenger> p=passengerRepository.getByTransactionIdAndStatus(transactionId);
//		List<Passenger> list=new ArrayList<>(p);
		
		TicketHistory th = new TicketHistory();
		th.setTransactionId(transactionId);
		
		
		
		PassengerEmbeddable pe = new PassengerEmbeddable();
		
		pe.setTransactionId(th);
		pe.setPassengerId("Passenger 1");
		System.out.println("************************");
		List<Passenger> pg = passengerRepository.findByTransactionIdAndStatusBooked(transactionId);
		
		
		System.out.println("------------------------");
		System.out.println(pg.size());
		
		return pg;
	}

	@Override
	public String updatePassenger(String transactionId, String passengerId) {
		// TODO Auto-generated method stub		
		 Passenger P=passengerRepository.updatePassenger(transactionId, passengerId);
		 P.setStatus("Cancelled");
		 passengerRepository.save(P);
		 return "Ticket Cancelled Successfully";
	}

	
	
}
