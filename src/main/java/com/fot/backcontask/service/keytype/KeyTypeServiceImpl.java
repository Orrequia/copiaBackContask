package com.fot.backcontask.service.keytype;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.KeyTypeDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.KeyType;
import com.fot.backcontask.service.AbstractService;

@Service
public class KeyTypeServiceImpl extends AbstractService<KeyType, KeyTypeDAO> implements KeyTypeService {

	@Override
	public KeyType getAndCheck(Long id) throws NotFoundException {
		return findById(id).orElseThrow(() -> new NotFoundException("El tipo de mochila no existe"));
	}

	@Override
	public boolean isEqual(KeyType kt1, KeyType kt2) {
		return StringUtils.equals(kt1.getName(), kt2.getName());
	}

	@Override
	public void setValues(KeyType to, KeyType from) {
		to.setName(from.getName());
	}
}
