package com.techwave.busticketbooking.Models.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.techwave.busticketbooking.Models.Pojo.State;

@Repository
public interface StateRepository extends CrudRepository<State, String>{
	@Query(name="State.getByCountryName")
	List<State> findStateNamesByCountryName(String countryName);
}
