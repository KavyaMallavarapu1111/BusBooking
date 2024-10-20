package com.techwave.busticketbooking.Models.BAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.techwave.busticketbooking.Models.DAO.TicketHistoryDAOInterface;
import com.techwave.busticketbooking.Models.Pojo.TicketHistory;

public class TicketHistoryBAO {
	@Autowired
	TicketHistoryDAOInterface ticketHistoryDAOInterface;
	
	public TicketHistory insertTicketHistory(TicketHistory T)
	{
		return ticketHistoryDAOInterface.insertTicketHistory(T);
	}
	
	public List<TicketHistory> findByCustomerId(String customerId)
	{
		return ticketHistoryDAOInterface.findByCustomerId(customerId);
	}
	
	public TicketHistory getByTicketId(String ticketId,String customerId) {
		return ticketHistoryDAOInterface.getByTicketId(ticketId,customerId);
	}
	
	public List<TicketHistory> getByTicketIdCancelStatus(String ticketId,String customerId)
	{
		return ticketHistoryDAOInterface.getByTicketIdCancelStatus(ticketId,customerId);
	}
	
	public TicketHistory getByTransactionId(String transactionId) {
		return ticketHistoryDAOInterface.getByTransactionId(transactionId);
	}
}
