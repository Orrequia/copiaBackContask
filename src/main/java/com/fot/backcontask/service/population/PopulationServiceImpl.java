package com.fot.backcontask.service.population;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.PopulationDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Population;
import com.fot.backcontask.service.AbstractService;

@Service
public class PopulationServiceImpl extends AbstractService<Population, PopulationDAO> implements PopulationService {

	@Override
	public Population getAndCheck(Long id) throws NotFoundException {
		return findById(id).orElseThrow(() -> new NotFoundException("La población no existe"));
	}

	@Override
	public boolean isEqual(Population p1, Population p2) {
		return StringUtils.equals(p1.getName(), p2.getName()) &&
				StringUtils.equals(p1.getPostalCode(), p2.getPostalCode()) &&
				p1.getProvince().equals(p2.getProvince());
	}

	@Override
	public void setValues(Population to, Population from) {
		to.setName(from.getName());
		to.setPostalCode(from.getPostalCode());
		to.setProvince(from.getProvince());
	}

}
