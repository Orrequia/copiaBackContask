package com.fot.backcontask.service.population;

import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.PopulationDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Population;
import com.fot.backcontask.service.AbstractService;

@Service
public class PopulationServiceImpl extends AbstractService<Population, PopulationDAO> implements PopulationService {

	@Override
	public Population getAndCheck(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEqual(Population u1, Population u2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setValues(Population to, Population from) {
		// TODO Auto-generated method stub
		
	}

}
