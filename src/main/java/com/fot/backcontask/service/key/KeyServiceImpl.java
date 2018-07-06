package com.fot.backcontask.service.key;

import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.KeyDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Key;
import com.fot.backcontask.service.AbstractService;

@Service
public class KeyServiceImpl extends AbstractService<Key, KeyDAO> implements KeyService {

	@Override
	public Key getAndCheck(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEqual(Key u1, Key u2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setValues(Key to, Key from) {
		// TODO Auto-generated method stub
		
	}

}
