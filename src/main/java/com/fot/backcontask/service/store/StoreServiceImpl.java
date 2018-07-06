package com.fot.backcontask.service.store;

import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.StoreDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Store;
import com.fot.backcontask.service.AbstractService;

@Service
public class StoreServiceImpl extends AbstractService<Store, StoreDAO> implements StoreService {

	@Override
	public Store getAndCheck(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEqual(Store u1, Store u2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setValues(Store to, Store from) {
		// TODO Auto-generated method stub
		
	}

}
