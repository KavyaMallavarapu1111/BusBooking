package com.techwave.busticketbooking.Models.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.techwave.busticketbooking.Models.Pojo.Login;

public interface AdminRepository extends CrudRepository<Login, String>{

}
