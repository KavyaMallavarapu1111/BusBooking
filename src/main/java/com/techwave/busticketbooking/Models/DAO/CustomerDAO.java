package com.techwave.busticketbooking.Models.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.techwave.busticketbooking.Models.Pojo.Login;
import com.techwave.busticketbooking.Models.Pojo.Customer;
import com.techwave.busticketbooking.Models.Repositories.CustomerRepository;
import com.techwave.busticketbooking.Models.Repositories.LoginRepository;

@Service
public class CustomerDAO implements CustomerDAOInterface{
	
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	LoginRepository loginRepository;
	@Override
	public String insert(Customer C) {
		customerRepository.save(C);
		loginRepository.save(new Login(C.getCustomerId(),C.getCustomerPassword(),"Customer"));
		return "You have registered Successfully:"+C.getCustomerId();
	}
	@Override
	public Customer findById(String customerId) {
		// TODO Auto-generated method stub
		return customerRepository.findById(customerId).get();
	}
	@Override
	public String updateByCustomer(Customer C) {
		// TODO Auto-generated method stub
		customerRepository.save(C);
		return "Your profile updated successfully....";
	}
}
