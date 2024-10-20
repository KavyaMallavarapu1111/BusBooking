package com.techwave.busticketbooking.Models.DAO;

import java.util.List;
import com.techwave.busticketbooking.Models.Pojo.TicketHistory;

public interface TicketHistoryDAOInterface {
	TicketHistory insertTicketHistory(TicketHistory T);
	List<TicketHistory> findByCustomerId(String customerId);
	TicketHistory getByTicketId(String ticketId,String customerId);
	List<TicketHistory> getByTicketIdCancelStatus(String ticketId,String customerId);
	TicketHistory getByTransactionId(String transactionId);
}
