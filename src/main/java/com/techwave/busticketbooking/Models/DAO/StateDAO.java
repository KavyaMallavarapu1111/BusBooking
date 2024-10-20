package com.techwave.busticketbooking.Models.DAO;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.busticketbooking.Models.Pojo.State;
import com.techwave.busticketbooking.Models.Repositories.StateRepository;

@Service
public class StateDAO implements StateDAOInterface{
	@Autowired
	StateRepository stateRepository;

	@Override
	public String[] findStateNamesByCountryId(String countryName) {
		// TODO Auto-generated method stub
		List<State> state=stateRepository.findStateNamesByCountryName(countryName);
		List<String> stateNames=new ArrayList<String>();
		for(int i=0;i<state.size();i++)
		{
			stateNames.add(state.get(i).getStateName());
		}
		String[] stringArray = stateNames.toArray(new String[0]);
		return stringArray;
	}
}
