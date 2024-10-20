package com.techwave.busticketbooking.Models.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techwave.busticketbooking.Models.Pojo.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String>{
	
}
