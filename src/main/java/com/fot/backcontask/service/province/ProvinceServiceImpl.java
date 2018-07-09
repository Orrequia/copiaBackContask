package com.fot.backcontask.service.province;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.ProvinceDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Province;
import com.fot.backcontask.service.AbstractService;

@Service
public class ProvinceServiceImpl extends AbstractService<Province, ProvinceDAO> implements ProvinceService {

	@Override
	public Province getAndCheck(Long id) throws NotFoundException {
		return findById(id).orElseThrow(() -> new NotFoundException("La provincia no existe"));
	}

	@Override
	public boolean isEqual(Province p1, Province p2) {
		return StringUtils.equals(p1.getName(), p2.getName()) &&
				p1.getPopulation().equals(p2.getPopulation());
	}

	@Override
	public void setValues(Province to, Province from) {
		to.setName(from.getName());
		to.setPopulation(from.getPopulation());
	}
}
