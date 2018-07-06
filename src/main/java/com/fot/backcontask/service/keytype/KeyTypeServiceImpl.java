package com.fot.backcontask.service.keytype;

import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.KeyTypeDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.KeyType;
import com.fot.backcontask.service.AbstractService;

@Service
public class KeyTypeServiceImpl extends AbstractService<KeyType, KeyTypeDAO> implements KeyTypeService {

	@Override
	public KeyType getAndCheck(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEqual(KeyType u1, KeyType u2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setValues(KeyType to, KeyType from) {
		// TODO Auto-generated method stub
		
	}

}
