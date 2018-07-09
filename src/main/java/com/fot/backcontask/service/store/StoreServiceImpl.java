package com.fot.backcontask.service.store;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.StoreDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Store;
import com.fot.backcontask.service.AbstractService;

@Service
public class StoreServiceImpl extends AbstractService<Store, StoreDAO> implements StoreService {

	@Override
	public Store getAndCheck(Long id) throws NotFoundException {
		return findById(id).orElseThrow(() -> new NotFoundException("La tienda no existe"));
	}

	@Override
	public boolean isEqual(Store s1, Store s2) {
		return StringUtils.equals(s1.getName(), s2.getName()) &&
				StringUtils.equals(s1.getEmail(), s2.getEmail()) &&
				StringUtils.equals(s1.getAddress(), s2.getAddress()) &&
				s1.getEmployee().equals(s2.getEmployee()) &&
				s1.getResponsible().equals(s2.getResponsible()) &&
				s1.getPopulation().equals(s2.getPopulation());
				
	}

	@Override
	public void setValues(Store to, Store from) {
		to.setName(from.getName());
		to.setEmail(from.getEmail());
		to.setAddress(from.getAddress());
		to.setEmployee(from.getEmployee());
		to.setResponsible(from.getResponsible());
		to.setPopulation(from.getPopulation());
	}

}
