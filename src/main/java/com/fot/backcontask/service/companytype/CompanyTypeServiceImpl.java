package com.fot.backcontask.service.companytype;

import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.CompanyTypeDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.CompanyType;
import com.fot.backcontask.service.AbstractService;

@Service
public class CompanyTypeServiceImpl extends AbstractService<CompanyType, CompanyTypeDAO> implements CompanyTypeService {

	@Override
	public CompanyType getAndCheck(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEqual(CompanyType u1, CompanyType u2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setValues(CompanyType to, CompanyType from) {
		// TODO Auto-generated method stub
		
	}

}
