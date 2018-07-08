package com.fot.backcontask.service.company;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.CompanyDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Company;
import com.fot.backcontask.service.AbstractService;

@Service
public class CompanyServiceImpl extends AbstractService<Company, CompanyDAO> implements CompanyService {

	@Override
	public Company getAndCheck(Long id) throws NotFoundException {
		return findById(id).orElseThrow(() -> new NotFoundException("La empresa no existe"));
	}

	@Override
	public boolean isEqual(Company c1, Company c2) {
		return StringUtils.equals(c1.getName(), c2.getName()) &&
				StringUtils.equals(c1.getNif(), c2.getNif()) && 
				StringUtils.equals(c1.getNote(), c2.getNote()) &&
				c1.getOwner().equals(c2.getOwner()) &&
				c1.getStore().equals(c2.getStore()) &&
				c1.getContract().equals(c2.getContract()) &&
				c1.getCompanyType().equals(c2.getCompanyType());
	}

	@Override
	public void setValues(Company to, Company from) {
		to.setName(from.getName());
		to.setNif(from.getNif());
		to.setNote(from.getNote());
		to.setOwner(from.getOwner());
		to.setStore(from.getStore());
		to.setContract(from.getContract());
		to.setCompanyType(from.getCompanyType());
	}

}
