package com.techwave.busticketbooking.Models.DAO;

import java.util.List;

import com.techwave.busticketbooking.Models.Pojo.State;

public interface StateDAOInterface {
	String[] findStateNamesByCountryId(String countryName);
}
