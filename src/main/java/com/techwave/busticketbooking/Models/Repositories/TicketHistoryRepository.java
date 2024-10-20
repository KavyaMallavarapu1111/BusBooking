package com.techwave.busticketbooking.Models.Repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.techwave.busticketbooking.Models.Pojo.TicketHistory;

@Repository
public interface TicketHistoryRepository extends CrudRepository<TicketHistory, String>{
	@Query(name="TicketHistory.getByCustomerId")
	Collection<TicketHistory> getByCustomerId(String customerId);
	TicketHistory getByTicketId(String ticketId,String customerId);
	Collection<TicketHistory> getByTicketIdCancelStatus(String ticketId,String customerId);
}
