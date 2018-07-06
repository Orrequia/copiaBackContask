package com.fot.backcontask.service.province;

import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.ProvinceDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Province;
import com.fot.backcontask.service.AbstractService;

@Service
public class ProvinceServiceImpl extends AbstractService<Province, ProvinceDAO> implements ProvinceService {

	@Override
	public Province getAndCheck(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEqual(Province u1, Province u2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setValues(Province to, Province from) {
		// TODO Auto-generated method stub
		
	}

}
