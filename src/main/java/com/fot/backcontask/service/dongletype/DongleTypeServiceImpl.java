package com.fot.backcontask.service.dongletype;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.DongleTypeDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.DongleType;
import com.fot.backcontask.service.AbstractService;

@Service
public class DongleTypeServiceImpl extends AbstractService<DongleType, DongleTypeDAO> implements DongleTypeService {

	@Override
	public DongleType getAndCheck(Long id) throws NotFoundException {
		return findById(id).orElseThrow(() -> new NotFoundException("El tipo de mochila no existe"));
	}

	@Override
	public boolean isEqual(DongleType kt1, DongleType kt2) {
		return StringUtils.equals(kt1.getName(), kt2.getName());
	}

	@Override
	public void setValues(DongleType to, DongleType from) {
		to.setName(from.getName());
	}
}
