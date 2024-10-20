package com.techwave.busticketbooking.Models.DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.busticketbooking.Models.Pojo.ScheduleInfo;
import com.techwave.busticketbooking.Models.Pojo.TicketHistory;
import com.techwave.busticketbooking.Models.Repositories.TicketHistoryRepository;

@Service
public class TicketHistoryDAO implements TicketHistoryDAOInterface {
	@Autowired
	TicketHistoryRepository ticketHistoryRepository;

	@Override
	public TicketHistory insertTicketHistory(TicketHistory T) {
		ticketHistoryRepository.save(T);
		TicketHistory t=ticketHistoryRepository.findById(T.getTransactionId()).get();
		return t;
	}

	@Override
	public List<TicketHistory> findByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		Collection<TicketHistory> list=(Collection<TicketHistory>) ticketHistoryRepository.getByCustomerId(customerId);
		List<TicketHistory> tickets=new ArrayList<>(list);
		return tickets;
	}

	@Override
	public TicketHistory getByTicketId(String ticketId,String customerId) {
		// TODO Auto-generated method stub
		return ticketHistoryRepository.getByTicketId(ticketId,customerId);
	}

	@Override
	public List<TicketHistory> getByTicketIdCancelStatus(String ticketId,String customerId) {
		// TODO Auto-generated method stub
		Collection<TicketHistory> t=ticketHistoryRepository.getByTicketIdCancelStatus(ticketId,customerId);
		List<TicketHistory> list=new ArrayList<>(t);
		return list;
	}

	@Override
	public TicketHistory getByTransactionId(String transactionId) {
		// TODO Auto-generated method stub
		return ticketHistoryRepository.findById(transactionId).get();
	}
}
