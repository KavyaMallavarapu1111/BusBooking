package com.techwave.busticketbooking.Models.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techwave.busticketbooking.Models.Pojo.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, String>{

}
