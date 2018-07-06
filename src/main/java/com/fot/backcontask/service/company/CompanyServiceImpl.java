package com.fot.backcontask.service.company;

import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.CompanyDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Company;
import com.fot.backcontask.service.AbstractService;

@Service
public class CompanyServiceImpl extends AbstractService<Company, CompanyDAO> implements CompanyService {

	@Override
	public Company getAndCheck(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEqual(Company u1, Company u2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setValues(Company to, Company from) {
		// TODO Auto-generated method stub
		
	}

}
