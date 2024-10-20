package com.techwave.busticketbooking.Models.Pojo;
import java.time.LocalDateTime;
import java.util.List;

import aj.org.objectweb.asm.Type;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;

@NamedQueries(value= {
		@NamedQuery(
			name="TicketHistory.getByCustomerId",
			query="select t from TicketHistory t where t.customerId.customerId=?1"
		),
		
		@NamedQuery(
				name="TicketHistory.getByTicketId",
				query="select t from TicketHistory t where t.ticketId=?1 and t.status='Booked' and t.customerId.customerId=?2"
		),
		@NamedQuery(
				name="TicketHistory.getByTicketIdCancelStatus",
				query="select t from TicketHistory t where t.ticketId=?1 and t.status='Cancelled' and t.customerId.customerId=?2"
		)
})

@Entity
public class TicketHistory {
		@Id
		@Column(length=20)
		private String transactionId;
		@ManyToOne
		@JoinColumn(name="customerId")
		private Customer customerId;
		private LocalDateTime transctionDate;
		@ManyToOne
		@JoinColumn(name="scheduleId") 
		private ScheduleInfo scheduleId;
		private int noOfTickets;
		private String ticketId;
		@Column(length=20)
		private String status;
		private double totalFare;
		public TicketHistory() {
			super();
		}
		public TicketHistory(String transactionId, Customer customerId, LocalDateTime transctionDate,
				ScheduleInfo scheduleId, int noOfTickets, String ticketId, String status, double totalFare) {
			super();
			this.transactionId = transactionId;
			this.customerId = customerId;
			this.transctionDate = transctionDate;
			this.scheduleId = scheduleId;
			this.noOfTickets = noOfTickets;
			this.ticketId = ticketId;
			this.status = status;
			this.totalFare = totalFare;
		}
		public String getTransactionId() {
			return transactionId;
		}
		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
		}
		public Customer getCustomerId() {
			return customerId;
		}
		public void setCustomerId(Customer customerId) {
			this.customerId = customerId;
		}
		public LocalDateTime getTransctionDate() {
			return transctionDate;
		}
		public void setTransctionDate(LocalDateTime transctionDate) {
			this.transctionDate = transctionDate;
		}
		public ScheduleInfo getScheduleId() {
			return scheduleId;
		}
		public void setScheduleId(ScheduleInfo scheduleId) {
			this.scheduleId = scheduleId;
		}
		public int getNoOfTickets() {
			return noOfTickets;
		}
		public void setNoOfTickets(int noOfTickets) {
			this.noOfTickets = noOfTickets;
		}
		public String getTicketId() {
			return ticketId;
		}
		public void setTicketId(String ticketId) {
			this.ticketId = ticketId;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public double getTotalFare() {
			return totalFare;
		}
		public void setTotalFare(double totalFare) {
			this.totalFare = totalFare;
		}
}	
