package com.fot.backcontask.service.dongle;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.DongleDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Dongle;
import com.fot.backcontask.service.AbstractService;

@Service
public class DongleServiceImpl extends AbstractService<Dongle, DongleDAO> implements DongleService {

	@Override
	public Dongle getAndCheck(Long id) throws NotFoundException {
		return findById(id).orElseThrow(() -> new NotFoundException("La mochila no existe"));
	}

	@Override
	public boolean isEqual(Dongle k1, Dongle k2) {
		return StringUtils.equals(k1.getLicense(), k2.getLicense()) &&
				k1.getKeyType().equals(k2.getKeyType());
	}

	@Override
	public void setValues(Dongle to, Dongle from) {
		to.setLicense(from.getLicense());
		to.setKeyType(from.getKeyType());
	}
}
